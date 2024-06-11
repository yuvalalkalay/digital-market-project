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
        boolean nameExists = false; // Flag to check if the buyer name already exists
        String name = "";
        System.out.println("Enter buyer name: ");
        name = s.nextLine();

        while(data.isBuyerExist(name)){ // Loop to ensure a unique buyer name is entered
            System.out.println("The name you chose exists in the system");
            System.out.println("Enter buyer name: ");
            name = s.nextLine();
        }
        String city;
        String street;
        String passWord;
        int houseNumber;

        System.out.println("craete password: ");
        passWord = s.nextLine();
        System.out.println("address");
        System.out.println("enter city: ");
        city = s.nextLine();
        System.out.println("enter street: ");
        street = s.nextLine();
        System.out.println("enter house number: ");
        houseNumber = s.nextInt();
        Address a = new Address(city, street, houseNumber);
        Buyer b = new Buyer(name, passWord, a);
        data.addBuyer(b);
    }

    // Function to add a new seller to the system
    static void addSeller() {
        String name = "";
        System.out.println("Enter seller name: ");
        name = s.nextLine();

        while(data.isBuyerExist(name)){ // Loop to ensure a unique buyer name is entered
            System.out.println("The name you chose exists in the system");
            System.out.println("Enter seller name: ");
            name = s.nextLine();
        }

        String passWord;

        System.out.println("craete password: ");
        passWord = s.nextLine();

        Seller seller = new Seller(name, passWord);
        data.addSeller(seller);
    }

    // Function to add a product to a seller (implementation incomplete)
    static void addProductToSeller() {
        System.out.print("Enter seller name: ");
        String sellerName = s.nextLine();
        System.out.print("Enter product name: ");
        String product = s.nextLine();
        System.out.print("Enter product price: ");
        String price = s.nextLine();
        System.out.print("Enter product category: ");
        String category = s.nextLine();

        // Note: The implementation to actually store and link products to the seller is not completed
    }

    // Function to add a product to a buyer (implementation incomplete)
    static void addProductToBuyer() {
        System.out.print("Enter buyer name: ");
        String buyerName = s.nextLine();
        System.out.print("From which seller would you like to buy: ");
        String sellerName = s.nextLine();
        System.out.print("What product would you like to buy: ");
        String product = s.nextLine();

        // Note: The implementation to actually handle the purchase process is not completed
    }

    // Function to process payment for a buyer (implementation incomplete)
    static void payment() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter buyer name for payment: ");
        String buyer = s.nextLine();

        // Note: The implementation to actually handle the payment process is not completed
    }

    // Function to display all buyers' data
    static void showBuyersData() {
        if (data.buyers.length > 0) { // Check if there are any buyers
            for (int i = 0; i < data.buyers.length; i++) {
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
