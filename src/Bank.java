public class Bank {
    public static void printStatement(Account account) {
        System.out.println();
        System.out.println("--- Statement for " + account.getOwner() + " ---");
        System.out.println("Current balance: " + account.getBalance() + " yen");
        for (String entry : account.getHistory()) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) {
        Account tyler = new Account("Tyler", 5000);
        Account hana = new Account("Hana", 1000);
        tyler.deposit(2000);
        tyler.transfer(hana, 2000);
        hana.pay(1500);
        hana.pay(-500);
        hana.pay(500);
        tyler.deposit(0);
        tyler.transfer(hana, 100000);
        hana.transfer(tyler, 1000);
        hana.pay(100);
        printStatement(tyler);
        printStatement(hana);
    }
}