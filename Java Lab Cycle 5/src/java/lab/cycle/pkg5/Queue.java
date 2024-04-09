import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Queue{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        Queue<Integer> myLQ=new LinkedList<>();
        int data,limit,i;
        System.out.print("Enter the number of elements:");
        limit=obj.nextInt();
        for(i=0;i<limit;i++){
            System.out.print("Enter the elements to add:");
            data=obj.nextInt();
            myLQ.offer(data);
        }
        System.out.println("The elements in Queue are:"+myLQ);
        
        System.out.println("Polled Element is:"+myLQ.poll());
        System.out.println("After polling the queue is:"+myLQ);
        
        System.out.println("Peeked Element is:"+myLQ.peek());
        
        System.out.println("The head element of the queue is:"+myLQ.element());
        
        System.out.println("The removed element of the queue is:"+myLQ.remove());
        System.out.println("After removing the element queue is:"+myLQ);
    }
}
