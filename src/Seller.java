import java.util.Arrays;

public class Seller {
    private String name;
    private String passWord;
    private Product[] products = new Product[0];
    private int arraySizeProduct=0;
    private int logicSizeProduct=0;

    public Seller(){

    }

    public Seller(String name, String passWord){
        this.name = name;
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

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public boolean setPassWord(String passWord) {
        this.passWord = passWord;
        return true;
    }

    public boolean setProducts(Product[] products) {
        this.products = products;
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

    @Override
    public String toString(){
        return  "seller name='" + name + '\'' + "\n" +
                "passWord='" + passWord + '\''+"\n"+
                "products='" +Arrays.toString(products)+ '\'' + "\n";
    }
}
