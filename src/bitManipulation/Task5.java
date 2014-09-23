package bitManipulation;

public class Task5 {

	public int numberOfBitsToConvert(int x, int y)
	{
		int diff = x^y;
		int i= 0;
		for(; diff!= 0; diff = diff & (diff-1))
		{
			i++; 
		}
		return i;
	}
	
	public int numberOfOnes(int val)
	{
		int count =0;
		for(; val!=0; val = val & (val-1))
		{
			count ++; 
		} 
		return count;
	}
}
