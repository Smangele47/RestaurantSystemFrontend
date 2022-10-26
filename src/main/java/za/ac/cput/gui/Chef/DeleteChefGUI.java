package za.ac.cput.gui.Chef;

import za.ac.cput.domain.Chef;
import za.ac.cput.domain.Chef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteChefGUI implements ActionListener {

        //Initializing Components
    Chef chef;
        private JFrame DeleteChefFrame;
        private JPanel DeleteChefPanelNorth, DeleteChefPanelSouth, DeleteChefPanelEast, DeleteChefPanelWest, DeleteChefPanelCenter;
        private JLabel lblHeading, lblID;
        private JTextField txtChefID;
        private JButton btnDelete, btnReturn, btnClear;
        private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
        private Font headingFont;


        //Setting Up GUI Components
        public DeleteChefGUI() {
            //Font
            headingFont = new Font("Arial", Font.BOLD, 18);

            //Panels
            DeleteChefFrame = new JFrame("Chef ");
            DeleteChefPanelNorth = new JPanel();
            DeleteChefPanelSouth = new JPanel();
            DeleteChefPanelEast = new JPanel();
            DeleteChefPanelWest = new JPanel();
            DeleteChefPanelCenter = new JPanel();

            DeleteChefPanelNorth.setBackground(Color.LIGHT_GRAY);
            DeleteChefPanelEast.setBackground(Color.LIGHT_GRAY);
            DeleteChefPanelSouth.setBackground(Color.LIGHT_GRAY);
            DeleteChefPanelWest.setBackground(Color.LIGHT_GRAY);
            DeleteChefPanelCenter.setBackground(Color.LIGHT_GRAY);

            //Heading
            lblHeading = new JLabel("Delete Chef Record", JLabel.CENTER);

            //Labels
            lblID = new JLabel("Enter ChefID:");

            //TextFields
            txtChefID = new JTextField();

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
            DeleteChefPanelNorth.setLayout(new GridLayout(2, 1));
            DeleteChefPanelEast.setLayout(new GridLayout(12, 1));
            DeleteChefPanelSouth.setLayout(new GridLayout(1, 3));
            DeleteChefPanelWest.setLayout(new GridLayout(12, 1));
            DeleteChefPanelCenter.setLayout(new GridLayout(12, 1));
            DeleteChefPanelEast.setLayout(new GridLayout(12, 1));

            //Adding the components to the panels:
            //Panel North:
            DeleteChefPanelNorth.add(Filler5);
            DeleteChefPanelNorth.add(lblHeading);

            //Panel West:
            DeleteChefPanelWest.add(Filler1);

            //Panel Center:
            DeleteChefPanelCenter.add(lblID);
            DeleteChefPanelCenter.add(txtChefID);
            DeleteChefPanelCenter.add(Filler4);

            //Panel East
            DeleteChefPanelEast.add(Filler2);

            //Panel South:
            DeleteChefPanelSouth.add(btnDelete);
            DeleteChefPanelSouth.add(btnClear);
            DeleteChefPanelSouth.add(btnReturn);

            //Heading
            lblHeading.setFont(headingFont);



            //Adding panels to Chef Frame:
            DeleteChefFrame.add(DeleteChefPanelNorth, BorderLayout.NORTH);
            DeleteChefFrame.add(DeleteChefPanelSouth, BorderLayout.SOUTH);
            DeleteChefFrame.add(DeleteChefPanelEast, BorderLayout.EAST);
            DeleteChefFrame.add(DeleteChefPanelCenter, BorderLayout.CENTER);
            DeleteChefFrame.add(DeleteChefPanelWest, BorderLayout.WEST);

            //Telling compiler to listen for actions from the buttons:
            btnDelete.addActionListener(this);
            btnClear.addActionListener(this);
            btnReturn.addActionListener(this);

            //Set GUI:
            DeleteChefFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            DeleteChefFrame.pack();
            DeleteChefFrame.setSize(400, 300);
            DeleteChefFrame.setLocationRelativeTo(null);
            DeleteChefFrame.setVisible(true);

        }



        @Override
        public void actionPerformed(ActionEvent e) {

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
            }


            //When Clear Button is clicked
            if (e.getActionCommand().equals("Clear")) {
                txtChefID.setText("");
            }

            //When Exit Button is clicked
            if (e.getActionCommand().equals("Return")) {
                DeleteChefFrame.dispose();
            }
        }
        }
