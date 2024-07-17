package Targil_3;

public class Product {

    public enum Category {
        Children,
        Electricity,
        Office,
        Clothing
    }
    private float price;
    private String name;
    private static int ID = 0;
    private Category category;
    private boolean isSpecialProd = false;

    public Product() {
    }
    public Product(String name, float price, Category category, boolean isSpecialProd) {
        this.price = price;
        this.name = name;
        this.category = category;
        this.isSpecialProd = isSpecialProd;
        this.ID++;
    }

    public Product(Product other) {
        this.price = other.price;
        this.name = other.name;
        this.category = other.category;
    }

    public int getID() {
        return ID;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public boolean getisSpecialProd() {
        return isSpecialProd;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSpecialProd(boolean specialProd) {
        isSpecialProd = specialProd;
    }

    @Override
    public String toString(){
        return "{name:'" + name + '\'' + "," +
                "price:'" + price + '\''+"," +
                "type':"+category+ '\''+"}";
    }

}
