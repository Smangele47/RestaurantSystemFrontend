package za.ac.cput.gui.Tim.Manager;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteManagerGUI implements ActionListener {

    //Initializing Components
    Manager manager;
    private JFrame DeleteManagerFrame;
    private JPanel DeleteManagerPanelNorth, DeleteManagerPanelSouth, DeleteManagerPanelEast, DeleteManagerPanelWest, DeleteManagerPanelCenter;
    private JLabel lblHeading, lblID;
    private JTextField txtManagerID;
    private JButton btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public DeleteManagerGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        DeleteManagerFrame = new JFrame("Customer ");
        DeleteManagerPanelNorth = new JPanel();
        DeleteManagerPanelSouth = new JPanel();
        DeleteManagerPanelEast = new JPanel();
        DeleteManagerPanelWest = new JPanel();
        DeleteManagerPanelCenter = new JPanel();

        DeleteManagerPanelNorth.setBackground(Color.LIGHT_GRAY);
        DeleteManagerPanelEast.setBackground(Color.LIGHT_GRAY);
        DeleteManagerPanelSouth.setBackground(Color.LIGHT_GRAY);
        DeleteManagerPanelWest.setBackground(Color.LIGHT_GRAY);
        DeleteManagerPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Delete Customer Record", JLabel.CENTER);

        //Labels
        lblID = new JLabel("Enter CustomerID:");

        //TextFields
        txtManagerID = new JTextField();

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
        DeleteManagerPanelNorth.setLayout(new GridLayout(2, 1));
        DeleteManagerPanelEast.setLayout(new GridLayout(12, 1));
        DeleteManagerPanelSouth.setLayout(new GridLayout(1, 3));
        DeleteManagerPanelWest.setLayout(new GridLayout(12, 1));
        DeleteManagerPanelCenter.setLayout(new GridLayout(12, 1));
        DeleteManagerPanelEast.setLayout(new GridLayout(12, 1));

        //Adding the components to the panels:
        //Panel North:
        DeleteManagerPanelNorth.add(Filler5);
        DeleteManagerPanelNorth.add(lblHeading);

        //Panel West:
        DeleteManagerPanelWest.add(Filler1);

        //Panel Center:
        DeleteManagerPanelCenter.add(lblID);
        DeleteManagerPanelCenter.add(txtManagerID);
        DeleteManagerPanelCenter.add(Filler4);

        //Panel East
        DeleteManagerPanelEast.add(Filler2);

        //Panel South:
        DeleteManagerPanelSouth.add(btnDelete);
        DeleteManagerPanelSouth.add(btnClear);
        DeleteManagerPanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);



        //Adding panels to Customer Frame:
        DeleteManagerFrame.add(DeleteManagerPanelNorth, BorderLayout.NORTH);
        DeleteManagerFrame.add(DeleteManagerPanelSouth, BorderLayout.SOUTH);
        DeleteManagerFrame.add(DeleteManagerPanelEast, BorderLayout.EAST);
        DeleteManagerFrame.add(DeleteManagerPanelCenter, BorderLayout.CENTER);
        DeleteManagerFrame.add(DeleteManagerPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        DeleteManagerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DeleteManagerFrame.pack();
        DeleteManagerFrame.setSize(400, 300);
        DeleteManagerFrame.setLocationRelativeTo(null);
        DeleteManagerFrame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Delete")){

            //Store textfield text in string
            String id = txtManagerID.getText();
            httpsmethods httpsmethods = new httpsmethods();

            //Use String as parameter in http method
            httpsmethods.deleteManager(id);

            //Show message when successfully completed
            JOptionPane.showMessageDialog(null, "Manager Deleted");
            txtManagerID.setText("");
        }


        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtManagerID.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            DeleteManagerFrame.dispose();
        }

    }
}
