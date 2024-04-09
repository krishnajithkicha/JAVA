import java.util.Scanner;
import java.util.Random;
class InvalidMoveException extends IllegalArgumentException{
    public InvalidMoveException(String message){
        super(message);
    }
    
}
public class TicTacToeRand{
	private String board[][];
	public TicTacToeRand(){
		board=new String[3][3];
	}
	public void initializeBoard(){
		for(int i=0;i<3;i++){
		    for(int j=0;j<3;j++){
			board[i][j]="_";
		    }
		}
	}
	public boolean makeMove(int r,int c,int player) throws InvalidMoveException{
		boolean move=false;
		 /*if (r<0 || r>=3 || c<0 || c>=3 ){
                     throw new IllegalArgumentException("Invalid move:enter the row between 1 to 3");
                 }*/
                 if (r<0 || r>=3 || c<0 || c>=3 ){
                     throw new InvalidMoveException("Invalid move:enter the row between 1 and 3");
                 }
                 /*if(!board[r][c].equals(" _")){
                     throw new InvalidMoveException("Invalid move:Cell is already occupied");
                 }*/
	         if(player==1 && board[r][c]=="_"){
			board[r][c]="X";
			move=true;
		 }
		else if(player==2 && board[r][c]=="_"){
			board[r][c]="O";
			move=true;
		}
		else{
			System.out.println("Invalid move:Cell is already occupied");
		}
		return move;
	}
	public boolean isGameOver(){

		return true;
	}
	public boolean checkWin(int row,int col,int player){
		boolean win=false;
		String val1="XXX";
		String val2="OOO";
		String win1="";
		String win2="";
		String win3="";
		String win4="";
		int p=player;
		for(int i=0;i<3;i++){		
			win1+=board[i][col];
		}
		for(int j=0;j<3;j++){
			win2+=board[row][j];
		}
		for(int k=0;k<3;k++){
		   for(int l=0;l<3;l++){
			if(k==l){
			  win3+=board[k][k];
			}
			else if(k+l==2){
			   win4+=board[k][l];
			}
		   }
		}
		if(win1.equals(val1) || win2.equals(val1) ||  win3.equals(val1) || win4.equals(val1) ){
			System.out.println("Player 1 wins");
			win= true;
		}
		else if(win1.equals(val2) || win2.equals(val2) || win3.equals(val2) || win4.equals(val2) ){
			System.out.print("Computer Player wins");
			System.out.println();
			win=true;
		}
		return win;
	}
	public void dispBoard(){
		for(int i=0;i<3;i++){
		   for(int j=0;j<3;j++){
			System.out.print(board[i][j]+" ");
		   }
		 System.out.println();
		}
	}
	public static void main(String [] args){
		Scanner obj=new Scanner(System.in);
		Random random=new Random();
		TicTacToeRand game1=new TicTacToeRand();
		game1.initializeBoard();
		System.out.print("Initial Condition");
		System.out.println();
		game1.dispBoard();
		int player=1;
		boolean gameSt=false;
		System.out.print("Start game?(y/n):");
		String ch=obj.next();
		int count=1;
		int row=-1,column=-1;
		boolean move=false;
                //try{
		while(ch.equals("y") && gameSt==false && count<10){
                    try{
			if(player==1){
			    System.out.print("Enter the row:");
			    row=obj.nextInt()-1;
			    System.out.print("Enter the columns:");
			    column=obj.nextInt()-1;
			    move=game1.makeMove(row,column,player);
			}
			if(player==2){
				System.out.println("Move by Computer player");
				do{row=random.nextInt(3);
				column=random.nextInt(3);
				move=game1.makeMove(row,column,player);}
				while(!move);
			}
			if(move==false){
			    if(player==1){
			    System.out.print("Enter the row:");
			    row=obj.nextInt()-1;
			    System.out.print("Enter the columns:");
			    column=obj.nextInt()-1;
			    move=game1.makeMove(row,column,player);
			    }
			    if(player==2){
				row=random.nextInt(3);
				column=random.nextInt(3);
				move=game1.makeMove(row,column,player);
			     }
			     /*System.out.print("Enter the row:");
			     row=obj.nextInt()-1;
		             System.out.print("Enter the column:");
		             column=obj.nextInt()-1;
		             game1.makeMove(row,column,player);*/
			}
			game1.dispBoard();
			boolean iswin=game1.checkWin(row,column,player);
			if(iswin==true){
				gameSt=game1.isGameOver();
			}
			if(player==1){
				player=2;
			}
			else{
				player=1;
			}
			count++;
                    }
                    
                   /* catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        obj.nextLine();
                        continue;
                        }*/
                   catch(InvalidMoveException e){
                       System.out.println(e.getMessage());
                       obj.nextLine();
                       continue;
                   }
                }
                /*catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        obj.nextLine();
                        }
                finally{
                    obj.close();
                }*/


	}
}
