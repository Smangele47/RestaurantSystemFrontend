package za.ac.cput.gui.main;

import za.ac.cput.gui.Chef.ChefMenuGUI;
import za.ac.cput.gui.Meal.MealMenuGUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantSystemGUI implements ActionListener {

    private JFrame mainframe;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnCustomer, btnOrder, btnBookings,
            btnChef, btnEvent, btnManagers, btnMeal, btnPayments, btnTables, btnWaiters, btnDelivery, btnReceptionist;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5, Filler6, Filler7, Filler8, Filler9, Filler10;
    Color panAllColor = Color.LIGHT_GRAY;
    Color btnColor = Color.WHITE;
    private Font headingFont;


    public RestaurantSystemGUI () {

        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        mainframe = new JFrame("Restaurant System");
        panelWest = new JPanel();
        panelNorth = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelEast.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);
        panelWest.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);

        //Fillers
        Filler1 = new JLabel("======");
        Filler2 = new JLabel("======");
        Filler3 = new JLabel("======");
        Filler4 = new JLabel("======");
        Filler1.setForeground(panAllColor);
        Filler2.setForeground(panAllColor);
        Filler3.setForeground(panAllColor);
        Filler4.setForeground(panAllColor);

        //Buttons
        btnCustomer = new JButton("1. Customer");
        btnCustomer.setBackground(btnColor);

        btnOrder = new JButton("2. Order");
        btnOrder.setBackground(btnColor);

        btnBookings = new JButton("3. Bookings");
        btnBookings.setBackground(btnColor);

        btnChef = new JButton("4. Chef");
        btnChef.setBackground(btnColor);

        btnEvent= new JButton("5. Event ");
        btnEvent.setBackground(btnColor);

        btnManagers = new JButton("6. Managers");
        btnManagers.setBackground(btnColor);

        btnMeal = new JButton("7. Meal");
        btnMeal.setBackground(btnColor);

        btnPayments = new JButton("8. Payments");
        btnPayments.setBackground(btnColor);

        btnTables = new JButton("9. Tables");
        btnTables.setBackground(btnColor);

        btnWaiters = new JButton("10. Waiters");
        btnWaiters.setBackground(btnColor);

        btnDelivery = new JButton("11. Delivery");
        btnDelivery.setBackground(btnColor);

        btnReceptionist = new JButton("12. Receptionist");
        btnReceptionist.setBackground(btnColor);

    }

    //Creating the GUI
    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelSouth.setLayout(new GridLayout(1, 1));
        panelWest.setLayout(new GridLayout(12, 1));
        panelCenter.setLayout(new GridLayout(12, 1));
        panelEast.setLayout(new GridLayout(12, 1));

        //Panel North
        panelNorth.add(Filler4);

        //Panel West:
        panelWest.add(Filler1);

        //Panel East:
        panelEast.add(Filler2);

        //Panel South:
        panelSouth.add(Filler3);

        //Panel Center
        panelCenter.add(btnCustomer);
        panelCenter.add(btnOrder);

        panelCenter.add(btnBookings);
        panelCenter.add(btnChef);

        panelCenter.add(btnEvent);
        panelCenter.add(btnManagers);

        panelCenter.add(btnMeal);
        panelCenter.add(btnPayments);

        panelCenter.add(btnTables);
        panelCenter.add(btnWaiters);

        panelCenter.add(btnDelivery);
        panelCenter.add(btnReceptionist);

        //Adding panels to mainframe:
        mainframe.add(panelNorth, BorderLayout.NORTH);
        mainframe.add(panelSouth, BorderLayout.SOUTH);
        mainframe.add(panelEast, BorderLayout.EAST);
        mainframe.add(panelCenter, BorderLayout.CENTER);
        mainframe.add(panelWest, BorderLayout.WEST);

        //Adding actions to buttons
        btnCustomer.addActionListener(this);
        btnOrder.addActionListener(this);

        btnBookings.addActionListener(this);
        btnChef.addActionListener(this);

        btnEvent.addActionListener(this);
        btnManagers.addActionListener(this);

        btnMeal.addActionListener(this);
        btnPayments.addActionListener(this);

        btnTables.addActionListener(this);
        btnWaiters.addActionListener(this);

        btnDelivery.addActionListener(this);
        btnReceptionist.addActionListener(this);



        // Set UI:
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(400,500);
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getActionCommand().equals("4. Chef"))
        {
            ChefMenuGUI customerMenuGUI = new ChefMenuGUI();
            customerMenuGUI.setGUI();
            mainframe.dispose();
        }

        if(e.getActionCommand().equals("7. Meal"))
        {
            MealMenuGUI orderMenuGui = new MealMenuGUI();
            orderMenuGui.setGUI();
        }




    }
}

