package za.ac.cput.gui.Chef;

import za.ac.cput.domain.Chef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadChefGUI implements ActionListener {

        //Initializing Components
        private JFrame ReadItemFrame;
        private JPanel ReadItemPanelNorth, ReadItemPanelSouth, ReadItemPanelEast, ReadItemPanelWest, ReadItemPanelCenter;
        private JLabel lblHeading;
        private JLabel lblChefID, lblChefName, lblChefGender, lblMealStatus, lblChefSalary;
        private JTextField txtChefID, txtChefName, txtChefGender, txtMealStatus, txtChefSalary;
        private JButton btnRead, btnDelete, btnReturn, btnClear;
        private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
        private Font headingFont;


        //Setting Up GUI Components
        public ReadChefGUI() {
            //Font
            headingFont = new Font("Arial", Font.BOLD, 18);

            //Panels
            ReadItemFrame = new JFrame("Chef: ");
            ReadItemPanelNorth = new JPanel();
            ReadItemPanelSouth = new JPanel();
            ReadItemPanelEast = new JPanel();
            ReadItemPanelWest = new JPanel();
            ReadItemPanelCenter = new JPanel();
            ReadItemPanelNorth.setBackground(Color.LIGHT_GRAY);
            ReadItemPanelEast.setBackground(Color.LIGHT_GRAY);
            ReadItemPanelSouth.setBackground(Color.LIGHT_GRAY);
            ReadItemPanelWest.setBackground(Color.LIGHT_GRAY);
            ReadItemPanelCenter.setBackground(Color.LIGHT_GRAY);

            //Heading
            lblHeading = new JLabel("Enter Chef ID", JLabel.CENTER);

            //Labels
            lblChefID = new JLabel("ChefID:");
            lblChefName= new JLabel("ChefName:");
            lblChefGender = new JLabel("ChefGender:");
            lblMealStatus = new JLabel("MealStatus:");
            lblChefSalary = new JLabel("ChefSalary:");


            //TextFields
            txtChefID = new JTextField();
            txtChefName= new JTextField();
            txtChefGender = new JTextField();
            txtMealStatus = new JTextField();
            txtChefSalary = new JTextField();


            //Fillers:
            Filler1 = new JLabel("===========");
            Filler2 = new JLabel("===========");
            Filler3 = new JLabel("===========");
            Filler4 = new JLabel("===========");
            Filler5 = new JLabel("===========");
            Filler1.setForeground(Color.LIGHT_GRAY);
            Filler2.setForeground(Color.LIGHT_GRAY);
            Filler3.setForeground(Color.LIGHT_GRAY);
            Filler4.setForeground(Color.LIGHT_GRAY);
            Filler5.setForeground(Color.LIGHT_GRAY);

            //Buttons:
            btnRead = new JButton("Read");
            btnDelete = new JButton("Delete");
            btnClear = new JButton("Clear");
            btnReturn = new JButton("Return");

        }

        //Setting GUI Layout
        public void setGUI() {
            //Panel Grids
            ReadItemPanelNorth.setLayout(new GridLayout(4, 1));
            ReadItemPanelEast.setLayout(new GridLayout(13, 1));
            ReadItemPanelSouth.setLayout(new GridLayout(1, 4));
            ReadItemPanelWest.setLayout(new GridLayout(13, 1));
            ReadItemPanelCenter.setLayout(new GridLayout(13, 1));
            ReadItemPanelEast.setLayout(new GridLayout(13, 1));

            //Adding the components to the panels:
            //Panel North:
            ReadItemPanelNorth.add(Filler5);
            ReadItemPanelNorth.add(lblHeading);
            ReadItemPanelNorth.add(txtChefID);

            //Panel West:
            ReadItemPanelWest.add(Filler1);

            //Panel Center:
            ReadItemPanelCenter.add(lblChefID);
            ReadItemPanelCenter.add(txtChefID);

            ReadItemPanelCenter.add(lblChefName);
            ReadItemPanelCenter.add(txtChefName);

            ReadItemPanelCenter.add(lblChefGender);
            ReadItemPanelCenter.add(txtChefGender);

            ReadItemPanelCenter.add(lblMealStatus);
            ReadItemPanelCenter.add(txtMealStatus);

            ReadItemPanelCenter.add(lblChefSalary);
            ReadItemPanelCenter.add(txtChefSalary);

            ReadItemPanelCenter.add(Filler4);

            //Panel East
            ReadItemPanelEast.add(Filler2);

            //Panel South:
            ReadItemPanelSouth.add(btnRead);
            ReadItemPanelSouth.add(btnDelete);
            ReadItemPanelSouth.add(btnClear);
            ReadItemPanelSouth.add(btnReturn);

            //Heading
            lblHeading.setFont(headingFont);

            //Adding panels to Chef Frame:
            ReadItemFrame.add(ReadItemPanelNorth, BorderLayout.NORTH);
            ReadItemFrame.add(ReadItemPanelSouth, BorderLayout.SOUTH);
            ReadItemFrame.add(ReadItemPanelEast, BorderLayout.EAST);
            ReadItemFrame.add(ReadItemPanelCenter, BorderLayout.CENTER);
            ReadItemFrame.add(ReadItemPanelWest, BorderLayout.WEST);

            //Telling compiler to listen for actions from the buttons:
            btnRead.addActionListener(this);
            btnDelete.addActionListener(this);
            btnClear.addActionListener(this);
            btnReturn.addActionListener(this);

            //Set GUI:
            ReadItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ReadItemFrame.pack();
            ReadItemFrame.setSize(400, 500);
            ReadItemFrame.setLocationRelativeTo(null);
            ReadItemFrame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //When Delete Button is clicked
            if (e.getActionCommand().equals("Read")) {

                //Store textfield text in string
                String id = txtChefID.getText();
                httpsmethods httpmethods = new httpsmethods();

                //Use String as parameter in http read method and assign result to a Item
                Chef che = httpmethods.findChef(id);
                System.out.println(che);

                //Item parameters are assigned to textfields
                txtChefID.setText(che.getChefID());
                txtChefName.setText(che.getChefName());
                txtChefGender.setText(che.getChefGender());
                txtMealStatus.setText(che.getMealStatus());
                txtChefSalary.setText(che.getChefSalary());
            }

            //When Delete Button is clicked
            if (e.getActionCommand().equals("Delete")) {
                //Store textfield text in string
                String id = txtChefID.getText();
                httpsmethods httpsmethods = new httpsmethods();

                //Use String as parameter in http method
                httpsmethods.deleteChef(id);

                //Show message when successfully completed
                JOptionPane.showMessageDialog(null, "Chef Deleted");
                txtChefID.setText("");
                txtChefName.setText("");
                txtChefGender.setText("");
                txtMealStatus.setText("");
                txtChefSalary.setText("");
            }


            //When Clear Button is clicked
            if (e.getActionCommand().equals("Clear")) {
                txtChefID.setText("");
                txtChefName.setText("");
                txtChefGender.setText("");
                txtMealStatus.setText("");
                txtChefSalary.setText("");
            }

            //When Exit Button is clicked
            if (e.getActionCommand().equals("Return")) {
                ReadItemFrame.dispose();
            }
        }
}