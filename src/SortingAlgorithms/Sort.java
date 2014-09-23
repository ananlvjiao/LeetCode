package SortingAlgorithms;

public class Sort {
	
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

	public void HeapSort()
	{}
		
	public void RadixSort()
	{}
	
	public void InsertionSort()
	{
		
	}
	
	public void SelectionSort()
	{}
	
	public void BubbleSort()
	{}
	
	public void IntegerSort()
	{}


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

	public int findValueIndex(int X[], int val)
    {
	  if(val < X[0]) return -1;
      if(val > X[X.length-1]) return X.length;
      int low = 0;
      int high = X.length-1;
      int middle = (low + high)/2;
      
      while(low<= high && middle>low && middle<high)
      {
          if((val == X[middle]) || (val>X[middle] && val<X[middle+1]))
          {
              return middle+1;
          }
          else if(val<X[middle] && val>X[middle-1] )
          {
              return middle;
          }
          else if(val<X[middle]) {high = middle-1;}
          else {low = high+1;}
          middle = (low + high)/2;
      }
      return -1;
    }

	public int[] sortDistinctIntegers(int[] a, int min, int max){  
        int N = (max-min) / 8 + 1;  
        byte[] bitmap = new byte[N]; //initialized to 0  
          
        for(int i = 0; i < a.length; i++)  
             bitmap[a[i]/8] |= 1 << (a[i] % 8);  
          
        int k = 0;  
        for(int i = 0; i < N; i++){  
             for(int j = 0; j < 8; j++){  
                  if((bitmap[i] & (1 << j)) > 0){  
                       a[k] = i * 8 + j + min;  
                       k++;  
                  }  
             }  
        }  
          
        return a;  
   }  

}

