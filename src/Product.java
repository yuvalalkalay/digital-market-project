import java.util.Random;

public class Product extends ProductType{

    private int price;
    private String name;
    private final static int ID = new Random(1000000).nextInt();
    private Category category;

    public Product() {
    }
    public Product(String name, int price, Category category) {
        this.price = price;
        this.name = name;
        this.category = category;
    }

    public static int getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString(){
        return "{name:'" + name + '\'' + "," +
                "price:'" + price + '\''+ "}";
    }
}
