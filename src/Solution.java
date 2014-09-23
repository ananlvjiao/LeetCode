import java.util.ArrayList;

import LeetCode.Helper.ListNode;


public class Solution {

	//bit manipulation
	public boolean is_power(int x)
	{
	    return (((x-1) & x)==0);
	}
	
	public boolean getBit(int num, int i)
	{
		return ((num&(num<<i))!=0);
	}
	
	public int setBit(int num, int i)
	{
		return num|(1<<i);
	}
	
	public int clearBit(int num, int i)
	{
		int mask = ~(1<<i);
		return num & mask;
	}
	
	public int updateBit(int num, int i, int v)
	{
		int mask= ~(1<<i);
		return (num & mask)|(v<<i);
	}
	
	public ArrayList<Integer> getBinary(int val)
	{
		ArrayList<Integer> oneBitLocs = new ArrayList();
		//int is 4 bytes = 32 bits
		for(int i= 0; i< 32; i++)
		{
			// isolate bit by bit
			if((val&(1<<i))!= 0)
			{
				oneBitLocs.add(i);
			}
		}
		return oneBitLocs;
	}
	
	//Get Digits
	public ArrayList<Integer> getDigits(int x) {

		ArrayList<Integer> digits = new ArrayList<Integer>();
		if (x == 0) {
			digits.add(0);
			return digits;
		}
		while (x != 0) {
			digits.add(0, x % 10);
			x = x / 10;
		}
		return digits;
	}
	
	//dynamic programming
	public int fibonacci(int i){
		if(i==0) return 0;
		if(i==1) return 1;
		return fibonacci(i-1) + fibonacci(i-2);
	}
	int fib[] = new int[1000];//size can be change
	public int fibonacci_m(int i){
		if(i==0) fib[i] =0;
		if(i==1) fib[i]=1;
		if(fib[i]!=0) return fib[i];
		fib[i] = fibonacci_m(i-1) + fibonacci_m(i-2);
		return fib[i];
	}
	
	//Sort
	public void quickSort(int[] array, int left, int right)
	{
		int index = partition(array,left, right );
		if(left< index -1)
		{
			quickSort(array, left, index-1);
		}
		if(index< right)
		{
			quickSort(array, index, right);
		}
	}
	
	private int partition(int[] array, int left, int right)
	{
		int pivot = array[(left+right)/2];//pick pivot point
		while(left<right)
		{
			while(array[left]<pivot) left++;
			while(array[right]> pivot) right--;
			//swap
			if(left< right)
			{
				swap(array, left, right);
				left++; right--;
			}
		}
		return left;
	}
	
	private void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void mergeSort(int[] array, int low, int high)
	{
		if(low< high){
		int middle = (low+ high)/2;
		mergeSort(array, low, middle);
		mergeSort(array, middle+1, high);
		merge(array, low, middle, high);
		}
	}
	
	private void merge(int[] array, int low, int middle, int high)
	{
		int[] helper= new int[array.length];
		
		//copy array to helper
		for(int i= low; i<= high; i++)
		{
			helper[i] = array[i];
		}
			
		int left = low;
		int right = middle+1;
		int current = low;
	
		while(left<=middle && right <=high)
		{
			if(helper[left] <= helper[right])
			{
				array[current] = helper[left];
				left ++;
			}
			else
			{
				array[current] = helper[right];
			}
			current ++;
		}
		
		//copy the rest of the left
		int remaining = middle - left;
		for(int i = 0; i<= remaining; i++)
		{
			array[current+i] = helper[left+i];
		}
	
	}
	
	//buttom up build heap
	public void buildHeap(ArrayList<ListNode> lists)
	{
		int size = lists.size();
		int start = (size-2)/2; //start is assigned the index in a of the last parent node
		while(start >=0)
		{
			//sift down the node at index start to the proper place such that all nodes below
	        //the start index are in heap order
			downHeap(lists, start, size-1);
			start--;
		
		}
	}

	//down heap
	public void downHeap(ArrayList<ListNode> heap, int start, int end)
	{
        int root = start;
        while(root*2 +1 <= end)
        {
        	int child = root*2 +1;// left
        	int swap = root;
        	
        	if(heap.get(swap).val > heap.get(child).val)
        	{
        		swap = child;
        	}
        	if( child+1 <=end && heap.get(swap).val> heap.get(child+1).val)
        	{
        		swap = child + 1;
        	}
        	if(swap!= root)
        	{
        		//swap elem
    			ListNode temp = heap.get(swap);
    			heap.set(swap,heap.get(root));
    			heap.set(root, temp);
    			root = swap;
        	}
        	else
        		return;
        }
	}
	

	public int binarySearch(int[] a, int x)
	{
		int low = 0;
		int high = a.length -1;
		int middle;
		
		while(low <= high)
		{
			middle = (low+ high)/2;
			if(x==a[middle]) return middle;
			if(x< a[middle])
			{
				high = middle -1;
			}
			else if(x> a[middle])
			{
				low = middle+1;
			}
		}
		return -1;
	}

	public int binarySearchRecursive(int[] a, int x, int left, int right)
	{
		if(left>right) return -1;
		int middle = (left + right)/2;
		if(x==a[middle]) return middle;
		else if(x< a[middle]) return binarySearchRecursive(a, x, left, middle -1);
		else return binarySearchRecursive(a, x, middle+1, right);
	}

	
	
}
