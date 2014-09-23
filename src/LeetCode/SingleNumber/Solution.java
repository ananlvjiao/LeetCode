package LeetCode.SingleNumber;

import java.util.*;

public class Solution {
    public int singleNumber_S (int[] A) {
     HashMap<Integer, Integer> tokens = new HashMap<Integer, Integer>();

     for(int i=0; i< A.length; i++)
     {
     	if(tokens.containsKey(A[i]))
     	{
     		tokens.put(A[i],tokens.get(A[i])+1);
     	}
     	else
     	{
     		tokens.put(A[i],1);
     	}
     }
     
       // Get a set of the entries
      Set set = tokens.entrySet();
      // Get an iterator
      Iterator i = set.iterator();
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         if((Integer)me.getValue()==1)
         {return (Integer)me.getKey();}
      }
      return 0;
    }
    
    public int singleNumber(int[] A) {

    	int val = 0;
    	for(int i = 0; i<A.length; i++)
    	{ 
    		val = val ^ A[i];
    	}
    	
    	return val;

    }
}