public class BankAccount { 
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;
    private static int numOfAccounts = 0;
    private static double totalMoney = 0;
    
    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numOfAccounts++; 
        totalMoney = totalMoney + checkingBalance + savingsBalance;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }


    public void deposit(String account, double amount) {
        if (account == "savings") {
            savingsBalance = savingsBalance + amount; 
        }
        else if (account == "checking") { 
            checkingBalance = checkingBalance + amount;
        }
        totalMoney = totalMoney + amount;
    }
    
    public void withdraw(String account, double amount) {
        if (account == "savings") {
            if (amount > savingsBalance) {
                System.out.println("You have insufficient funds.");
            }
            else {
                savingsBalance = savingsBalance - amount;
            }
        }
        else if (account == "checking") {
            if (amount > checkingBalance) {
                System.out.println("You have insufficient funds.");
            }
            else { 
                checkingBalance = checkingBalance - amount;
            }
        }
        totalMoney = totalMoney - amount;
    }

    public void displayAccountTotals() {
        System.out.println(String.format("Savings Balance: $%.2f", savingsBalance));
        System.out.println(String.format("Checking Balance: $%.2f", checkingBalance));
        double totalUserBalance = savingsBalance + checkingBalance;
        System.out.println(String.format("Total User Balance: $%.2f", totalUserBalance));
    }

    public static void displayBankTotalInfo() {
        System.out.println(String.format("Banks Total Balance: $%.2f", totalMoney));
        System.out.println(String.format("Total number of accounts: %d", numOfAccounts));
    }
}



