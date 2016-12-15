package Model;

/**
 * Created by Ronan
 * on 15/12/2016.
 */
public class Product {

    private int reference;
    private String name;
    private String species;
    private double unitPrice;
    private Category category;

    public Product() {
    }

    public int getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Category getCategory() {
        return category;
    }
}
