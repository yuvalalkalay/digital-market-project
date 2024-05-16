import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int ARRAY_SIZE_SALERS = 10;
    static int logicSizeSalers = 0;

    static String[] salersNames = new String[ARRAY_SIZE_SALERS];

    static void addSaler(){
        boolean b = false;
        String name = "";
        Scanner nameInput = new Scanner(System.in);
        do{
            if(b == true){
                System.out.println("the name you choose exists in the system");
                b = false;
            }
            System.out.println("enter saler name: ");
            name = nameInput.nextLine();
            for(int i = 0; i < logicSizeSalers; i++){
                System.out.println("salersnames: "+salersNames[i]);
                System.out.println(name);
                if(name.equals(salersNames[i])) { // change it to foreach function in the futcher.
                    b = true;
                    i = logicSizeSalers;
                }
            }
        }while(b == true);
        salersNames[logicSizeSalers] = name;
        logicSizeSalers++;
        System.out.println(Arrays.toString(salersNames));
    }

    static  boolean isMainRunning = true;
    static void operation(int selection){
        switch (selection){
            case 0:
                isMainRunning = false;
                break;
            case 1:
                addSaler();
                break;
            case 2:
                System.out.println(selection);
                break;
            case 3:
                System.out.println(selection);
                break;
            case 4:
                System.out.println(selection);
                break;
            case 5:
                System.out.println(selection);
                break;
            case 6:
                System.out.println(selection);
                break;
            case 7:
                System.out.println(selection);
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