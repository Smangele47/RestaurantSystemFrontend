package za.ac.cput.gui.Tim.Manager;

import za.ac.cput.domain.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateManagerGUI implements ActionListener {

    //Initializing Components
    private JFrame UpdateItemFrame;
    private JPanel UpdateItemPanelNorth, UpdateItemPanelSouth, UpdateItemPanelEast, UpdateItemPanelWest, UpdateItemPanelCenter;
    private JLabel lblHeading;
    private JLabel lblManagerID, lblFirstName, lblLastName, lblEmail, lblAddress, lblContactNumber;
    private JTextField txtManagerID, txtFirstName,txtLastName, txtEmail, txtAddress, txtContactNumber;
    private JButton btnUpdate, btnReturn, btnClear, btnGet;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Manager manager;

    public UpdateManagerGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        UpdateItemFrame = new JFrame("Customer ");
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
        lblHeading = new JLabel("Update Customer", JLabel.CENTER);



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
        UpdateItemPanelCenter.add(lblManagerID);
        UpdateItemPanelCenter.add(txtManagerID);

        UpdateItemPanelCenter.add(lblFirstName);
        UpdateItemPanelCenter.add(txtFirstName);

        UpdateItemPanelCenter.add(lblLastName);
        UpdateItemPanelCenter.add(txtLastName);

        UpdateItemPanelCenter.add(lblEmail);
        UpdateItemPanelCenter.add(txtEmail);

        UpdateItemPanelCenter.add(lblAddress);
        UpdateItemPanelCenter.add(txtAddress);

        UpdateItemPanelCenter.add(lblContactNumber);
        UpdateItemPanelCenter.add(txtContactNumber);

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

        //Adding panels to Customer Frame:
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

        if(e.getActionCommand().equals("Update")){
            httpsmethods httpmethods = new httpsmethods();

            //Store textfield text in string
            String managerID = txtManagerID.getText();
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();
            String contactNumber = txtContactNumber.getText();

            //Read method
            Manager man = httpmethods.findManager(managerID);

            //booleans for checking valid input
            boolean FirstNameCheck, LastNameCheck;

            if(!firstName.matches("[a-zA-Z0-9]+")){
                FirstNameCheck = false;
                txtFirstName.setText("Invalid  Input");
            }
            else{
                FirstNameCheck = true;
            }

            if(!lastName.matches("[a-zA-Z0-9]+")){
                LastNameCheck = false;
                txtFirstName.setText("Invalid  Input");
            }
            else{
                LastNameCheck = true;
            }



            //If all are valid then call update httpmethod
            if(FirstNameCheck && LastNameCheck ){

                manager = new Manager.Builder().copy(man)
                        .setManagerID(managerID)
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setAddress(address)
                        .setContactNumber(contactNumber)
                        .build();
                httpmethods.updateManager(manager);
                txtManagerID.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                txtContactNumber.setText("");
                JOptionPane.showMessageDialog(null, "Manager Updated");
            }


        }

        //When Get Info Button is clicked
        if(e.getActionCommand().equals("Get Info")){
            boolean idCheck;

            //Use read method of readitemgui
            String id = txtManagerID.getText();
            httpsmethods httpmethods = new httpsmethods();
            Manager man = httpmethods.findManager(id);
            txtFirstName.setText(man.getFirstName());
            txtLastName.setText(man.getLastName());

        }

        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtManagerID.setText("");
            txtFirstName.setText("");
            txtLastName.setText("");
            txtEmail.setText("");
            txtAddress.setText("");
            txtContactNumber.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            UpdateItemFrame.dispose();
        }

    }
}
