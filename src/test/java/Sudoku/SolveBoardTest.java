package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*; 
import org.junit.Test;

public class SolveBoardTest {
    @Test

    public void findMissingRowCellsTest(){
        ArrayList<Integer> incompleteRow = new ArrayList<Integer>(Arrays.asList(0,0,3,4,5,6,7,8,9));
        // assertArrayEquals(new int[]{1,2}, SolveBoard.findMissingRowCells(incompleteRow));
        incompleteRow = new ArrayList<Integer>(Arrays.asList(3,0,0,0,5,6,7,8,9));
        // assertArrayEquals(new int[]{1,2,4}, SolveBoard.findMissingRowCells(incompleteRow));

    }

    public void rowIsCompleteTest(){
        int[] completeRow = new int[]{1,2,3,4,5,6,7,8,9};
        int[] incompleteRow = new int[]{0,2,3,4,5,6,7,8,9};
        assertTrue(SolveBoard.rowIsComplete(completeRow) == true);
        assertTrue(SolveBoard.rowIsComplete(incompleteRow) == false);
    } 

} 

