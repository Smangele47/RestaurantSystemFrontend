package za.ac.cput.gui.Meal;

import za.ac.cput.domain.Meal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadMealGUI implements ActionListener {

        //Initializing Components
        private JFrame ReadItemFrame;
        private JPanel ReadItemPanelNorth, ReadItemPanelSouth, ReadItemPanelEast, ReadItemPanelWest, ReadItemPanelCenter;
        private JLabel lblHeading;
        private JLabel lblMealCode, lblMealName, lblMealPrice, lblMealStatus, lblTakeAway;
        private JTextField txtMealCode, txtMealName, txtMealPrice, txtMealStatus, txtTakeAway;
        private JButton btnRead, btnDelete, btnReturn, btnClear;
        private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
        private Font headingFont;


        //Setting Up GUI Components
        public ReadMealGUI() {
            //Font
            headingFont = new Font("Arial", Font.BOLD, 18);

            //Panels
            ReadItemFrame = new JFrame("Meal: ");
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
            lblHeading = new JLabel("Enter Meal ID", JLabel.CENTER);

            //Labels
            lblMealCode = new JLabel("MealCode:");
            lblMealName= new JLabel("MealName:");
            lblMealPrice = new JLabel("MealPrice:");
            lblMealStatus = new JLabel("MealStatus:");
            lblTakeAway = new JLabel("TakeAway:");


            //TextFields
            txtMealCode = new JTextField();
            txtMealName= new JTextField();
            txtMealPrice = new JTextField();
            txtMealStatus = new JTextField();
            txtTakeAway = new JTextField();


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
            ReadItemPanelNorth.add(txtMealCode);

            //Panel West:
            ReadItemPanelWest.add(Filler1);

            //Panel Center:
            ReadItemPanelCenter.add(lblMealCode);
            ReadItemPanelCenter.add(txtMealCode);

            ReadItemPanelCenter.add(lblMealName);
            ReadItemPanelCenter.add(txtMealName);

            ReadItemPanelCenter.add(lblMealPrice);
            ReadItemPanelCenter.add(txtMealPrice);

            ReadItemPanelCenter.add(lblMealStatus);
            ReadItemPanelCenter.add(txtMealStatus);

            ReadItemPanelCenter.add(lblTakeAway);
            ReadItemPanelCenter.add(txtTakeAway);

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

            //Adding panels to Meal Frame:
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
                String id = txtMealCode.getText();
                httpsmethods httpmethods = new httpsmethods();

                //Use String as parameter in http read method and assign result to a Item
                Meal mea = httpmethods.findMeal(id);
                System.out.println(mea);

                //Item parameters are assigned to textfields
                txtMealCode.setText(mea.getMealCode());
                txtMealName.setText(mea.getMealName());
                txtMealPrice.setText(mea.getMealPrice());
                txtMealStatus.setText(mea.getMealStatus());
                txtTakeAway.setText(mea.getTakeAway());
            }

            //When Delete Button is clicked
            if (e.getActionCommand().equals("Delete")) {
                //Store textfield text in string
                String id = txtMealCode.getText();
                httpsmethods httpsmethods = new httpsmethods();

                //Use String as parameter in http method
                httpsmethods.deleteMeal(id);

                //Show message when successfully completed
                JOptionPane.showMessageDialog(null, "Meal Deleted");
                txtMealCode.setText("");
                txtMealName.setText("");
                txtMealPrice.setText("");
                txtMealStatus.setText("");
                txtTakeAway.setText("");
            }


            //When Clear Button is clicked
            if (e.getActionCommand().equals("Clear")) {
                txtMealCode.setText("");
                txtMealName.setText("");
                txtMealPrice.setText("");
                txtMealStatus.setText("");
                txtTakeAway.setText("");
            }

            //When Exit Button is clicked
            if (e.getActionCommand().equals("Return")) {
                ReadItemFrame.dispose();
            }
        }
}