package za.ac.cput.gui.Tim.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaiterMenuGUI implements ActionListener {

    //Initializing Components
    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAddWaiter, btnDeleteWaiter, btnViewWaiter, btnUpdateWaiter, btnViewAllWaiters, btnReturn;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Color btnColor = Color.WHITE;


    //Setting Up GUI Components
    public WaiterMenuGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        MenuFrame = new JFrame("Waiter ");
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
        lblHeading = new JLabel("Waiter Interface", JLabel.CENTER);

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
        btnAddWaiter = new JButton("Add Customer");
        btnAddWaiter.setBackground(btnColor);

        btnViewWaiter = new JButton("View Customer");
        btnViewWaiter.setBackground(btnColor);

        btnUpdateWaiter = new JButton("Update Customer");
        btnUpdateWaiter.setBackground(btnColor);

        btnDeleteWaiter = new JButton("Delete Customer Record");
        btnDeleteWaiter.setBackground(btnColor);

        btnViewAllWaiters = new JButton("View All Customers");
        btnViewAllWaiters.setBackground(btnColor);

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
        panelCenter.add(btnAddWaiter);
        panelCenter.add(btnViewWaiter);
        panelCenter.add(btnUpdateWaiter);
        panelCenter.add(btnDeleteWaiter);
        panelCenter.add(btnViewAllWaiters);
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
        btnAddWaiter.addActionListener(this);
        btnViewWaiter.addActionListener(this);
        btnUpdateWaiter.addActionListener(this);
        btnDeleteWaiter.addActionListener(this);
        btnViewWaiter.addActionListener(this);
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

        //When Add Waiter Button is clicked
        if(e.getActionCommand().equals("Add Customer")){
            //Call AddWaiterGui
            AddWaiterGUI addItemGUI = new AddWaiterGUI();
            addItemGUI.setGUI();
        }


        if(e.getActionCommand().equals("View Customer")){
            //Call ViewCustomerGUI
            ReadWaiterGUI readWaiterGUI = new ReadWaiterGUI();
            readWaiterGUI.setGUI();
        }

        //When Update Customer Button is clicked
        if(e.getActionCommand().equals("Update Customer")){
            //Call UpdateCustomerGui
            UpdateWaiterGUI updateWaiterGUI = new UpdateWaiterGUI();
            updateWaiterGUI.setGUI();
        }

        //When Update Customer Button is clicked
        if(e.getActionCommand().equals("Delete Customer Record")){
            //Call DeleteCustomerGui
            DeleteWaiterGUI deleteWaiterGUI = new DeleteWaiterGUI();
            deleteWaiterGUI.setGUI();
        }

        //When Update Customer Button is clicked
        if(e.getActionCommand().equals("Delete Customer Record")){
            //Call FindAllCustomerGui
            FindAllWaitersGUI findAllWaitersGUI= new FindAllWaitersGUI();
            findAllWaitersGUI.setGUI();
        }

        if(e.getActionCommand().equals("Return")){
            MenuFrame.dispose();
        }
    }

}
