/*
 * Eric Nguyen 
 * CSE 007
 * 10/30/2022
 * Homework 6
 * Tic-Tac-Toe Game
 */

import java.util.Scanner;

 public class TicTacToe{
    public static void main(String[] args) {
        //initalizing scanner and boolean
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int x = 5;
        int y = 5;
        // initalizing board
        String [][] board = {
            {"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}};

        do{
            printBroad(board);
        
            board = updateBoard(board, "o", input);
            if(playerWon(board, "o") || tieGame(board)){
                break;
            }
            printBroad(board);
            
            board = updateBoard(board, "x", input);
            if(playerWon(board, "x") || tieGame(board)){
                valid = true;
            }
        }while(!valid);
    }        

    //pre con: prompt user for int
    // function validates the input
    // post con: returns the valid int


    public static int getInt(Scanner input) {
        boolean good = false;
        int number = 0;
        do{
            if(input.hasNextInt()){
                number = input.nextInt();
                input.nextLine();
                if(number >= 1 && number <= 3) {
                    good =true;
                }
                else {
                    System.out.println("You entered an invalid number(Enter 1-3)");
                }
            }
            else{
                String temp = input.nextLine();
                System.out.println(temp + " is not an integer");
            }
        }while(!good);
        return number;
    }

    //preconditions: 2d array must be crated 
    //prints out the board
    //post condition printined board
    public static void printBroad(String[][] board){
        for(String[] row:board){
            for(String pos:row ){
                System.out.print(pos + "\t");
            }
            System.out.println();
        }
    }
    
    //pre-con: board was created and all rows and columns are initalized 
    // returns true if positions on board is being used 
    // false if it is not being used
    // post con: returns true if pos is taken false if not.
    public static boolean validPos(int col, int row, String[][] board){
        String pos = board[row-1][col-1];
        if(pos.equals("o") || pos.equals("x")){
            System.out.println("This position is taken");
            return true;
        }
        return false;
    }

    //pre-con: a 2d board snd scannermmust be initialized 
    // function updates baord by asking user where they want to place thier symbol
    // and validates the position 
    // post-con: returns a 2d board with updates values coresspodnig nto user input.
    public static String[][] updateBoard(String[][] board,  String value, Scanner input){
        boolean good = false;
        int colPos = 0;
        int rowPos= 0;

        do{
            System.out.print("Please enter the column you would like \""+ value +"\" in: ");
            colPos = getInt(input);
            System.out.print("\nPlease enter the row you would like \""+ value +"\" in: ");
            rowPos = getInt(input);
            //if position is not taken, end the loop
            if (!(validPos(colPos, rowPos, board))){
                board[rowPos-1][colPos-1] = value;
                good = true;
            }
        }while(!good);
        return board;
    }

    public static boolean tieGame(String[][] board){
        for(String[] row:board) {
            for(String pos:row){
                if(!(pos.equals("o") || pos.equals("x"))){
                    return false;
                }
            }
        }
        System.out.print("Tie Game!");
        return true;
    }
    //pre-con: board is created
    // function determines winner
    //post-con: returns true if someone won and returns false if no one won.;
    public static boolean playerWon(String[][] board, String value) {
        boolean hasWon = false;
        if(board[0][0].equals(value) && board[0][1].equals(value) && board[0][2].equals(value)) {
            hasWon = true;
        }
        else if(board[1][0].equals(value) && board[1][1].equals(value) && board[1][2].equals(value)) {
            hasWon = true;
        }
        else if(board[2][0].equals(value) && board[2][1].equals(value) && board[2][2].equals(value)) {
            hasWon = true;
        }
        else if (board[0][0].equals(value) && board[1][0].equals(value) && board[2][0].equals(value)) {
            hasWon = true;
        }
        else if (board[0][1].equals(value) && board[1][1].equals(value) && board[2][1].equals(value)) {
            hasWon = true;
        }
        else if (board[0][2].equals(value) && board[1][2].equals(value) && board[2][2].equals(value)) {
            hasWon = true;
        }
        else if (board[0][0].equals(value) && board[1][1].equals(value) && board[2][2].equals(value)) {
            hasWon = true;
        }
        else if (board[0][2].equals(value) && board[1][1].equals(value) && board[2][0].equals(value)) {
            hasWon = true;
        }
        if(hasWon) {
            System.out.println("player " + value + " won!");
        }
        return hasWon;
    }
}
