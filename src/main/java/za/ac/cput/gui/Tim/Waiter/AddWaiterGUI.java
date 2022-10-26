package za.ac.cput.gui.Tim.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWaiterGUI implements ActionListener {


    //Initializing Components
    private JFrame SaveWaiterFrame;
    private JPanel SaveWaiterPanelNorth, SaveWaiterPanelSouth, SaveWaiterPanelEast, SaveWaiterPanelWest, SaveWaiterPanelCenter;
    private JLabel lblHeading;

    private JLabel lblWaiterID, lblFirstName, lblLastName, lblEmail, lblAddress, lblContactNumber ;
    private JTextField txtWaiterID, txtFirstName, txtLastName, txtEmail, txtAddress, txtContactNumber ;

    private JButton btnSave, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public AddWaiterGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        SaveWaiterFrame = new JFrame("Customer ");
        SaveWaiterPanelNorth = new JPanel();
        SaveWaiterPanelSouth = new JPanel();
        SaveWaiterPanelEast = new JPanel();
        SaveWaiterPanelWest = new JPanel();
        SaveWaiterPanelCenter = new JPanel();

        SaveWaiterPanelNorth.setBackground(Color.LIGHT_GRAY);
        SaveWaiterPanelEast.setBackground(Color.LIGHT_GRAY);
        SaveWaiterPanelSouth.setBackground(Color.LIGHT_GRAY);
        SaveWaiterPanelWest.setBackground(Color.LIGHT_GRAY);
        SaveWaiterPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Add Customer ", JLabel.CENTER);

        //Labels
        lblWaiterID = new JLabel("CustomerID:");
        lblFirstName = new JLabel("FirstName:");
        lblLastName = new JLabel("LastName:");

        lblEmail = new JLabel("Email:");
        lblAddress = new JLabel("Address:");
        lblContactNumber = new JLabel("ContactNumber:");

        //TextFields
        txtWaiterID = new JTextField();
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
        SaveWaiterPanelNorth.setLayout(new GridLayout(4, 1));
        SaveWaiterPanelEast.setLayout(new GridLayout(13, 1));
        SaveWaiterPanelSouth.setLayout(new GridLayout(1, 4));
        SaveWaiterPanelWest.setLayout(new GridLayout(13, 1));
        SaveWaiterPanelCenter.setLayout(new GridLayout(13, 1));
        SaveWaiterPanelEast.setLayout(new GridLayout(13, 1));


        //Adding the components to the panels:
        //Panel North:
        SaveWaiterPanelNorth.add(Filler5);
        SaveWaiterPanelNorth.add(lblHeading);

        //Panel West:
        SaveWaiterPanelWest.add(Filler1);

        //Panel Center:
        SaveWaiterPanelCenter.add(lblWaiterID);
        SaveWaiterPanelCenter.add(txtWaiterID);

        SaveWaiterPanelCenter.add(lblFirstName);
        SaveWaiterPanelCenter.add(txtFirstName);

        SaveWaiterPanelCenter.add(lblLastName);
        SaveWaiterPanelCenter.add(txtLastName);

        SaveWaiterPanelCenter.add(lblEmail);
        SaveWaiterPanelCenter.add(txtEmail);

        SaveWaiterPanelCenter.add(lblAddress);
        SaveWaiterPanelCenter.add(txtAddress);

        SaveWaiterPanelCenter.add(lblContactNumber);
        SaveWaiterPanelCenter.add(txtContactNumber);

        SaveWaiterPanelCenter.add(Filler4);


        //Panel East
        SaveWaiterPanelEast.add(Filler2);

        //Panel South:
        SaveWaiterPanelSouth.add(btnSave);
        SaveWaiterPanelSouth.add(btnClear);
        SaveWaiterPanelSouth.add(btnReturn);


        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        SaveWaiterFrame.add(SaveWaiterPanelNorth, BorderLayout.NORTH);
        SaveWaiterFrame.add(SaveWaiterPanelSouth, BorderLayout.SOUTH);
        SaveWaiterFrame.add(SaveWaiterPanelEast, BorderLayout.EAST);
        SaveWaiterFrame.add(SaveWaiterPanelCenter, BorderLayout.CENTER);
        SaveWaiterFrame.add(SaveWaiterPanelWest, BorderLayout.WEST);


        //Telling compiler to listen for actions from the buttons:
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        SaveWaiterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SaveWaiterFrame.pack();
        SaveWaiterFrame.setSize(600, 400);
        SaveWaiterFrame.setLocationRelativeTo(null);
        SaveWaiterFrame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //When Save Button is clicked
        if (e.getActionCommand().equals("Save")) {

            //Store textfield text in string
            String CustomerID = txtWaiterID.getText();
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
                Httpsmethods httpmethods = new Httpsmethods();
                httpmethods.saveWaiter(CustomerID, FirstName, LastName, Email, Address, ContactNumber);
                txtWaiterID.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                txtContactNumber.setText("");
            }
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtWaiterID.setText("");
            txtFirstName.setText("");
            txtLastName.setText("");
            txtEmail.setText("");
            txtAddress.setText("");
            txtContactNumber.setText("");
        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Return")){
            SaveWaiterFrame.dispose();
        }

    }
}
