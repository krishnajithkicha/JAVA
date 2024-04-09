import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Map{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        Map<Integer,String> stD=new HashMap<>();
        int limit,i,rno;
        String data;
        System.out.print("Enter the number of students:");
        limit=obj.nextInt();
        for(i=0;i<limit;i++){
            System.out.print("Enter the rollno:");
            rno=obj.nextInt();
            System.out.print("Enter the Name to insert:");
            data=obj.next();
            stD.put(rno, data);  
        }
        System.out.println("The elements in HashMap are:"+stD);
        int getr;
        System.out.print("Enter the roll no to get the details:");
        getr=obj.nextInt();
        System.out.println("The name of the roll number "+getr+" is:"+stD.get(getr));
        
        int key;
        System.out.print("Enter the key to search:");
        key=obj.nextInt();
        System.out.println("Whether the key "+key+" is present(true/false)?:"+stD.containsKey(key));
        
        String value;
        System.out.print("Enter the value to search:");
        value=obj.next();
        System.out.println("Whether the value "+value+" is present(true/false)?:"+stD.containsValue(value));
        
        System.out.println("Entries in the map:");
        for(Map.Entry<Integer,String>entry:stD.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
        
        System.out.println("Whether the Hashmap is empty(true/false)?: "+stD.isEmpty());
        
        System.out.println("The keys of the set are:"+stD.keySet());
        System.out.println("The values of the set are:"+stD.values());
        
        int remove;
        System.out.print("Enter the key to remove:");
        remove=obj.nextInt();
        stD.remove(remove);
        System.out.println("The Hashmap after removing the key "+remove+" are:"+stD);
        
        Map<Integer,String> stD2=new HashMap<>();
        int limit2,j,rno2;
        String data2;
        System.out.print("Enter the number of students:");
        limit2=obj.nextInt();
        for(j=0;j<limit2;j++){
            System.out.print("Enter the rollno:");
            rno2=obj.nextInt();
            System.out.print("Enter the Name to insert:");
            data2=obj.next();
            stD2.put(rno2, data2);  
        }
        System.out.println("The elements in new HashMap are:"+stD2);
        
        stD.putAll(stD2);
        System.out.println("Combining two hashmaps together:"+stD);
        
        stD.clear();
        System.out.println("Cleared Hashmap");
    }
}