package LeetCode.SearchInsertPosition;

public class Solution {
	public int searchInsert(int[] A, int target) {

        for(int i= 0; i< A.length; i++)
        {
            if(target<=A[i])
            {
                return i;
            }
        }
        return A.length;
    }
	
}
