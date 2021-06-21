package Sudoku;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

// TODO 

public class SolveBoard {

    public static ArrayList<Integer> findMissingRowCells(ArrayList<Integer> row){ 
        ArrayList<Integer> missing = new ArrayList<Integer>();
        for(int i = 0; i < SudokuBoard.BLOCK_SIZE; i = i + 1){


        }
        return missing;
    }
    
    public static boolean rowIsComplete(int[] row){
        for(int i = 0; i < row.length; i++){
            if(row[i] == SudokuBoard.BLANK_SQUARE){ return false; }
        }
        return true;
    } 
}
