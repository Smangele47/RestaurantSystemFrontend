package za.ac.cput.gui.Order;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.gui.Customer.httpsmethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateOrderGUI implements ActionListener {


    //Initializing Components
    private JFrame UpdateFrame;
    private JPanel UpdatePanelNorth, UpdatePanelSouth, UpdatePanelEast, UpdatePanelWest, UpdatePanelCenter;
    private JLabel lblHeading;

    private JLabel lblOrderID, lblOrderDetails, lblOrderType, lblOrderQuantity;
    private JTextField txtOrderID, txtOrderDetails , txtOrderType, txtOrderQuantity;

    private JButton btnUpdate, btnReturn, btnClear, btnGet;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Order order;

    public UpdateOrderGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        UpdateFrame = new JFrame("Order ");
        UpdatePanelNorth = new JPanel();
        UpdatePanelSouth = new JPanel();
        UpdatePanelEast = new JPanel();
        UpdatePanelWest = new JPanel();
        UpdatePanelCenter = new JPanel();
        UpdatePanelNorth.setBackground(Color.LIGHT_GRAY);
        UpdatePanelEast.setBackground(Color.LIGHT_GRAY);
        UpdatePanelSouth.setBackground(Color.LIGHT_GRAY);
        UpdatePanelWest.setBackground(Color.LIGHT_GRAY);
        UpdatePanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Update Order", JLabel.CENTER);



        //Labels
        lblOrderID = new JLabel("OrderID:");
        lblOrderDetails = new JLabel("OrderDetails:");
        lblOrderType= new JLabel("OrderType:");
        lblOrderQuantity= new JLabel("OrderQuantity:");



        //TextFields
        txtOrderID = new JTextField();
        txtOrderDetails = new JTextField();
        txtOrderType = new JTextField();
        txtOrderQuantity = new JTextField();



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
        UpdatePanelNorth.setLayout(new GridLayout(2, 1));
        UpdatePanelEast.setLayout(new GridLayout(13, 1));
        UpdatePanelSouth.setLayout(new GridLayout(1, 4));
        UpdatePanelWest.setLayout(new GridLayout(13, 1));
        UpdatePanelCenter.setLayout(new GridLayout(13, 1));
        UpdatePanelEast.setLayout(new GridLayout(13, 1));

        //Adding the components to the panels:
        //Panel North:
        UpdatePanelNorth.add(Filler5);
        UpdatePanelNorth.add(lblHeading);

        //Panel West:
        UpdatePanelWest.add(Filler1);

        //Panel Center:
        UpdatePanelCenter.add(lblOrderID);
        UpdatePanelCenter.add(txtOrderID);

        UpdatePanelCenter.add(lblOrderDetails);
        UpdatePanelCenter.add(txtOrderDetails);

        UpdatePanelCenter.add(lblOrderType);
        UpdatePanelCenter.add(txtOrderType);

        UpdatePanelCenter.add(lblOrderQuantity);
        UpdatePanelCenter.add(txtOrderQuantity);

        UpdatePanelCenter.add(Filler4);

        //Panel East
        UpdatePanelEast.add(Filler2);

        //Panel South:
        UpdatePanelSouth.add(btnGet);
        UpdatePanelSouth.add(btnUpdate);
        UpdatePanelSouth.add(btnClear);
        UpdatePanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        UpdateFrame.add(UpdatePanelNorth, BorderLayout.NORTH);
        UpdateFrame.add(UpdatePanelSouth, BorderLayout.SOUTH);
        UpdateFrame.add(UpdatePanelEast, BorderLayout.EAST);
        UpdateFrame.add(UpdatePanelCenter, BorderLayout.CENTER);
        UpdateFrame.add(UpdatePanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnGet.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        UpdateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UpdateFrame.pack();
        UpdateFrame.setSize(450, 500);
        UpdateFrame.setLocationRelativeTo(null);
        UpdateFrame.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Update")) {
            za.ac.cput.gui.Customer.httpsmethods httpmethods = new httpsmethods();

            //Store textfield text in string
            String orderID = txtOrderID.getText();
            String orderDetails = txtOrderDetails.getText();
            String orderType = txtOrderType.getText();
            String orderQuantity = txtOrderQuantity.getText();


            //Read method
           // Order or = httpmethods.findOrder(orderID);

            //booleans for checking valid input
            boolean OrderDetailsCheck, OrderTypeCheck;

            if (!orderDetails.matches("[a-zA-Z0-9]+")) {
                OrderDetailsCheck = false;
                txtOrderDetails.setText("Invalid  Input");
            } else {
                OrderDetailsCheck = true;
            }

            if (!orderType.matches("[a-zA-Z0-9]+")) {
                OrderTypeCheck = false;
                txtOrderQuantity.setText("Invalid  Input");
            } else {
                OrderTypeCheck = true;
            }

            //If all are valid then call update httpmethod
            if (OrderDetailsCheck && OrderTypeCheck) {

               /*
                order = new Order.Builder().copy(or)
                        .setOrderID(orderID)
                        .setOrderDetails(orderDetails)
                        .setOrderType(orderDetails)
                        .setOrderQuantity(Integer.parseInt(orderQuantity))
                        .build();
                */

               // httpmethods.updateOrder(order);

                txtOrderID.setText("");
                txtOrderDetails.setText("");
                txtOrderType.setText("");
                txtOrderQuantity.setText("");
                JOptionPane.showMessageDialog(null, "Order Updated");
            }

            //When Get Info Button is clicked
            if (e.getActionCommand().equals("Get Info")) {
                boolean idCheck;

               /*
                //Use read method of readitemgui
                String id = txtOrderID.getText();
                httpsmethods httpmethods = new httpsmethods();
                Order or = httpmethods.findOrder(id);
                txtOrderDetails.setText(or.getOrderDetails());
                txtOrderType.setText(or.getOrderType());
                */

            }

            //When Clear Button is clicked
            if (e.getActionCommand().equals("Clear")) {
                txtOrderID.setText("");
                txtOrderDetails.setText("");
                txtOrderType.setText("");
                txtOrderQuantity.setText("");
            }

            //When Exit Button is clicked
            if (e.getActionCommand().equals("Return")) {
                UpdateFrame.dispose();
            }
        }

    }
}
