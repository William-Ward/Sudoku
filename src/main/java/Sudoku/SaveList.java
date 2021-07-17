package Sudoku;

import java.util.ArrayList;

public class SaveList {
    static final int BOARD_SIZE = 9;
    ArrayList<ArrayList<Integer>> thisList = new ArrayList<ArrayList<Integer>>();
    SaveList(){
        initializeListSize();
    }

    private void initializeListSize(){
        for(int i = 0; i < BOARD_SIZE * BOARD_SIZE; i = i + 1){
            thisList.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<Integer> getList(int row, int col){
        int index = get1dIndexFromRowCol(row, col);
        if(index != -1){
            return thisList.get(index); 
        }
        return null;
    }

    public boolean addList(int row, int col, ArrayList<Integer> insertList){
        int index = get1dIndexFromRowCol(row, col);
        if(index != -1){
            thisList.set(index, insertList);
            return true;
        }
        return false;
    }

    public int get1dIndexFromRowCol(int row, int col){
        int index = row*BOARD_SIZE+col;
        if(index >= 0 && index <= 80){
            return index;
        }
        return -1;
    }

    public int getSize(){
        return thisList.size();
    }

    public void printList(){
        System.out.println(thisList);
    }
}
