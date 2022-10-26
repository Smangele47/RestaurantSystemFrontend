package za.ac.cput.gui.Tim.Waiter;

import za.ac.cput.domain.Waiter;
import za.ac.cput.gui.Tim.Manager.httpsmethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteWaiterGUI implements ActionListener {

    //Initializing Components
    Waiter waiter;
    private JFrame DeleteWaiterFrame;
    private JPanel DeleteWaiterPanelNorth, DeleteWaiterPanelSouth, DeleteWaiterPanelEast, DeleteWaiterPanelWest, DeleteWaiterPanelCenter;
    private JLabel lblHeading, lblID;
    private JTextField txtWaiterID;
    private JButton btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public DeleteWaiterGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        DeleteWaiterFrame = new JFrame("Customer ");
        DeleteWaiterPanelNorth = new JPanel();
        DeleteWaiterPanelSouth = new JPanel();
        DeleteWaiterPanelEast = new JPanel();
        DeleteWaiterPanelWest = new JPanel();
        DeleteWaiterPanelCenter = new JPanel();

        DeleteWaiterPanelNorth.setBackground(Color.LIGHT_GRAY);
        DeleteWaiterPanelEast.setBackground(Color.LIGHT_GRAY);
        DeleteWaiterPanelSouth.setBackground(Color.LIGHT_GRAY);
        DeleteWaiterPanelWest.setBackground(Color.LIGHT_GRAY);
        DeleteWaiterPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Delete Customer Record", JLabel.CENTER);

        //Labels
        lblID = new JLabel("Enter CustomerID:");

        //TextFields
        txtWaiterID = new JTextField();

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
        DeleteWaiterPanelNorth.setLayout(new GridLayout(2, 1));
        DeleteWaiterPanelEast.setLayout(new GridLayout(12, 1));
        DeleteWaiterPanelSouth.setLayout(new GridLayout(1, 3));
        DeleteWaiterPanelWest.setLayout(new GridLayout(12, 1));
        DeleteWaiterPanelCenter.setLayout(new GridLayout(12, 1));
        DeleteWaiterPanelEast.setLayout(new GridLayout(12, 1));

        //Adding the components to the panels:
        //Panel North:
        DeleteWaiterPanelNorth.add(Filler5);
        DeleteWaiterPanelNorth.add(lblHeading);

        //Panel West:
        DeleteWaiterPanelWest.add(Filler1);

        //Panel Center:
        DeleteWaiterPanelCenter.add(lblID);
        DeleteWaiterPanelCenter.add(txtWaiterID);
        DeleteWaiterPanelCenter.add(Filler4);

        //Panel East
        DeleteWaiterPanelEast.add(Filler2);

        //Panel South:
        DeleteWaiterPanelSouth.add(btnDelete);
        DeleteWaiterPanelSouth.add(btnClear);
        DeleteWaiterPanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);



        //Adding panels to Customer Frame:
        DeleteWaiterFrame.add(DeleteWaiterPanelNorth, BorderLayout.NORTH);
        DeleteWaiterFrame.add(DeleteWaiterPanelSouth, BorderLayout.SOUTH);
        DeleteWaiterFrame.add(DeleteWaiterPanelEast, BorderLayout.EAST);
        DeleteWaiterFrame.add(DeleteWaiterPanelCenter, BorderLayout.CENTER);
        DeleteWaiterFrame.add(DeleteWaiterPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        DeleteWaiterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DeleteWaiterFrame.pack();
        DeleteWaiterFrame.setSize(400, 300);
        DeleteWaiterFrame.setLocationRelativeTo(null);
        DeleteWaiterFrame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Delete")){

            //Store textfield text in string
            String id = txtWaiterID.getText();
            Httpsmethods Httpsmethods = new Httpsmethods();

            //Use String as parameter in http method
            Httpsmethods.deleteWaiter(id);

            //Show message when successfully completed
            JOptionPane.showMessageDialog(null, "Waiter Deleted");
            txtWaiterID.setText("");
        }


        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtWaiterID.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            DeleteWaiterFrame.dispose();
        }

    }
}
