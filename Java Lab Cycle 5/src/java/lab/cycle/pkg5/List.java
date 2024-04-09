import java.util.*;
public class List{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        ArrayList<String> mylist=new ArrayList<>();
        String data;
        int limit,i;
        System.out.print("Enter the number of elements to add in list:");
        limit=obj.nextInt();
        for(i=0;i<limit;i++){
            System.out.print("Enter the data to enter in the list:");
            data=obj.next();
            mylist.add(data);
        }
        System.out.println("The datas in list are:"+mylist);
        
        int limit2;
        String data2;
        ArrayList<String>myList2=new ArrayList<>();
        System.out.print("Enter the number of elements to add in second list:");
        limit2=obj.nextInt();
        for(i=0;i<limit2;i++){
            System.out.print("Enter the data to enter in the second list:");
            data2=obj.next();
            myList2.add(data2);
        }
        myList2.addAll(mylist);
        System.out.println("After combining both list:"+myList2);
        
        int index;
        System.out.print("Enter the index position of element to get:");
        index=obj.nextInt();
        String elem=myList2.get(index);
        System.out.println("The element at the index position "+index+" is:"+elem);
        
        String search;
        System.out.print("Enter the element to search:");
        search=obj.next();
        int ind=myList2.indexOf(search);
        System.out.println("The element "+search+" is found at index:"+ind);
        
        String tofind;
        System.out.print("Enter the element to find the index:");
        tofind=obj.next();
        int inde=myList2.lastIndexOf(tofind);
        if(inde!=-1){
            System.out.println("The element's last occurence is at :"+inde);
        }
        else{
            System.out.println("The element is not found:"+inde);
        }
        Iterator<String>itrs=myList2.listIterator();
        System.out.println("The elements in list are displaying using list iterator:");
        while(itrs.hasNext()){
            System.out.print(itrs.next()+" ");
        }
        System.out.println();
        int indx;
        System.out.print("Enter the index from which the iteration should begin:");
        indx=obj.nextInt();
        Iterator<String>itrst=myList2.listIterator(indx);
        System.out.println("The elementd in list are displaying from index "+indx+"are using list iterator:");
        while(itrst.hasNext()){
            System.out.print(itrst.next()+" ");
        }
        System.out.println();
        
        String remove;
        System.out.print("Enter the element to remove from list:");
        remove=obj.next();
        myList2.remove(remove);
        System.out.println("The list after removing the element "+remove+" are:"+myList2);
        
        int inds;
        String elemt;
        System.out.print("Enter the index position to set:");
        inds=obj.nextInt();
        System.out.print("Enter the element to insert at the position:");
        elemt=obj.next();
        myList2.set(inds,elemt);
        System.out.println("The updated list after inserting element "+elemt+" at position "+inds+" are:"+myList2);
        
        int begind,endind;
        System.out.print("Enter the starting index for sublist:");
        begind=obj.nextInt();
        System.out.print("Enter the ending index fo sublist:");
        endind=obj.nextInt();
        System.out.println("The new sublist :"+myList2.subList(begind,endind));
    }
}