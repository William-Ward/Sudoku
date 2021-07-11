package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*; 
import org.junit.Test;
import org.junit.Before;

public class SaveListTest {
    SaveList savelist;

    @Before
    public void initialize(){
        savelist = new SaveList();
    }

    @Test
    public void addListTest(){
        ArrayList<Integer> cell00 = new  ArrayList<Integer>(Arrays.asList(0,0,0));
        ArrayList<Integer> cell88 = new  ArrayList<Integer>(Arrays.asList(8,8,8));
        assertTrue(savelist.addList(0, 0, cell00));
        assertTrue(savelist.addList(8, 8, cell88));
        assertFalse(savelist.addList(-1, -1, cell00));
        assertFalse(savelist.addList(8, 9, cell88));
    }

    @Test
    public void getCellPossibleListTest(){
        ArrayList<Integer> cell00 = new  ArrayList<Integer>(Arrays.asList(0,0,0));
        ArrayList<Integer> cell88 = new  ArrayList<Integer>(Arrays.asList(8,8,8));
        savelist.addList(0, 0, cell00);
        savelist.addList(8, 8, cell88); 
        assertEquals(cell00, savelist.getCellPossibleList(0,0));
        assertEquals(cell88, savelist.getCellPossibleList(8,8)); 
        assertEquals(null, savelist.getCellPossibleList(8,9)); 
        assertEquals(null, savelist.getCellPossibleList(-1,-1)); 
    }

    @Test
    public void getIndexFromRowColTest(){ 
        assertEquals(3, savelist.getIndexFromRowCol(0, 3));
        assertEquals(8, savelist.getIndexFromRowCol(0, 8));
        assertEquals(9, savelist.getIndexFromRowCol(1, 0));
        assertEquals(17, savelist.getIndexFromRowCol(1, 8));
        assertEquals(18, savelist.getIndexFromRowCol(2, 0));
        assertEquals(80, savelist.getIndexFromRowCol(8, 8));
        assertEquals(-1, savelist.getIndexFromRowCol(8, 9));
    }
    
    @Test
    public void initialSizeTest(){
        assertEquals(81, savelist.getSize());
    }

} 

