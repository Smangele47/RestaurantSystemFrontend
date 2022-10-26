package za.ac.cput.gui.Meal;

import za.ac.cput.domain.Meal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateMealGUI implements ActionListener {

        //Initializing Components
        private JFrame UpdateItemFrame;
        private JPanel UpdateItemPanelNorth, UpdateItemPanelSouth, UpdateItemPanelEast, UpdateItemPanelWest, UpdateItemPanelCenter;
        private JLabel lblHeading;
        private JLabel lblMealCode, lblMealName, lblMealPrice, lblTakeAway, lblMealStatus;
        private JTextField txtMealCode, txtMealName,txtMealPrice, txtTakeAway, txtMealStatus;
        private JButton btnUpdate, btnReturn, btnClear, btnGet;
        private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
        private Font headingFont;
        Meal meal;

        public UpdateMealGUI() {
            //Font
            headingFont = new Font("Arial", Font.BOLD, 18);

            //Panels
            UpdateItemFrame = new JFrame("Meal ");
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
            lblHeading = new JLabel("Update Meal", JLabel.CENTER);



            //Labels
            lblMealCode = new JLabel("MealCode:");
            lblMealName = new JLabel("MealName:");
            lblMealPrice = new JLabel("MealPrice:");
            lblTakeAway = new JLabel("TakeAway:");
            lblMealStatus = new JLabel("MealStatus:");

            //TextFields
            txtMealCode = new JTextField();
            txtMealName = new JTextField();
            txtMealPrice = new JTextField();
            txtTakeAway = new JTextField();
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
            UpdateItemPanelCenter.add(lblMealCode);
            UpdateItemPanelCenter.add(txtMealCode);

            UpdateItemPanelCenter.add(lblMealName);
            UpdateItemPanelCenter.add(txtMealName);

            UpdateItemPanelCenter.add(lblMealPrice);
            UpdateItemPanelCenter.add(txtMealPrice);

            UpdateItemPanelCenter.add(lblTakeAway);
            UpdateItemPanelCenter.add(txtTakeAway);

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

            //Adding panels to Meal Frame:
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
                String MealCode = txtMealCode.getText();
                String MealName = txtMealName.getText();
                String MealPrice = txtMealPrice.getText();
                String TakeAway = txtTakeAway.getText();
                String MealStatus = txtMealStatus.getText();

                //Read method
                Meal che = httpmethods.findMeal(MealCode);

                //booleans for checking valid input
                boolean MealNameCheck, MealPriceCheck;

                if (!MealName.matches("[a-zA-Z0-9]+")) {
                    MealNameCheck = false;
                    txtMealName.setText("Invalid  Input");
                } else {
                    MealNameCheck = true;
                }


                //If all are valid then call update httpmethod
                if (MealNameCheck) {

                    meal = new Meal.Builder().copy(che)
                            .setMealCode(MealCode)
                            .setMealName(MealName)
                            .setMealPrice(MealPrice)
                            .setTakeAway(TakeAway)
                            .setMealStatus(MealStatus)
                            .build();
                    httpmethods.updateMeal(meal);
                    txtMealCode.setText("");
                    txtMealName.setText("");
                    txtMealPrice.setText("");
                    txtTakeAway.setText("");
                    txtMealStatus.setText("");
                    JOptionPane.showMessageDialog(null, "Meal Updated");
                }


            }

            //When Get Info Button is clicked
            if (e.getActionCommand().equals("Get Info")) {
                boolean idCheck;

                //Use read method of readitemgui
                String id = txtMealCode.getText();
                httpsmethods httpmethods = new httpsmethods();
                Meal mea = httpmethods.findMeal(id);
                txtMealName.setText(mea.getMealName());
                txtMealPrice.setText(mea.getMealPrice());

            }

            //When Clear Button is clicked
            if (e.getActionCommand().equals("Clear")) {
                txtMealCode.setText("");
                txtMealName.setText("");
                txtMealPrice.setText("");
                txtTakeAway.setText("");
                txtMealStatus.setText("");
            }

            //When Exit Button is clicked
            if (e.getActionCommand().equals("Return")) {
                UpdateItemFrame.dispose();
            }
        }
}
