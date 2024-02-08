import java.util.Scanner;
public class Matrix{
	private int rows;
	private int columns;
	private double[][] data;
	private String name;
	
	public Matrix(int rows,int columns){
	       this.rows=rows;
	       this.columns=columns;	
	       this.data=new double[rows][columns];
        }
        public void setElement(int row,int col,double value){
	       data[row][col]=value;
        }
	public double getElement(int row,int col){
               return data[row][col];
        }
	public static void main(String[] args){
	      int r,c;
	      double v;
              Scanner myobj=new Scanner(System.in);
	      System.out.println("Enter number of rows:");
	      r=myobj.nextInt();
              System.out.println("Enter number of columns:");
	      c=myobj.nextInt();
	      Matrix myObj=new Matrix(r,c);
	      System.out.println("Enter the values:");
	      for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
		    v=myobj.nextDouble();
		    myObj.setElement(i,j,v);
		}
	      }
	      System.out.println("Matrix values:");
	      for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
		    System.out.print(myObj.getElement(i,j)+" ");
                }
		System.out.println();
             }
         }
}	
              
	      
	      
               