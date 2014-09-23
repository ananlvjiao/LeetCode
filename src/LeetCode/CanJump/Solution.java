package LeetCode.CanJump;

public class Solution {
	 public boolean canJump(int[] A) {
		 boolean result = true;
	        int fristStart = 0;
	        for(int i = 0; i<A.length; i++)
	        {
	            if(i==0 && A[i]==0 && i<A.length-1) return false;
	            if(A[i]== 0 && i< A.length-1)
	            {
	            	
	            	int j= i-1;
	                for(; j> 0; j--)
	                {
	                    if(A[j]> i-j)
	                    {
	                        break;
	                    }
	                }
	                if(j == fristStart)
	                return false;
	                else
	                {
	                	fristStart = i;
	                }
	            }
	        }
	        return result;
	 }
}
