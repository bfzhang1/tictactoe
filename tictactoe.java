import java.util.Scanner;
public class tictactoe{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int turns = 0;
        int[][] board = new int[3][3];

        for(turns = 0; turns < 9; turns++){
            printBoard(board);
            if(turns % 2 == 0){
                //player turn
                System.out.println("Select a position, using coordinates. (Ex. 0 0 represents the top left, 1 2 represents the middle right.)");
                int row = input.nextInt(); //gets the player input
                int col = input.nextInt();
                board[row][col] = 1;
                if(checkWin(board)){ //checks if the player wins
                    System.out.println("\n\nYou win!");
                    break;
                }
            }
            else{
                //com turn
                System.out.println("Deciding...");
                board = comTurn(board);
                if(checkWin(board)){ //checks if the A.I. wins
                    System.out.println("\n\nYou lose...");
                    break;
                }
            }

            System.out.println();
        }

        if(turns >= 9)
            System.out.println("\n\nIt's a tie!");
        printBoard(board);
    }
    public static int[][] comTurn(int[][] board){
        //checks the rows if it can win or block you from winning
        for(int i=0; i<3; i++){
            if(board[i][0] == board[i][1] && board[i][0] != 0 && board[i][2] == 0){
                board[i][2] = 2;
                return board;
            }
            else if(board[i][1] == board[i][2] && board[i][1] != 0 && board[i][0] == 0){
                board[i][0] = 2;
                return board;
            }
            else if(board[i][0] == board[i][2] && board[i][0] != 0 && board[i][1] == 0){
                board[i][1] = 2;
                return board;
            }
        }

        //checks the columns if it can win or block you from winning
        for(int j=0; j<3; j++){
            if(board[0][j] == board[1][j] && board[0][j] != 0 && board[2][j] == 0){
                board[2][j] = 2;
                return board;
            }
            else if(board[1][j] == board[2][j] && board[1][j] != 0 && board[0][j] == 0){
                board[0][j] = 2;
                return board;
            }
            else if(board[0][j] == board[2][j] && board[0][j] != 0 && board[1][j] == 0){
                board[1][j] = 2;
                return board;
            }
        }

        //checks the left diagonal if it can win or block you from winning
        if(board[0][0] == board[1][1] && board[0][0] != 0 && board[2][2] == 0){
            board[2][2] = 2;
            return board;
        }
        if(board[1][1] == board[2][2] && board[1][1] != 0 && board[0][0] == 0){
            board[0][0] = 2;
            return board;
        }
        if(board[0][0] == board[2][2] && board[0][0] != 0 && board[1][1] == 0){
            board[1][1] = 2;
            return board;
        }

        //checks the right diagonal if it can win or block you from winning
        if(board[0][2] == board[1][1] && board[0][2] != 0 && board[2][0] == 0){
            board[2][0] = 2;
            return board;
        }
        if(board[1][1] == board[2][0] && board[1][1] != 0 && board[0][2] == 0){
            board[0][2] = 2;
            return board;
        }
        if(board[0][2] == board[2][0] && board[0][2] != 0 && board[1][1] == 0){
            board[1][1] = 2;
            return board;
        }

        //checks if the centerpiece is open; if it is it will take that as a priority
        if(board[1][1] == 0){
            board[1][1] = 2;
            return board;
        }

        //checks if the corners are open; if they are it will take them as a priority
        if(board[0][0] == 0){
            board[0][0] = 2;
            return board;
        }
        if(board[0][2] == 0){
            board[0][2] = 2;
            return board;
        }
        if(board[2][0] == 0){
            board[2][0] = 2;
            return board;
        }
        if(board[2][2] == 0){
            board[2][2] = 2;
            return board;
        }

        //if none of these are available, choose a random square as a fail-safe
        while(true){
            int x = (int)(Math.random() * 3); //rand num between 0-2
            int y = (int)(Math.random() * 3);
            if(board[x][y] == 0){
                board[x][y] = 2;
                return board;
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
                if(board[i][j] == 1){
                    System.out.print("  X  ");
                }
                else if(board[i][j] == 2){
                    System.out.print("  O  ");
                }
                else{
                    System.out.print("[" + i + " " + j + "]");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
