package za.ac.cput.gui.Order;

import za.ac.cput.domain.Customer;
import za.ac.cput.gui.Customer.httpsmethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteOrderGUI implements ActionListener {


    //Initializing Components
    Customer customer;
    private JFrame DeleteFrame;
    private JPanel PanelNorth, PanelSouth, PanelEast, PanelWest, PanelCenter;

    private JLabel lblHeading, lblID;
    private JTextField txtOrderID;

    private JButton btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public DeleteOrderGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        DeleteFrame = new JFrame("Order ");
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
        lblHeading = new JLabel("Delete Order Record", JLabel.CENTER);

        //Labels
        lblID = new JLabel("Enter OrderID:");

        //TextFields
        txtOrderID = new JTextField();

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
        btnDelete = new JButton("Delete");
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
        PanelCenter.add(lblID);
        PanelCenter.add(txtOrderID);
        PanelCenter.add(Filler4);

        //Panel East
        PanelEast.add(Filler2);

        //Panel South:
        PanelSouth.add(btnDelete);
        PanelSouth.add(btnClear);
        PanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);



        //Adding panels to Customer Frame:
        DeleteFrame.add(PanelNorth, BorderLayout.NORTH);
        DeleteFrame.add(PanelSouth, BorderLayout.SOUTH);
        DeleteFrame.add(PanelEast, BorderLayout.EAST);
        DeleteFrame.add(PanelCenter, BorderLayout.CENTER);
        DeleteFrame.add(PanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        DeleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DeleteFrame.pack();
        DeleteFrame.setSize(400, 300);
        DeleteFrame.setLocationRelativeTo(null);
        DeleteFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
        }


        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtOrderID.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            DeleteFrame.dispose();
        }

    }
}
