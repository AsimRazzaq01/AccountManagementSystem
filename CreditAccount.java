public class CreditAccount extends Account {

    //CREDIT CARD ACCOUNT BALANCE IS HOW MUCH YOU USED/OWE OF THE CREDIT LIMIT
    //CREDIT DEPOSIT WILL PAY OFF AND BRING DOWN THE BALANCE
    //CAN WITHDRAW MONEY BUT NOT MORE THAN YOUR CREDIT LIMIT  (WITHDRAW <= CREDIT LIMIT - BALANCE)

    //used to call the constructor of the parent class
    public CreditAccount() {
        super();
    }

//Parametric Constructor
    CreditAccount(double _CreditLimit, double _balance){
        setCreditLimit(_CreditLimit);
        setBalance(_balance);
    }

    // CreditLimit Variable
    private double CreditLimit ;

    // Getting/ Setting CreditLimit
    public double getCreditLimit() {
        return CreditLimit;
    }
    public void setCreditLimit(double CreditLimit) {
        this.CreditLimit = CreditLimit;
    }


    // Implementation of abstract method DEPOSIT from Account class
    @Override
    public boolean Deposit(double amount) {
        if (amount < getBalance()) {
            System.out.println("Deposit amount to less than balance! ");
            return false;
        }
        if (amount > getBalance()) {
            System.out.println("Deposit amount is greater than balance!");
        }
        double newBalance = getBalance() ;
        newBalance -= amount;
        setBalance(newBalance);
        System.out.println("Deposit amount successfully deposited!");
        return true;
    }

    // Implementation of abstract method WITHDRAW from Account class
    @Override
    public boolean Withdraw(double amount) {
        if(amount > getCreditLimit() - getBalance()) {
            System.out.println("Insufficient Amount requested , please enter a valid amount.");
            return false;
        }
            setBalance(getBalance() + amount);
            return true;
    }


    public String toString(){
        return "Your Credit Account Limit is: " + getCreditLimit() + "\nYour Balance is: " + getBalance()
                + "\nYour remaining Credit is : " + (getCreditLimit() - getBalance()+ "\n");
    }

}
