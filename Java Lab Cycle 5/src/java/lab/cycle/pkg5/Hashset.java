import java.util.*;
public class Hashset{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        HashSet<String> hashs=new HashSet<>();
        String data;
        int limit,i;
        
        System.out.print("Enter the number of elements to be added to the Hashset:");
        limit=obj.nextInt();
        for(i=0;i<limit;i++){
            System.out.print("Enter the data to be inserted in the HashSet:");
            data=obj.next();
            hashs.add(data);
        }
        
        System.out.println("The datas in HashSet are:"+hashs);
        
        System.out.println("The Size of HashSet is:"+hashs.size());
        
        String search;
        System.out.print("Enter the data to search:");
        search=obj.next();
        System.out.println("Whether the entered data "+search+" is present or not(true/false)?:"+hashs.contains(search));
        
        System.out.println("Is HashSet empty?:"+hashs.isEmpty());
        
        HashSet<String>hashs2=new HashSet<>();
        String d2;
        int l2;
        System.out.print("Enter the number of elements to be added to new HashSet:");
        l2=obj.nextInt();
        for(i=0;i<l2;i++){
            System.out.print("Enter the data to be inserted in new HashSet:");
            d2=obj.next();
            hashs2.add(d2);
        }
        hashs.addAll(hashs2);
        //System.out.println("Displaying Hashset after adding another Hashset:"+hashs);
        Iterator<String> itr=hashs.iterator();
        while(itr.hasNext()){
            System.out.println("The Elements in HashSet are:"+itr.next());
        }
        
        System.out.println("Whether all datas are present in HashSet(true/false)?:"+hashs.containsAll(hashs2));
        
        System.out.println("Whether both HashSets are equal(true/false)?:"+hashs.equals(hashs2));
        
        int hashcode=hashs.hashCode();
        System.out.println("The HashCode of the HashSet is:"+hashcode);
        
        String remove;
        System.out.print("Enter the data to remove  from HashSet:");
        remove=obj.next();
        hashs.remove(remove);
        System.out.println("The HashSet after removal:"+hashs);
        
        ArrayList<String> hashlist=new ArrayList<>(hashs);
        System.out.println("The elements in hashset after converting to list:"+hashlist);
        
        hashs.retainAll(hashs2);
        System.out.println("The HashSet after retaining common  elements in HashSet:"+hashs);
        
        hashs.clear();
        System.out.println("The HashSet after removal of all elements:"+hashs);
        
    }
}