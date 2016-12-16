package View;

import Controller.MainController;
import Model.Category;
import Model.OrderRow;
import Model.Product;
import View.ModelView.OrderTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.DoubleSummaryStatistics;
import java.util.Vector;

/**
 * Created by Ronan
 * on 15/12/2016.
 */
public class OrderView extends JFrame{
    private JComboBox<Product> productComboBox;
    private JSpinner quantitySpinner;
    private JTable orderTable;
    private JButton signOutButton;
    private JButton validateButton;
    private JButton addButton;
    private JLabel subtotalLabel;
    private JLabel reductionLabel;
    private JLabel totalLabel;
    private JPanel mainPanel;
    private JButton deleteButton;
    private JLabel tvaLabel;
    private JLabel subTotalTTC;

    private SpinnerNumberModel spinnerNumberModel;
    private DefaultComboBoxModel<Product> productComboBoxModel;
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

        spinnerNumberModel = new SpinnerNumberModel(0,0,1000,1);
        quantitySpinner.setModel(spinnerNumberModel);

        orderTableModel = new OrderTableModel();
        orderTable.setModel(orderTableModel);

        productComboBoxModel = new DefaultComboBoxModel<>();
        productComboBox.setModel(productComboBoxModel);

        //Just for the test
//        productComboBoxModel.addElement(new Product(1, "Rose", "Rouge", 20, Category.Flower));
//        productComboBoxModel.addElement(new Product(2, "Rose", "Blanche", 30, Category.Flower));

        addButton.addActionListener(e -> {
            if(spinnerNumberModel.getNumber().intValue() < 1 || spinnerNumberModel.getNumber().intValue() > 1000){
                JOptionPane.showMessageDialog(this,
                        "Sorry, you must choose a quantity between 1 and 1000",
                        "Invalid quantity input",
                        JOptionPane.ERROR_MESSAGE);
            }
            else if (productComboBoxModel.getSelectedItem() == null){
                JOptionPane.showMessageDialog(this,
                        "Sorry, you must choose a product",
                        "Invalid product input",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                orderTableModel.addOrderRow(new OrderRow((Product)productComboBoxModel.getSelectedItem(), spinnerNumberModel.getNumber().intValue()));
                orderTable.updateUI();
                makeCalculation();
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                orderTableModel.removeOrderRowAt(orderTable.getSelectedRow());
                orderTable.updateUI();
                makeCalculation();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this,
                        "Sorry, you must choose a product to delete from your order",
                        "Invalid command",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void registerListener(MainController connectionController){
        signOutButton.addActionListener(connectionController);
        validateButton.addActionListener(connectionController);
    }

    public void makeCalculation(){
        subtotalLabel.setText(Double.toString(orderTableModel.calculateSum())+" €");
        tvaLabel.setText(Double.toString(Double.parseDouble(subtotalLabel.getText().substring(0, subtotalLabel.getText().indexOf(" "))) * 0.15)+" €");
        subTotalTTC.setText(Double.toString(Double.parseDouble(subtotalLabel.getText().substring(0, subtotalLabel.getText().indexOf(" "))) + Double.parseDouble(tvaLabel.getText().substring(0, tvaLabel.getText().indexOf(" "))))+" €");
        double subTTC = Double.parseDouble(subTotalTTC.getText().substring(0, subTotalTTC.getText().indexOf(" ")));
        double reduction = Double.parseDouble(reductionLabel.getText().substring(0, reductionLabel.getText().indexOf(" ")));

        if (reduction >= 1){
            totalLabel.setText(Double.toString(subTTC - (reduction*subTTC/100))+ " €");
        }
        else {
            totalLabel.setText(subTotalTTC.getText());
        }
    }
}
