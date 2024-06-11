import java.util.Arrays;

public class Buyer {
    String name;
    String passWord;
    Address address = new Address();
    Product[] products = new Product[0];

    public Buyer(){

    }

    public Buyer(String name, String passWord, Address address){
        this.name = name;
        this.passWord = passWord;
        this.address = address;
        this.products = products;
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

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    void addProduct(Product product){
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length-1] = product;
    }

    @Override
    public String toString(){
        return "Buyer{" +
                "name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", address=" + address +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
