import java.util.Arrays;

public class Seller {
    String name;
    String passWord;
    Product[] products = new Product[0];

    public Seller(){

    }
    public Seller(String name, String passWord){
        this.name = name;
        this.passWord = passWord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    void addProduct(Product product){
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length-1] = product;
    }

    @Override
    public String toString(){
        return "Seller{" +
                "name='" + name + '\'' +
                ", passWord='" + passWord + '\''+
                ", products='" +Arrays.toString(products)+ '\'' +
                '}';
    }
}
