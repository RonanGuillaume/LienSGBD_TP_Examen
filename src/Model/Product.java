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

    public Product(int reference, String name, String species, double unitPrice, Category category) {
        this.reference = reference;
        this.name = name;
        this.species = species;
        this.unitPrice = unitPrice;
        this.category = category;
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

    public String toString(){
        return ""+Integer.toString(reference)+", "+name+", "+species;
    }
}
