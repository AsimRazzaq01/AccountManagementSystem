public class DebitAcccount  extends Account {

    //used to call the constructor of the parent class
    DebitAcccount() {
        super();
    }

// Promotional Balance Offer free Money into user Account for joining
    DebitAcccount(double Promotion){
        setBalance(Promotion);
    }

    // Implementation of abstract methods from Account class
    @Override
    public boolean Deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Incorrect deposit amount. Please try again.");
            return false;
        }
        setBalance( getBalance() + amount);
        return true;
    }


    // Implementation of abstract methods from Account class
    @Override
    public boolean Withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("insufficient balance. Please try again.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("You don't have enough money. Your BROKEEEEE ! ");
            return false;
        }
        double balance = getBalance();
        balance = balance - amount;
        setBalance(balance);
        return true;
    }

    //To String Method for clean reading of data
    public String toString() {
        return "Your balance is: " + getBalance() + "\n";
    }


}
