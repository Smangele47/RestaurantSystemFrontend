package za.ac.cput.gui.Chef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChefMenuGUI implements ActionListener {

        //Initializing Components
        private JFrame MenuFrame;
        private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
        private JLabel lblHeading;
        private JButton btnAddChef, btnDeleteChef, btnViewChef, btnUpdateChef, btnViewAllChefs, btnReturn;
        private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
        private Font headingFont;
        Color btnColor = Color.WHITE;


        //Setting Up GUI Components
        public ChefMenuGUI() {
            //Font
            headingFont = new Font("Arial", Font.BOLD, 18);

            //Panels
            MenuFrame = new JFrame("Chef ");
            panelNorth = new JPanel();
            panelSouth = new JPanel();
            panelEast = new JPanel();
            panelWest = new JPanel();
            panelCenter = new JPanel();
            panelNorth.setBackground(Color.LIGHT_GRAY);
            panelEast.setBackground(Color.LIGHT_GRAY);
            panelSouth.setBackground(Color.LIGHT_GRAY);
            panelWest.setBackground(Color.LIGHT_GRAY);
            panelCenter.setBackground(Color.LIGHT_GRAY);

            //Heading
            lblHeading = new JLabel("Chef Interface", JLabel.CENTER);

            //Fillers:
            Filler1 = new JLabel("=====");
            Filler1.setForeground(Color.LIGHT_GRAY);
            Filler2 = new JLabel("=====");
            Filler2.setForeground(Color.LIGHT_GRAY);
            Filler3 = new JLabel("================================");
            Filler3.setForeground(Color.LIGHT_GRAY);
            Filler4 = new JLabel("================================");
            Filler4.setForeground(Color.LIGHT_GRAY);
            Filler5 = new JLabel("================================");
            Filler5.setForeground(Color.LIGHT_GRAY);

            //Buttons:
            btnAddChef = new JButton("Add Chef");
            btnAddChef.setBackground(btnColor);

            btnViewChef = new JButton("View Chef");
            btnViewChef.setBackground(btnColor);

            btnUpdateChef = new JButton("Update Chef");
            btnUpdateChef.setBackground(btnColor);

            btnDeleteChef = new JButton("Delete Chef Record");
            btnDeleteChef.setBackground(btnColor);

            btnViewAllChefs = new JButton("View Chef List");
            btnViewAllChefs.setBackground(btnColor);

            btnReturn = new JButton("Return");
            btnReturn.setBackground(btnColor);

        }

        //Setting GUI Layout
        public void setGUI() {
            //Panel Grids
            panelNorth.setLayout(new GridLayout(2, 1));
            panelEast.setLayout(new GridLayout(5, 1));
            panelSouth.setLayout(new GridLayout(1, 3));
            panelWest.setLayout(new GridLayout(5, 1));
            panelCenter.setLayout(new GridLayout(7, 1));

            //Adding the components to the panels:
            //Panel North:
            panelNorth.add(Filler5);
            panelNorth.add(lblHeading);

            //Panel West:
            panelWest.add(Filler1);

            //Panel Center:
            panelCenter.add(Filler3);
            panelCenter.add(btnAddChef);
            panelCenter.add(btnViewChef);
            panelCenter.add(btnUpdateChef);
            panelCenter.add(btnDeleteChef);
            panelCenter.add(btnViewAllChefs);
            panelCenter.add(Filler4);

            //Panel East
            panelEast.add(Filler2);

            //Panel South:
            panelSouth.add(btnReturn);


            //Heading
            lblHeading.setFont(headingFont);

            //Adding panels to Chef Frame:
            MenuFrame.add(panelNorth, BorderLayout.NORTH);
            MenuFrame.add(panelSouth, BorderLayout.SOUTH);
            MenuFrame.add(panelEast, BorderLayout.EAST);
            MenuFrame.add(panelCenter, BorderLayout.CENTER);
            MenuFrame.add(panelWest, BorderLayout.WEST);

            //Telling compiler to listen for actions from the buttons:
            btnAddChef.addActionListener(this);
            btnViewChef.addActionListener(this);
            btnUpdateChef.addActionListener(this);
            btnDeleteChef.addActionListener(this);
            btnViewChef.addActionListener(this);
            btnReturn.addActionListener(this);

            //Set GUI:
            MenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            MenuFrame.pack();
            MenuFrame.setSize(350, 400);
            MenuFrame.setLocationRelativeTo(null);
            MenuFrame.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //When Add Chef Button is clicked
            if (e.getActionCommand().equals("Add Chef")) {
                AddChefGUI addItemGUI = new AddChefGUI();
                addItemGUI.setGUI();
            }


            if (e.getActionCommand().equals("View Chef")) {
                ReadChefGUI readChefGUI = new ReadChefGUI();
                readChefGUI.setGUI();
            }

            //When Update Chef Button is clicked
            if (e.getActionCommand().equals("Update Chef")) {
                UpdateChefGUI updateChefGUI = new UpdateChefGUI();
                updateChefGUI.setGUI();
            }

            //When Update Chef Button is clickeds
            if (e.getActionCommand().equals("Delete Chef Record")) {
                DeleteChefGUI deleteChefGUI = new DeleteChefGUI();
                deleteChefGUI.setGUI();
            }

            //When Update Chef Button is clicked
            if (e.getActionCommand().equals("Delete Chef Record")) {
                FindAllChefGUI findAllChefGUI = new FindAllChefGUI();
                findAllChefGUI.setGUI();
            }

            if (e.getActionCommand().equals("Return")) {
                MenuFrame.dispose();
            }
        }
    }