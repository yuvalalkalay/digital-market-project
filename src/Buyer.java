import java.util.Arrays;

public class Buyer {
    String name;
    String passWord;
    Address address = new Address();
    Product[] products = new Product[0];
    CartHistory[] PaymentHistory = new CartHistory[0];

    public Buyer(){

    }

    public Buyer(String name, String passWord, Address address){
        this.name = name;
        this.passWord = passWord;
        this.address = address;
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

    public Product[] getProducts() {
        return products;
    }

    public CartHistory[] getPaymentHistory() {
        return PaymentHistory;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void setPaymentHistory(CartHistory[] paymentHistory) {
        PaymentHistory = paymentHistory;
    }

    void addProduct(Product product){
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length-1] = product;
    }

    double paymentPrice(){
        double sum = 0;
        for(int i = 0; i < products.length; i++){
            sum = sum + products[i].price;
        }
        return sum;
    }

    void addPaymentHistory(Product[] products){

        CartHistory history = new CartHistory(products);
        PaymentHistory = Arrays.copyOf(PaymentHistory, PaymentHistory.length + 1);
        PaymentHistory[PaymentHistory.length - 1] = history;
    }

    @Override
    public String toString(){
        return "Buyer{" +
                "name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", address='" + address +
                ", products='" + Arrays.toString(products) +
                ", PaymentHistory='" + Arrays.toString(PaymentHistory) + '\'' +
                '}';
    }
}
