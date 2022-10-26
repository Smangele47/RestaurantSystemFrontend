package za.ac.cput.gui.Jody.DeliveryGui;

import za.ac.cput.domain.Customer;
import za.ac.cput.gui.Jody.httpsmethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDeliveryGUI implements ActionListener {

    //Initializing Components
    Customer customer;
    private JFrame DeleteCustomerFrame;
    private JPanel DeletePanelNorth, DeletePanelSouth, DeletePanelEast, DeletePanelWest, DeletePanelCenter;
    private JLabel lblHeading, lblID;

    private JTextField txtReceptionistId;
    private JButton btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public DeleteDeliveryGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        DeleteCustomerFrame = new JFrame("Receptionist ");
        DeletePanelNorth = new JPanel();
        DeletePanelSouth = new JPanel();
        DeletePanelEast = new JPanel();
        DeletePanelWest = new JPanel();
        DeletePanelCenter = new JPanel();

        DeletePanelNorth.setBackground(Color.LIGHT_GRAY);
        DeletePanelEast.setBackground(Color.LIGHT_GRAY);
        DeletePanelSouth.setBackground(Color.LIGHT_GRAY);
        DeletePanelWest.setBackground(Color.LIGHT_GRAY);
        DeletePanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Delete Customer Record", JLabel.CENTER);

        //Labels
        lblID = new JLabel("Enter CustomerID:");

        //TextFields
        txtReceptionistId = new JTextField();

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
        DeletePanelNorth.setLayout(new GridLayout(2, 1));
        DeletePanelEast.setLayout(new GridLayout(12, 1));
        DeletePanelSouth.setLayout(new GridLayout(1, 3));
        DeletePanelWest.setLayout(new GridLayout(12, 1));
        DeletePanelCenter.setLayout(new GridLayout(12, 1));
        DeletePanelEast.setLayout(new GridLayout(12, 1));

        //Adding the components to the panels:
        //Panel North:
        DeletePanelNorth.add(Filler5);
        DeletePanelNorth.add(lblHeading);

        //Panel West:
        DeletePanelWest.add(Filler1);

        //Panel Center:
        DeletePanelCenter.add(lblID);
        DeletePanelCenter.add(txtReceptionistId);
        DeletePanelCenter.add(Filler4);

        //Panel East
        DeletePanelEast.add(Filler2);

        //Panel South:
        DeletePanelSouth.add(btnDelete);
        DeletePanelSouth.add(btnClear);
        DeletePanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);



        //Adding panels to Customer Frame:
        DeleteCustomerFrame.add(DeletePanelNorth, BorderLayout.NORTH);
        DeleteCustomerFrame.add(DeletePanelSouth, BorderLayout.SOUTH);
        DeleteCustomerFrame.add(DeletePanelEast, BorderLayout.EAST);
        DeleteCustomerFrame.add(DeletePanelCenter, BorderLayout.CENTER);
        DeleteCustomerFrame.add(DeletePanelWest, BorderLayout.WEST);

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
            String id = txtReceptionistId.getText();
            httpsmethods httpsmethods = new httpsmethods();

            //Use String as parameter in http method
            httpsmethods.deleteReceptionist(id);

            //Show message when successfully completed
            JOptionPane.showMessageDialog(null, "Receptionist Deleted");
            txtReceptionistId.setText("");
        }


        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtReceptionistId.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            DeleteCustomerFrame.dispose();
        }

    }
}
