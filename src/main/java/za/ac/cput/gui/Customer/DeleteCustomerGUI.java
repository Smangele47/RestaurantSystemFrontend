package za.ac.cput.gui.Customer;

import za.ac.cput.domain.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteCustomerGUI implements ActionListener {

    //Initializing Components
    Customer customer;
    private JFrame DeleteCustomerFrame;
    private JPanel DeleteCustomerPanelNorth, DeleteCustomerPanelSouth, DeleteCustomerPanelEast, DeleteCustomerPanelWest, DeleteCustomerPanelCenter;
    private JLabel lblHeading, lblID;
    private JTextField txtCustomerID;
    private JButton btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public DeleteCustomerGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        DeleteCustomerFrame = new JFrame("Customer ");
        DeleteCustomerPanelNorth = new JPanel();
        DeleteCustomerPanelSouth = new JPanel();
        DeleteCustomerPanelEast = new JPanel();
        DeleteCustomerPanelWest = new JPanel();
        DeleteCustomerPanelCenter = new JPanel();

        DeleteCustomerPanelNorth.setBackground(Color.LIGHT_GRAY);
        DeleteCustomerPanelEast.setBackground(Color.LIGHT_GRAY);
        DeleteCustomerPanelSouth.setBackground(Color.LIGHT_GRAY);
        DeleteCustomerPanelWest.setBackground(Color.LIGHT_GRAY);
        DeleteCustomerPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Delete Customer Record", JLabel.CENTER);

        //Labels
        lblID = new JLabel("Enter CustomerID:");

        //TextFields
        txtCustomerID = new JTextField();

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
        DeleteCustomerPanelNorth.setLayout(new GridLayout(2, 1));
        DeleteCustomerPanelEast.setLayout(new GridLayout(12, 1));
        DeleteCustomerPanelSouth.setLayout(new GridLayout(1, 3));
        DeleteCustomerPanelWest.setLayout(new GridLayout(12, 1));
        DeleteCustomerPanelCenter.setLayout(new GridLayout(12, 1));
        DeleteCustomerPanelEast.setLayout(new GridLayout(12, 1));

        //Adding the components to the panels:
        //Panel North:
        DeleteCustomerPanelNorth.add(Filler5);
        DeleteCustomerPanelNorth.add(lblHeading);

        //Panel West:
        DeleteCustomerPanelWest.add(Filler1);

        //Panel Center:
        DeleteCustomerPanelCenter.add(lblID);
        DeleteCustomerPanelCenter.add(txtCustomerID);
        DeleteCustomerPanelCenter.add(Filler4);

        //Panel East
        DeleteCustomerPanelEast.add(Filler2);

        //Panel South:
        DeleteCustomerPanelSouth.add(btnDelete);
        DeleteCustomerPanelSouth.add(btnClear);
        DeleteCustomerPanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);



        //Adding panels to Customer Frame:
        DeleteCustomerFrame.add(DeleteCustomerPanelNorth, BorderLayout.NORTH);
        DeleteCustomerFrame.add(DeleteCustomerPanelSouth, BorderLayout.SOUTH);
        DeleteCustomerFrame.add(DeleteCustomerPanelEast, BorderLayout.EAST);
        DeleteCustomerFrame.add(DeleteCustomerPanelCenter, BorderLayout.CENTER);
        DeleteCustomerFrame.add(DeleteCustomerPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        DeleteCustomerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DeleteCustomerFrame.pack();
        DeleteCustomerFrame.setSize(400, 300);
        DeleteCustomerFrame.setLocationRelativeTo(null);
        DeleteCustomerFrame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Delete")){

            //Store textfield text in string
            String id = txtCustomerID.getText();
            httpsmethods httpsmethods = new httpsmethods();

            //Use String as parameter in http method
            httpsmethods.deleteCustomer(id);

            //Show message when successfully completed
            JOptionPane.showMessageDialog(null, "Customer Deleted");
            txtCustomerID.setText("");
        }


        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtCustomerID.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            DeleteCustomerFrame.dispose();
        }

    }
}
