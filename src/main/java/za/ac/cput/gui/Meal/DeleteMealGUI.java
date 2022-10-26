package za.ac.cput.gui.Meal;

import za.ac.cput.domain.Meal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMealGUI implements ActionListener {


    Meal meal;
        private JFrame DeleteMealFrame;
        private JPanel DeleteMealPanelNorth, DeleteMealPanelSouth, DeleteMealPanelEast, DeleteMealPanelWest, DeleteMealPanelCenter;
        private JLabel lblHeading, lblID;
        private JTextField txtMealCode;
        private JButton btnDelete, btnReturn, btnClear;
        private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
        private Font headingFont;


        //Setting Up GUI Components
        public DeleteMealGUI() {
            //Font
            headingFont = new Font("Arial", Font.BOLD, 18);

            //Panels
            DeleteMealFrame = new JFrame("Meal ");
            DeleteMealPanelNorth = new JPanel();
            DeleteMealPanelSouth = new JPanel();
            DeleteMealPanelEast = new JPanel();
            DeleteMealPanelWest = new JPanel();
            DeleteMealPanelCenter = new JPanel();

            DeleteMealPanelNorth.setBackground(Color.LIGHT_GRAY);
            DeleteMealPanelEast.setBackground(Color.LIGHT_GRAY);
            DeleteMealPanelSouth.setBackground(Color.LIGHT_GRAY);
            DeleteMealPanelWest.setBackground(Color.LIGHT_GRAY);
            DeleteMealPanelCenter.setBackground(Color.LIGHT_GRAY);

            //Heading
            lblHeading = new JLabel("Delete Meal Record", JLabel.CENTER);

            //Labels
            lblID = new JLabel("Enter MealCode:");

            //TextFields
            txtMealCode = new JTextField();

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
            btnDelete = new JButton("Delete");
            btnClear = new JButton("Clear");
            btnReturn = new JButton("Return");


        }


        //Setting GUI Layout
        public void setGUI() {
            //Panel Grids
            DeleteMealPanelNorth.setLayout(new GridLayout(2, 1));
            DeleteMealPanelEast.setLayout(new GridLayout(12, 1));
            DeleteMealPanelSouth.setLayout(new GridLayout(1, 3));
            DeleteMealPanelWest.setLayout(new GridLayout(12, 1));
            DeleteMealPanelCenter.setLayout(new GridLayout(12, 1));
            DeleteMealPanelEast.setLayout(new GridLayout(12, 1));

            //Adding the components to the panels:
            //Panel North:
            DeleteMealPanelNorth.add(Filler5);
            DeleteMealPanelNorth.add(lblHeading);

            //Panel West:
            DeleteMealPanelWest.add(Filler1);

            //Panel Center:
            DeleteMealPanelCenter.add(lblID);
            DeleteMealPanelCenter.add(txtMealCode);
            DeleteMealPanelCenter.add(Filler4);

            //Panel East
            DeleteMealPanelEast.add(Filler2);

            //Panel South:
            DeleteMealPanelSouth.add(btnDelete);
            DeleteMealPanelSouth.add(btnClear);
            DeleteMealPanelSouth.add(btnReturn);

            //Heading
            lblHeading.setFont(headingFont);



            //Adding panels to Meal Frame:
            DeleteMealFrame.add(DeleteMealPanelNorth, BorderLayout.NORTH);
            DeleteMealFrame.add(DeleteMealPanelSouth, BorderLayout.SOUTH);
            DeleteMealFrame.add(DeleteMealPanelEast, BorderLayout.EAST);
            DeleteMealFrame.add(DeleteMealPanelCenter, BorderLayout.CENTER);
            DeleteMealFrame.add(DeleteMealPanelWest, BorderLayout.WEST);

            //Telling compiler to listen for actions from the buttons:
            btnDelete.addActionListener(this);
            btnClear.addActionListener(this);
            btnReturn.addActionListener(this);

            //Set GUI:
            DeleteMealFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            DeleteMealFrame.pack();
            DeleteMealFrame.setSize(400, 300);
            DeleteMealFrame.setLocationRelativeTo(null);
            DeleteMealFrame.setVisible(true);

        }



        @Override
        public void actionPerformed(ActionEvent e) {

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
            }


            //When Clear Button is clicked
            if (e.getActionCommand().equals("Clear")) {
                txtMealCode.setText("");
            }

            //When Exit Button is clicked
            if (e.getActionCommand().equals("Return")) {
                DeleteMealFrame.dispose();
            }
        }
        }
