package Sudoku;

// import java.util.Arrays;
import java.util.ArrayList;

public class Board {
    static final int BLANK_SQUARE = 0;
    static final int BOARD_SIZE = 9;
    public int[][] board = new int[9][9];

    Board(){ }
    Board(int[][] constructorBoard){
        board = constructorBoard;
    }

    public boolean setCell(int val, int row, int col){
        if(val < 10 && val > -1){
            board[row][col] = val;
            return true;
        }
        return false;
    }

    public int getCell(int row, int col){
        return board[row][col];
    }

    public boolean setCube(ArrayList<Integer> cube, int rowNum, int colNum){
        rowNum = setToCubeBeginning(rowNum);
        colNum = setToCubeBeginning(colNum);
        int counter = 0;

        for(int row = rowNum; row < rowNum + 3; row = row + 1){
            for(int col = colNum; col < colNum + 3; col = col + 1){
                board[row][col] = cube.get(counter);
                counter++;
            }
        }
        return true; 
    }

    // find how many occurences of a given number are left on the board
    public int getRemainingOfNumber(int numToFind){
        int count = 0;
        for(int row = 0; row < BOARD_SIZE; row++){
            for(int col = 0; col < BOARD_SIZE; col++){
                if(board[row][col] == numToFind){
                    count++;
                    break;
                }
            }
        }
        return BOARD_SIZE - count;
    }


    public static int setToCubeBeginning(int num){
        if(num < 6 && num >= 3){ return 3; }
        if(num >= 6){ return 6; } 
        return 0;
    }

    public ArrayList<Integer> getCube(int rowNum, int colNum){
        rowNum = setToCubeBeginning(rowNum);
        colNum = setToCubeBeginning(colNum);
        ArrayList<Integer> cube = new ArrayList<Integer>(); 

        for(int row = rowNum; row < rowNum+3; row = row + 1){
            for(int col = colNum; col < colNum + 3; col = col + 1){
                cube.add(board[row][col]); 
            }
        }
        return cube;
    }

    public ArrayList<Integer> getRow(int row){
        ArrayList<Integer> returnrow = new ArrayList<Integer>(); 
        for(int col = 0; col < BOARD_SIZE; col = col + 1){
            returnrow.add(board[row][col]);
        }
        return returnrow;
    }

    public ArrayList<Integer> getColumn(int col){
        ArrayList<Integer> column = new ArrayList<Integer>();
        for(int row = 0; row < BOARD_SIZE; row = row + 1){
            column.add(board[row][col]);
        }
        return column;
    }

    public void printBoard(){
        for(int row = 0; row < BOARD_SIZE; row++){
            for(int col = 0; col < BOARD_SIZE; col++){
                System.out.print(board[row][col]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    public int getBoardSize(){
        return BOARD_SIZE;
    }

}


