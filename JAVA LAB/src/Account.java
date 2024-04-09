import java.util.Scanner;
public class Account{
    private int accountNumber;
    private double balance;
    public Account(int acno,double bal){
        accountNumber=acno;
        balance=bal;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public double deposit(double amount){
        balance+=amount;
        return balance;
    }
    public double withdraw(double amount){
        if(getBalance()>amount){
            balance-=amount;
        }
        else{
            System.out.println("Insufficient Balance");
        }
        return balance;
    }
}
public class SavingsAccount extends Account{
    private int interestRate;
    public SavingsAccount(int intR){
        interestRate=intR;
    }
    public double calc_Rate(){
        double totbal=this.getBalance()+this.getBalance()*interestRate*0.01;
        return totbal;
    }
}
public class CheckingAccount extends Account{
    double overdraftLimit=-100.00;
    public double withdraw(double amount){
        while(this.getBalance()>=overdraftLimit){
            this.getBalance()-=amount;
        }
        return this.getBalance();
    }
    
    public static void main(String[] args){
        int acno;
        double amt,bal,amtw,amtd;
        Scanner obj=new Scanner(System.in);
        System.out.print("Enter your account number:");
        acno=obj.nextInt();
        System.out.print("Enter your balance:");
        bal=obj.nextDouble();
        Account acc=new Account(acno,bal);
        System.out.print("Enter the amount to deposit:");
        amtd=obj.nextDouble();
        
    }
}