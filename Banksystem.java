import java.util.Scanner;
import java.util.Vector;

public class Banksystem {
    static Vector<Account> accounts = new Vector<>();
    static int nextAccountNumber = 1001;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            printMainMenu();
            int x = in.nextInt();
            
            switch (x) {
                case 1:
                    createAccount(in);
                    break;
                case 2:
                    login(in);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you for using the ATM system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void printMainMenu() {
        System.out.println("\n        WELCOME TO OUR BANK SYSTEM");
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("----------------------------------------");
        System.out.print("Enter your choice: ");
    }

    public static void createAccount(Scanner in) {
        System.out.println("\n====== CREATE NEW ACCOUNT ======");
        
        System.out.print("Enter Full Name: ");
        in.nextLine(); // Clear buffer
        String name = in.nextLine();
        
        System.out.print("Enter Password: ");
        int password = in.nextInt();
        
        System.out.print("Enter Initial Balance: ");
        double balance = in.nextDouble();
        
        int accountNumber = nextAccountNumber++;
        
        Account newAccount = new Account(name, accountNumber, password, balance);
        accounts.add(newAccount);
        
        System.out.println("Account Created Successfully!");
        System.out.println("Your Account Number: " + accountNumber);
    }

    public static void login(Scanner in) {
        System.out.println("\n====== LOGIN ======");
        System.out.print("Enter Account Number: ");
        int accNum = in.nextInt();
        
        System.out.print("Enter Password: ");
        int password = in.nextInt();
        
        Account userAccount = null;
        
        for (Account account : accounts) {
            if (account.getAccountNumber() == accNum && account.getPassword() == password) {
                userAccount = account;
                break;
            }
        }
        
        if (userAccount != null) {
            System.out.println("Login Successful! Welcome " + userAccount.getName());
            userMenu(in, userAccount);
        } else {
            System.out.println("Login failed. Account Number or Password incorrect.");
        }
    }

    public static void userMenu(Scanner in, Account account) {
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
                    account.deposit(dep);
                    System.out.println("Deposit successful. New Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w = in.nextDouble();
                    if (account.withdraw(w)) {
                        System.out.println("Withdraw successful. New Balance: " + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;
                case 3:
                    System.out.println("Your Balance: " + account.getBalance());
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