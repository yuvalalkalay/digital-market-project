import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int ARRAY_SIZE_SALERS = 0;
    static String[] salersNames = new String[ARRAY_SIZE_SALERS];

    static int ARRAY_SIZE_BUYERS = 0;
    static String[] buyersNames = new String[ARRAY_SIZE_BUYERS];

    static void addBuyer(){
        boolean b = false;
        String name = "";
        Scanner nameInput = new Scanner(System.in);
        do{
            if(b){
                System.out.println("the name you choose exists in the system");
                b = false;
            }
            System.out.println("enter buyer name: ");
            name = nameInput.nextLine();
            for(int i = 0; i < ARRAY_SIZE_SALERS; i++){
                if(name.equals(buyersNames[i])) { // change it to foreach function in the futcher.
                    b = true;
                    i = ARRAY_SIZE_SALERS;
                }
            }
        }while(b);
        buyersNames = Arrays.copyOf(buyersNames, ARRAY_SIZE_BUYERS+1);
        buyersNames[ARRAY_SIZE_BUYERS-1] = name;
        ARRAY_SIZE_BUYERS++;
        System.out.println(Arrays.toString(buyersNames));
    }

    static void addSeller(){
        boolean b = false;
        String name = "";
        Scanner nameInput = new Scanner(System.in);
        do{
            if(b){
                System.out.println("the name you choose exists in the system");
                b = false;
            }
            System.out.println("enter seller name: ");
            name = nameInput.nextLine();
            for(int i = 0; i < ARRAY_SIZE_SALERS; i++){
                if(name.equals(salersNames[i])) { // change it to foreach function in the future.
                    b = true;
                    i = ARRAY_SIZE_SALERS;
                }
            }
        }while(b);
        salersNames = Arrays.copyOf(salersNames, ARRAY_SIZE_SALERS + 1);
        salersNames[salersNames.length - 1] = name;
        ARRAY_SIZE_SALERS++;
        System.out.println(Arrays.toString(salersNames));
    }

    static void addProductToSeller(){
        Scanner s = new Scanner(System.in);
        System.out.print("enter seller name: ");
        String sellerName = s.nextLine();
        System.out.print("enter product name: ");
        String product = s.nextLine();
        System.out.print("enter product price: ");
        String price = s.nextLine();
        System.out.print("enter product category: ");
        String category = s.nextLine();
    }

    static void addProductToBuyer(){
        Scanner s = new Scanner(System.in);
        System.out.print("enter buyer name: ");
        String buyerName = s.nextLine();
        System.out.print("from which seller would you like to buy: ");
        String sellerName = s.nextLine();
        System.out.print("what product would you like to buy: ");
        String product = s.nextLine();
    }

    static void payment(){
            Scanner s = new Scanner(System.in);
        System.out.print("enter buyer name for payment: ");
        String buyer = s.nextLine();
    }

    static void showBuyersData(){
        System.out.println(Arrays.toString(buyersNames));
    }

    static void showSellersData(){
        System.out.println(Arrays.toString(salersNames));
    }

    static  boolean isMainRunning = true;

    static void operation(int selection){
        switch (selection){
            case 0: // exit the program.
                isMainRunning = false;
                break;
            case 1: // add saler to the salers array.
                addSeller();
                break;
            case 2: // add buyer to the buyer array.
                addBuyer();
                break;
            case 3: // add product to saler.
                addProductToSeller();
                break;
            case 4: // add product to buyer.
                addProductToBuyer();
                break;
            case 5: // payment for buyer.
                payment();
                break;
            case 6: // show all data of all buyers.
                showBuyersData();
                break;
            case 7: // show all data of all salers.
                showSellersData();
                break;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("0 : exit");
            System.out.println("1 : add saler");
            System.out.println("2 : add buyer");
            System.out.println("3 : add product to saler");
            System.out.println("4 : add product to buyer");
            System.out.println("5 : payment for buyer");
            System.out.println("6 : show all buyers information");
            System.out.println("7 : show all salers information");
            int select = s.nextInt();
            operation(select);
        }while(isMainRunning);
    }
}