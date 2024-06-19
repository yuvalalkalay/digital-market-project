// name: Yuval Alkalay  id: 207962770
// name: Almog Dinur    id: 211627054
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // Flag to keep the main loop running
    static boolean isMainRunning = true;
    static SingleSourceOfTruth data = new SingleSourceOfTruth();
    static Scanner s = new Scanner(System.in);
    // Variables for sellers' names array and their sizes
    static int arraySizeSellers = 0; // Physical size of the sellers array
    static int logicSizeSellers = 0; // Logical number of sellers currently in the array
    static String[] sellersNames = new String[arraySizeSellers]; // Array to store sellers' names

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

        Address a = new Address(city, street, houseNumber);
        Buyer b = new Buyer(name, passWord, a);
        data.addBuyer(b);
    }

    // Function to add a new seller to the system
    static void addSeller() {
        String name;
        System.out.print("Enter seller name: ");
        name = s.nextLine();

        while(data.isBuyerExist(name)){ // Loop to ensure a unique buyer name is entered
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
        for(int i = 0; i < data.sellers.length; i++){
            System.out.println(i + ") " + data.sellers[i].name);
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
        data.sellers[sellerNumber].addProduct(newProduct);
    }

    // Function to add a product to a buyer (implementation incomplete)
    static void addProductToBuyer() {
        for(int i = 0; i < data.buyers.length; i++){
            System.out.println(i + ") " + data.buyers[i].name);
        }
        System.out.print("Enter buyer number: ");
        int buyerNumber = s.nextInt();

        for(int i = 0; i < data.sellers.length; i++){
            System.out.println(i + ") " + data.sellers[i].name);
        }
        System.out.print("enter seller number: ");
        int sellerNumber = s.nextInt();

        for(int i = 0; i < data.sellers[sellerNumber].products.length; i++){
            System.out.println(i + ") " + data.sellers[sellerNumber].products[i].name + " " + data.sellers[sellerNumber].products[i].price + "$");
        }
        System.out.print("enter product number: ");
        int productNumber = s.nextInt();
        Product p = data.sellers[sellerNumber].products[productNumber];
        data.buyers[buyerNumber].addProduct(p);
    }

    // Function to process payment for a buyer (implementation incomplete)
    static void payment() {
        for(int i = 0; i < data.buyers.length; i++){
            System.out.println(i + ") " + data.buyers[i].name);
        }
        System.out.print("Enter buyer number for payment: ");
        int buyerNumber = s.nextInt();
        System.out.println("buyer name: " + data.buyers[buyerNumber].name);
        System.out.println("your total payment is: " + data.buyers[buyerNumber].paymentPrice() + "$");
        Product[] cart = data.buyers[buyerNumber].getProducts();
        data.buyers[buyerNumber].addPaymentHistory(cart);
        Product[] newCart = new Product[0];
        data.buyers[buyerNumber].setProducts(newCart);
    }

    // Function to display all buyers' data
    static void showBuyersData() {
        if (data.buyers.length > 0) { // Check if there are any buyers
            for (int i = 0; i < data.buyers.length; i++) {
                System.out.println(data.buyers[i].name + " :");
                System.out.println(data.buyers[i].toString()); // Print each buyer's name
            }
        } else {
            System.out.println("No buyer yet.");
        }
    }

    // Function to display all sellers' data
    static void showSellersData() {
        if (data.sellers.length > 0) { // Check if there are any buyers
            for (int i = 0; i < data.sellers.length; i++) {
                System.out.println(data.sellers[i].toString()); // Print each buyer's name
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
