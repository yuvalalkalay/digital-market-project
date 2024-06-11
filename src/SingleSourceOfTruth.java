import java.util.Arrays;

public class SingleSourceOfTruth {
    Buyer[] buyers = new Buyer[0];
    Seller[] sellers = new Seller[0];

    public SingleSourceOfTruth() {
    }
    public SingleSourceOfTruth(Buyer[] buyers, Seller[] sellers) {
        this.buyers = buyers;
        this.sellers = sellers;
    }

    public Buyer[] getBuyers() {
        return buyers;
    }

    public Seller[] getSellers() {
        return sellers;
    }

    public void setBuyers(Buyer[] buyers) {
        this.buyers = buyers;
    }

    public void setSellers(Seller[] sellers) {
        this.sellers = sellers;
    }

    void addBuyer(Buyer buyer){
        buyers = Arrays.copyOf(buyers, buyers.length + 1);
        buyers[buyers.length - 1] = buyer;
    }

    void addSeller(Seller seller){
        sellers = Arrays.copyOf(sellers, sellers.length + 1);
        sellers[sellers.length - 1] = seller;
    }

    boolean isBuyerExist(String name){
        for(int i = 0; i < buyers.length; i++){
            if(buyers[i].name.equals(name)){
                return true;
            }
        }
        return false;
    }

    boolean isSellerExist(String name){
        for(int i = 0; i < buyers.length; i++){
            if(sellers[i].name.equals(name)){
                return true;
            }
        }
        return false;
    }
}
