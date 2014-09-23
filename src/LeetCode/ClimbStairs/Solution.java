package LeetCode.ClimbStairs;

public class Solution {
	
	 public int climbStairs_S(int n) {
	        if(n == 0)
	        {
	            return 1;
	        }
	        if(n< 0)
	        {
	            return 0;
	        }
	        return climbStairs_S(n-1)+climbStairs_S(n-2);
	    }
	 public int climbStairs(int n) {
	       int[] mWays = new int[n+1];
	       climbStairsWithMemorization(n,mWays);
	       return mWays[n];
	    }
	    //add memorization
	    public void climbStairsWithMemorization(int n, int[] mWays)
	    {
	         //add memorization
	         if(n==0)
	         {
	             mWays[0] = 1;
	             return;
	         }
	         if(n==1)
	         {
	             mWays[1]=1;
	             return;
	         }
	         if(n==2)
	         {
	             mWays[2] = 2;
	             return;
	         }
	         if(mWays[n-1]== 0)
	         {
	             climbStairsWithMemorization(n-1, mWays);
	         }
	         if(mWays[n-2]== 0)
	         {
	             climbStairsWithMemorization(n-2, mWays);
	         }
	         mWays[n] = mWays[n-1] + mWays[n-2];
	         return;
	    }
}
