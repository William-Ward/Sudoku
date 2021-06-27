package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

// TODO 

public class SolveBoard {
    SudokuBoard board;
    ArrayList<Integer> templateRow = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    SolveBoard(){
        board = new SudokuBoard();
    }

  public void populateDiagonalCubes(){ 
        board.setCube(SolveBoard.shuffleArray(templateRow), 0, 0); 
        board.setCube(SolveBoard.shuffleArray(templateRow), 3, 3); 
        board.setCube(SolveBoard.shuffleArray(templateRow), 6, 6); 
    }

    public static ArrayList<Integer> shuffleArray(ArrayList<Integer> row){ 
        Collections.shuffle(row);
        return row;
    }

    public static boolean rowIsComplete(ArrayList<Integer> row){
        for(int i = 0; i < row.size(); i++){
            if(row.get(i) == SudokuBoard.BLANK_SQUARE){ 
                return false; 
            }
        }
        return true;
    } 

    public static int getRandomNumber(int min, int max) { 
        return new Random().nextInt(max - min) + min;
    }

}
