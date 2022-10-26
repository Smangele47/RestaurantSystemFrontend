package za.ac.cput.gui.Order;

/*
    Author: Damone Hartnick (219093717)
    Date: October 2022
*/

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOrderGui implements ActionListener {

    

    //Initializing Components
    private JFrame OrderFrame;
    private JPanel PanelNorth, PanelSouth, PanelEast, PanelWest, PanelCenter;
    private JLabel lblHeading;

    private JLabel lblOrderID, lblOrderDetails, lblOrderType, lblOrderQuantity;
    private JTextField txtOrderID, txtOrderDetails, txtOrderType, txtOrderQuantity;

    private JButton btnSave, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;

    //Setting Up GUI Components
    public AddOrderGui() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        OrderFrame = new JFrame("Order ");
        PanelNorth = new JPanel();
        PanelSouth = new JPanel();
        PanelEast = new JPanel();
        PanelWest = new JPanel();
        PanelCenter = new JPanel();

        PanelNorth.setBackground(Color.LIGHT_GRAY);
        PanelEast.setBackground(Color.LIGHT_GRAY);
        PanelSouth.setBackground(Color.LIGHT_GRAY);
        PanelWest.setBackground(Color.LIGHT_GRAY);
        PanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Add Order ", JLabel.CENTER);

        //Labels
        lblOrderID = new JLabel("OrderID:");
        lblOrderDetails = new JLabel("OrderDetails:");
        lblOrderType = new JLabel("OrderType:");
        lblOrderQuantity = new JLabel("OrderQuantity:");



        //TextFields
        txtOrderID = new JTextField();
        txtOrderDetails = new JTextField();
        txtOrderType = new JTextField();
        txtOrderQuantity = new JTextField();


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
        PanelNorth.setLayout(new GridLayout(4, 1));
        PanelEast.setLayout(new GridLayout(13, 1));
        PanelSouth.setLayout(new GridLayout(1, 4));
        PanelWest.setLayout(new GridLayout(13, 1));
        PanelCenter.setLayout(new GridLayout(13, 1));
        PanelEast.setLayout(new GridLayout(13, 1));


        //Adding the components to the panels:
        //Panel North:
        PanelNorth.add(Filler5);
        PanelNorth.add(lblHeading);

        //Panel West:
        PanelWest.add(Filler1);

        //Panel Center:
        PanelCenter.add(lblOrderID);
        PanelCenter.add(txtOrderID);

        PanelCenter.add(lblOrderDetails);
        PanelCenter.add(txtOrderDetails);

        PanelCenter.add(lblOrderType);
        PanelCenter.add(txtOrderType);

        PanelCenter.add(lblOrderDetails);
        PanelCenter.add(txtOrderDetails);


        PanelCenter.add(Filler4);


        //Panel East
        PanelEast.add(Filler2);

        //Panel South:
        PanelSouth.add(btnSave);
        PanelSouth.add(btnClear);
        PanelSouth.add(btnReturn);


        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        OrderFrame.add(PanelNorth, BorderLayout.NORTH);
        OrderFrame.add(PanelSouth, BorderLayout.SOUTH);
        OrderFrame.add(PanelEast, BorderLayout.EAST);
        OrderFrame.add(PanelCenter, BorderLayout.CENTER);
        OrderFrame.add(PanelWest, BorderLayout.WEST);


        //Telling compiler to listen for actions from the buttons:
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        OrderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        OrderFrame.pack();
        OrderFrame.setSize(600, 400);
        OrderFrame.setLocationRelativeTo(null);
        OrderFrame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //When Save Button is clicked
        if (e.getActionCommand().equals("Save")) {

            //Store textfield text in string
            String OrderID = txtOrderID.getText();
            String OrderDetails = txtOrderDetails.getText();
            String OrderType = txtOrderType.getText();
            String OrderQuantity = txtOrderQuantity.getText();


            //booleans for checking valid input
            boolean OrderDetailsCheck, OrderTypeCheck;

            if(!OrderDetails.matches("[a-zA-Z0-9]+")){
                OrderDetailsCheck = false;
                txtOrderDetails.setText("Invalid  Input");
            }
            else{
                OrderDetailsCheck = true;
            }

            if(!OrderType.matches("[a-zA-Z0-9]+")){
                OrderTypeCheck = false;
                txtOrderType.setText("Invalid  Input");
            }
            else{
                OrderTypeCheck = true;
            }

            /*
                 httpsmethods httpmethods = new httpsmethods();
                httpmethods.saveOrder(OrderID, OrderDetails, OrderType, OrderQuantity);
                txtOrderID.setText("");
                txtOrderDetails.setText("");
                txtOrderType.setText("");
                txtOrderQuantity.setText("");
             */



            //If all are valid then call save httpmethod
            if(OrderDetailsCheck && OrderTypeCheck ) {


            }
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtOrderID.setText("");
            txtOrderDetails.setText("");
            txtOrderType.setText("");
            txtOrderQuantity.setText("");
        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Return")){
            OrderFrame.dispose();

        }

    }
}
