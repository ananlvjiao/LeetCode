package LeetCode.Practise;

import java.util.ArrayList;

public class Solution2 {
	public boolean binarySearchExt(int[] vals, int low, int high, int target, boolean ascending)
	{
		System.out.print("2");
		if(low> high) return false;
		int midIndex = (low+high)/2;
		if(vals[midIndex]==target) return true;
		else if(ascending && target< vals[midIndex] || !ascending && target> vals[midIndex]) 
			return binarySearchExt(vals, low, midIndex-1, target, ascending);
		else return binarySearchExt(vals, midIndex+1, high, target, ascending);
	}
	
	public boolean binarySearchExt(int[] vals,int target, boolean ascending)
	{
		System.out.print("2");
		int high = vals.length -1;
		int low = 0;
		while(high>= low)
		{
			int midIndex = (high+ low)/2;
			if(target == vals[midIndex]) return true;
			else if(ascending && target < vals[midIndex] || !ascending && target>vals[midIndex])
			{
				high = midIndex-1;
			}
			else 
			{
				low = midIndex+1;
			}
	
		}
		return false;
	}
	//think about corner case. All ascending, smallest the first
	public int findSummit(int[] vals, int low, int high)
	{
		System.out.print("1");
		if(high-low == 1)
		{
			if(vals[high] == vals[low]) return -1;
			else if(vals[high]>vals[low])
				return high;
			else
				return low;
		}
		if(high == low) return high;
		if(low> high) return -1;
		
		int midIndex = (low+high)/2;
		
		if(vals[midIndex]>vals[midIndex-1] && vals[midIndex]> vals[midIndex+1]) return midIndex;
		else if(vals[midIndex]<=vals[midIndex-1])// descending
			return findSummit(vals, low, midIndex-1);
		else //ascending
			return findSummit(vals, midIndex+1, high);
	}
	
	public boolean findSummit2(int[] vals, int low, int high, int target)
	{
		//log(n) * log(n/2)
		System.out.print("1");
		if(high-low == 1)
		{
			if(vals[high] == target|| vals[low]== target) 
				return true;
			else 
				return false;
		}
		if(high == low) 
			{
				if(target == vals[high]) 
					return true;
				else return false;
			}
		if(low> high) return false;
		
		int midIndex = (low+high)/2;
		if(target == vals[midIndex]) return true;
		//check summit
		if(vals[midIndex]>vals[midIndex-1] && vals[midIndex]> vals[midIndex+1])
		{
			if(target > vals[midIndex]) return false;
			else
			   return (binarySearchExt(vals, low, midIndex -1, target, true))||
						(binarySearchExt(vals, midIndex+1, high, target, false));

		}
		//summit in the left
		if(vals[midIndex]<=vals[midIndex-1])
		{
			if(target > vals[midIndex])
				return findSummit2(vals, low, midIndex-1, target);
			else
				return findSummit2(vals, low, midIndex-1, target)||
						binarySearchExt(vals, midIndex+1, high, target, false);
		}
		
		if(vals[midIndex]>=vals[midIndex-1])
		{
			if(target> vals[midIndex])
				return findSummit2(vals, midIndex+1, high, target);
			else 
				return findSummit2(vals, midIndex+1, high, target)||
						binarySearchExt(vals, low, midIndex-1, target, true);
		}
		return true;
	}
	
	public boolean ifExistInArray(int[] vals, int target)
	{
		if(vals== null) return false;
		int len = vals.length; 
		if(len == 0) return false;
		int summitIndex = findSummit(vals, 0, len-1);
		if(target == vals[summitIndex]) return true;
		else if(target > vals[summitIndex]) return false;
		else
			return (binarySearchExt(vals, 0, summitIndex -1, target, true))||
					(binarySearchExt(vals, summitIndex+1, len-1, target, false));
	}

	public boolean ifExistInArray2(int[] vals, int target)
	{
		if(vals== null) return false;
		int len = vals.length; 
		if(len == 0) return false;
		int summitIndex = findSummit(vals, 0, len-1);
		if(target == vals[summitIndex]) return true;
		else if(target > vals[summitIndex]) return false;
		else
			return (binarySearchExt(vals, 0, summitIndex -1, target, true))||
					(binarySearchExt(vals, summitIndex+1, len-1, target, false));
	}
	
