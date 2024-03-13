import java.util.Scanner;
import java.util.Random;
public class Matrix {
    private int rows;
    private int columns;
    private double[][] data;
    private String name;
    private int UniqueId;
    private static int objectcount=0;
    public Matrix(){
        Random rand=new Random();
        rows=rand.nextInt(10)+1;
        columns=rand.nextInt(10)+1;
        data=new double[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                double vals=rand.nextDouble(1000.0);
                this.data[i][j]=vals;
            }
        }
        UniqueId=++objectcount;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(this.data[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int getUniqueId(){
        return UniqueId;
    }
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
        
    }
    
    public void setElement(int row, int col, double value) {
        data[row][col] = value;
    }
    
    public double getElement(int row, int col) {
        return data[row][col];
    }
    
    public Matrix add(Matrix mat2) {
        int i, j;
        Matrix sum = new Matrix(rows, columns);
        for (i = 0; i < sum.rows; i++) {
            for (j = 0; j < sum.columns; j++) {
                sum.data[i][j] = this.data[i][j] + mat2.data[i][j];
            }
        }
        return sum;
    }
    
    public Matrix multiply(Matrix mat2) {
        int i, j;
        Matrix product = new Matrix(rows, columns);
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < mat2.columns; j++) {
                double pro = 0;
                int k;
                for (k = 0; k < this.columns; k++) {
                    pro += this.data[i][k] * mat2.data[k][j];
                }
                product.setElement(i, j, pro);
            }
        }
        return product;
    }
    
    public Matrix subtract(Matrix mat2) {
        Matrix difference = new Matrix(rows, columns);
        for (int i = 0; i < difference.rows; i++) {
            for (int j = 0; j < difference.columns; j++) {
                difference.data[i][j] = this.data[i][j] - mat2.data[i][j];
            }
        }
        return difference;
    }

    public Matrix transpose() {
        Matrix transposed = new Matrix(this.columns, this.rows);
        for (int i = 0; i < transposed.rows; i++) {
            for (int j = 0; j < transposed.columns; j++) {
                transposed.setElement(i, j, this.data[j][i]);
            }
        }
        return transposed;
    }

    public String toString() {
        String toSt = "";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                toSt += this.data[i][j] + " ";
            }
        }
        return toSt;
    }


}
class SquareMatrix extends Matrix {

    private int order;

    public SquareMatrix(int size) {
        super(size, size);
        order = size;

    }

