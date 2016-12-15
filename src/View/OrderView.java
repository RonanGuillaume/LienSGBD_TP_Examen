package View;

import View.ModelView.OrderTableModel;

import javax.swing.*;

/**
 * Created by Ronan
 * on 15/12/2016.
 */
public class OrderView extends JFrame{
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JTable orderTable;
    private JButton disconnectButton;
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

        orderTableModel = new OrderTableModel();
        orderTable.setModel(orderTableModel);
    }
}
