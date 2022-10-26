package za.ac.cput.gui.Chef;

import za.ac.cput.domain.Chef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateChefGUI implements ActionListener {

        //Initializing Components
        private JFrame UpdateItemFrame;
        private JPanel UpdateItemPanelNorth, UpdateItemPanelSouth, UpdateItemPanelEast, UpdateItemPanelWest, UpdateItemPanelCenter;
        private JLabel lblHeading;
        private JLabel lblChefID, lblChefName, lblChefGender, lblChefSalary, lblMealStatus;
        private JTextField txtChefID, txtChefName,txtChefGender, txtChefSalary, txtMealStatus;
        private JButton btnUpdate, btnReturn, btnClear, btnGet;
        private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
        private Font headingFont;
        Chef chef;

        public UpdateChefGUI() {
            //Font
            headingFont = new Font("Arial", Font.BOLD, 18);

            //Panels
            UpdateItemFrame = new JFrame("Chef ");
            UpdateItemPanelNorth = new JPanel();
            UpdateItemPanelSouth = new JPanel();
            UpdateItemPanelEast = new JPanel();
            UpdateItemPanelWest = new JPanel();
            UpdateItemPanelCenter = new JPanel();
            UpdateItemPanelNorth.setBackground(Color.LIGHT_GRAY);
            UpdateItemPanelEast.setBackground(Color.LIGHT_GRAY);
            UpdateItemPanelSouth.setBackground(Color.LIGHT_GRAY);
            UpdateItemPanelWest.setBackground(Color.LIGHT_GRAY);
            UpdateItemPanelCenter.setBackground(Color.LIGHT_GRAY);

            //Heading
            lblHeading = new JLabel("Update Chef", JLabel.CENTER);



            //Labels
            lblChefID = new JLabel("ChefID:");
            lblChefName = new JLabel("ChefName:");
            lblChefGender = new JLabel("ChefGender:");
            lblChefSalary = new JLabel("ChefSalary:");
            lblMealStatus = new JLabel("MealStatus:");

            //TextFields
            txtChefID = new JTextField();
            txtChefName = new JTextField();
            txtChefGender = new JTextField();
            txtChefSalary = new JTextField();
            txtMealStatus = new JTextField();


            //Fillers:
            Filler1 = new JLabel("===========");
            Filler2 = new JLabel("===========");
            Filler3 = new JLabel("===========");
            Filler4 = new JLabel("============");
            Filler5 = new JLabel("============");
            Filler1.setForeground(Color.LIGHT_GRAY);
            Filler2.setForeground(Color.LIGHT_GRAY);
            Filler3.setForeground(Color.LIGHT_GRAY);
            Filler4.setForeground(Color.LIGHT_GRAY);
            Filler5.setForeground(Color.LIGHT_GRAY);

            //Buttons:
            btnUpdate = new JButton("Update");
            btnGet = new JButton("Get Info");
            btnClear = new JButton("Clear");
            btnReturn = new JButton("Return");


        }


        //Setting GUI Layout
        public void setGUI() {
            //Panel Grid Layout
            UpdateItemPanelNorth.setLayout(new GridLayout(2, 1));
            UpdateItemPanelEast.setLayout(new GridLayout(13, 1));
            UpdateItemPanelSouth.setLayout(new GridLayout(1, 4));
            UpdateItemPanelWest.setLayout(new GridLayout(13, 1));
            UpdateItemPanelCenter.setLayout(new GridLayout(13, 1));
            UpdateItemPanelEast.setLayout(new GridLayout(13, 1));

            //Adding the components to the panels:
            //Panel North:
            UpdateItemPanelNorth.add(Filler5);
            UpdateItemPanelNorth.add(lblHeading);

            //Panel West:
            UpdateItemPanelWest.add(Filler1);

            //Panel Center:
            UpdateItemPanelCenter.add(lblChefID);
            UpdateItemPanelCenter.add(txtChefID);

            UpdateItemPanelCenter.add(lblChefName);
            UpdateItemPanelCenter.add(txtChefName);

            UpdateItemPanelCenter.add(lblChefGender);
            UpdateItemPanelCenter.add(txtChefGender);

            UpdateItemPanelCenter.add(lblChefSalary);
            UpdateItemPanelCenter.add(txtChefSalary);

            UpdateItemPanelCenter.add(lblMealStatus);
            UpdateItemPanelCenter.add(txtMealStatus);

            UpdateItemPanelCenter.add(Filler4);

            //Panel East
            UpdateItemPanelEast.add(Filler2);

            //Panel South:
            UpdateItemPanelSouth.add(btnGet);
            UpdateItemPanelSouth.add(btnUpdate);
            UpdateItemPanelSouth.add(btnClear);
            UpdateItemPanelSouth.add(btnReturn);

            //Heading
            lblHeading.setFont(headingFont);

            //Adding panels to Chef Frame:
            UpdateItemFrame.add(UpdateItemPanelNorth, BorderLayout.NORTH);
            UpdateItemFrame.add(UpdateItemPanelSouth, BorderLayout.SOUTH);
            UpdateItemFrame.add(UpdateItemPanelEast, BorderLayout.EAST);
            UpdateItemFrame.add(UpdateItemPanelCenter, BorderLayout.CENTER);
            UpdateItemFrame.add(UpdateItemPanelWest, BorderLayout.WEST);

            //Telling compiler to listen for actions from the buttons:
            btnGet.addActionListener(this);
            btnUpdate.addActionListener(this);
            btnClear.addActionListener(this);
            btnReturn.addActionListener(this);

            //Set GUI:
            UpdateItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            UpdateItemFrame.pack();
            UpdateItemFrame.setSize(450, 500);
            UpdateItemFrame.setLocationRelativeTo(null);
            UpdateItemFrame.setVisible(true);
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Update")) {
                httpsmethods httpmethods = new httpsmethods();

                //Store textfield text in string
                String ChefID = txtChefID.getText();
                String ChefName = txtChefName.getText();
                String ChefGender = txtChefGender.getText();
                String ChefSalary = txtChefSalary.getText();
                String MealStatus = txtMealStatus.getText();

                //Read method
                Chef che = httpmethods.findChef(ChefID);

                //booleans for checking valid input
                boolean ChefNameCheck, ChefGenderCheck;

                if (!ChefName.matches("[a-zA-Z0-9]+")) {
                    ChefNameCheck = false;
                    txtChefName.setText("Invalid  Input");
                } else {
                    ChefNameCheck = true;
                }


                //If all are valid then call update httpmethod
                if (ChefNameCheck) {

                    chef = new Chef.Builder().copy(che)
                            .setChefID(ChefID)
                            .setChefName(ChefName)
                            .setChefGender(ChefGender)
                            .setChefSalary(ChefSalary)
                            .setMealStatus(MealStatus)
                            .build();
                    httpmethods.updateChef(chef);
                    txtChefID.setText("");
                    txtChefName.setText("");
                    txtChefGender.setText("");
                    txtChefSalary.setText("");
                    txtMealStatus.setText("");
                    JOptionPane.showMessageDialog(null, "Chef Updated");
                }


            }

            //When Get Info Button is clicked
            if (e.getActionCommand().equals("Get Info")) {
                boolean idCheck;

                //Use read method of readitemgui
                String id = txtChefID.getText();
                httpsmethods httpmethods = new httpsmethods();
                Chef che = httpmethods.findChef(id);
                txtChefName.setText(che.getChefName());
                txtChefGender.setText(che.getChefGender());

            }

            //When Clear Button is clicked
            if (e.getActionCommand().equals("Clear")) {
                txtChefID.setText("");
                txtChefName.setText("");
                txtChefGender.setText("");
                txtChefSalary.setText("");
                txtMealStatus.setText("");
            }

            //When Exit Button is clicked
            if (e.getActionCommand().equals("Return")) {
                UpdateItemFrame.dispose();
            }
        }
}
