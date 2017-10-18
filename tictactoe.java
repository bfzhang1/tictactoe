import java.util.Scanner;
public class tictactoe{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[][] board = new int[3][3];
        while(true){
            printBoard(board);
            //player turn
            System.out.println("Select a position, using coordinates. (Ex. 0 0 represents the top left, 1 2 represents the bottom middle.)");
            int row = input.nextInt();
            int col = input.nextInt();
            board[row][col] = 1;
            checkWin();
            
            //comp turn
        }
    }
    public static void comTurn(){
        
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
        return false;
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
