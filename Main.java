public class Main {
    public static void main(String[] args) {

    //DEBIT ACCOUNT
        System.out.println("DEBIT ACCOUNT - ~DETAILS~\n");
        DebitAcccount person1 = new DebitAcccount(0);
        DebitAcccount person2 = new DebitAcccount(25);

        //Person 1
        person1.Deposit(100);
        person1.Withdraw(25);
        System.out.println(person1.toString());

        //Person 2
        person2.Deposit(100);
        person2.Withdraw(25);
        System.out.println(person2.toString());

    //CREDIT ACCOUNT
        System.out.println("CREDIT ACCOUNT - ~DETAILS~\n");
        CreditAccount acc1 = new CreditAccount(15000,1000.72);
        CreditAccount acc2 = new CreditAccount(2500,98.67);

        //CREDIT ACCOUNT 1
        acc1.Deposit(1000.72);
        acc1.Withdraw(0);
        System.out.println(acc1.toString());

        //CREDIT ACCOUNT 2
        acc2.Deposit(98.67);
        acc2.Withdraw(2501);
        System.out.println(acc2.toString());

    //LOAN ACCOUNT
        System.out.println("LOAN ACCOUNT - ~DETAILS~\n");
        LoanAccount Loan1 = new LoanAccount(.06,1000,12);

        //LOAN ACCOUNT1
        Loan1.Deposit(1033);
        Loan1.Withdraw(999);
        System.out.println(Loan1.toString());



    }
}