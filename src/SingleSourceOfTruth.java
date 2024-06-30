import java.util.Arrays;

public class SingleSourceOfTruth {
    private Buyer[] buyers = new Buyer[0];
    private Seller[] sellers = new Seller[0];
    private int logicSizeBuyers=0;
    private int arraySizeBuyers=0;
    private int logicSizeSellers=0;
    private int arraySizeSellers=0;

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

    public boolean setBuyers(Buyer[] buyers) {
        this.buyers = buyers;
        return true;
    }

    public boolean setSellers(Seller[] sellers) {
        this.sellers = sellers;
        return true;
    }

    void addBuyer(Buyer buyer){
        if(arraySizeBuyers == 0) {
            buyers = Arrays.copyOf(buyers, arraySizeBuyers + 1);
            buyers[0] = buyer;
            arraySizeBuyers++;
        }
        else{
            if(logicSizeBuyers < arraySizeBuyers){
                buyers[logicSizeBuyers] = buyer;

            }
            else {
                buyers = Arrays.copyOf(buyers, arraySizeBuyers * 2);
                arraySizeBuyers *= 2;
                buyers[logicSizeBuyers] = buyer;
            }
        }
        logicSizeBuyers++;
    }

    void addSeller(Seller seller){
        if(arraySizeSellers == 0) {
            sellers = Arrays.copyOf(sellers, arraySizeSellers + 1);
            sellers[0] = seller;
            arraySizeSellers++;
        }
        else{
            if(logicSizeSellers < arraySizeSellers){
                sellers[logicSizeSellers] = seller;

            }
            else {
                sellers = Arrays.copyOf(sellers, arraySizeSellers * 2);
                arraySizeSellers *= 2;
                sellers[logicSizeSellers] = seller;
            }
        }
        logicSizeSellers++;
    }

    boolean isBuyerExist(String name){
        for(int i = 0; i < buyers.length; i++){
            if(buyers[i]==null) {
                return false;
            }
            if(buyers[i].getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    boolean isSellerExist(String name){
        for(int i = 0; i < sellers.length; i++){
            if(sellers[i]==null){
                return false;
            }
            if(sellers[i].getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
