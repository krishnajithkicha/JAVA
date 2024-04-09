import java.util.Scanner;
class Theatre{
    private String name;
    private int seats[];
    private int screens;
    private String location;
    private int seat[][];
    public void setName(String s){
        name=s;
    }
    public String getName(){
        return name;
    }
    public void setSeat(int []s ){
        int i;
        for (i=0;i<screens;i++){
            seats[i]=s[i];
        }
    }
    public int getSeats(int i){
        return seats[i];
    }
    public void setScreen(int s){
        screens=s;
        seats=new int[s];
    }
    public int getscreen(){
        return screens;
    }
    public void setLoc(String loc){
        location=loc;
    }
    public String getLoc(){
        return location;
    }
    public void create_seat(int s){
       
        seat=new int[s/10][10];
        for(int i=0;i<=seats[(s-1)/10];i++){
            for(int j=1;j<=10;j++){
                seat[i][j]=j;
            }
        }
    }
    public void display_seat(int s){
        for(int i=0;i<seats[(s-1)/10];i++){
            for (int j=1;j<=10;j++){
                System.out.print(seat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        Scanner obj=new Scanner(System.in);
        Theatre t=new Theatre();
        System.out.print("ENTER THE USER(Customer/Admin)");
        String user=obj.next();
        if (user.equals("Admin")){
            System.out.print("Enter the admin password:");
            String pass=obj.next();
            if (pass.equals("1234")){
                    System.out.println("Password verification sucessful!!, Welcome Admin");
                    System.out.println("The operations to perform along with their choices are as follows:\n"+"1.Set the name of the theatre\n"+"2.Set the number of screens\n"+"3.Set the location\n"+"4.Set Number of seats\n"+"Enter the number corresponding to these options to perform that specific task");

                    int screens=-1;
                    System.out.print("Start performing operations(yes/no):");
                    String ch=obj.next();
                      while (ch.equals("yes")){
                        System.out.print("Enter the option corresponding to the task you need to perform:");
                        int op=obj.nextInt();
                        if (op==1){
                            System.out.print("Enter the number of screens in your theatre:");
                            screens=obj.nextInt();
                            t.setScreen(screens);
                        }
                        else if (op==2){
                            System.out.print("Enter the location of your theatre:");
                            String loc=obj.next();
                            t.setLoc(loc);  
                        }
                        else if (op==3){
                            int seats[];
                            seats=new int[screens];
                            for (int i=0;i<screens;i++){
                                System.out.print("Enter the number of seats in screen "+(i+1)+":");
                                int seat=obj.nextInt();
                                seats[i]=seat;                      
                            }
                            t.setSeat(seats);
                        }
                        else{
                            System.out.println("Invalid Choice!!!");
                        }
                        System.out.print("Do you want to continue with another operation(yes/no)");
                        ch=obj.next();
                    }
            }
        }
        if (user.equals("Customer")){
            
        }
            
     }
}
interface PaymentMethod{
    void pay(double amt);
    void cancel(double amt);  
            
}
class CreditCard implements PaymentMethod{
    private String cardHolder;
    private int cvv;
    private String expiry;
    private double availableBalance;
    public CreditCard(String name,int cv,String exp,double bal){
        cardHolder=name;
        cvv=cv;
        expiry=exp;
        availableBalance=bal;
    }
    public void pay(double amt){
        System.out.println("Payement of rupees "+amt+" made by credit card of "+cardHolder);
        System.out.println("Payment Successful!!!");
        availableBalance=availableBalance-amt;
        System.out.println("Available blance is:"+availableBalance);
       
    }
    public void cancel(double amt){
        System.out.println("Payement of rupees "+amt+" made by credit card of "+cardHolder+" is cancelled");
        double bal=availableBalance+amt;
        System.out.println("Money credit back to account");
        System.out.println("Available blance is:"+bal);
        
    }
}
class  PayPal implements PaymentMethod{
    private String email;
    private String password;
    private double availableBalance;
    public PayPal(String mail,String pwd,double bal){
        email=mail;
        password=pwd;
        availableBalance=bal;
    }
     public void pay(double amt){
        System.out.println("Payement of rupees "+amt+" made by email-id "+email);
        System.out.println("Payment Successful!!!");
        double bal=availableBalance-amt;
        System.out.println("Available blance is:"+bal);
    }
    public void cancel(double amt){
        System.out.println("Payement of rupees "+amt+" made by email-id  "+email+" is cancelled");
        availableBalance=availableBalance+amt;
        System.out.println("Money credit back to account");
        System.out.println("Available blance is:"+availableBalance);
        
    }

   }