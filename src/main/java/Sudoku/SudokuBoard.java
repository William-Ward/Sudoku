package Sudoku;

// import java.util.Arrays;
import java.util.ArrayList;

public class SudokuBoard {
    static final int BLANK_SQUARE = 0;
    static final int BOARD_SIZE = 9;
    public int[][] board = new int[9][9];

    SudokuBoard(){ }
    SudokuBoard(int[][] constructorBoard){
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

    public boolean setCube(ArrayList<Integer> cube, int rowStart, int colStart){
        int counter = 0;
        for(int row = rowStart; row < rowStart + 3; row = row + 1){
            for(int col = colStart; col < colStart + 3; col = col + 1){
                board[row][col] = cube.get(counter);
                counter++;
            }
        }
        return true; 
    }

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

    public ArrayList<Integer> getCube(int rowStart, int colStart){
        ArrayList<Integer> cube = new ArrayList<Integer>(); 
        for(int row = rowStart; row < rowStart+3; row = row + 1){
            for(int col = colStart; col < colStart + 3; col = col + 1){
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

}
