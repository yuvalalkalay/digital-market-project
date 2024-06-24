import java.util.Arrays;

public class Buyer {
    String name;
    String passWord;
    Address address = new Address();
    Product[] products = new Product[0];
    CartHistory[] PaymentHistory = new CartHistory[0];
    private int arraySizeProduct=0;
    private int logicSizeProduct=0;
    private int arraySizePaymentHistory=0;
    private int logicSizePaymentHistory=0;

    public Buyer(){

    }
    public Buyer(String name, String passWord, Address address){
        this.name = name;
        this.passWord = passWord;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
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

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public boolean setPassWord(String passWord) {
        this.passWord = passWord;
        return true;
    }

    public boolean setAddress(Address address) {
        this.address = address;
        return true;
    }

    public boolean setProducts(Product[] products) {
        this.products = products;
        return true;
    }

    public boolean setPaymentHistory(CartHistory[] paymentHistory) {
        PaymentHistory = paymentHistory;
        return true;
    }

    void addProduct(Product product){
        if(arraySizeProduct == 0) {
            products = Arrays.copyOf(products, arraySizeProduct + 1);
            products[0] = product;
            arraySizeProduct++;
        }
        else{
            if(logicSizeProduct < arraySizeProduct){
                products[logicSizeProduct] = product;

            }
            else {
                products = Arrays.copyOf(products, arraySizeProduct * 2);
                arraySizeProduct *= 2;
                products[logicSizeProduct] = product;
            }
        }
        logicSizeProduct++;
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
        if(arraySizePaymentHistory == 0) {
            PaymentHistory = Arrays.copyOf(PaymentHistory, arraySizePaymentHistory + 1);
            PaymentHistory[0] = history;
            arraySizePaymentHistory++;
        }
        else{
            if(logicSizePaymentHistory < arraySizePaymentHistory){
                PaymentHistory[logicSizePaymentHistory] = history;

            }
            else {
                PaymentHistory = Arrays.copyOf(PaymentHistory, arraySizePaymentHistory * 2);
                arraySizePaymentHistory *= 2;
                PaymentHistory[logicSizePaymentHistory] = history;
            }
        }
        logicSizePaymentHistory++;
    }

    @Override
    public String toString(){
        return  "Buyer name='" + name + '\'' + "\n" +
                "passWord='" + passWord + '\'' + "\n" +
                "address='" + address + "\n" +
                "products='" + Arrays.toString(products) + "\n" +
                "PaymentHistory='" + Arrays.toString(PaymentHistory) + '\'' + "\n";
    }
}
