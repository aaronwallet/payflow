import java.util.ArrayList;

public class Account {
    private String owner;
    private long balance;
    private ArrayList<String> history = new ArrayList<>();

    public Account(String owner, long startingBalance) {
        this.balance = startingBalance;
        this.owner = owner;
    }

    public boolean pay(long amount) {
        if (amount <= 0) {
            history.add("Payment declined: Invalid amount. Remaining balance: " + balance + " yen");
            return false;
        } else if (amount > balance) {
            history.add("Payment declined: Insufficient balance. Remaining balance: " + balance + " yen");
            return false;
        } else {
            balance = balance - amount;
            history.add("Paid " + amount + " yen. Remaining balance: " + balance + " yen");
            return true;
        }
    }

    public boolean deposit(long amount) {
        if (amount <= 0) {
            history.add("Deposit declined: Invalid amount. Remaining balance: " + balance + " yen");
            return false;
        } else {
            balance = balance + amount;
            history.add("Deposited " + amount + " yen. Remaining balance: " + balance + " yen");
            return true;
        }
    }

    public boolean transfer(Account to, long amount) {
        if (amount <= 0) {
            history.add("Transfer declined: Invalid amount. Remaining balance: " + balance + " yen");
            return false;
        } else if (amount > balance) {
            history.add("Transfer declined: Insufficient balance. Remaining balance: " + balance + " yen");
            return false;
        } else {
            balance = balance - amount;
            to.balance = to.balance + amount;
            history.add("Transferred " + amount + " yen to " + to.owner + ". Remaining balance: " + balance + " yen");
            to.history.add("Transfer from " + owner + ": " + amount + " yen. Remaining balance: " + to.balance + " yen");
            return true;
        }
    }

    public long getBalance () {
        return balance;
    }

    public String getOwner () {
        return owner;
    }

    public ArrayList<String> getHistory() {
        return new ArrayList<>(history);
    }


}