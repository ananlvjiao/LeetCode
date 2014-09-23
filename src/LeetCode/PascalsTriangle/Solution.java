package LeetCode.PascalsTriangle;

import java.util.ArrayList;

public class Solution {
	
	  public ArrayList<ArrayList<Integer>> generate(int numRows) {
	        //init 
	        if(numRows<= 0) return null;
	        ArrayList<ArrayList<Integer>> result =  new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> row_0 = new ArrayList<Integer>();
	        row_0.add(1);
	        result.add(row_0);
	        if(numRows ==1 )
	        {
	            return result;
	        }
	        for(int i= 1;i < numRows; i++)
	        {
	            //create row
	        	ArrayList<Integer> aboveRow = result.get(i-1);
	            ArrayList<Integer> row = new ArrayList<Integer>();
	            for(int j=0; j<=i; j++)
	            {
	            	if(j==0 || j==i)
	            	{
	            		row.add(1);
	            	}
	            	else
	            	{
	            		row.add((aboveRow.get(j-1) + aboveRow.get(j)));
	            	}
	            } 
	            result.add(row);
	        }
	        return result;
	  }

	  public ArrayList<Integer> getRow(int rowIndex) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(rowIndex == 0) return result;
	        result.add(1);
	        if(rowIndex == 1) return result;
	        //cal half
	        //start from second row 
	        
	        for(int i= 1; i < rowIndex ; i++)
	        {
	           if((i+1)%2!=0)
	           {
	               result.add(2 * result.get((i+1)/2-1));
	           }
	           for(int j= (i+1)/2-1; j>0; j--)
	           {
	            //[1,2] => [1,3]
	            result.set(j, result.get(j) + result.get(j-1));
	           }
	           
	        }
	        //add the left half
	        for(int i= rowIndex/2-1; i>=0; i--)
	        {
	            result.add(result.get(i));
	        }
	        return result;
	    }
}
