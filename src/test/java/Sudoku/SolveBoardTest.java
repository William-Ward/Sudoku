package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*; 
import org.junit.Test;
import org.junit.Before;

public class SolveBoardTest {
    SolveBoard solve;
    SolveBoard solveExample1;

    @Before
    public void initialize(){
        solve = new SolveBoard();
        solveExample1 = new SolveBoard(new SudokuBoard(BoardExample.example1));
    }

    @Test
    public void solveTest(){
        // assertTrue(solveExample1.board.isSolved());
    }

    @Test
    public void findPossibleInBoardTest(){
        SaveList savelist = solveExample1.findPossibleInBoard();
        assertTrue(savelist.getList(0,0).isEmpty());
        assertEquals(Arrays.asList(1,2), savelist.getList(3,4)); 
        // savelist.printList();
    }

    @Test
    public void populateDiagonalCubesTest(){
        ArrayList<Integer> cubeZeros = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0)); 
        assertEquals(cubeZeros, solve.board.getCube(0, 0));
        solve.populateDiagonalCubes();
        assertNotEquals(cubeZeros, solve.board.getCube(0, 0));
        assertNotEquals(solve.board.getCube(6,6), solve.board.getCube(3, 3));
        // solve.board.printBoard();
    }

    @Test
    public void shuffleArrayTest(){
        ArrayList<Integer> row = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        ArrayList<Integer> originalRow = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        assertNotSame(originalRow, SolveBoard.shuffleArray(row));
    }

    @Test
    public void rowIsCompleteTest(){
        ArrayList<Integer> completeRow = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        ArrayList<Integer> incompleteRow = new ArrayList<Integer>(Arrays.asList(0,2,3,4,5,6,7,8,9));
        assertTrue(SolveBoard.rowIsComplete(completeRow) == true);
        assertTrue(SolveBoard.rowIsComplete(incompleteRow) == false);
    } 

    @Test
    public void getRandomNumberTest(){
        assertTrue(SolveBoard.getRandomNumber(1,9) <= 9 && SolveBoard.getRandomNumber(1,9) > 0); 
        assertEquals(4, SolveBoard.getRandomNumber(4,5));
    } 

} 

