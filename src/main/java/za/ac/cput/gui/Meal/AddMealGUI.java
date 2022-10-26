package za.ac.cput.gui.Meal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMealGUI implements ActionListener {


    //Initializing Components
    private JFrame SaveMealFrame;
    private JPanel SaveMealPanelNorth, SaveMealPanelSouth, SaveMealPanelEast, SaveMealPanelWest, SaveMealPanelCenter;
    private JLabel lblHeading;

    private JLabel lblMealCode, lblMealName, lblMealPrice, lblMealTakeAway, lblMealStatus;
    private JTextField txtMealCode, txtMealName, txtMealPrice, txtMealTakeAway, txtMealStatus ;

    private JButton btnSave, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public AddMealGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        SaveMealFrame = new JFrame("Meal ");
        SaveMealPanelNorth = new JPanel();
        SaveMealPanelSouth = new JPanel();
        SaveMealPanelEast = new JPanel();
        SaveMealPanelWest = new JPanel();
        SaveMealPanelCenter = new JPanel();

        SaveMealPanelNorth.setBackground(Color.LIGHT_GRAY);
        SaveMealPanelEast.setBackground(Color.LIGHT_GRAY);
        SaveMealPanelSouth.setBackground(Color.LIGHT_GRAY);
        SaveMealPanelWest.setBackground(Color.LIGHT_GRAY);
        SaveMealPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Add Meal ", JLabel.CENTER);

        //Labels
        lblMealCode = new JLabel("MealCode:");
        lblMealName = new JLabel("MealName:");
        lblMealPrice = new JLabel("MealPrice:");
        lblMealTakeAway = new JLabel("MealTakeAway:");
        lblMealStatus = new JLabel("MealStatus:");


        //TextFields
        txtMealCode = new JTextField();
        txtMealName = new JTextField();
        txtMealPrice = new JTextField();
        txtMealTakeAway = new JTextField();
        txtMealStatus = new JTextField();

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
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");

    }
    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        SaveMealPanelNorth.setLayout(new GridLayout(4, 1));
        SaveMealPanelEast.setLayout(new GridLayout(13, 1));
        SaveMealPanelSouth.setLayout(new GridLayout(1, 4));
        SaveMealPanelWest.setLayout(new GridLayout(13, 1));
        SaveMealPanelCenter.setLayout(new GridLayout(13, 1));
        SaveMealPanelEast.setLayout(new GridLayout(13, 1));


        //Adding the components to the panels:
        SaveMealPanelNorth.add(Filler5);
        SaveMealPanelNorth.add(lblHeading);
        SaveMealPanelWest.add(Filler1);
        SaveMealPanelCenter.add(lblMealCode);
        SaveMealPanelCenter.add(txtMealCode);

        SaveMealPanelCenter.add(lblMealName);
        SaveMealPanelCenter.add(txtMealName);

        SaveMealPanelCenter.add(lblMealPrice);
        SaveMealPanelCenter.add(txtMealPrice);

        SaveMealPanelCenter.add(lblMealTakeAway);
        SaveMealPanelCenter.add(txtMealTakeAway);

        SaveMealPanelCenter.add(lblMealStatus);
        SaveMealPanelCenter.add(txtMealStatus);

        SaveMealPanelCenter.add(Filler4);


        //Panel East
        SaveMealPanelEast.add(Filler2);

        //Panel South:
        SaveMealPanelSouth.add(btnSave);
        SaveMealPanelSouth.add(btnClear);
        SaveMealPanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        SaveMealFrame.add(SaveMealPanelNorth, BorderLayout.NORTH);
        SaveMealFrame.add(SaveMealPanelSouth, BorderLayout.SOUTH);
        SaveMealFrame.add(SaveMealPanelEast, BorderLayout.EAST);
        SaveMealFrame.add(SaveMealPanelCenter, BorderLayout.CENTER);
        SaveMealFrame.add(SaveMealPanelWest, BorderLayout.WEST);


        //Telling compiler to listen for actions from the buttons:
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        SaveMealFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SaveMealFrame.pack();
        SaveMealFrame.setSize(600, 400);
        SaveMealFrame.setLocationRelativeTo(null);
        SaveMealFrame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //When Save Button is clicked
        if (e.getActionCommand().equals("Save")) {

            //Store textfield text in string
            String MealCode = txtMealCode.getText();
            String MealName = txtMealName.getText();
            String MealPrice = txtMealPrice.getText();
            String MealTakeAway = txtMealTakeAway.getText();
            String MealStatus = txtMealStatus.getText();


            //booleans for checking valid input
            boolean MealNameCheck;

            if (!MealName.matches("[a-zA-Z0-9]+")) {
                MealNameCheck = false;
                txtMealName.setText("Invalid  Input");
            } else {
                MealNameCheck = true;
            }

            //If all are valid then call save httpmethod
            if (MealNameCheck) {
                httpsmethods httpmethods = new httpsmethods();
                httpmethods.saveMeal(MealCode, MealName, MealPrice, MealTakeAway, MealStatus);
                txtMealCode.setText("");
                txtMealName.setText("");
                txtMealPrice.setText("");
                txtMealTakeAway.setText("");
                txtMealStatus.setText("");
            }
        }

        //When clear button is clicked
        if (e.getActionCommand().equals("Clear")) {
            txtMealCode.setText("");
            txtMealName.setText("");
            txtMealPrice.setText("");
            txtMealTakeAway.setText("");
            txtMealStatus.setText("");
        }

        //When exit button is clicked
        if (e.getActionCommand().equals("Return")) {
            SaveMealFrame.dispose();
        }
    }
}