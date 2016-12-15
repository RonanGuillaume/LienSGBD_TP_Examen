package View;

import Controller.MainController;
import View.ModelView.OrderTableModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ronan
 * on 15/12/2016.
 */
public class OrderView extends JFrame{
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JTable orderTable;
    private JButton signOutButton;
    private JButton validateButton;
    private JButton addButton;
    private JLabel subtotalLabel;
    private JLabel reductionLabel;
    private JLabel totalLabel;
    private JPanel mainPanel;

    private OrderTableModel orderTableModel;

    public OrderView() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        makeOrderView();
    }

    private void makeOrderView() {
        setVisible(true);

        //Minimize the frame's size and freeze the minimum size
        pack();
        setMinimumSize(getSize());

        //Set the frame on the middle screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        //set Sign In as a default button
        JRootPane rootPane = SwingUtilities.getRootPane(validateButton);
        rootPane.setDefaultButton(validateButton);

        orderTableModel = new OrderTableModel();
        orderTable.setModel(orderTableModel);
    }

    public void registerListener(MainController connectionController){
        signOutButton.addActionListener(connectionController);
    }
}
