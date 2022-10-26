package za.ac.cput.gui.Customer;

/*
    Author: Damone Hartnick 219093717
    Date: October 2022
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerGui implements ActionListener {


    //Initializing Components
    private JFrame SaveCustomerFrame;
    private JPanel SaveCustomerPanelNorth, SaveCustomerPanelSouth, SaveCustomerPanelEast, SaveCustomerPanelWest, SaveCustomerPanelCenter;
    private JLabel lblHeading;

    private JLabel lblCustomerID, lblFirstName, lblLastName, lblEmail, lblAddress, lblContactNumber ;
    private JTextField txtCustomerID, txtFirstName, txtLastName, txtEmail, txtAddress, txtContactNumber ;

    private JButton btnSave, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public AddCustomerGui() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        SaveCustomerFrame = new JFrame("Customer ");
        SaveCustomerPanelNorth = new JPanel();
        SaveCustomerPanelSouth = new JPanel();
        SaveCustomerPanelEast = new JPanel();
        SaveCustomerPanelWest = new JPanel();
        SaveCustomerPanelCenter = new JPanel();

        SaveCustomerPanelNorth.setBackground(Color.LIGHT_GRAY);
        SaveCustomerPanelEast.setBackground(Color.LIGHT_GRAY);
        SaveCustomerPanelSouth.setBackground(Color.LIGHT_GRAY);
        SaveCustomerPanelWest.setBackground(Color.LIGHT_GRAY);
        SaveCustomerPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Add Customer ", JLabel.CENTER);

        //Labels
        lblCustomerID = new JLabel("CustomerID:");
        lblFirstName = new JLabel("FirstName:");
        lblLastName = new JLabel("LastName:");

        lblEmail = new JLabel("Email:");
        lblAddress = new JLabel("Address:");
        lblContactNumber = new JLabel("ContactNumber:");

        //TextFields
        txtCustomerID = new JTextField();
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
            SaveCustomerPanelNorth.setLayout(new GridLayout(4, 1));
            SaveCustomerPanelEast.setLayout(new GridLayout(13, 1));
            SaveCustomerPanelSouth.setLayout(new GridLayout(1, 4));
            SaveCustomerPanelWest.setLayout(new GridLayout(13, 1));
            SaveCustomerPanelCenter.setLayout(new GridLayout(13, 1));
            SaveCustomerPanelEast.setLayout(new GridLayout(13, 1));


            //Adding the components to the panels:
            //Panel North:
            SaveCustomerPanelNorth.add(Filler5);
            SaveCustomerPanelNorth.add(lblHeading);

            //Panel West:
            SaveCustomerPanelWest.add(Filler1);

            //Panel Center:
            SaveCustomerPanelCenter.add(lblCustomerID);
            SaveCustomerPanelCenter.add(txtCustomerID);

            SaveCustomerPanelCenter.add(lblFirstName);
            SaveCustomerPanelCenter.add(txtFirstName);

            SaveCustomerPanelCenter.add(lblLastName);
            SaveCustomerPanelCenter.add(txtLastName);

            SaveCustomerPanelCenter.add(lblEmail);
            SaveCustomerPanelCenter.add(txtEmail);

            SaveCustomerPanelCenter.add(lblAddress);
            SaveCustomerPanelCenter.add(txtAddress);

            SaveCustomerPanelCenter.add(lblContactNumber);
            SaveCustomerPanelCenter.add(txtContactNumber);

            SaveCustomerPanelCenter.add(Filler4);


            //Panel East
            SaveCustomerPanelEast.add(Filler2);

            //Panel South:
            SaveCustomerPanelSouth.add(btnSave);
            SaveCustomerPanelSouth.add(btnClear);
            SaveCustomerPanelSouth.add(btnReturn);


            //Heading
            lblHeading.setFont(headingFont);

            //Adding panels to Customer Frame:
            SaveCustomerFrame.add(SaveCustomerPanelNorth, BorderLayout.NORTH);
            SaveCustomerFrame.add(SaveCustomerPanelSouth, BorderLayout.SOUTH);
            SaveCustomerFrame.add(SaveCustomerPanelEast, BorderLayout.EAST);
            SaveCustomerFrame.add(SaveCustomerPanelCenter, BorderLayout.CENTER);
            SaveCustomerFrame.add(SaveCustomerPanelWest, BorderLayout.WEST);


            //Telling compiler to listen for actions from the buttons:
            btnSave.addActionListener(this);
            btnClear.addActionListener(this);
            btnReturn.addActionListener(this);

            //Set GUI:
            SaveCustomerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            SaveCustomerFrame.pack();
            SaveCustomerFrame.setSize(600, 400);
            SaveCustomerFrame.setLocationRelativeTo(null);
            SaveCustomerFrame.setVisible(true);

        }


    @Override
    public void actionPerformed(ActionEvent e) {

        //When Save Button is clicked
        if (e.getActionCommand().equals("Save")) {

            //Store textfield text in string
            String CustomerID = txtCustomerID.getText();
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
                httpmethods.saveCustomer(CustomerID, FirstName, LastName, Email, Address, ContactNumber);
                txtCustomerID.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                txtContactNumber.setText("");
            }
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtCustomerID.setText("");
            txtFirstName.setText("");
            txtLastName.setText("");
            txtEmail.setText("");
            txtAddress.setText("");
            txtContactNumber.setText("");
        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Return")){
            SaveCustomerFrame.dispose();
        }

    }
}
