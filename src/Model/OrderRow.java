package Model;

import Model.Product;

/**
 * Created by Ronan
 * on 15/12/2016.
 */
public class OrderRow {
    private Product product;
    private int quantity;

    public OrderRow(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
