package Sudoku;

import static org.junit.Assert.assertTrue; 
import static org.junit.Assert.assertEquals; 
import org.junit.Test;

public class PopulateBoardTest {
    @Test
    public void returnZeroTest() {
        assertTrue(PopulateBoard.returnZero() == 0);
    }
}
