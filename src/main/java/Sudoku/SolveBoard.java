package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class SolveBoard {
    SudokuBoard board;
    SaveList scratchList = new SaveList();
    SolveBoard(){
        board = new SudokuBoard();
    }
    SolveBoard(SudokuBoard newboard){
        board = newboard;
    }

    public SaveList findPossibleInBoard(){
        int boardSize = board.getBoardSize();
        for(int row = 0; row < boardSize; row = row + 1){
            for(int col = 0; col < boardSize; col = col + 1){
                scratchList.addList(row, col, board.findPossibleInCell(row, col));
            } 
        }
        return scratchList;
    }

  public void populateDiagonalCubes(){ 
        ArrayList<Integer> templateRow = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        board.setCube(SolveBoard.shuffleArray(templateRow), 0, 0); 
        board.setCube(SolveBoard.shuffleArray(templateRow), 3, 3); 
        board.setCube(SolveBoard.shuffleArray(templateRow), 6, 6); 
    }

    public static boolean rowIsComplete(ArrayList<Integer> row){
        for(int i = 0; i < row.size(); i++){
            if(row.get(i) == SudokuBoard.BLANK_SQUARE){ 
                return false; 
            }
        }
        return true;
    } 

    public static ArrayList<Integer> shuffleArray(ArrayList<Integer> row){ 
        Collections.shuffle(row);
        return row;
    }

    public static int getRandomNumber(int min, int max) { 
        return new Random().nextInt(max - min) + min;
    }

}
