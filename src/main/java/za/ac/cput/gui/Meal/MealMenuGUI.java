package za.ac.cput.gui.Meal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MealMenuGUI implements ActionListener {

        //Initializing Components
        private JFrame MenuFrame;
        private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
        private JLabel lblHeading;
        private JButton btnAddMeal, btnDeleteMeal, btnViewMeal, btnUpdateMeal, btnViewAllMeals, btnReturn;
        private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
        private Font headingFont;
        Color btnColor = Color.WHITE;


        //Setting Up GUI Components
        public MealMenuGUI() {
            //Font
            headingFont = new Font("Arial", Font.BOLD, 18);

            //Panels
            MenuFrame = new JFrame("Meal ");
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
            lblHeading = new JLabel("Meal Interface", JLabel.CENTER);

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
            btnAddMeal = new JButton("Add Meal");
            btnAddMeal.setBackground(btnColor);

            btnViewMeal = new JButton("View Meal");
            btnViewMeal.setBackground(btnColor);

            btnUpdateMeal = new JButton("Update Meal");
            btnUpdateMeal.setBackground(btnColor);

            btnDeleteMeal = new JButton("Delete Meal Record");
            btnDeleteMeal.setBackground(btnColor);

            btnViewAllMeals = new JButton("View Meal List");
            btnViewAllMeals.setBackground(btnColor);

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
            panelCenter.add(btnAddMeal);
            panelCenter.add(btnViewMeal);
            panelCenter.add(btnUpdateMeal);
            panelCenter.add(btnDeleteMeal);
            panelCenter.add(btnViewAllMeals);
            panelCenter.add(Filler4);

            //Panel East
            panelEast.add(Filler2);

            //Panel South:
            panelSouth.add(btnReturn);


            //Heading
            lblHeading.setFont(headingFont);

            //Adding panels to Meal Frame:
            MenuFrame.add(panelNorth, BorderLayout.NORTH);
            MenuFrame.add(panelSouth, BorderLayout.SOUTH);
            MenuFrame.add(panelEast, BorderLayout.EAST);
            MenuFrame.add(panelCenter, BorderLayout.CENTER);
            MenuFrame.add(panelWest, BorderLayout.WEST);

            //Telling compiler to listen for actions from the buttons:
            btnAddMeal.addActionListener(this);
            btnViewMeal.addActionListener(this);
            btnUpdateMeal.addActionListener(this);
            btnDeleteMeal.addActionListener(this);
            btnViewMeal.addActionListener(this);
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

            //When Add Meal Button is clicked
            if (e.getActionCommand().equals("Add Meal")) {
                AddMealGUI addItemGUI = new AddMealGUI();
                addItemGUI.setGUI();
            }


            if (e.getActionCommand().equals("View Meal")) {
                ReadMealGUI readMealGUI = new ReadMealGUI();
                readMealGUI.setGUI();
            }

            //When Update Meal Button is clicked
            if (e.getActionCommand().equals("Update Meal")) {
                UpdateMealGUI updateMealGUI = new UpdateMealGUI();
                updateMealGUI.setGUI();
            }

            //When Update Meal Button is clicked
            if (e.getActionCommand().equals("Delete Meal Record")) {
                DeleteMealGUI deleteMealGUI = new DeleteMealGUI();
                deleteMealGUI.setGUI();
            }

            //When Update Meal Button is clicked
            if (e.getActionCommand().equals("Delete Meal Record")) {
                FindAllMealGUI findAllMealGUI = new FindAllMealGUI();
                findAllMealGUI.setGUI();
            }

            if (e.getActionCommand().equals("Return")) {
                MenuFrame.dispose();
            }
        }
    }