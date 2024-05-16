import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int ARRAY_SIZE_SALERS = 10;
    static int logicSizeSalers = 0;
    static String[] salersNames = new String[ARRAY_SIZE_SALERS];

    static final int ARRAY_SIZE_BUYERS = 10;
    static int logicSizeBuyers = 0;
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
            for(int i = 0; i < logicSizeBuyers; i++){
                System.out.println("buyers names: "+buyersNames[i]);
                System.out.println(name);
                if(name.equals(buyersNames[i])) { // change it to foreach function in the futcher.
                    b = true;
                    i = logicSizeBuyers;
                }
            }
        }while(b);
        buyersNames[logicSizeBuyers] = name;
        logicSizeBuyers++;
        System.out.println(Arrays.toString(buyersNames));
    }

    static void addSaler(){
        boolean b = false;
        String name = "";
        Scanner nameInput = new Scanner(System.in);
        do{
            if(b){
                System.out.println("the name you choose exists in the system");
                b = false;
            }
            System.out.println("enter saler name: ");
            name = nameInput.nextLine();
            for(int i = 0; i < logicSizeSalers; i++){
                System.out.println("salers names: "+salersNames[i]);
                System.out.println(name);
                if(name.equals(salersNames[i])) { // change it to foreach function in the futcher.
                    b = true;
                    i = logicSizeSalers;
                }
            }
        }while(b);
        salersNames[logicSizeSalers] = name;
        logicSizeSalers++;
        System.out.println(Arrays.toString(salersNames));
    }

    static void addProductToSaler(){
        Scanner s = new Scanner(System.in);
        System.out.print("enter saler name: ");
        String salerName = s.nextLine();
        System.out.print("enter product name: ");
        String product = s.nextLine();
    }

    static void addProductToBuyer(){
        Scanner s = new Scanner(System.in);
        System.out.print("enter buyer name: ");
        String buyerName = s.nextLine();
        System.out.print("enter saler name: ");
        String salerName = s.nextLine();
        System.out.print("enter product name: ");
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

    static void showSalersData(){
        System.out.println(Arrays.toString(salersNames));
    }

    static  boolean isMainRunning = true;

    static void operation(int selection){
        switch (selection){
            case 0: // exit the program.
                isMainRunning = false;
                break;
            case 1: // add saler to the salers array.
                addSaler();
                break;
            case 2: // add buyer to the buyer array.
                addBuyer();
                break;
            case 3: // add product to saler.
                addProductToSaler();
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
                showSalersData();
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