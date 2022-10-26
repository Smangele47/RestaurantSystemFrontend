package za.ac.cput.gui.Order;

import za.ac.cput.gui.Customer.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderMenuGUI implements ActionListener {

    //Initializing Components
    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;

    private JButton btnAddOrder, btnDeleteOrder, btnViewOrder, btnUpdateOrder, btnViewAllOrders, btnReturn;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Color btnColor = Color.WHITE;


    //Setting Up GUI Components
    public OrderMenuGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        MenuFrame = new JFrame("Order ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(Color.LIGHT_GRAY);
        panelEast.setBackground(Color.LIGHT_GRAY);
        panelSouth.setBackground(Color.LIGHT_GRAY);
        panelWest.setBackground(Color.LIGHT_GRAY);
        panelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Customer Order", JLabel.CENTER);

        //Fillers:
        Filler1 = new JLabel("=====");
        Filler1.setForeground(Color.LIGHT_GRAY);
        Filler2 = new JLabel("=====");
        Filler2.setForeground(Color.LIGHT_GRAY);
        Filler3 = new JLabel("================================");
        Filler3.setForeground(Color.LIGHT_GRAY);
        Filler4 = new JLabel("================================");
        Filler4.setForeground(Color.LIGHT_GRAY);
        Filler5 = new JLabel("================================");
        Filler5.setForeground(Color.LIGHT_GRAY);

        //Buttons:
        btnAddOrder = new JButton("Add Order");
        btnAddOrder.setBackground(btnColor);

        btnViewOrder = new JButton("View Order");
        btnViewOrder.setBackground(btnColor);

        btnUpdateOrder = new JButton("Update Order");
        btnUpdateOrder.setBackground(btnColor);

        btnDeleteOrder = new JButton("Delete Order Record");
        btnDeleteOrder.setBackground(btnColor);

        btnViewAllOrders = new JButton("View All Orders");
        btnViewAllOrders.setBackground(btnColor);

        btnReturn = new JButton("Return");
        btnReturn.setBackground(btnColor);

    }


    public void setGUI() {
        //Panel Grids
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(5, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(5, 1));
        panelCenter.setLayout(new GridLayout(7, 1));

        //Adding the components to the panels:
        //Panel North:
        panelNorth.add(Filler5);
        panelNorth.add(lblHeading);

        //Panel West:
        panelWest.add(Filler1);

        //Panel Center:
        panelCenter.add(Filler3);
        panelCenter.add(btnAddOrder);
        panelCenter.add(btnViewOrder);
        panelCenter.add(btnUpdateOrder);
        panelCenter.add(btnDeleteOrder);
        panelCenter.add(btnViewAllOrders);
        panelCenter.add(Filler4);

        //Panel East
        panelEast.add(Filler2);

        //Panel South:
        panelSouth.add(btnReturn);


        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        MenuFrame.add(panelNorth, BorderLayout.NORTH);
        MenuFrame.add(panelSouth, BorderLayout.SOUTH);
        MenuFrame.add(panelEast, BorderLayout.EAST);
        MenuFrame.add(panelCenter, BorderLayout.CENTER);
        MenuFrame.add(panelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnAddOrder.addActionListener(this);
        btnViewOrder.addActionListener(this);
        btnUpdateOrder.addActionListener(this);
        btnDeleteOrder.addActionListener(this);
        btnViewOrder.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        MenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MenuFrame.pack();
        MenuFrame.setSize(350, 400);
        MenuFrame.setLocationRelativeTo(null);
        MenuFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //When Add Customer Button is clicked
        if(e.getActionCommand().equals("Add Order")){
            //Call AddCustomerGui
            AddOrderGui addOrderGui = new AddOrderGui();
            addOrderGui.setGUI();
        }


        if(e.getActionCommand().equals("View Order")){
            //Call ViewCustomerGUI
            ReadOrderGUI readOrderGUI = new ReadOrderGUI();
            readOrderGUI.setGUI();
        }

        //When Update Customer Button is clicked
        if(e.getActionCommand().equals("Update Order")){
            //Call UpdateCustomerGui
            UpdateOrderGUI updateOrderGUI = new UpdateOrderGUI();
            updateOrderGUI.setGUI();
        }

        //When Update Customer Button is clicked
        if(e.getActionCommand().equals("Delete Order Record")){
            //Call DeleteCustomerGui
            DeleteOrderGUI deleteOrderGUI = new DeleteOrderGUI();
            deleteOrderGUI.setGUI();
        }

        //When Update Customer Button is clicked
        if(e.getActionCommand().equals("Delete Order Record")){
            //Call FindAllCustomerGui
            FindAllOrdersGUI findAllOrdersGUI= new FindAllOrdersGUI();
            findAllOrdersGUI.setGUI();
        }

        if(e.getActionCommand().equals("Return")){
            MenuFrame.dispose();
        }




    }
}