    public boolean isSymmetric() {
        Matrix transposing = this.transpose();
        boolean sym = false;
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                if (this.getElement(i, j) != transposing.getElement(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public double determinant() {
        double result = 0;
        if(order==1){
            return this.getElement(0,0);
        }
        if(order==2){
            result=this.getElement(0,0)*this.getElement(1,1)-this.getElement(0,1)*this.getElement(1, 0);
            return result;
        }
        if(order==3){
            double row1=this.getElement(0,0)*(this.getElement(1,1)*this.getElement(2,2)-this.getElement(1,2)*this.getElement(2,1));
            double row2=this.getElement(0,1)*(this.getElement(1,0)*this.getElement(2,2)-this.getElement(1,2)*this.getElement(2,0));
            double row3=this.getElement(0,2)*(this.getElement(1,0)*this.getElement(2,1)-this.getElement(1,1)*this.getElement(2,0));
            result=row1-row2+row3;
            return result;
        }
        return result;
    }

    public boolean isSingular() {
        double det=this.determinant();
        boolean deter=false;
        if(det==0){
            deter=true;   
        }
        else{
            deter=false;
        }
        return deter;
    }
    public double trace(){
        double result=0;
        for(int i=0;i<this.order;i++){
            for(int j=0;j<this.order;j++){
                if(i==j){
                    result+=this.getElement(j,j);
                }
            }
        }
        /*if(order==1){
            return this.getElement(0,0);
        }
        else if(order==2){
            result=this.getElement(0,0)+this.getElement(1,1);
        }
        else if(order==3){
            result=this.getElement(0,0)+this.getElement(1,1)+this.getElement(2,2);
        }*/
        return result;
    }
}
class DiagonalMatrix extends SquareMatrix{
    private double values[];
    public DiagonalMatrix(int size,double value[]){
        super(size);
        this.values=value;
        for(int i=0;i<size;i++){
            setElement(i,i,values[i]);
        }
    }


    public static void main(String[] args) {
        /*int r1, r2, c1, c2;
        double v1, v2;*/
        Scanner obj = new Scanner(System.in);
        /*System.out.println("Enter number of rows:");
        r1 = obj.nextInt();
        System.out.println("Enter number of columns:");
        c1 = obj.nextInt();
        Matrix mat = new Matrix(r1, c1);
        System.out.println("Enter the values:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                v1 = obj.nextDouble();
                mat.setElement(i, j, v1);
            }
        }

        System.out.println("Matrix values:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.print(mat.getElement(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("Enter number of rows:");
        r2 = obj.nextInt();
        System.out.println("Enter number of columns:");
        c2 = obj.nextInt();
        Matrix mat2 = new Matrix(r2, c2);
        System.out.println("Enter the values:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                v2 = obj.nextDouble();
                mat2.setElement(i, j, v2);
            }
        }
        System.out.println("MATRIX ADDITION: \n");
        if (r1 == r2 && c1 == c2) {

            System.out.println("After matrix addition:");
            System.out.println();

            Matrix sum = mat.add(mat2);
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    System.out.print(sum.getElement(i, j) + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("UNEQUAL ORDER \n");
        }
        System.out.println("MATRIX MULTIPLICATION \n");
        if (c1 == r2) {

            System.out.println("After matrix multiplication:");
            System.out.println();

            Matrix product = mat.multiply(mat2);
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    System.out.print(product.getElement(i, j) + " ");
                }
                System.out.println();
            }
        } else {
            System.out.print("Unequal order \n");
        }
        System.out.println("MATRIX SUBSTRACTION:");
        if (r1 == r2 && c1 == c2) {
            System.out.println("After matrix subtraction:");
            System.out.println();

            Matrix difference = mat.subtract(mat2);
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    System.out.print(difference.getElement(i, j) + " ");
                }
                System.out.println();
            }
        } else {
            System.out.print("Unequal Order \n ");
        }

        System.out.println("After matrix transpose:");
        System.out.println();

        Matrix transposing1 = mat.transpose();
        for (int i = 0; i < c1; i++) {
            for (int j = 0; j < r1; j++) {
                System.out.print(transposing1.getElement(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("After matrix transpose:");
        System.out.println();

        Matrix transposing2 = mat2.transpose();
        for (int i = 0; i < c2; i++) {
            for (int j = 0; j < r2; j++) {
                System.out.print(transposing2.getElement(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("After toString conversion of Matrix 1:");
        String st1 = mat.toString();
        System.out.print(st1);
        System.out.println();
        System.out.println("After toString conversion of Matrix 2:");
        String st2 = mat2.toString();
        System.out.print(st2);
        System.out.println();
                
        //CYCLE 1 QUESTION 2
       /* int row,col;
        System.out.println("Enter the row,column and values separated by space in a line:");
        String val1=obj.nextLine();
        String[] valu=val1.split(" ");
        int len=valu.length;
        row=Integer.parseInt(valu[0]);
        col=Integer.parseInt(valu[1]);
        Matrix matr=new Matrix(row,col);
        int start=2;
        while(start<len){
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    double values=Double.parseDouble(valu[start]);
                    matr.setElement(i,j,values);
                    start++;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(matr.getElement(i,j)+" ");
            }
            System.out.println();
        }
        */
        //CYCLE 1 QUESTION 3
        /*System.out.println("THE DIFFERENT OPERATIONS ON MATRIX ARE: \n 1.Creating Matrix \n 2.Displaying Matrix \n 3.Calculate Column Sum \n 4.Calculate Row sum \n 5.Printing Average of All Elements in Matrix \n 6.Checking Diagonal or not \n 7.Exit the program ");
        int choice;
        int r=0,c=0;
        Matrix matx=null;
        String ch;
        System.out.print("Enter yes/no to perform operations on Matrix:");
        ch = obj.next();
        while (ch.equals("yes")) {
            System.out.print("Enter the choice:");
            choice = obj.nextInt();
            if(choice==1){
                    double v;
                    System.out.println("Enter number of rows:");
                    r = obj.nextInt();
                    System.out.println("Enter number of columns:");
                    c = obj.nextInt();
                    matx = new Matrix(r, c);
                    System.out.println("Enter the values:");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            v = obj.nextDouble();
                            matx.setElement(i, j, v);
                        }
                    }
            }
            else if(choice==2){
                    System.out.println("Matrix values:");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            System.out.print(matx.getElement(i, j) + " ");
                        }
                        System.out.println();
                    }
            }   
            else if(choice==3){
                    int col;
                    System.out.print("Enter the column to be added:");
                    col = obj.nextInt();
                    int col1=col-1;
                    double colSum=0;
                    for(int i=0;i<r;i++){
                        colSum+=matx.getElement(i,col1);
                    }
                    System.out.println("Column sum of column "+col+"is:"+colSum);
            }
            else if(choice==4){
                    int row;
                    System.out.print("Enter the row to be added:");
                    row=obj.nextInt();
                    int row1=row-1;
                    double rowSum=0;
                    for(int i=0;i<c;i++){
                        rowSum+=matx.getElement(row1,i);
                    }
                    System.out.println("Row Sum of the row "+row+"is:"+rowSum);
            }
            else if(choice==5){
                int totelmts=r*c;
                double avg=0;
                for(int i=0;i<r;i++){
                    for(int j=0;j<c;j++){
                        avg+=matx.getElement(i,j);
                    }
                }
                avg/=totelmts;
                System.out.println("Average of the matrix elements is:"+avg);
            }
            else if(choice==6){
                boolean diagonal=false;
                for(int i=0;i<r;i++){
                    for(int j=0;j<c;j++){
                        if(i!=j && matx.getElement(i,j)==0){
                            diagonal=true;
                        }
                    }
                }
                if(diagonal==true){
                    System.out.println("It is a diagonal matrix");
                }
                else{
                    System.out.println("It is not a diagonal matrix");
                }
            }
            else if(choice==7){
                System.out.println("THANK YOU");
            }
            else{
                System.out.println("Invalid choice ,kindly enter valid choice");
            }
            System.out.print("Enter yes/no to perform operations on Matrix:");
            ch = obj.next();
        }  */
        //CYCLE 1 QUESTION 4
        /*System.out.println("Randomly Generated Matrix");
        Matrix matri=new Matrix();*/
        //CYCLE 1 QUESTION 5
        /*Matrix mat4=new Matrix();
        System.out.println("Unique id= "+mat4.getUniqueId());*/
        //CYCLE 2 QUESTION 1
        int size;
        double val;
        System.out.print("Enter the size:");
        size = obj.nextInt();
        SquareMatrix sqm = new SquareMatrix(size);
        System.out.print("Enter the values:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                val = obj.nextDouble();
                sqm.setElement(i, j, val);
            }
        }
        boolean s = sqm.isSymmetric();
        if (s == true) {
            System.out.println("Symmetric");
        } 
        else {
            System.out.println("Non-symmetric");
        }
        double det=sqm.determinant();
        System.out.println("Determinant:"+det);
        boolean deter=sqm.isSingular();
        if(deter==true){
            System.out.println("Singular Matrix");
        }
        else{
            System.out.println("Non-Singular Matrix");
        }
        double traces=sqm.trace();
        System.out.println("Trace:"+traces);
        
        double value1[];
        System.out.print("Enter the size:");
        size=obj.nextInt();
        System.out.println("Enter the values for the diagonal Matrix");
        value1=new double[size];
        for(int i=0;i<size;i++){
            value1[i]=obj.nextDouble();
            
        }
        DiagonalMatrix dim=new DiagonalMatrix(size,value1);
        System.out.println("Diagonal Matrix :");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==j){
                   System.out.print(dim.getElement(i,j)+" ");
                }
                else{
                    System.out.print("0.0 ");
                }
            }
            System.out.println();
        }
    }
}
