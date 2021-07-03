package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*; 
import org.junit.Test;
import org.junit.Before;

public class SudokuBoardTest {
    SudokuBoard board;
    @Before
    public void initialize(){
        board = new SudokuBoard(BoardExample.example1);
    }

    @Test
    public void constructorTest(){
        SudokuBoard blankBoard = new SudokuBoard();
        assertEquals(0, blankBoard.getCell(8,8));
    }
    @Test
    public void setCubeTest(){
        ArrayList<Integer> cube66 = new ArrayList<Integer>(Arrays.asList(4,1,2,6,0,0,9,3,0));
        ArrayList<Integer> allZeros = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0));
        assertEquals(cube66, board.getCube(6,6));

        assertTrue(board.setCube(allZeros, 6, 6));
        assertEquals(allZeros, board.getCube(6,6));
        assertTrue(board.setCube(cube66, 6, 6));
        assertEquals(cube66, board.getCube(6,6));
    }

    @Test
    public void setCellTest(){
        assertEquals(8, board.getCell(3,3));
        assertTrue(board.setCell(0,3,3));
        assertEquals(0, board.getCell(3,3));
        assertTrue(!board.setCell(10,3,3)); 
        assertTrue(board.setCell(8,3,3));
    }

    @Test
    public void getCellTest(){
        assertEquals(8, board.getCell(3,3));
        assertEquals(3, board.getCell(0,0));
    }

    @Test
    public void getRemainingOfNumberTest(){
        assertEquals(5, board.getRemainingOfNumber(1));
        assertEquals(3, board.getRemainingOfNumber(4));
    }

    @Test
    public void normalizeRowColTest(){
        assertEquals(0, SudokuBoard.normalizeRowOrCol(0));
        assertEquals(3, SudokuBoard.normalizeRowOrCol(3));
        assertEquals(6, SudokuBoard.normalizeRowOrCol(6));
        assertEquals(0, SudokuBoard.normalizeRowOrCol(2));
        assertEquals(6, SudokuBoard.normalizeRowOrCol(12));
        assertEquals(0, SudokuBoard.normalizeRowOrCol(-1));
    }

    @Test
    public void getCubeTest(){
        ArrayList<Integer> cube00 = new ArrayList<Integer>(Arrays.asList(3,8,0,0,1,7,6,0,0));
        assertEquals(cube00, board.getCube(0, 0));
        ArrayList<Integer> cube66 = new ArrayList<Integer>(Arrays.asList(4,1,2,6,0,0,9,3,0));
        assertEquals(cube66, board.getCube(6, 6)); 
    }

    @Test
    public void getRowTest(){
        ArrayList<Integer> row0 = new ArrayList<Integer>(Arrays.asList(3,8,0, 1,7,0, 5,6,4));
        assertEquals(row0, board.getRow(0)); 
        ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(9,0,3, 8,0,0, 0,4,6));
        assertEquals(row3, board.getRow(3)); 
    }
    
    @Test
    public void getColumnTest(){
        ArrayList<Integer> column1 = new ArrayList<Integer>(Arrays.asList(8,1,0,0,0,6,0,3,2));
        assertEquals(column1, board.getColumn(1)); 
        ArrayList<Integer> column2 = new ArrayList<Integer>(Arrays.asList(0,7,0,3,2,4,0,0,0));
        assertEquals(column2, board.getColumn(2)); 
    }

} 

class BoardExample {

    static int[][] example1 = {{3,8,0, 1,7,0, 5,6,4},
                               {0,1,7, 0,5,0, 0,8,9},
                               {6,0,0, 0,3,8, 0,0,0},

                               {9,0,3, 8,0,0, 0,4,6},
                               {0,0,2, 0,0,6, 0,5,0},
                               {1,6,4, 0,0,0, 0,9,0},

                               {5,0,0, 7,6,3, 4,1,2},
                               {4,3,0, 2,0,9, 6,0,0},
                               {0,2,0, 5,4,0, 9,3,0}};

} 
