import java.time.LocalDate;
import java.util.Arrays;

public class CartHistory {
    Product[] products = new Product[0];
    LocalDate time = LocalDate.now();

    public CartHistory() {
    }
    public CartHistory(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    @Override
    public String toString(){
        return "CartHistory: " + "\n" +
                "time" + time + '\'' + "\n" +
                "products='" + Arrays.toString(products) + '\'' + "\n";
    }

}
