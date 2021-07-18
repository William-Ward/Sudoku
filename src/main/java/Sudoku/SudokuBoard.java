package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuBoard extends Board{
    SudokuBoard(){ }
    SudokuBoard(int[][] constructorBoard){
        super(constructorBoard);
    }

    public boolean isComplete(){
        if(super.getRemainingOfNumber(BLANK_SQUARE) == 9){
            return true;
        } 
        return false;
    }

    public ArrayList<Integer> findPossibleInCell(int row, int col){ 
        ArrayList<Integer> foundPossible = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)); 
        if(super.getCell(row, col) == BLANK_SQUARE){
            findPossibleInList(foundPossible, super.getRow(row));
            findPossibleInList(foundPossible, super.getColumn(col));
            findPossibleInList(foundPossible, super.getCube(row, col));
            return foundPossible;
        }
        return new ArrayList<Integer>();
    }

    public ArrayList<Integer> findPossibleInList(
           ArrayList<Integer> currentPossible, ArrayList<Integer> fromList){ 
        for(Integer e : fromList){
            if(e != BLANK_SQUARE){
                currentPossible.remove(e);
            }
        }
        return currentPossible;
    }

    public boolean isValid(){
        for(int index = 0; index < BOARD_SIZE; index = index + 1){
            if(!isListValid(super.getRow(index))){ return false; }
            if(!isListValid(super.getColumn(index))){ return false; }
        }
        for(int row = 0; row < BOARD_SIZE; row = row + 3){
            for(int col = 0; col < BOARD_SIZE; col = col + 3){
                if(!isListValid(super.getCube(row, col))){ return false; } 
            }
        }
        return true;
    }

    public static boolean isListValid(ArrayList<Integer> list){ 
        ArrayList<Integer> tempList = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
        for(Integer i : list){
            if(tempList.get(i.intValue()) == 0){ 
                tempList.set(i.intValue(), i.intValue()); 
            }
            else{return false;}
        }
        return true;
    }

}
