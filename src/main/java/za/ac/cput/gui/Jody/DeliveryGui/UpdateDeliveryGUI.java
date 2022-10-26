package za.ac.cput.gui.Jody.DeliveryGui;

import za.ac.cput.domain.Receptionist;
import za.ac.cput.gui.Jody.httpsmethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDeliveryGUI implements ActionListener {
    private JFrame UpdateItemFrame;
    private JPanel UpdateItemPanelNorth, UpdateItemPanelSouth, UpdateItemPanelEast, UpdateItemPanelWest, UpdateItemPanelCenter;
    private JLabel lblHeading;
    private JLabel lblReceptionistID, lblReceptionistTime, lblNumberOfPeople, lblCreateReservation;
    private JTextField txtReceptionistID, txtReceptionistTime, txtNumberOfPeople, txtCreateReservation;
    private JButton btnUpdate, btnReturn, btnClear, btnGet;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Receptionist receptionist;

    public UpdateDeliveryGUI() {
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
        UpdateItemPanelCenter.add(lblReceptionistID);
        UpdateItemPanelCenter.add(txtReceptionistID);

        UpdateItemPanelCenter.add(lblReceptionistTime);
        UpdateItemPanelCenter.add(txtReceptionistTime);

        UpdateItemPanelCenter.add(lblNumberOfPeople);
        UpdateItemPanelCenter.add(txtNumberOfPeople);

        UpdateItemPanelCenter.add(lblCreateReservation);
        UpdateItemPanelCenter.add(txtCreateReservation);

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
            String ReceptionistID = txtReceptionistID.getText();
            String ReceptionistTime = txtReceptionistTime.getText();
            String NumberOfPeople = txtNumberOfPeople.getText();
            String CreateReservation = txtCreateReservation .getText();

            //Read method
            Receptionist r = httpmethods.findReceptionist(ReceptionistID);

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



            //If all are valid then call update httpmethod
            if(ReceptionistTimeCheck && NumberOfPeopleCheck ){

                receptionist = new Receptionist.Builder().copy(r)
                        .setReceptionistID(ReceptionistID)
                        .setReceptionistTime(ReceptionistTime)
                        .setNumberOfPeople(NumberOfPeople)
                        .setCreateReservation(CreateReservation)
                        .build();

                httpmethods.updateReceptionist(receptionist);
                txtReceptionistID.setText("");
                txtReceptionistTime.setText("");
                txtNumberOfPeople.setText("");
                txtCreateReservation.setText("");
                JOptionPane.showMessageDialog(null, "Receptionist Updated");
            }


        }

        //When Get Info Button is clicked
        if(e.getActionCommand().equals("Get Info")){
            boolean idCheck;

            //Use read method of readitemgui
            String id = txtReceptionistID.getText();
            httpsmethods httpmethods = new httpsmethods();
            Receptionist r = httpmethods.findReceptionist(id);
            txtReceptionistTime.setText(r.getReceptionistTime());
            txtCreateReservation.setText(r.getCreateReservation());

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
            UpdateItemFrame.dispose();
        }

    }
}
