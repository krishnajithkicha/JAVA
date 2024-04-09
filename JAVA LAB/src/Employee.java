import java.util.Scanner;
abstract class Employee{
    private int empid;
    private String empname;
    private double Salary;
    public Employee(int eid,String ename,double Sal){
        empid=eid;
        empname=ename;
        Salary=Sal;
    }
    abstract double calculateSalary();
    abstract void displayInfo();
    public int getId(){
        return empid;
    }
    public String getName(){
        return empname;
    }
    public double getSal(){
        return Salary;
    }
}
class Manager extends Employee{
    private double allowance=0.5;
    Manager(int id,String name,double sal){
        super(id,name,sal);
    }
    public double calculateSalary(){
        // 5 percent allowance
        double totsal=allowance*super.getSal()+super.getSal();
        return totsal; 
    }
    public void displayInfo(){
        System.out.println("Employee Post:Manager");
        System.out.println("Manager id:"+super.getId());
        System.out.println("Manager Name:"+super.getName());
        double tots=calculateSalary();
        System.out.println("Manager Total Salary:"+tots);
    }
}
class Programmer extends Employee{
    private double allowance;
    Programmer(int id,String name,double sal){
        super(id,name,sal);
    }
    public double calculateSalary(){
        //allowance 7 percent
        allowance=0.7;
        double totsal=allowance*super.getSal()+super.getSal();
        return totsal;
    }
    public void displayInfo(){
        System.out.println("Employee Post:Programmer");
        System.out.println("Programmer id:"+super.getId());
        System.out.println("Programmer Name:"+super.getName());
        double tots=calculateSalary();
        System.out.println("Programmer Total Salary:"+tots);
    }
}
class Main{
    public void EmployeeList(Employee[] emp){
        System.out.println("NAME\t\tSALARY");
        int len=emp.length;
        for(int i=0;i<len;i++){
            System.out.println(emp[i].getName()+"\t\t"+emp[i].calculateSalary());
        }
    }
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        int limit;
        System.out.print("Enter the number of employees:");
        limit=obj.nextInt();
        String choice;
        for(int i=0;i<limit;i++){
            System.out.print("Enter M for Manager or P for Programmer:");
            choice=obj.next();
            if(choice.equals("M")){
                int id;
                System.out.print("Enter the employee id:");
                id = obj.nextInt();
                String name;
                System.out.print("Enter employee name:");
                name = obj.next();
                double sal;
                System.out.print("Enter employee salary:");
                sal = obj.nextDouble();
                Manager mag = new Manager(id, name, sal);
                mag.displayInfo();
                
            }
            if(choice.equals("P")){
                int id1;
                System.out.print("Enter the employee id:");
                id1 = obj.nextInt();
                String name1;
                System.out.print("Enter employee name:");
                name1 = obj.next();
                double sal1;
                System.out.print("Enter employee salary:");
                sal1 = obj.nextDouble();
                Programmer  prg= new Programmer(id1, name1, sal1);
                prg.displayInfo(); 
            }
        }
        Employee e[]=new Employee[limit];
        Main main=new Main();
        for(int i=0;i<limit;i++){
            System.out.println("DETAILS OF EMPLOYEES for Manager(M) or Programmer(P):");
            choice=obj.next();
            int idn;
            String empname;
            double salary;
            System.out.print("Enter employee id:");
            idn=obj.nextInt();
            System.out.print("Enter employee name:");
            empname=obj.next();
            System.out.print("Enter employee salary:");
            salary=obj.nextDouble();
            if(choice.equals("M")){
                e[i]=new Manager(idn,empname,salary);
            }
            if(choice.equals("P")){
                e[i]=new Programmer(idn,empname,salary);
            }
            
        }
        main.EmployeeList(e);
    }
  
}