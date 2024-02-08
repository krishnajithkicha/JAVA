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
        public Matrix add(Matrix mat2){
        	int i,j;
        	Matrix sum=new Matrix(rows,columns);
        	for(i=0;i<sum.rows;i++){
        	   for(j=0;j<sum.columns;j++){
        	       sum.data[i][j]=this.data[i][j]+mat2.data[i][j];
        	   }
        	}
        	return sum;
        }
        //public Matrix multiply(Matrix mat2){
        	//int i,j;
	public static void main(String[] args){
	      int r,c;
	      double v;
              Scanner obj=new Scanner(System.in);
	      System.out.println("Enter number of rows:");
	      r=obj.nextInt();
              System.out.println("Enter number of columns:");
	      c=obj.nextInt();
	      Matrix mat=new Matrix(r,c);
	      System.out.println("Enter the values:");
	      for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
		    v=obj.nextDouble();
		    mat.setElement(i,j,v);
		}
	      }
	      System.out.println("Matrix values:");
	      for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
		    System.out.print(mat.getElement(i,j)+" ");
                }
		System.out.println();
             }
             System.out.println("Enter number of rows:");
	      r=obj.nextInt();
              System.out.println("Enter number of columns:");
	      c=obj.nextInt();
	      Matrix mat2=new Matrix(r,c);
	      System.out.println("Enter the values:");
	      for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
		    v=obj.nextDouble();
		    mat2.setElement(i,j,v);
		}
	      }
             System.out.println("After matrix addition:");
             System.out.println();
             
             Matrix sum=mat.add(mat2);
             for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    System.out.print(sum.getElement(i,j)+" ");
                }
                System.out.println();
             }
         }
}	

          
