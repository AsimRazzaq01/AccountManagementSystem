public abstract class Account {
    //Abstract class because methods will be implemented in the child classes!


    //Variables
    private int id;
    private String name;
    private double balance;


    //Balance
    public Account(){
        this.balance = 0;
    }

    //Account copy constructor
    public Account(Account Act){
        this.balance = Act.balance;
    }


    //Get Id / Set Id
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }


    //Get Name / Set Name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    //Get Balance / Set Balance
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }


    //Deposit
    public abstract boolean Deposit(double amount);


    //Withdraw
    public abstract boolean Withdraw(double amount);


}
