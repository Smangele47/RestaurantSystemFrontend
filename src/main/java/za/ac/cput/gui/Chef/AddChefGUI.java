package za.ac.cput.gui.Chef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddChefGUI implements ActionListener {


    //Initializing Components
    private JFrame SaveChefFrame;
    private JPanel SaveChefPanelNorth, SaveChefPanelSouth, SaveChefPanelEast, SaveChefPanelWest, SaveChefPanelCenter;
    private JLabel lblHeading;

    private JLabel lblChefID, lblChefName, lblChefGender, lblChefSalary, lblMealStatus;
    private JTextField txtChefID, txtChefName, txtChefGender, txtChefSalary, txtMealStatus ;

    private JButton btnSave, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public AddChefGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        SaveChefFrame = new JFrame("Chef ");
        SaveChefPanelNorth = new JPanel();
        SaveChefPanelSouth = new JPanel();
        SaveChefPanelEast = new JPanel();
        SaveChefPanelWest = new JPanel();
        SaveChefPanelCenter = new JPanel();

        SaveChefPanelNorth.setBackground(Color.LIGHT_GRAY);
        SaveChefPanelEast.setBackground(Color.LIGHT_GRAY);
        SaveChefPanelSouth.setBackground(Color.LIGHT_GRAY);
        SaveChefPanelWest.setBackground(Color.LIGHT_GRAY);
        SaveChefPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Add Chef ", JLabel.CENTER);

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
        SaveChefPanelNorth.setLayout(new GridLayout(4, 1));
        SaveChefPanelEast.setLayout(new GridLayout(13, 1));
        SaveChefPanelSouth.setLayout(new GridLayout(1, 4));
        SaveChefPanelWest.setLayout(new GridLayout(13, 1));
        SaveChefPanelCenter.setLayout(new GridLayout(13, 1));
        SaveChefPanelEast.setLayout(new GridLayout(13, 1));


        //Adding the components to the panels:
        SaveChefPanelNorth.add(Filler5);
        SaveChefPanelNorth.add(lblHeading);
        SaveChefPanelWest.add(Filler1);
        SaveChefPanelCenter.add(lblChefID);
        SaveChefPanelCenter.add(txtChefID);

        SaveChefPanelCenter.add(lblChefName);
        SaveChefPanelCenter.add(txtChefName);

        SaveChefPanelCenter.add(lblChefGender);
        SaveChefPanelCenter.add(txtChefGender);

        SaveChefPanelCenter.add(lblChefSalary);
        SaveChefPanelCenter.add(txtChefSalary);

        SaveChefPanelCenter.add(lblMealStatus);
        SaveChefPanelCenter.add(txtMealStatus);

        SaveChefPanelCenter.add(Filler4);


        //Panel East
        SaveChefPanelEast.add(Filler2);

        //Panel South:
        SaveChefPanelSouth.add(btnSave);
        SaveChefPanelSouth.add(btnClear);
        SaveChefPanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        SaveChefFrame.add(SaveChefPanelNorth, BorderLayout.NORTH);
        SaveChefFrame.add(SaveChefPanelSouth, BorderLayout.SOUTH);
        SaveChefFrame.add(SaveChefPanelEast, BorderLayout.EAST);
        SaveChefFrame.add(SaveChefPanelCenter, BorderLayout.CENTER);
        SaveChefFrame.add(SaveChefPanelWest, BorderLayout.WEST);


        //Telling compiler to listen for actions from the buttons:
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        SaveChefFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SaveChefFrame.pack();
        SaveChefFrame.setSize(600, 400);
        SaveChefFrame.setLocationRelativeTo(null);
        SaveChefFrame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //When Save Button is clicked
        if (e.getActionCommand().equals("Save")) {

            //Store textfield text in string
            String ChefID = txtChefID.getText();
            String ChefName = txtChefName.getText();
            String ChefGender = txtChefGender.getText();
            String ChefSalary = txtChefSalary.getText();
            String MealStatus = txtMealStatus.getText();


            //booleans for checking valid input
            boolean ChefNameCheck;

            if (!ChefName.matches("[a-zA-Z0-9]+")) {
                ChefNameCheck = false;
                txtChefName.setText("Invalid  Input");
            } else {
                ChefNameCheck = true;
            }

            //If all are valid then call save httpmethod
            if (ChefNameCheck) {
                httpsmethods httpmethods = new httpsmethods();
                httpmethods.saveChef(ChefID, ChefName, ChefGender, ChefSalary, MealStatus);
                txtChefID.setText("");
                txtChefName.setText("");
                txtChefGender.setText("");
                txtChefSalary.setText("");
                txtMealStatus.setText("");
            }
        }

        //When clear button is clicked
        if (e.getActionCommand().equals("Clear")) {
            txtChefID.setText("");
            txtChefName.setText("");
            txtChefGender.setText("");
            txtChefSalary.setText("");
            txtMealStatus.setText("");
        }

        //When exit button is clicked
        if (e.getActionCommand().equals("Return")) {
            SaveChefFrame.dispose();
        }
    }
}