package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class SolveBoard {
    SudokuBoard board;
    SolveBoard()                    { board = new SudokuBoard(); }
    SolveBoard(SudokuBoard newboard){ board = newboard; }

  public void populateDiagonalCubes(){ 
        ArrayList<Integer> templateRow = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        board.setCube(SolveBoard.shuffleArray(templateRow), 0, 0); 
        board.setCube(SolveBoard.shuffleArray(templateRow), 3, 3); 
        board.setCube(SolveBoard.shuffleArray(templateRow), 6, 6); 
    }

    public ArrayList<Integer> findPossibleInCell(int row, int col){ 
        ArrayList<Integer> foundPossible = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)); 
        findPossibleInArrayList(foundPossible, board.getRow(row));
        findPossibleInArrayList(foundPossible, board.getColumn(col));
        findPossibleInArrayList(foundPossible, board.getCube(row, col));
        return foundPossible;
    }

    public ArrayList<Integer> findPossibleInArrayList(
           ArrayList<Integer> currentPossible, ArrayList<Integer> fromList){ 
        for(Integer e : fromList){
            if(e != 0){
                currentPossible.remove(e);
            }
        }
        return currentPossible;
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
