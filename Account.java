public class Account {
    
    private String name;
    private int accountNumber;
    private int password;
    private double balance;
    
    public Account(String name, int accountNumber, int password, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = balance;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public int getPassword() {
        return password;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
