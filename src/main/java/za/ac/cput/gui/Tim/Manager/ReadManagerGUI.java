package za.ac.cput.gui.Tim.Manager;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadManagerGUI implements ActionListener {

    //Initializing Components
    private JFrame ReadItemFrame;
    private JPanel ReadItemPanelNorth, ReadItemPanelSouth, ReadItemPanelEast, ReadItemPanelWest, ReadItemPanelCenter;
    private JLabel lblHeading;
    private JLabel lblManagerID, lblFirstName, lblLastName, lblEmail, lblAddress, lblContactNumber;
    private JTextField txtManagerID, txtFirstName, txtLastName, txtEmail, txtAddress, txtContactNumber;
    private JButton btnRead, btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public ReadManagerGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        ReadItemFrame = new JFrame("Customer: ");
        ReadItemPanelNorth = new JPanel();
        ReadItemPanelSouth = new JPanel();
        ReadItemPanelEast = new JPanel();
        ReadItemPanelWest = new JPanel();
        ReadItemPanelCenter = new JPanel();
        ReadItemPanelNorth.setBackground(Color.LIGHT_GRAY);
        ReadItemPanelEast.setBackground(Color.LIGHT_GRAY);
        ReadItemPanelSouth.setBackground(Color.LIGHT_GRAY);
        ReadItemPanelWest.setBackground(Color.LIGHT_GRAY);
        ReadItemPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Enter Customer ID", JLabel.CENTER);

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
        btnRead = new JButton("Read");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");

    }


    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        ReadItemPanelNorth.setLayout(new GridLayout(4, 1));
        ReadItemPanelEast.setLayout(new GridLayout(13, 1));
        ReadItemPanelSouth.setLayout(new GridLayout(1, 4));
        ReadItemPanelWest.setLayout(new GridLayout(13, 1));
        ReadItemPanelCenter.setLayout(new GridLayout(13, 1));
        ReadItemPanelEast.setLayout(new GridLayout(13, 1));

        //Adding the components to the panels:
        //Panel North:
        ReadItemPanelNorth.add(Filler5);
        ReadItemPanelNorth.add(lblHeading);
        ReadItemPanelNorth.add(txtManagerID);

        //Panel West:
        ReadItemPanelWest.add(Filler1);

        //Panel Center:
        ReadItemPanelCenter.add(lblManagerID);
        ReadItemPanelCenter.add(txtManagerID);

        ReadItemPanelCenter.add(lblFirstName);
        ReadItemPanelCenter.add(txtFirstName);

        ReadItemPanelCenter.add(lblLastName);
        ReadItemPanelCenter.add(txtLastName);

        ReadItemPanelCenter.add(lblEmail);
        ReadItemPanelCenter.add(txtEmail);

        ReadItemPanelCenter.add(lblAddress);
        ReadItemPanelCenter.add(txtAddress);

        ReadItemPanelCenter.add(lblContactNumber);
        ReadItemPanelCenter.add(txtContactNumber);

        ReadItemPanelCenter.add(Filler4);

        //Panel East
        ReadItemPanelEast.add(Filler2);

        //Panel South:
        ReadItemPanelSouth.add(btnRead);
        ReadItemPanelSouth.add(btnDelete);
        ReadItemPanelSouth.add(btnClear);
        ReadItemPanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        ReadItemFrame.add(ReadItemPanelNorth, BorderLayout.NORTH);
        ReadItemFrame.add(ReadItemPanelSouth, BorderLayout.SOUTH);
        ReadItemFrame.add(ReadItemPanelEast, BorderLayout.EAST);
        ReadItemFrame.add(ReadItemPanelCenter, BorderLayout.CENTER);
        ReadItemFrame.add(ReadItemPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnRead.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        ReadItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ReadItemFrame.pack();
        ReadItemFrame.setSize(400, 500);
        ReadItemFrame.setLocationRelativeTo(null);
        ReadItemFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Read")){

            //Store textfield text in string
            String id = txtManagerID.getText();
            httpsmethods httpmethods = new httpsmethods();

            //Use String as parameter in http read method and assign result to a Item
            Manager man = httpmethods.findManager(id);
            System.out.println(man);

            //Item parameters are assigned to textfields
            txtManagerID.setText(man.getManagerID());
            txtFirstName.setText(man.getFirstName());
            txtLastName.setText(man.getLastName());
            txtEmail.setText(man.getEmail());
            txtAddress.setText(man.getAddress());
            txtContactNumber.setText(man.getContactNumber());

        }

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Delete")){
            //Store textfield text in string
            String id = txtManagerID.getText();
            httpsmethods httpsmethods = new httpsmethods();

            //Use String as parameter in http method
            httpsmethods.deleteManager(id);

            //Show message when successfully completed
            JOptionPane.showMessageDialog(null, "Customer Deleted");
            txtManagerID.setText("");
            txtFirstName.setText("");
            txtLastName.setText("");
            txtEmail.setText("");
            txtAddress.setText("");
            txtContactNumber.setText("");
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
            ReadItemFrame.dispose();
        }

    }
}
