package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*; 
import org.junit.Test;
import org.junit.Before;

public class SudokuBoardTest {
    SudokuBoard example1Board;
    SudokuBoard notValidBoard;

    @Before
    public void initialize(){
        this.example1Board = new SudokuBoard(BoardExample.example1);
        this.notValidBoard = new SudokuBoard(BoardExample.example1notValid);
    }

    @Test
    public void isCompleteTest(){
        assertFalse(example1Board.isComplete());
        assertTrue(new SudokuBoard(BoardExample.example1complete).isComplete());
    }

    @Test
    public void findPossibleInCellTest(){ 
        assertEquals(Arrays.asList(9), example1Board.findPossibleInCell(0,2));
        assertEquals(Arrays.asList(1,2), example1Board.findPossibleInCell(3, 4));
        assertEquals(new ArrayList<Integer>(), example1Board.findPossibleInCell(0,0));
    }

    @Test
    public void findPossibleInListTest(){
        ArrayList<Integer> arraylist = new ArrayList<Integer>(Arrays.asList(3,8,0, 1,7,0, 5,6,4));
        ArrayList<Integer> currentList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        ArrayList<Integer> possibleInCell = new ArrayList<Integer>(Arrays.asList(2,9));
        assertEquals(possibleInCell, example1Board.findPossibleInList(currentList, arraylist));
        assertEquals(Arrays.asList(2,9), currentList);
        arraylist = new ArrayList<Integer>(Arrays.asList(0,7,0,3,2,4,0,0,0)); 
        assertEquals(Arrays.asList(9), example1Board.findPossibleInList(currentList, arraylist));
    }

    @Test
    public void isValidTest(){
        assertTrue(example1Board.isValid());
        assertFalse(notValidBoard.isValid());
    }
    @Test
    public void isListValidTest(){
        ArrayList<Integer> invalidList = new ArrayList<Integer>(Arrays.asList(4,1,2,6,0,6,9,3,0));
        ArrayList<Integer> validList = new ArrayList<Integer>(Arrays.asList(4,1,2,6,0,0,9,3,0));
        assertFalse(SudokuBoard.isListValid(invalidList));
        assertTrue(SudokuBoard.isListValid(validList)); 
    }
} 
