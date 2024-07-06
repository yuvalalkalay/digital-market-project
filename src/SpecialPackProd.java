import java.util.Arrays;

public class SpecialPackProd extends Product {
    private float extraPay;

    public SpecialPackProd() {
    }
    public SpecialPackProd(String name, float price, Category category, float extraPay) {
        super(name, price, category);
        this.extraPay = extraPay;
    }

    public float getExtraPay() {
        return extraPay;
    }

    public void setExtraPay(float extraPay) {
        this.extraPay = extraPay;
    }

    public String toString(float ExtraPrice) {
        float newPrice = super.getPrice()+ExtraPrice;
        return "{name:'" + super.getName() + '\'' + "," +
                "price:'" + newPrice + '\''+"," +
                "type':"+super.getCategory()+ '\''+"}";
    }


}