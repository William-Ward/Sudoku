package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;


public class SudokuBoard {
    static final int BLANK_SQUARE = 0;
    static final int BLOCK_SIZE = 9;
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
        for(int col = 0; col < BLOCK_SIZE; col = col + 1){
            returnrow.add(board[row][col]);
        }
        return returnrow;
    }

    public ArrayList<Integer> getColumn(int col){
        ArrayList<Integer> column = new ArrayList<Integer>();
        for(int row = 0; row < BLOCK_SIZE; row = row + 1){
            column.add(board[row][col]);
        }
        return column;
    }

    public static ArrayList<Integer> shuffleArray(ArrayList<Integer> row){ 
        Collections.shuffle(row);
        return row;
    }

    public static int getRandomNumber(int min, int max) { 
        return new Random().nextInt(max - min) + min;
    }

}
