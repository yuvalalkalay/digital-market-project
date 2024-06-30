// name: Yuval Alkalay  id: 207962770
// name: Almog Dinur    id: 211627054
// we are both in pini shlomi's class
import java.util.Scanner;

public class Main {
    // Flag to keep the main loop running
    static boolean isMainRunning = true;
    static SingleSourceOfTruth data = new SingleSourceOfTruth();
    static Scanner s = new Scanner(System.in);

    // Function to add a new buyer to the system
    static void addBuyer() {
        String name;
        System.out.print("Enter buyer name: ");
        name = s.nextLine();

        while(data.isBuyerExist(name)){ // Loop to ensure a unique buyer name is entered
            System.out.println("The name you chose exists in the system");
            System.out.println("Enter buyer name: ");
            name = s.nextLine();
        }

        String passWord;
        String city;
        String street;
        int houseNumber;

        System.out.print("create password: ");
        passWord = s.nextLine();
        System.out.println("address");
        System.out.print("enter city: ");
        city = s.nextLine();
        System.out.print("enter street: ");
        street = s.nextLine();
        System.out.print("enter house number: ");
        houseNumber = s.nextInt();
        s.nextLine();
        Address a = new Address(city, street, houseNumber);
        Buyer b = new Buyer(name, passWord, a);
        data.addBuyer(b);
    }

    // Function to add a new seller to the system
    static void addSeller() {
        String name;
        System.out.print("Enter seller name: ");
        name = s.nextLine();

        while(data.isSellerExist(name)){ // Loop to ensure a unique buyer name is entered
            System.out.println("The name you chose exists in the system");
            System.out.println("Enter seller name: ");
            name = s.nextLine();
        }

        String passWord;

        System.out.print("create password: ");
        passWord = s.nextLine();

        Seller seller = new Seller(name, passWord);
        data.addSeller(seller);
    }

    // Function to add a product to a seller (implementation incomplete)
    static void addProductToSeller() {
        for(int i = 1; i <= data.getSellers().length; i++){
            System.out.println(i + ") " + data.getSellers()[i-1].getName());
        }
        System.out.print("enter seller number: ");
        int sellerNumber = s.nextInt();
        s.nextLine();

        System.out.print("Enter product name: ");
        String product = s.nextLine();

        System.out.print("Enter product price: ");
        int price = s.nextInt();
        s.nextLine();

        Product newProduct = new Product(product, price);
        data.getSellers()[sellerNumber-1].addProduct(newProduct);
    }

    // Function to add a product to a buyer (implementation incomplete)
    static void addProductToBuyer() {
        for(int i = 1; i <= data.getBuyers().length; i++){
            System.out.println(i + ") " + data.getBuyers()[i - 1].getName());
        }
        System.out.print("Enter buyer number: ");
        int buyerNumber = s.nextInt();

        for(int i = 1; i <= data.getSellers().length; i++){
            System.out.println(i + ") " + data.getSellers()[i - 1].getName());
        }
        System.out.print("enter seller number: ");
        int sellerNumber = s.nextInt();

        for(int i = 1; i <= data.getSellers()[sellerNumber - 1].getProducts().length; i++){
            System.out.println(i + ") " + data.getSellers()[sellerNumber - 1].getProducts()[i - 1].getName() + " " + data.getSellers()[sellerNumber - 1].getProducts()[i - 1].getPrice() + "$");
        }
        System.out.print("enter product number: ");
        int productNumber = s.nextInt();
        Product p = data.getSellers()[sellerNumber - 1].getProducts()[productNumber-1];
        data.getBuyers()[buyerNumber-1].addProduct(p);
    }

    // Function to process payment for a buyer (implementation incomplete)
    static void payment() {
        for(int i = 1; i <= data.getBuyers().length; i++){
            System.out.println(i + ") " + data.getBuyers()[i - 1].getName());
        }
        System.out.print("Enter buyer number for payment: ");
        int buyerNumber = s.nextInt();
        System.out.println("buyer name: " + data.getBuyers()[buyerNumber - 1].getName());
        System.out.println("your total payment is: " + data.getBuyers()[buyerNumber-1].paymentPrice() + "$");
        Product[] cart = data.getBuyers()[buyerNumber-1].getProducts();
        data.getBuyers()[buyerNumber-1].addPaymentHistory(cart);
        Product[] newCart = new Product[0];
        data.getBuyers()[buyerNumber-1].setProducts(newCart);
    }

    // Function to display all buyers' data
    static void showBuyersData() {
        if (data.getBuyers().length > 0) { // Check if there are any buyers
            for (int i = 0; i < data.getBuyers().length; i++) {
                if(data.getBuyers()[i] != null){
                    System.out.println(data.getBuyers()[i].getName() + " :");
                    System.out.println(data.getBuyers()[i].toString()); // Print each buyer's name
                }else {
                    i = data.getBuyers().length;
                }
            }
        } else {
            System.out.println("No buyer yet.");
        }
    }

    // Function to display all sellers' data
    static void showSellersData() {
        if (data.getSellers().length > 0) { // Check if there are any buyers
            for (int i = 0; i < data.getSellers().length; i++) {
                if(data.getSellers()[i] != null){
                    System.out.println(data.getSellers()[i].toString()); // Print each buyer's name
                }else{
                    i = data.getSellers().length;
                }
            }
        } else {
            System.out.println("No buyer yet.");
        }
    }

    // Function to handle user menu selection and perform corresponding operations
    static void operation(int selection) {
        if (selection >= 0 && selection <= 7) {
            switch (selection) {
                case 0: // Exit the program
                    s.close();
                    isMainRunning = false;
                    break;
                case 1: // Add seller to the sellers array
                    addSeller();
                    break;
                case 2: // Add buyer to the buyers array
                    addBuyer();
                    break;
                case 3: // Add product to seller
                    addProductToSeller();
                    break;
                case 4: // Add product to buyer
                    addProductToBuyer();
                    break;
                case 5: // Process payment for buyer
                    payment();
                    break;
                case 6: // Show all buyers' information
                    showBuyersData();
                    break;
                case 7: // Show all sellers' information
                    showSellersData();
                    break;
            }
        } else {
            System.out.println("Please enter a valid number of selection");
        }
    }

// name: Yuval Alkalay  id: 207962770
// name: Almog Dinur    id: 211627054
    // Main function to display the menu and take user input for operations
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        do {
            // Display menu options
            System.out.println("0 : Exit");
            System.out.println("1 : Add seller");
            System.out.println("2 : Add buyer");
            System.out.println("3 : Add product to seller");
            System.out.println("4 : Add product to buyer");
            System.out.println("5 : Payment for buyer");
            System.out.println("6 : Show all buyers' information");
            System.out.println("7 : Show all sellers' information");
            System.out.print("Please enter a number of selection from the menu: ");

            // Get user's menu selection
            int select = s.nextInt();

            // Perform operation based on user's selection
            operation(select);
        } while (isMainRunning);
    }
}
