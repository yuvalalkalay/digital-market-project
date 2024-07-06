import java.util.Arrays;

public class Seller extends Username implements Comparable<Seller>{

    public Seller() {
    }
    public Seller(String name, String passWord) {
        super(name, passWord);
    }

    @Override
    public String toString(){
        return  "seller name='" + getName() + '\'' + "\n" +
                "passWord='" + getPassWord() + '\'';
    }

    @Override
    public int compareTo(Seller other) {
        return super.getLogicSizeProduct() - other.getLogicSizeProduct();
    }
}
