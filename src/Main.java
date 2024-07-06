// name: Yuval Alkalay  id: 207962770
// name: Almog Dinur    id: 211627054
// we are both in pini shlomi's class
import java.util.Arrays;
import java.util.InputMismatchException;
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

        while (data.isBuyerExist(name)) { // Loop to ensure a unique buyer name is entered
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
        while (data.isSellerExist(name)) { // Loop to ensure a unique buyer name is entered
            System.out.println("The name you chose exists in the system");
            System.out.println("Enter seller name: ");
            name = s.nextLine();
        }
        System.out.print("create password: ");
        String passWord = s.nextLine();
        Seller seller = new Seller(name, passWord);
        data.addSeller(seller);
    }

    // Function to add a product to a seller (implementation incomplete)
    static void addProductToSeller() {
        int sellerNumber;
        float price;
        int index;
        String answer;
        float extraPay;
        for (int i = 1; i <= data.getLogicSizeSellers(); i++) {
            System.out.println(i + ") " + data.getSellers()[i - 1].getName());
        }
        while(true) {
            try{
                System.out.print("enter seller number: ");
                sellerNumber = s.nextInt();
                s.nextLine();
                if (sellerNumber >= 1 && sellerNumber <= data.getLogicSizeSellers()) {
                    break;
                }
                else{
                    throw new Exception("Invalid input. the number must be between 1 to "+data.getLogicSizeSellers());
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }// checks if input for the selected seller is valid
        System.out.print("Enter product name: ");
        String product = s.nextLine();
        while (true) {
            try {
                System.out.print("Enter product price: ");
                price = s.nextInt();
                s.nextLine();
                if (price>0) {
                    break;
                }
                else{
                    throw new Exception("Invalid input. The price for Product can't be 0 or less");
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }// checks if input for the product price valid
        while(true) {
            try {
                System.out.println("1) Children");
                System.out.println("2) Electricity");
                System.out.println("3) Office");
                System.out.println("4) Clothing");
                System.out.print("enter the number of the category: ");
                index = s.nextInt();
                s.nextLine();
                if (index >= 1 && index <= 4) {
                    break;
                } else {
                    throw new Exception("Invalid input. the number must be between 1 to 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }// checks if input for the selected product type is valid
        Product.Category[] categories = Product.Category.values();
        while (true) {
            try {
                System.out.print("do you wish to sell this product in a special packaging? yes/no: ");
                answer = s.next();
                s.nextLine();
                if (answer.equals("no") || answer.equals("yes")) {
                    break;
                } else {
                    throw new Exception("Invalid input. type 'yes' or 'no' please");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }// checks that user inputs yes/no properly
        if (answer.equals("yes")) {
            while(true) {
                try {
                    System.out.print("what is your price for the special packaging? ");
                    extraPay = s.nextInt();
                    s.nextLine();
                    if (extraPay>0) {
                        break;
                    } else {
                        throw new Exception("Invalid input. The price for Special packaging can't be 0 or less ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    s.nextLine();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }// checks if input for the price of the special packaging is valid
            SpecialPackProd newProduct = new SpecialPackProd(product, price, categories[index - 1], extraPay);
            data.getSellers()[sellerNumber - 1].addProduct(newProduct);
        } else {
            Product newProduct = new Product(product, price, categories[index - 1]);
            data.getSellers()[sellerNumber - 1].addProduct(newProduct);
        }
    }

    // Function to add a product to a buyer (implementation incomplete)
    static void addProductToBuyer() {
        int buyerNumber;
        int sellerNumber;
        int productNumber;
        int counter = 0;
        Seller[] temp = new Seller[0];
        String answer;
        for (int i = 1; i <= data.getLogicSizeBuyers(); i++) {
            System.out.println(i + ") " + data.getBuyers()[i - 1].getName());
        }
        while (true) {
            try {
                System.out.print("Enter buyer number: ");
                buyerNumber = s.nextInt();
                if (buyerNumber >= 1 && buyerNumber <= data.getLogicSizeBuyers()) {
                    break;
                } else {
                    throw new Exception("Invalid input. the number must be between 1 to " + data.getLogicSizeBuyers());
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } // checks if input for the selected buyer is valid
        for (int i = 1; i <= data.getLogicSizeSellers(); i++) {
            if (data.getSellers()[i - 1].getLogicSizeProduct() != 0) {
                counter++;
                System.out.println(counter + ") " + data.getSellers()[i - 1].getName());
                temp = Arrays.copyOf(temp, counter);
                temp[counter - 1] = data.getSellers()[i - 1];
            }
        }
        if (counter == 0) {
            System.out.println("Error: there are no sellers who got initiated with products yet");
        } else {
            while (true) {
                try {
                    System.out.print("enter the seller's number: ");
                    sellerNumber = s.nextInt();
                    if (sellerNumber >= 1 && sellerNumber <= counter) {
                        break;
                    } else {
                        throw new Exception("Invalid input. the number must be between 1 to " + data.getLogicSizeSellers());
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    s.nextLine();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }// checks if input for the selected seller is valid
            for (int i = 1; i <= temp[sellerNumber-1].getLogicSizeProduct(); i++) {
                System.out.println(i + ") " + temp[sellerNumber - 1].getProducts()[i - 1].getName() + " " + temp[sellerNumber - 1].getProducts()[i - 1].getPrice() + "$");
            }
            while (true) {
                try {
                    System.out.print("enter product number: ");
                    productNumber = s.nextInt();
                    if (productNumber >= 1 && productNumber <= temp[sellerNumber-1].getLogicSizeProduct()) {
                        break;
                    } else {
                        throw new Exception("Invalid input. the number must be between 1 to " +
                                temp.length);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    s.nextLine();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }// checks if input for the selected product is valid
            if (temp[sellerNumber - 1].getProducts()[productNumber - 1] instanceof SpecialPackProd) {
                System.out.print("the product: '" + temp[sellerNumber - 1].getProducts()[productNumber - 1].getName() +
                        "' can be packed in a special package,\n" + "would you like to pay " +
                        ((SpecialPackProd) temp[sellerNumber - 1].getProducts()[productNumber - 1]).getExtraPay() +
                        " for the special package?\ntype yes/no: ");
                while (true) {
                    try {
                        answer = s.next();
                        s.nextLine();
                        if (answer.equals("no") || answer.equals("yes")) {
                            break;
                        } else {
                            throw new Exception("Invalid input. type 'yes' or 'no' please");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }// checks that user inputs yes/no properly
                if (answer.equals("yes")) {
                    data.getBuyers()[buyerNumber-1].addSpecialProdArr(temp[sellerNumber - 1].getProducts()[productNumber - 1]);
                    float FinalPay = ((SpecialPackProd) temp[sellerNumber - 1].getProducts()[productNumber - 1]).getExtraPay() +
                            temp[sellerNumber - 1].getProducts()[productNumber - 1].getPrice();
                    System.out.println("your total price for the product '"+
                            temp[sellerNumber - 1].getProducts()[productNumber - 1].getName() +
                            "' is: "+FinalPay+"$");
                }
            }
            Product p = data.getSellers()[sellerNumber - 1].getProducts()[productNumber - 1];
            data.getBuyers()[buyerNumber - 1].addProduct(p);
        }
    }

    // Function to process payment for a buyer (implementation incomplete)
    static void payment() {
        int buyerNumber;
        String answer;
        float sum = 0;
        for (int i = 1; i <= data.getLogicSizeBuyers(); i++) {
            System.out.println(i + ") " + data.getBuyers()[i - 1].getName());
        }
        while(true) {// checks
            try {
                System.out.print("Enter buyer number for payment: ");
                buyerNumber = s.nextInt();
                if (buyerNumber >= 1 && buyerNumber <= data.getLogicSizeBuyers()) {
                    break;
                } else {
                    throw new Exception("Invalid input. the number must be between 1 to " +
                            data.getLogicSizeBuyers());
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }// checks if input for the selected buyer is valid
        try{
            if(data.getBuyers()[buyerNumber-1].getLogicSizeProduct()!=0) {
                System.out.println("buyer name: " + data.getBuyers()[buyerNumber - 1].getName());
                sum = data.getSum()+data.getBuyers()[buyerNumber - 1].paymentPrice();
                System.out.println("your total payment is: " + sum + "$");
                Product[] cart = data.getBuyers()[buyerNumber - 1].getProducts();
                data.getBuyers()[buyerNumber - 1].addPaymentHistory(cart);
                Product[] newCart = new Product[0];
                data.getBuyers()[buyerNumber - 1].setProducts(Arrays.copyOf(newCart, 0));
                data.getBuyers()[buyerNumber - 1].setLogicSizeProduct(0);
                data.getBuyers()[buyerNumber - 1].setArraySizeProduct(0);
            }else{
                throw new Exception("Your cart is EMPTY! please go add products and than come back to pay");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Function to display all buyers' data
    static void showBuyersData() {
        if (data.getLogicSizeBuyers() > 0) { // Check if there are any buyers
            Buyer[] temp = Arrays.copyOfRange(data.getBuyers(), 0, data.getLogicSizeBuyers());
            Arrays.sort(temp);
            for (Buyer buyer : temp) {
                System.out.println("\n"+buyer.toString()); // Print each seller's info
                for (int j = 0; j < buyer.getLogicSizeProduct(); j++) {
                    if(buyer.getProducts()[j].getID() == buyer.getSpecialPackProd()[j].getID()){

                    }
                    System.out.println(buyer.getProducts()[j].toString());
                }
                for (int j = 0; j < buyer.getLogicSizePaymentHistory(); j++) {
                    System.out.println(buyer.getPaymentHistory()[j].toString());
                }
            }
            System.out.println();
        } else {
            System.out.println("No buyer yet.");
        }
    }

    // Function to display all sellers' data
    static void showSellersData() {
        if (data.getLogicSizeSellers() > 0) { // Check if there are any seller's
            Seller[] temp = Arrays.copyOfRange(data.getSellers(), 0, data.getLogicSizeSellers());
            Arrays.sort(temp);
            for (Seller seller : temp) {
                System.out.println("\n"+seller.toString()); // Print each seller's info
                for (int j = 0; j < seller.getLogicSizeProduct(); j++) {
                    System.out.println(seller.getProducts()[j].toString());
                }
            }
            System.out.println();
        } else {
            System.out.println("No seller yet.");
        }
    }

    static void printAllProductByType() {
        int index;
        while(true) {
            try {
                System.out.println("enter the number of the category:");
                System.out.println("1) Children");
                System.out.println("2) Electricity");
                System.out.println("3) Office");
                System.out.println("4) Clothing");
                index = s.nextInt();
                s.nextLine();
                if (index >= 1 && index <= 4) {
                    break;
                } else {
                    throw new Exception("Invalid input. the number must be between 1 to 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }// checks if input for the selected product type is valid
        Product.Category[] categories = Product.Category.values();
        for (int i = 0; i < data.getLogicSizeSellers(); i++) {
            for (int j = 0; j < data.getSellers()[i].getLogicSizeProduct(); j++) {
                if (data.getSellers()[i].getProducts()[j].getCategory() == categories[index - 1]) {
                    System.out.println(data.getSellers()[i].getProducts()[j].toString());
                }
            }
        }
    }

    static void changeCart() {
        int input;
        int index;
        while(true) {
            try {
                System.out.print("would you like to delete your current cart and " +
                        "replace it with the one you have in history?\n" +
                        "Enter 1 to continue, enter 0 to exit: ");
                input = s.nextInt();
                s.nextLine();
                if (input >= 0 && input <=1) {
                    break;
                } else {
                    throw new Exception("Invalid input. the number must be 1 or 0 ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }// checks if user wants to switch his cart
        if (input == 1) {
            for (int i = 1; i <= data.getLogicSizeBuyers(); i++) {
                System.out.println(i + ")" + data.getBuyers()[i - 1].getName());
            }
            while (true) {
                try {
                    System.out.print("Pick your username's number: ");
                    index = s.nextInt();
                    s.nextLine();
                    if (index >= 1 && index <= data.getLogicSizeBuyers()) {
                        break;
                    } else {
                        throw new Exception("Invalid input. the number must be between 1 to "+data.getLogicSizeBuyers());
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    s.nextLine();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }// checks if input for the selected buyer is valid
            for (int j = 1; j <= data.getBuyers()[index - 1].
                    getLogicSizePaymentHistory(); j++) {
                System.out.println(j + ")" + data.getBuyers()[index - 1].
                        getPaymentHistory()[j - 1].toString());
            }
            while(true) {
                try {
                    System.out.print("Pick the number of the cart you want to restore: ");
                    input = s.nextInt();
                    s.nextLine();
                    if (input >= 1 && index <= data.getBuyers()[index-1].getLogicSizeProduct()) {
                        break;
                    } else {
                        throw new Exception("Invalid input. the number must be between 1 to " + data.getBuyers()[index-1].getLogicSizeProduct());
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    s.nextLine();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }// checks if input for the selected cart from history is valid
            boolean stop = true;
            int count = 0;
            Product[] newCart = new Product[data.getBuyers()[index - 1].getPaymentHistory()[input - 1].getProducts().length];
            for (int i = 0; i<newCart.length && data.getBuyers()[index - 1].getPaymentHistory()[input - 1].getProducts()[i] !=null; i++) {
                newCart[i] = data.getBuyers()[index - 1].getPaymentHistory()[input - 1].getProducts()[i].clone();
                count++;
                for (int j = 0; j < data.getLogicSizeSellers() && stop; j++) { //goes over the entire array of sellers
                    for (int k = 0; k < data.getSellers()[j].getLogicSizeProduct() && stop; k++) { // goes over the entire array of products of each seller
                        if (newCart[i].getID() == data.getSellers()[j].getProducts()[k].getID() //checks to see if the price of the item has changed
                                && data.getSellers()[j].getProducts()[k].getPrice() != newCart[j].getPrice()) {
                            data.getBuyers()[index - 1].getProducts()[i].setPrice(data.getBuyers()[index - 1].getProducts()[i].getPrice());
                            stop = false;
                        }
                    }
                }
                stop = true;
            }
            data.getBuyers()[index - 1].setProducts(newCart);
            data.getBuyers()[index-1].setLogicSizeProduct(count);
            data.getBuyers()[index-1].setArraySizeProduct(newCart.length);
        }

    }

    // Function to handle user menu selection and perform corresponding operations
    static void operation(int selection) {
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
            case 8:
                printAllProductByType();
                break;
            case 9:
                changeCart();
                break;
        }
    }

    // name: Yuval Alkalay  id: 207962770
// name: Almog Dinur    id: 211627054
    // save. function to display the menu and take user input for operations
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (isMainRunning) {
            try {
                // Display menu options
                System.out.println("0 : Exit");
                System.out.println("1 : Add seller");
                System.out.println("2 : Add buyer");
                System.out.println("3 : Add product to seller");
                System.out.println("4 : Add product to buyer");
                System.out.println("5 : Payment for buyer");
                System.out.println("6 : Show all buyer's information");
                System.out.println("7 : Show all seller's information");
                System.out.println("8 : Show all products by type");
                System.out.println("9 : Switch current cart with cart from history");
                System.out.print("Please enter a number of selection from the menu: ");

                // Get user's menu selection
                int select = s.nextInt();
                if(select>=0 && select<=9){
                    operation(select);// Perform operation based on user's selection
                }
                else{
                    throw new Exception("Invalid input. the number must be between 0 to 9.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
