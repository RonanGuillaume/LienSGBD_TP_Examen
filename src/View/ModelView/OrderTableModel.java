package View.ModelView;

import Model.OrderRow;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

/**
 * Created by Ronan
 * on 15/12/2016.
 */
public class OrderTableModel extends AbstractTableModel implements TableModel{
    private ArrayList<OrderRow> myProducts;
    private String[] columnName = {"Reference", "Name", "Quantity", "Unit price", "Price"};

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
            case "Price" :
                return myProducts.get(rowIndex).getProduct().getUnitPrice()*myProducts.get(rowIndex).getQuantity();
            default:
                return null;
        }
    }

    public OrderRow getElementAt(int index){
        return myProducts.get(index);
    }

    public void addOrderRow(OrderRow orderRow){
        myProducts.add(orderRow);
    }

    public void removeOrderRow(OrderRow orderRow){
        String orderRowToString = orderRow.toString();
        for (OrderRow myOrderRow : myProducts) {
            if (myOrderRow.toString().equalsIgnoreCase(orderRowToString)){
                myProducts.remove(myOrderRow);
                break;
            }
        }
    }

    public void removeOrderRowAt(int index) throws Exception {
        if(index < 0 || index >= myProducts.size()){
            throw new Exception("Invalid index");
        }
        myProducts.remove(index);
    }

    public void removeAllOrderRows(){
        while (myProducts.size()>0){
            removeOrderRow(getElementAt(0));
        }
    }

    public double calculateSum(){
        double sum = 0;
        int indexPrice = 4;//Could be better

        for (int i=0; i<myProducts.size(); i++){
            sum += (double)getValueAt(i, indexPrice);
        }
        return sum;
    }
}
