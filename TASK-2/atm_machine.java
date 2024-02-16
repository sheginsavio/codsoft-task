import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs." + amount);
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
        } else {
            System.out.println("Insufficient amount");
        }
    }
}
class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void processOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option");
        }
    }
    private void checkBalance() {
        System.out.println("Your balance is: Rs." + account.getBalance());
    }
    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: Rs.");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: Rs.");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}
public class atm_machine {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            atm.displayMenu();
            System.out.print("Enter option: ");
            option = scanner.nextInt();
            atm.processOption(option);
        } while (option != 4);
    }
}
