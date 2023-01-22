public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(10, 10);
        BankAccount account2 = new BankAccount(10, 10);
        // System.out.println(String.format("Number of Accounts: " + BankAccount.numOfAccounts));
        // System.out.println("Total Money: " + BankAccount.totalMoney);


        account1.deposit("checking", 10);
        account2.deposit("savings", 10);
        // System.out.println(account1.checkingBalance);

        // System.out.println("Total Money: " + BankAccount.totalMoney);

        // account1.withdraw("checking", 10);
        // System.out.println("Account 1 checking balance: " + account1.checkingBalance);
        // System.out.println("Total Money: " + BankAccount.totalMoney);

        account1.displayAccountTotals();
        BankAccount.displayBankTotalInfo();

        // Why does this print a % sign after number?
        System.out.print(account1.getSavingsBalance());

        

    }
}