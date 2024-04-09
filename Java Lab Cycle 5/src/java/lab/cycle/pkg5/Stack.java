import java.util.Stack;
import java.util.Scanner;
public class Stack{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        Stack<Integer> mySt=new Stack<>();
        int limit,data,i;
        String ch;
        System.out.print("Enter the number of elements:");
        limit=obj.nextInt();
        for(i=0;i<limit;i++){
            System.out.print("Do you like to pop(y/n)?:");
            ch=obj.next();
            if(ch.equals("y")){
                System.out.println("The popped element is "+mySt.pop());
            }
            System.out.print("Enter the element to push into stack:");
            data=obj.nextInt();
            mySt.push(data);
        }
        System.out.print("Do you want to pop last element:");
        ch=obj.next();
        if(ch.equals("y")){
            System.out.println("The popped element is:"+mySt.pop());
        }
        System.out.println("The elements in Stack are:"+mySt);
        
        System.out.println("Whether the stack is empty(true/false)?:"+mySt.isEmpty());
        
        System.out.println("The toppest element in the stack is:"+mySt.peek());
        
        int search;
        System.out.print("Enter the element to search in stack:");
        search=obj.nextInt();
        System.out.println("The element is found at :"+mySt.search(search));
    }
}