package za.ac.cput.gui.Jody.DeliveryGui;

import za.ac.cput.gui.Jody.httpsmethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDeliveryGUI implements ActionListener {
    private JFrame SaveReceptionistFrame;
    private JPanel  SaveReceptionistPanelNorth,  SaveReceptionistPanelSouth, SaveReceptionistPanelEast, SaveReceptionistPanelWest, SaveReceptionistPanelCenter;
    private JLabel lblHeading;

    private JLabel lblReceptionistID, lblReceptionistTime, lblNumberOfPeople, lblCreateReservation ;
    private JTextField txtReceptionistID, txtReceptionistTime, txtNumberOfPeople, txtCreateReservation;

    private JButton btnSave, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public AddDeliveryGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        SaveReceptionistFrame = new JFrame("Receptionist ");
        SaveReceptionistPanelNorth = new JPanel();
        SaveReceptionistPanelSouth = new JPanel();
        SaveReceptionistPanelEast = new JPanel();
        SaveReceptionistPanelWest = new JPanel();
        SaveReceptionistPanelCenter = new JPanel();

        SaveReceptionistPanelNorth.setBackground(Color.LIGHT_GRAY);
        SaveReceptionistPanelEast.setBackground(Color.LIGHT_GRAY);
        SaveReceptionistPanelSouth.setBackground(Color.LIGHT_GRAY);
        SaveReceptionistPanelWest.setBackground(Color.LIGHT_GRAY);
        SaveReceptionistPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Add Receptionist ", JLabel.CENTER);

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
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");

    }
    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        SaveReceptionistPanelNorth.setLayout(new GridLayout(4, 1));
        SaveReceptionistPanelEast.setLayout(new GridLayout(13, 1));
        SaveReceptionistPanelSouth.setLayout(new GridLayout(1, 4));
        SaveReceptionistPanelWest.setLayout(new GridLayout(13, 1));
        SaveReceptionistPanelCenter.setLayout(new GridLayout(13, 1));
        SaveReceptionistPanelEast.setLayout(new GridLayout(13, 1));


        //Adding the components to the panels:
        //Panel North:
        SaveReceptionistPanelNorth.add(Filler5);
        SaveReceptionistPanelNorth.add(lblHeading);

        //Panel West:
        SaveReceptionistPanelWest.add(Filler1);

        //Panel Center:
        SaveReceptionistPanelCenter.add(lblReceptionistID);
        SaveReceptionistPanelCenter.add(txtReceptionistID);

        SaveReceptionistPanelCenter.add(lblReceptionistTime);
        SaveReceptionistPanelCenter.add(txtReceptionistTime);

        SaveReceptionistPanelCenter.add(lblNumberOfPeople);
        SaveReceptionistPanelCenter.add(txtNumberOfPeople);

        SaveReceptionistPanelCenter.add(lblCreateReservation);
        SaveReceptionistPanelCenter.add(txtCreateReservation);


        SaveReceptionistPanelCenter.add(Filler4);


        //Panel East
        SaveReceptionistPanelEast.add(Filler2);

        //Panel South:
        SaveReceptionistPanelSouth.add(btnSave);
        SaveReceptionistPanelSouth.add(btnClear);
        SaveReceptionistPanelSouth.add(btnReturn);


        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Receptionist Frame:
        SaveReceptionistFrame.add(SaveReceptionistPanelNorth, BorderLayout.NORTH);
        SaveReceptionistFrame.add(SaveReceptionistPanelSouth, BorderLayout.SOUTH);
        SaveReceptionistFrame.add(SaveReceptionistPanelEast, BorderLayout.EAST);
        SaveReceptionistFrame.add(SaveReceptionistPanelCenter, BorderLayout.CENTER);
        SaveReceptionistFrame.add(SaveReceptionistPanelWest, BorderLayout.WEST);


        //Telling compiler to listen for actions from the buttons:
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        SaveReceptionistFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SaveReceptionistFrame.pack();
        SaveReceptionistFrame.setSize(600, 400);
        SaveReceptionistFrame.setLocationRelativeTo(null);
        SaveReceptionistFrame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //When Save Button is clicked
        if (e.getActionCommand().equals("Save")) {

            //Store textfield text in string
            String ReceptionistID = txtReceptionistID.getText();
            String ReceptionistTime = txtReceptionistTime.getText();
            String NumberOfPeople = txtNumberOfPeople.getText();
            String CreateReservation = txtCreateReservation .getText();


            //booleans for checking valid input
            boolean ReceptionistTimeCheck, NumberOfPeopleCheck;

            if(!ReceptionistTime.matches("^[0-9:]+$")){
                ReceptionistTimeCheck = false;
                txtReceptionistTime.setText("Invalid  Input");
            }
            else{
                ReceptionistTimeCheck = true;
            }

            if(!NumberOfPeople.matches("^[0-9]+$")){
                NumberOfPeopleCheck = false;
                txtNumberOfPeople.setText("Invalid  Input");
            }
            else{
                NumberOfPeopleCheck = true;
            }

            //If all are valid then call save httpmethod
            if(ReceptionistTimeCheck && NumberOfPeopleCheck ) {
                httpsmethods httpmethods = new httpsmethods();
                httpmethods.saveReceptionist(ReceptionistID, ReceptionistTime, NumberOfPeople, CreateReservation);
                txtReceptionistID.setText("");
                txtReceptionistTime.setText("");
                txtNumberOfPeople.setText("");
                txtCreateReservation.setText("");
            }
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtReceptionistID.setText("");
            txtReceptionistTime.setText("");
            txtNumberOfPeople.setText("");
            txtCreateReservation.setText("");
        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Return")){
            SaveReceptionistFrame.dispose();
        }

    }
}
