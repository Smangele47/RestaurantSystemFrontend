package za.ac.cput.gui.Order;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.gui.Customer.httpsmethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadOrderGUI implements ActionListener {


    //Initializing Components
    private JFrame ReadFrame;
    private JPanel ReadPanelNorth, ReadPanelSouth, ReadPanelEast, ReadPanelWest, ReadPanelCenter;
    private JLabel lblHeading;

    private JLabel lblOrderID, lblOrderDetails, lblOrderType, lblOrderQuantity;
    private JTextField txtOrderID, txtOrderDetails, txtOrderType, txtOrderQuantity;
    private JButton btnRead, btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public ReadOrderGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        ReadFrame = new JFrame("Order: ");
        ReadPanelNorth = new JPanel();
        ReadPanelSouth = new JPanel();
        ReadPanelEast = new JPanel();
        ReadPanelWest = new JPanel();
        ReadPanelCenter = new JPanel();
        ReadPanelNorth.setBackground(Color.LIGHT_GRAY);
        ReadPanelEast.setBackground(Color.LIGHT_GRAY);
        ReadPanelSouth.setBackground(Color.LIGHT_GRAY);
        ReadPanelWest.setBackground(Color.LIGHT_GRAY);
        ReadPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Enter Order ID", JLabel.CENTER);

        //Labels
        lblOrderID = new JLabel("OrderID:");
        lblOrderDetails = new JLabel("OrderDetails:");
        lblOrderType = new JLabel("OrderType:");
        lblOrderQuantity = new JLabel("Quantity:");


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
        btnRead = new JButton("Read");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");

    }

    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        ReadPanelNorth.setLayout(new GridLayout(4, 1));
        ReadPanelEast.setLayout(new GridLayout(13, 1));
        ReadPanelSouth.setLayout(new GridLayout(1, 4));
        ReadPanelWest.setLayout(new GridLayout(13, 1));
        ReadPanelCenter.setLayout(new GridLayout(13, 1));
        ReadPanelEast.setLayout(new GridLayout(13, 1));

        //Adding the components to the panels:
        //Panel North:
        ReadPanelNorth.add(Filler5);
        ReadPanelNorth.add(lblHeading);
        ReadPanelNorth.add(txtOrderID);

        //Panel West:
        ReadPanelWest.add(Filler1);

        //Panel Center:
        ReadPanelCenter.add(lblOrderID);
        ReadPanelCenter.add(txtOrderID);

        ReadPanelCenter.add(lblOrderDetails);
        ReadPanelCenter.add(txtOrderDetails);

        ReadPanelCenter.add(lblOrderType);
        ReadPanelCenter.add(txtOrderType);

        ReadPanelCenter.add(lblOrderQuantity);
        ReadPanelCenter.add(txtOrderQuantity);


        ReadPanelCenter.add(Filler4);

        //Panel East
        ReadPanelEast.add(Filler2);

        //Panel South:
        ReadPanelSouth.add(btnRead);
        ReadPanelSouth.add(btnDelete);
        ReadPanelSouth.add(btnClear);
        ReadPanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        ReadFrame.add(ReadPanelNorth, BorderLayout.NORTH);
        ReadFrame.add(ReadPanelSouth, BorderLayout.SOUTH);
        ReadFrame.add(ReadPanelEast, BorderLayout.EAST);
        ReadFrame.add(ReadPanelCenter, BorderLayout.CENTER);
        ReadFrame.add(ReadPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnRead.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        ReadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ReadFrame.pack();
        ReadFrame.setSize(400, 500);
        ReadFrame.setLocationRelativeTo(null);
        ReadFrame.setVisible(true);
    }





    @Override
    public void actionPerformed(ActionEvent e) {

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Read")){

            /*
            //Store textfield text in string
            String id = txtOrderID.getText();
            Order.httpsmethods httpmethods = new Order.httpsmethods();

            //Use String as parameter in http read method and assign result to a Item
            Order or = httpmethods.findOrder(id);
            System.out.println(or);

            //Item parameters are assigned to textfields
            txtOrderID.setText(or.getOrderID());
            txtOrderDetails.setText(or.getOrderDetails());
            txtOrderType.setText(or.getOrderType());
            txtOrderQuantity.setText(or.getOrderQuantity());
             */


        }

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Delete")){
            //Store textfield text in string
            String id = txtOrderID.getText();
            za.ac.cput.gui.Customer.httpsmethods httpsmethods = new httpsmethods();

            //Use String as parameter in http method
            httpsmethods.deleteCustomer(id);

            //Show message when successfully completed
            JOptionPane.showMessageDialog(null, "Order Deleted");
            txtOrderID.setText("");
            txtOrderDetails.setText("");
            txtOrderType.setText("");
            txtOrderQuantity.setText("");
        }


        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtOrderID.setText("");
            txtOrderDetails.setText("");
            txtOrderType.setText("");
            txtOrderQuantity.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            ReadFrame.dispose();
        }

    }
}