	 public ArrayList<String[]> solveNQueens(int n) {
	        String[] matrix = new String[n];
	        StringBuilder sb = new StringBuilder();
	        for(int i= 0; i< n; i++)
	        {
	            sb.append('.');
	        }
	        for(int i=0; i<n; i++)
	        {
	            matrix[i]= sb.toString();
	        }
	        return placeQueen(0, matrix);
	        
	    }
	    
	    public ArrayList<String[]> placeQueen(int row, String[] matrix)
	    {
	        ArrayList<String[]> results = new ArrayList<String[]>();
	        int size = matrix.length;
	        if(row == size) 
	        	{ results.add(matrix);
	        	return results;
	        	}
	        
	        for(int j= 0; j< size; j++ )
	        {
	            if(isValid(matrix, row, j))
	            {
	            	String[] newMatrix = matrix.clone();
	                //add the row to matrix and result
	            	StringBuilder sb= new StringBuilder(newMatrix[row]);
	                sb.setCharAt(j, 'Q');
	                newMatrix[row] = sb.toString();
	                results.addAll(placeQueen(row+1, newMatrix));
	            }
	        }
	        return results;
	    }  
	    public boolean isValid(String[] matrix, int r, int c)
	    {
	        //check column, diagonal
	        int size = matrix.length;
	        for(int i = 0; i< r; i++)
	        {
	            if(matrix[i].charAt(c)=='Q')
	                return false;
	        }
	        int i = r;
	        int j = c;
	        while(i>=0 && j>=0)
	        {
	            if(matrix[i].charAt(j)=='Q')
	                return false;
	            i--;
	            j--;
	        }
	        i = r;
	        j = c;
	        while(i>=0 && j<size)
	        {
	            if(matrix[i].charAt(j)=='Q')
	                return false;
	            i--;
	            j++;
	        }
	        // i = r+1;
	        // j = c+1;
	        
	        // while(i<size && j< size)
	        // {
	        //     if(matrix[i].charAt(j)=='Q')
	        //         return false;
	        //     j++;
	        //     j++;
	        // }
	        return true;
	    }
	   
	 public void mergeSort(int[] arr, int low, int high)
	 {
		 if(low<high)
		 {
		 int midIndex = (low + high)/2;
		  mergeSort(arr, low, midIndex);
		  mergeSort(arr, midIndex+1, high);
		 merge(arr, low, midIndex, high);
		 }
		 
	 }
	 public void merge(int[] arr, int low, int middle, int high)
	 {
		 //high - low
		 int[] helperArr = new int[high-low+1];
		 for(int k = 0; k<= high- low; k++)
		 {
			 helperArr[k] = arr[low+k];
		 }
		 int left = low;
		 int right = middle+1;
		 int i = low;
		 while(left<= middle && right <= high)
		 {
			 if(arr[left]<= arr[right])
			 {
				 arr[i] = helperArr[left-low];
				 left ++;
			 }
			 else
			 {
				 arr[i] = helperArr[right-low];
				 right ++;
			 }
			 i++;
		 }
		 int remaining = middle - left;
		 for(int j = 0; j<= remaining; j++)
		 {
			 arr[j+ i]= helperArr[left+ j]; 
		 }
	 }

	 public void quickSort(int[] arr, int low, int high)
	 {
		 int pivot = partition(arr, low, high);
		 if(low< pivot-1)
		 {
			 quickSort(arr, low, pivot-1);
		 }
		 if(high> pivot)
		{
			 quickSort(arr, pivot, high);
			 
			 }
		 
	 }
	 
	 public int partition(int[] array, int left, int right)
	 {
		 int pivot = array[(left+right)/2];
		 while(left< right)
		 {
			 while(array[left]< pivot)
			 {left++;}
			 while(array[right]>pivot)
			 {right--;}
			 if(left< right)
			 {
				 //swap(leftVal, rightVal);
				 left ++;
				 right--;
			 }
			 
		 }
		 return left;
	 }

}
