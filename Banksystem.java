import java.util.Scanner;
import java.util.Vector;
public class Banksystem {
    static Vector<String> names = new Vector<>();
    static Vector<Integer> accountnums = new Vector<>();
    static Vector<String> passwords = new Vector<>();
    static Vector<Double> balances = new Vector<>();
    static int nextAccountNumber = 1001;
    public static void main (String args[])
    {Scanner in = new Scanner(System.in);
         Boolean exit = false;
       
        while(!exit)
        { printMainMenu();
            Integer x = in.nextInt();
            switch (x) {
                case 1:
                    createAccount(in);
                    System.out.println(" Account Created Successfully!");
                    break;
                case 2:
                     login(in);
                    break;
                case 3:
                    exit= true;
                    System.out.println("Thank you for using the ATM system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }

    }
    public static void printMainMenu(){
        
        System.out.println("        WELCOME TO SMART BANK SYSTEM");
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("----------------------------------------");
        System.out.print("Enter your choice: ");
    }
    public static void createAccount(Scanner in){
        System.out.println("\n====== CREATE NEW ACCOUNT ======");
         
         System.out.print("Enter Full Name: ");
         String name = in.nextLine();
in.nextLine();
         System.out.print("Enter Password: ");
         String password = in.nextLine();
in.nextLine();
         System.out.print("Enter Initial Balance: ");
         double balance = in.nextDouble();
    in.nextLine();
         int accountNumber = nextAccountNumber++;
     names.add(name);
     accountnums.add(accountNumber);
     passwords.add(password);
     balances.add(balance);
     System.out.println("Your Account Number: " + accountNumber);

    }
    public static void login(Scanner in) {
    System.out.println("\n====== LOGIN ======");
    System.out.print("Enter Account Number: ");
    int accNum = in.nextInt();
    in.nextLine();

    System.out.print("Enter Password: ");
    String password = in.nextLine();

    for (int i = 0; i < accountnums.size(); i++) {
        if (accountnums.get(i) == accNum && passwords.get(i).equals(password)) {
            System.out.println("Login Successful! Welcome " + names.get(i));
            userMenu(in, i);
            return;
        }
    }
    System.out.println("Login failed. Account Number or Password incorrect.");
}
     public static void userMenu(Scanner in, int i) {
        boolean logout = false;

        while (!logout) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Logout");
            System.out.print("Choice: ");

            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = in.nextDouble();
                    balances.set(i, balances.get(i) + dep);
                    System.out.println("Deposit successful. New Balance: " + balances.get(i));
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w = in.nextDouble();
                    if (w <= balances.get(i)) {
                        balances.set(i, balances.get(i) - w);
                        System.out.println("Withdraw successful. New Balance: " + balances.get(i));
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;
                case 3:
                    System.out.println("Your Balance: " + balances.get(i));
                    break;
                case 4:
                    logout = true;
                    System.out.println("Logged out successfully!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                }
            }
        }
    }