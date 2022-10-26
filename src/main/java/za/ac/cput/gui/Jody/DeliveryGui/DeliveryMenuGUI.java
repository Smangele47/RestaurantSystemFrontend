package za.ac.cput.gui.Jody.DeliveryGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeliveryMenuGUI implements ActionListener {
    //Initializing Components
    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAddCustomer, btnDeleteCustomer, btnViewCustomer, btnUpdateCustomer, btnViewAllCustomers, btnReturn;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Color btnColor = Color.WHITE;


    //Setting Up GUI Components
    public DeliveryMenuGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        MenuFrame = new JFrame("Customer ");
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
        lblHeading = new JLabel("Customer Interface", JLabel.CENTER);

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
        btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.setBackground(btnColor);

        btnViewCustomer = new JButton("View Customer");
        btnViewCustomer.setBackground(btnColor);

        btnUpdateCustomer = new JButton("Update Customer");
        btnUpdateCustomer.setBackground(btnColor);

        btnDeleteCustomer = new JButton("Delete Customer Record");
        btnDeleteCustomer.setBackground(btnColor);

        btnViewAllCustomers = new JButton("View All Customers");
        btnViewAllCustomers.setBackground(btnColor);

        btnReturn = new JButton("Return");
        btnReturn.setBackground(btnColor);

    }

    //Setting GUI Layout
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
        panelCenter.add(btnAddCustomer);
        panelCenter.add(btnViewCustomer);
        panelCenter.add(btnUpdateCustomer);
        panelCenter.add(btnDeleteCustomer);
        panelCenter.add(btnViewAllCustomers);
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
        btnAddCustomer.addActionListener(this);
        btnViewCustomer.addActionListener(this);
        btnUpdateCustomer.addActionListener(this);
        btnDeleteCustomer.addActionListener(this);
        btnViewCustomer.addActionListener(this);
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
        if(e.getActionCommand().equals("Add Customer")){
            //Call AddCustomerGui
            AddDeliveryGUI addItemGUI = new AddDeliveryGUI();
            addItemGUI.setGUI();
        }

/*
        if(e.getActionCommand().equals("View Customer")){
            //Call ViewCustomerGUI
            ReadCustomerGUI readCustomerGUI = new ReadCustomerGUI();
            readCustomerGUI.setGUI();
        }

        //When Update Customer Button is clicked
        if(e.getActionCommand().equals("Update Customer")){
            //Call UpdateCustomerGui
            UpdateCustomerGUI updateCustomerGUI = new UpdateCustomerGUI();
            updateCustomerGUI.setGUI();
        }

        //When Update Customer Button is clicked
        if(e.getActionCommand().equals("Delete Customer Record")){
            //Call DeleteCustomerGui
            DeleteCustomerGUI deleteCustomerGUI = new DeleteCustomerGUI();
            deleteCustomerGUI.setGUI();
        }

        //When Update Customer Button is clicked
        if(e.getActionCommand().equals("Delete Customer Record")){
            //Call FindAllCustomerGui
            FindAllCustomersGUI findAllCustomersGUI= new FindAllCustomersGUI();
            findAllCustomersGUI.setGUI();
        }
*/
        if(e.getActionCommand().equals("Return")){
            MenuFrame.dispose();
        }
    }

}
