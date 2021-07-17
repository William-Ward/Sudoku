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
    public void getListTest(){
        ArrayList<Integer> cell00 = new  ArrayList<Integer>(Arrays.asList(0,0,0));
        ArrayList<Integer> cell88 = new  ArrayList<Integer>(Arrays.asList(8,8,8));
        savelist.addList(0, 0, cell00);
        savelist.addList(8, 8, cell88); 
        assertEquals(cell00, savelist.getList(0,0));
        assertEquals(cell88, savelist.getList(8,8)); 
        assertEquals(null, savelist.getList(8,9)); 
        assertEquals(null, savelist.getList(-1,-1)); 
    }

    @Test
    public void addListTest(){
        ArrayList<Integer> cell00 = new  ArrayList<Integer>(Arrays.asList(0,0,0));
        ArrayList<Integer> cell88 = new  ArrayList<Integer>(Arrays.asList(8,8,8));
        assertTrue(savelist.addList(0, 0, cell00));
        assertTrue(savelist.addList(8, 8, cell88));
        assertEquals(cell00, savelist.getList(0,0));
        assertEquals(81, savelist.getSize());
        assertFalse(savelist.addList(-1, -1, cell00));
    }

    @Test
    public void get1dIndexFromRowColTest(){ 
        assertEquals(3, savelist.get1dIndexFromRowCol(0, 3));
        assertEquals(8, savelist.get1dIndexFromRowCol(0, 8));
        assertEquals(9, savelist.get1dIndexFromRowCol(1, 0));
        assertEquals(17, savelist.get1dIndexFromRowCol(1, 8));
        assertEquals(18, savelist.get1dIndexFromRowCol(2, 0));
        assertEquals(80, savelist.get1dIndexFromRowCol(8, 8));
        assertEquals(-1, savelist.get1dIndexFromRowCol(8, 9));
    }
    
    @Test
    public void initialSizeTest(){
        assertEquals(81, savelist.getSize());
    }

} 

