package LeetCode.Sudoku;

import java.util.Stack;

public class Solution {
    
    private class Cell
    {
        int r;
        int c;
        char val;
        public Cell(int r, int c, char val)
        {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    
    public void solveSudoku(char[][] board) {
        Stack<Cell> cells = new Stack<Cell>();
        for(int i =0 ; i< 9; i++)
        {
            for(int j = 0; j< 9; j++)
            {
                if(board[i][j] == '.')
                {
                    char r = getNextPossibleNumber(board, i, j, '0');
                    if(r == '0')
                    {
                        //error case: sudoku not valid
                        if(cells.isEmpty()) return;
                        //backtracking;
                        getNextPossiblePath(cells, board, i, j);
                    }
                    else
                    {
                        //push to stack and move forward
                        cells.push(new Cell(i, j, r));
                        board[i][j] = r;
                    
                    }
                }
            }
        }
    }
    
    public void getNextPossiblePath(Stack<Cell> cells, char[][] board, int i, int j)
    {
        if(cells.isEmpty()) return;
        Cell prev = cells.pop();
        //set prev cell to .
        board[prev.r][prev.c] = '.';
        //get next possible prev
        char newPrev = getNextPossibleNumber(board, prev.r, prev.c, prev.val);
        if(newPrev == '0')
        {
            //back track
            getNextPossiblePath(cells, board, prev.r, prev.c);
        }
        else
        {
            cells.push(new Cell(prev.r, prev.c, newPrev));
            board[prev.r][prev.c] = newPrev;
        }
        
        char r = getNextPossibleNumber(board, i, j, '0');
        if(r != '0')
        {
            cells.push(new Cell(i, j, r));
            board[i][j] = r;
            return;
        }
        else
        {
            getNextPossiblePath(cells, board, i, j);
        }
    }
    
    //val should be less than '9'
    public char getNextPossibleNumber(char[][] board, int r, int c, char val)
    {
    	int vi = val;
        for(int i = vi+1; i<= 57; i++)
        {
            if(validSudoku(board, r, c, (char)i))
            { return (char)i;}
        }
        return '0';
    }
    
    public boolean validSudoku(char[][] board, int r, int c, char val)
    {
        //valid row r
        for(int i= 0; i< 9; i++)
        {
            if(board[r][i] == val)
            {
                return false;
            }
        }
        //valid column c
         for(int i= 0; i< 9; i++)
        {
            if(board[i][c] == val)
            {
                return false;
            }
        }
        //valid block
        int r_start = r/3;
        int c_start = c/3;
        for(int i= 0; i< 3; i++)
        {
            for(int j=0; j< 3; j++)
            {
                if(board[3*r_start + i][3 * c_start + j] == val)
                {
                    return false;
                }
            }
        }
        return true;
    }
}