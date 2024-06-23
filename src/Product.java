public class Product {
    int price;
    String name;

    public Product() {
    }
    public Product(String name, int price) {
        this.price = price;
        this.name = name;
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

    @Override
    public String toString(){
        return "Product: " + "\n" +
                "name='" + name + '\'' + "\n" +
                "price= '" + price + '\'' + "\n";
    }
}
