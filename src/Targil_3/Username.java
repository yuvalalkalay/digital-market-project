package Targil_3;

import java.util.Arrays;

public class Username {
    private String name;
    private String passWord;
    private Product[] products = new Product[0];
    private int arraySizeProduct=0;
    private int logicSizeProduct=0;

    public Username(){

    }

    public Username(String name, String passWord){
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

    public int getArraySizeProduct() {
        return arraySizeProduct;
    }

    public int getLogicSizeProduct() {
        return logicSizeProduct;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public boolean setPassWord(String passWord) {
        this.passWord = passWord;
        return true;
    }

    public void setLogicSizeProduct(int logicSizeProduct) {
        this.logicSizeProduct = logicSizeProduct;
    }

    public void setArraySizeProduct(int arraySizeProduct) {
        this.arraySizeProduct = arraySizeProduct;
    }

    public boolean setProducts(Product[] product) {
        this.products = Arrays.copyOf(product,product.length);
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

}
