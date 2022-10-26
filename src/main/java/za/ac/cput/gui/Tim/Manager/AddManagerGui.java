package za.ac.cput.gui.Tim.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddManagerGui implements ActionListener {


    //Initializing Components
    private JFrame SaveManagerFrame;
    private JPanel SaveManagerPanelNorth, SaveManagerPanelSouth, SaveManagerPanelEast, SaveManagerPanelWest, SaveManagerPanelCenter;
    private JLabel lblHeading;

    private JLabel lblManagerID, lblFirstName, lblLastName, lblEmail, lblAddress, lblContactNumber ;
    private JTextField txtManagerID, txtFirstName, txtLastName, txtEmail, txtAddress, txtContactNumber ;

    private JButton btnSave, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public AddManagerGui() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        SaveManagerFrame = new JFrame("Customer ");
        SaveManagerPanelNorth = new JPanel();
        SaveManagerPanelSouth = new JPanel();
        SaveManagerPanelEast = new JPanel();
        SaveManagerPanelWest = new JPanel();
        SaveManagerPanelCenter = new JPanel();

        SaveManagerPanelNorth.setBackground(Color.LIGHT_GRAY);
        SaveManagerPanelEast.setBackground(Color.LIGHT_GRAY);
        SaveManagerPanelSouth.setBackground(Color.LIGHT_GRAY);
        SaveManagerPanelWest.setBackground(Color.LIGHT_GRAY);
        SaveManagerPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Add Customer ", JLabel.CENTER);

        //Labels
        lblManagerID = new JLabel("CustomerID:");
        lblFirstName = new JLabel("FirstName:");
        lblLastName = new JLabel("LastName:");

        lblEmail = new JLabel("Email:");
        lblAddress = new JLabel("Address:");
        lblContactNumber = new JLabel("ContactNumber:");

        //TextFields
        txtManagerID = new JTextField();
        txtFirstName = new JTextField();
        txtLastName = new JTextField();

        txtEmail = new JTextField();
        txtAddress = new JTextField();
        txtContactNumber = new JTextField();

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
        SaveManagerPanelNorth.setLayout(new GridLayout(4, 1));
        SaveManagerPanelEast.setLayout(new GridLayout(13, 1));
        SaveManagerPanelSouth.setLayout(new GridLayout(1, 4));
        SaveManagerPanelWest.setLayout(new GridLayout(13, 1));
        SaveManagerPanelCenter.setLayout(new GridLayout(13, 1));
        SaveManagerPanelEast.setLayout(new GridLayout(13, 1));


        //Adding the components to the panels:
        //Panel North:
        SaveManagerPanelNorth.add(Filler5);
        SaveManagerPanelNorth.add(lblHeading);

        //Panel West:
        SaveManagerPanelWest.add(Filler1);

        //Panel Center:
        SaveManagerPanelCenter.add(lblManagerID);
        SaveManagerPanelCenter.add(txtManagerID);

        SaveManagerPanelCenter.add(lblFirstName);
        SaveManagerPanelCenter.add(txtFirstName);

        SaveManagerPanelCenter.add(lblLastName);
        SaveManagerPanelCenter.add(txtLastName);

        SaveManagerPanelCenter.add(lblEmail);
        SaveManagerPanelCenter.add(txtEmail);

        SaveManagerPanelCenter.add(lblAddress);
        SaveManagerPanelCenter.add(txtAddress);

        SaveManagerPanelCenter.add(lblContactNumber);
        SaveManagerPanelCenter.add(txtContactNumber);

        SaveManagerPanelCenter.add(Filler4);


        //Panel East
        SaveManagerPanelEast.add(Filler2);

        //Panel South:
        SaveManagerPanelSouth.add(btnSave);
        SaveManagerPanelSouth.add(btnClear);
        SaveManagerPanelSouth.add(btnReturn);


        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        SaveManagerFrame.add(SaveManagerPanelNorth, BorderLayout.NORTH);
        SaveManagerFrame.add(SaveManagerPanelSouth, BorderLayout.SOUTH);
        SaveManagerFrame.add(SaveManagerPanelEast, BorderLayout.EAST);
        SaveManagerFrame.add(SaveManagerPanelCenter, BorderLayout.CENTER);
        SaveManagerFrame.add(SaveManagerPanelWest, BorderLayout.WEST);


        //Telling compiler to listen for actions from the buttons:
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        SaveManagerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SaveManagerFrame.pack();
        SaveManagerFrame.setSize(600, 400);
        SaveManagerFrame.setLocationRelativeTo(null);
        SaveManagerFrame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //When Save Button is clicked
        if (e.getActionCommand().equals("Save")) {

            //Store textfield text in string
            String ManagerID = txtManagerID.getText();
            String FirstName = txtFirstName.getText();
            String LastName = txtLastName.getText();
            String Email = txtEmail.getText();
            String Address = txtAddress.getText();
            String ContactNumber = txtContactNumber.getText();

            //booleans for checking valid input
            boolean FirstNameCheck, LastNameCheck;

            if(!FirstName.matches("[a-zA-Z0-9]+")){
                FirstNameCheck = false;
                txtFirstName.setText("Invalid  Input");
            }
            else{
                FirstNameCheck = true;
            }

            if(!LastName.matches("[a-zA-Z0-9]+")){
                LastNameCheck = false;
                txtFirstName.setText("Invalid  Input");
            }
            else{
                LastNameCheck = true;
            }

            //If all are valid then call save httpmethod
            if(FirstNameCheck && LastNameCheck ) {
                httpsmethods httpmethods = new httpsmethods();
                httpmethods.saveManager(ManagerID, FirstName, LastName, Email, Address, ContactNumber);
                txtManagerID.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                txtContactNumber.setText("");
            }
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtManagerID.setText("");
            txtFirstName.setText("");
            txtLastName.setText("");
            txtEmail.setText("");
            txtAddress.setText("");
            txtContactNumber.setText("");
        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Return")){
            SaveManagerFrame.dispose();
        }

    }
}
