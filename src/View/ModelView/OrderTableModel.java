package View.ModelView;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Ronan
 * on 15/12/2016.
 */
public class OrderTableModel extends AbstractTableModel{
    private ArrayList<OrderRow> myProducts;
    private String[] columnName = {"Reference", "Name", "Quantity", "Unit price"};

    public OrderTableModel() {
        myProducts = new ArrayList<>();
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    @Override
    public int getRowCount() {
        return myProducts.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnName[columnIndex]){
            case "Reference" :
                return myProducts.get(rowIndex).getProduct().getReference();
            case "Name" :
                return myProducts.get(rowIndex).getProduct().getName();
            case "Quantity" :
                return myProducts.get(rowIndex).getQuantity();
            case "Unit price" :
                return myProducts.get(rowIndex).getProduct().getUnitPrice();
            default:
                return null;
        }
    }
}
