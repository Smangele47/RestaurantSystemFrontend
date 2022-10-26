package za.ac.cput.gui.Order;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.gui.Customer.httpsmethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class FindAllOrdersGUI implements ActionListener {

    //Initializing Components
    private JFrame FindAllFrame;
    private JPanel GetPanelNorth, GetPanelEast, GetPanelWest, GetPanelSouth, GetPanelCenter;
    private JTextArea OrderTextArea;
    private JLabel lblHeading;

    private JButton btnFindAll, btnClear, btnReturn;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont, textAreaFont;
    private JScrollPane scrollPane;


    public FindAllOrdersGUI(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        FindAllFrame = new JFrame("Order");

        //Panels
        GetPanelSouth = new JPanel();
        GetPanelNorth = new JPanel();
        GetPanelNorth.setBackground(Color.LIGHT_GRAY);
        GetPanelCenter = new JPanel();
        GetPanelCenter.setBackground(Color.LIGHT_GRAY);

        //TextArea
        OrderTextArea = new JTextArea(50, 40);
        OrderTextArea.setBackground(Color.white);
        OrderTextArea.setLineWrap(true);
        OrderTextArea.setWrapStyleWord(true);


        //Fillers:
        Filler1 = new JLabel("===========");
        Filler2 = new JLabel("===========");
        Filler3 = new JLabel("================================");
        Filler4 = new JLabel("================================");
        Filler5 = new JLabel("================================");
        Filler1.setForeground(Color.LIGHT_GRAY);
        Filler2.setForeground(Color.LIGHT_GRAY);
        Filler3.setForeground(Color.LIGHT_GRAY);
        Filler4.setForeground(Color.LIGHT_GRAY);
        Filler5.setForeground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("View All Orders",JLabel.CENTER);

        //Buttons
        btnFindAll = new JButton("View All Orders");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");

    }

    //Setting GUI Layout
    public void setGUI() {
        GetPanelNorth.setLayout(new GridLayout(3, 1));

        //Adding the components to the panels:
        //Panel North:
        GetPanelNorth.add(Filler5);
        GetPanelNorth.add(lblHeading);
        GetPanelNorth.add(btnFindAll);

        //Panel Center
        GetPanelCenter.add(OrderTextArea);

        //Panel South
        GetPanelSouth.add(btnClear);
        GetPanelSouth.add(btnReturn);

        //Adding panels to Customer Frame:
        FindAllFrame.add(GetPanelSouth, BorderLayout.SOUTH);
        FindAllFrame.add(GetPanelNorth, BorderLayout.NORTH);
        FindAllFrame.add(GetPanelCenter, BorderLayout.CENTER);

        //Telling compiler to listen for actions from the buttons:
        btnReturn.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        FindAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FindAllFrame.pack();
        FindAllFrame.setSize(400, 500);
        FindAllFrame.setLocationRelativeTo(null);
        FindAllFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {


        //When Display all button is clicked
        if(e.getActionCommand().equals("View All Orders")){

           /*
            httpsmethods httpmethods = new httpsmethods();
                httpmethods.saveOrder(OrderID, OrderDetails, OrderType, OrderQuantity);
                txtOrderID.setText("");
                txtOrderDetails.setText("");
                txtOrderType.setText("");
                txtOrderQuantity.setText("");
            */
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            OrderTextArea.setText("");
        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Return")){
            FindAllFrame.dispose();
        }


    }
}
