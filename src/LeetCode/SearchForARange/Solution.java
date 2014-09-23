package LeetCode.SearchForARange;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int len = A.length;
        if(len == 0)
        {
            return new int[]{-1,-1};            
        }
        int loc = searchTarget(A, 0, len-1, target);
        if(loc==-1)
        {
            return new int[]{-1,-1};     
        }
        else
        {
            return getTheRange(A, loc, target);
        }
    }

    public int searchTarget(int[] A, int left, int right, int target)
    {
    	if(right<left || left> right)
    	{
    		return -1;
    	}
        int middle = (right + left)/2;
        if(A[middle] == target)
        {
            return middle;
        }
        else
        {
            if(left == right)
            {
                return -1;
            }
            else if(A[middle]> target)
            {
                return searchTarget(A, left, middle-1, target);
            }
            else
            {
                return searchTarget(A, middle + 1, right, target);
            }
        }
		
    }

    public int[] getTheRange(int[] A, int loc, int target)
    {
        int forward, backward;
        forward = backward = loc;
        while(forward< A.length && target==A[forward])
        {
            forward++;
        }

        while(backward>=0 && target==A[backward])
        {
            backward--;
        }

        return new int[]{backward+1, forward-1};
    }

}