package za.ac.cput.gui.Tim.Manager;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class FindAllManagerGUI implements ActionListener {

        //Initializing Components
        private JFrame GetAllFrame;
        private JPanel GetAllPanelNorth, GetAllPanelEast, GetAllPanelWest, GetAllPanelSouth, GetAllPanelCenter;
        private JTextArea ManagerTextArea;
        private JLabel lblHeading;
        private JButton btnFindAll, btnClear, btnReturn;
        private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
        private Font headingFont, textAreaFont;
        private JScrollPane scrollPane;



        public FindAllManagerGUI(){
                //Font
                headingFont = new Font("Arial", Font.BOLD, 18);

                GetAllFrame = new JFrame("Customer");

                //Panels
                GetAllPanelSouth = new JPanel();
                GetAllPanelNorth = new JPanel();
                GetAllPanelNorth.setBackground(Color.LIGHT_GRAY);
                GetAllPanelCenter = new JPanel();
                GetAllPanelCenter.setBackground(Color.LIGHT_GRAY);

                //TextArea
                ManagerTextArea = new JTextArea(50, 40);
                ManagerTextArea.setBackground(Color.white);
                ManagerTextArea.setLineWrap(true);
                ManagerTextArea.setWrapStyleWord(true);


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
                lblHeading = new JLabel("View All Customers",JLabel.CENTER);

                //Buttons
                btnFindAll = new JButton("View All Customers");
                btnClear = new JButton("Clear");
                btnReturn = new JButton("Return");

        }



        //Setting GUI Layout
        public void setGUI() {
                GetAllPanelNorth.setLayout(new GridLayout(3, 1));

                //Adding the components to the panels:
                //Panel North:
                GetAllPanelNorth.add(Filler5);
                GetAllPanelNorth.add(lblHeading);
                GetAllPanelNorth.add(btnFindAll);

                //Panel Center
                GetAllPanelCenter.add(ManagerTextArea);

                //Panel South
                GetAllPanelSouth.add(btnClear);
                GetAllPanelSouth.add(btnReturn);

                //Adding panels to Customer Frame:
                GetAllFrame.add(GetAllPanelSouth, BorderLayout.SOUTH);
                GetAllFrame.add(GetAllPanelNorth, BorderLayout.NORTH);
                GetAllFrame.add(GetAllPanelCenter, BorderLayout.CENTER);

                //Telling compiler to listen for actions from the buttons:
                btnReturn.addActionListener(this);
                btnClear.addActionListener(this);
                btnReturn.addActionListener(this);

                //Set GUI:
                GetAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                GetAllFrame.pack();
                GetAllFrame.setSize(400, 500);
                GetAllFrame.setLocationRelativeTo(null);
                GetAllFrame.setVisible(true);


        }



        @Override
        public void actionPerformed(ActionEvent e) {

                //When Display all button is clicked
                if(e.getActionCommand().equals("View All Customers")){

                        httpsmethods httpsmethods = new httpsmethods();

                        //Create set to store method output
                        Set<Manager> managers = httpsmethods.getManagers(); // change backend

                        //Display set in text area
                        ManagerTextArea.setText(String.valueOf(managers));
                }

                //When clear button is clicked
                if(e.getActionCommand().equals("Clear")){
                        ManagerTextArea.setText("");
                }

                //When exit button is clicked
                if(e.getActionCommand().equals("Return")){
                        GetAllFrame.dispose();
                }


        }
}
