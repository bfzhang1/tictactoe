import java.util.Scanner;
public class tictactoe{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int turns = 0;
        int[][] board = new int[3][3];
        while(turns < 9){
            if(turns == 0){ //if it is the first turn, then it prints out the instruction board
                System.out.println("[0 0]\t[0 1]\t[0 2]");
                System.out.println("[1 0]\t[1 1]\t[1 2]");
                System.out.println("[2 0]\t[2 1]\t[2 2]");
            }
            else //otherwise it prints out the actual board
                printBoard(board);

            //player turn
            System.out.println("Select a position, using coordinates. (Ex. 0 0 represents the top left, 1 2 represents the middle right.)");
            int row = input.nextInt(); //gets the player input
            int col = input.nextInt();
            board[row][col] = 1;
            turns++;
            if(checkWin(board)){ //checks if the player wins
                System.out.println("You win!");
                break;
            }
            if(turns >= 9){ //if the game somehow makes it to the end without anyone winning
                break;
            }

            //com turn
            printBoard(board);
            System.out.println("Deciding...");
            comTurn(board);
            turns++;
            if(checkWin(board)){ //checks if the A.I. wins
                System.out.println("You lose...");
                break;
            }
        }
        printBoard(board);
        if(turns >= 9)
            System.out.println("It's a tie!");
    }
    public static void comTurn(int[][] board){
        //checks the rows if it can win or block you from winning
        for(int i=0; i<3; i++){
            if(board[i][0] == board[i][1] && board[i][0] != 0 && board[i][2] == 0){
                board[i][2] = 2;
                return;
            }
            else if(board[i][1] == board[i][2] && board[i][1] != 0 && board[i][0] == 0){
                board[i][0] = 2;
                return;
            }
            else if(board[i][0] == board[i][2] && board[i][0] != 0 && board[i][1] == 0){
                board[i][1] = 2;
                return;
            }
        }

        //checks the columns if it can win or block you from winning
        for(int j=0; j<3; j++){
            if(board[0][j] == board[1][j] && board[0][j] != 0 && board[2][j] == 0){
                board[2][j] = 2;
                return;
            }
            else if(board[1][j] == board[2][j] && board[1][j] != 0 && board[0][j] == 0){
                board[0][j] = 2;
                return;
            }
            else if(board[0][j] == board[2][j] && board[0][j] != 0 && board[1][j] == 0){
                board[1][j] = 2;
                return;
            }
        }

        //checks the left diagonal if it can win or block you from winning
        if(board[0][0] == board[1][1] && board[0][0] != 0 && board[2][2] == 0){
            board[2][2] = 2;
            return;
        }
        if(board[1][1] == board[2][2] && board[1][1] != 0 && board[0][0] == 0){
            board[0][0] = 2;
            return;
        }
        if(board[0][0] == board[2][2] && board[0][0] != 0 && board[1][1] == 0){
            board[1][1] = 2;
            return;
        }

        //checks the right diagonal if it can win or block you from winning
        if(board[0][2] == board[1][1] && board[0][2] != 0 && board[2][0] == 0){
            board[2][0] = 2;
            return;
        }
        if(board[1][1] == board[2][0] && board[1][1] != 0 && board[0][2] == 0){
            board[0][2] = 2;
            return;
        }
        if(board[0][2] == board[2][0] && board[0][2] != 0 && board[1][1] == 0){
            board[1][1] = 2;
            return;
        }

        //checks if the centerpiece is open; if it is it will take that as a priority
        if(board[1][1] == 0){
            board[1][1] = 2;
            return;
        }

        //checks if the corners are open; if they are it will take them as a priority
        if(board[0][0] == 0){
            board[0][0] = 2;
            return;
        }
        if(board[0][2] == 0){
            board[0][2] = 2;
            return;
        }
        if(board[2][0] == 0){
            board[2][0] = 2;
            return;
        }
        if(board[2][2] == 0){
            board[2][2] = 2;
            return;
        }

        //if none of these are available, choose a random square as a fail-safe
        while(true){
            int x = (int)(Math.random() * 3); //rand num between 0-2
            int y = (int)(Math.random() * 3);
            if(board[x][y] == 0){
                board[x][y] = 2;
                return;
            }
        }
    }
    public static boolean checkWin(int[][] board){
        for(int i=0; i<3; i++){ //vertical checks
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0){
                return true;
            }
        }
        for(int j=0; j<3; j++){ //horizontal checks
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != 0){
                return true;
            }
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0){ //left diagonal check
            return true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0){ //right diagonal check
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
                    System.out.print("X");
                }
                else if(board[i][j] == 2){
                    System.out.print("O");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
