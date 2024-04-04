import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static User u1;
    private static String userName;
    private static String passWord;
    private static int accountNumber;
    private static int accountBalance;
    private static List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        // Input from user
        System.out.println("Hello! " + "\n" + "Please Enter Your: " + "\n" + "1. UserName (Press Enter)" + "\n"
                + "2. Your Password (Press Enter)" + "\n" + "3. Account Number (Press Enter)" + "\n"
                + "4. Ammount You wish To Deposit: " + "\n");

        userName = scanner.nextLine();
        passWord = scanner.nextLine();
        accountNumber = scanner.nextInt();
        accountBalance = scanner.nextInt();
        System.out.println("\n");

        User u1 = new User(userName, passWord, accountNumber, accountBalance);
        System.out.println("UserName: " + u1.get_userName());
        System.out.println("\nAccountNumber: " + u1.get_accountNumber());
        System.out.println("\nAccountBalance: " + u1.get_accountBalance() + "KES \n");
        addToTransactionHistory("Deposit", accountBalance);
        restart();
        scanner.close();
    }

    public static void restart() {
        System.out.println("Select: \n1. To Continue\n2. To End Session");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            methodCall();
        } else if (choice == 2) {
            System.out.println("Session Ended Successfully!");
        } else {
            System.out.println("Invalid choice! Session Terminated");
        }

        scanner.close();
    }

    public static void methodCall() {
        System.out.println(
                "To access our services\n Select: \n 1. Account Details \n 2. Deposit Funds \n 3. Withdraw Funds \n 4. Transaction History");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // System.out.println("Querying Account Details... \n Success!");
                accountDetails();
                break;
            case 2:
                // System.out.println("Amount Deposited Successfully: ");
                depositFunds();
                break;
            case 3:
                // System.out.println("Amount Withdrawn Successfully: ");
                withdrawFunds();
                break;
            case 4:
                // System.out.println("Your Transaction History: ");
                transactionHistory();
                break;
            case 5:
                // System.out.println("Creatig new Account...");
                createNewAccount(choice, choice);
            default:
                System.out.println("Invalid Choice!");
        }
        scanner.close();

    }

    public static void accountDetails() {
        System.out.println("Querying Account Details...");
        System.out.println("UserName: " + userName);
        System.out.println("\nAccountNumber: " + accountNumber);
        System.out.println("\nAccountBalance: " + accountBalance + "KES \n");
        restart();
    }

    public static void depositFunds() {
        System.out.println("Enter Amount: \n");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter password: ");
        String pass = scanner.nextLine();
        if (!pass.equals(passWord)) {
            System.out.println("Incorrect Password! Try Again.");
        } else {
            accountBalance += amount;
            System.out.println("Success! Deposit: " + amount + "KES\n" + "New Balance: " + accountBalance + "KES\n");
        }

        addToTransactionHistory("Deposit", amount);
        restart();
        scanner.close();
    }

    public static void withdrawFunds() {
        System.out.println("Enter Your password: ");
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        if (!pass.equals(passWord)) {
            System.out.println("Incorrect Password!\nTry again.");
        } else {
            System.out.println("Enter Amount to be Withdrawn: ");
            double amount = scanner.nextDouble();
            if (amount > accountBalance) {
                System.out.println("Insufficient Funds!");
            } else if (amount <= accountBalance) {
                accountBalance -= amount;
                System.out.println("Success! \n Amount Withdrawn: " + amount + "KES \n" + "New Balance: "
                        + accountBalance + "KES \n");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
            addToTransactionHistory("Withdrawal", -amount);
        }

        restart();
        scanner.close();
    }

    public static void addToTransactionHistory(String transactionType, double amountTransacted) {
        String transaction = transactionType + ": " + amountTransacted + " KES";
        transactionHistory.add(transaction);
    }

    public static void transactionHistory() {

        System.out.println("Enter Your Password: ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String input = scanner.nextLine();
        if (input == passWord) {
            // success
            System.out.println("Transaction History:");
            if (transactionHistory.isEmpty()) {
                System.out.println("No transactions yet.");
            } else {
                for (String transaction : transactionHistory) {
                    System.out.println(transaction);
                }
            }
        } else {
            System.out.println("Incorrect Password! Please Try Again.");
            transactionHistory();
        }
        scanner.close();
        restart();
    }

    public static void createNewAccount(int newAccountNumber, int newAccountBalance) {
        Scanner scanner = new Scanner(System.in);
        newAccountNumber = scanner.nextInt();
        newAccountBalance = scanner.nextInt();
        Accounts account1 = new Accounts(newAccountNumber, newAccountBalance);
        u1.addAccount(account1);
        System.out.println("Success!\n Account added\n Account Number" + newAccountNumber);
        System.out.println("AccountBalance" + newAccountBalance);
        restart();
        scanner.close();
    }

}
