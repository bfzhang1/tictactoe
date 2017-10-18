import java.util.Scanner;
public class tictactoe{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int turns = 0;
        int[][] board = new int[3][3];
        System.out.println("[0 0]\t[0 1]\t[0 2]");
        System.out.println("[1 0]\t[1 1]\t[1 2]");
        System.out.println("[2 0]\t[2 1]\t[2 2]");
        while(turns <= 9){
            if(turns == 0){ //if it is the first turn, then it prints out the instruction board
                System.out.println("[0 0]\t[0 1]\t[0 2]");
                System.out.println("[1 0]\t[1 1]\t[1 2]");
                System.out.println("[2 0]\t[2 1]\t[2 2]");
            }
            else //otherwise it prints out the actual board
                printBoard(board);
            
            //player turn
            System.out.println("Select a position, using coordinates. (Ex. 0 0 represents the top left, 1 2 represents the bottom middle.)");
            int row = input.nextInt(); //gets the player input
            int col = input.nextInt();
            board[row][col] = 1;
            if(checkWin()){ //checks if the player wins
                System.out.println("You win!");
                break;
            }
            //comp turn
        }
        if(turns > 9)
            System.out.println("It's a tie!");
    }
    public static void comTurn(){
        for(int i=0; i<3; i++){ //checks the rows if it can win or block you from winning
            if(board[i][0] == board[i][1] && board[i][0] != 0){
                board[i][2] = 2;    
                return;
            }
            else if(board[i][1] == board[i][2] && board[i][1] != 0){
                board[i][0] = 2;    
                return;
            }
            else if(board[i][0] == board[i][2] && board[i][0] != 0){
                board[i][1] = 2;    
                return;
            }
        }
        for(int j=0; j<3; j++){ //checks the columns if it can win or block you from winning
            if(board[0][j] == board[1][j] && board[0][j] != 0){
                board[2][j] = 2;
                return;
            }
            else if(board[1][j] == board[2][j] && board[1][j] != 0){
                board[0][j] = 2;    
                return;
            }
            else if(board[0][j] == board[2][j] && board[0][j] != 0){
                board[1][j] = 2;    
                return;
            }
        }
        
    }
    public static boolean checkWin(){
        for(int i=0; i<3; i++){ //vertical checks
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return true;
            }
        }
        for(int j=0; j<3; j++){ //horizontal checks
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j]){
                return true;    
            }
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){ //left diagonal check
            return true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){ //right diagonal check
            return true;
        }
        return false; //if none of these are satisfied
    }
    public static void printBoard(int[][] board){
        /*
        0 = Nothing
        1 = X (player)
        2 = O (AI)
        */
        for(int i=0; i<3; i++){ 
            for(int j=0; j<3; j++){
                System.out.print("\t");
                if(board[i][j] == 1){
                    System.out.println("X");  
                }
                else if(board[i][j] == 2){
                    System.out.println("O");
                }
            }
            System.out.println();
        }
    }
}
