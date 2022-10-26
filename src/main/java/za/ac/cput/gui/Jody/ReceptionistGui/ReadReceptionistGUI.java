package za.ac.cput.gui.Jody.ReceptionistGui;


import za.ac.cput.domain.Receptionist;
import za.ac.cput.gui.Jody.httpsmethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadReceptionistGUI implements ActionListener {
    private JFrame ReadItemFrame;
    private JPanel ReadItemPanelNorth, ReadItemPanelSouth, ReadItemPanelEast, ReadItemPanelWest, ReadItemPanelCenter;
    private JLabel lblHeading;
    private JLabel lblReceptionistID, lblReceptionistTime, lblNumberOfPeople, lblCreateReservation;
    private JTextField txtReceptionistID, txtReceptionistTime, txtNumberOfPeople, txtCreateReservation;
    private JButton btnRead, btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public ReadReceptionistGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        ReadItemFrame = new JFrame("Receptionist: ");
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
        lblHeading = new JLabel("Enter Receptionist ID", JLabel.CENTER);

        //Labels
        lblReceptionistID = new JLabel("Receptionist ID:");
        lblReceptionistTime = new JLabel("Time:");
        lblNumberOfPeople = new JLabel("Number of people:");

        lblCreateReservation = new JLabel("Create Reservation:");

        //TextFields
        txtReceptionistID = new JTextField();
        txtReceptionistTime = new JTextField();
        txtNumberOfPeople = new JTextField();
        txtCreateReservation = new JTextField();

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
        ReadItemPanelNorth.add(txtReceptionistID);

        //Panel West:
        ReadItemPanelWest.add(Filler1);

        //Panel Center:
        ReadItemPanelCenter.add(lblReceptionistID);
        ReadItemPanelCenter.add(txtReceptionistID);

        ReadItemPanelCenter.add(lblReceptionistTime);
        ReadItemPanelCenter.add(txtReceptionistTime);

        ReadItemPanelCenter.add(lblNumberOfPeople);
        ReadItemPanelCenter.add(txtNumberOfPeople);

        ReadItemPanelCenter.add(lblCreateReservation);
        ReadItemPanelCenter.add(txtCreateReservation);


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

        //Adding panels to Receptionist Frame:
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
            String id = txtReceptionistID.getText();
            httpsmethods httpmethods = new httpsmethods();

            //Use String as parameter in http read method and assign result to a Item
            Receptionist receptionist = httpmethods.findReceptionist(id);
            System.out.println(receptionist);

            //Item parameters are assigned to textfields
            txtReceptionistID.setText(receptionist.getReceptionistID());
            txtReceptionistTime.setText(receptionist.getReceptionistTime());
            txtNumberOfPeople.setText(receptionist.getNumberOfPeople());
            txtCreateReservation.setText(receptionist.getCreateReservation());


        }

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Delete")){
            //Store textfield text in string
            String id = txtReceptionistID.getText();
            httpsmethods httpsmethods = new httpsmethods();

            //Use String as parameter in http method
            httpsmethods.deleteReceptionist(id);

            //Show message when successfully completed
            JOptionPane.showMessageDialog(null, "Receptionist Deleted");
            txtReceptionistID.setText("");
            txtReceptionistTime.setText("");
            txtNumberOfPeople.setText("");
            txtCreateReservation.setText("");
        }


        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtReceptionistID.setText("");
            txtReceptionistTime.setText("");
            txtNumberOfPeople.setText("");
            txtCreateReservation.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            ReadItemFrame.dispose();
        }

    }
}
