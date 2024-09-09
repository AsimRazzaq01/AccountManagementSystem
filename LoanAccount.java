import static java.lang.Math.round;

public class LoanAccount extends Account{

    //used to call the constructor of the parent class
    public LoanAccount() {
        super();
    }

    // VARIABLES
    private double InterestRate;   // 6% /12
    private double OutstandingBalance;
    private double PrincipalAmount;
    private double MonthlyPaymentAmount;
    private double Months;  //12 Months

//Parametric Constructor
    public LoanAccount(double InterestRate, double PrincipalAmount, double PaymentPeriod) {
        this.InterestRate = InterestRate;
        this.PrincipalAmount = PrincipalAmount;
        this.Months = PaymentPeriod;
    }

    // GETTER/SETTER FOR INTEREST RATE
    public double getInterestRate() {
        return InterestRate;
    }
    public void setInterestRate(double InterestRate) {
        this.InterestRate = InterestRate;
    }

    // GETTER/SETTER FOR PRINCIPAL AMOUNT
    public double getPrincipalAmount() {
        return PrincipalAmount;
    }
    public void setPrincipalAmount(double PrincipalAmount) {
        this.PrincipalAmount = PrincipalAmount;
    }

    // GETTER/SETTER FOR PAYMENT PERIOD
    public double getMonths() {
        return Months;
    }
    public void setMonths(double PaymentPeriod) {
        this.Months = PaymentPeriod;
    }

    // OUTSTANDING BALANCE = TOTAL AMOUNT
    public double getOutstandingBalance() {
        return OutstandingBalance;
    }
    public void setOutstandingBalance(double OutstandingBalance) {
        this.OutstandingBalance = OutstandingBalance;
    }

    // GETTER/SETTER FOR MONTHLY PAYMENT AMOUNT
    public double getMonthlyPaymentAmount() {
        return MonthlyPaymentAmount;
    }
    public void setMonthlyPaymentAmount(double MonthlyPaymentAmount) {
        this.MonthlyPaymentAmount = MonthlyPaymentAmount;
    }

    //MONTHLY INTEREST RATE ~ 0.005
    public double MonthlyInterestRate() {
        return (getInterestRate() / getMonths());
    }

    //-------->
    //Formula
    public double BaseValue () {
        return (1 + MonthlyInterestRate());
    }

    public double formulaPowerResult() {
        return Math.pow(BaseValue(), (-getMonths()));
    }

//FORMULA FOR MONTHLY PAYMENTS
   public double MonthlyPaymentAmount() {
        return (round(( getPrincipalAmount() * MonthlyInterestRate())/(1 - formulaPowerResult())));
    }

//Outstanding Balance
    public double OutstandingBalance() {
        return ((round( MonthlyPaymentAmount() * getMonths())));
    }

//InterestTotal
    public double TotalInterestAmount() {
        return ( ( MonthlyPaymentAmount() * getMonths()) - getPrincipalAmount() ) ;
    }


    // Person will continue to deposit money until Loan is paid
    @Override
    public boolean Deposit(double amount) {
        if (OutstandingBalance() < amount) {
            System.out.println("Error: deposit is greater than the balance");
            return false;
        }
        if (OutstandingBalance() > amount) {
            double NewOutstandingBalance = (OutstandingBalance() - amount);
            System.out.println("Payment Deposit Successful your remaining Balance due is: $"+ NewOutstandingBalance);
            return true;
        }
        System.out.println("Deposit Successful. Thank you loan is now PAID !");
        return true;
    }


    // Person can withdraw the Principal amount and that would essentially be his loan
    @Override
    public boolean Withdraw(double amount) {
        if (amount > PrincipalAmount) {
            System.out.println("Withdraw Failed, Insufficient Balance");
            return false;
        }
        if (amount < PrincipalAmount) {
            double RemainingBal = PrincipalAmount - amount;
            System.out.println("Withdraw Successful, You still have $"+RemainingBal+" remaining Balance left in your Account");
            setBalance(RemainingBal);
            return true;
        }
        System.out.println("Withdraw Successful You have $ 0 remaining Balance left in your Account");
        return true;
    }


    public String toString(){
        return "\nYou took a Loan of $"+getPrincipalAmount()+"\nWith an interest rate of "+getInterestRate()+"\nFor a payment period of: "+getMonths()+
                " Months \nYou have an outstanding balance of: $"+OutstandingBalance()+"\nYou have a monthly payment amount of: $"+MonthlyPaymentAmount()
                + "\nYou have an Monthly interest rate of: $"+ MonthlyInterestRate()+"\nTotal interest amount = $"+TotalInterestAmount();
    }

}
