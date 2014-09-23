package bitManipulation;

import java.util.ArrayList;

public class Sample {
	
	//One final neat trick of bitwise operators is that you can use them, in conjunction with a bit of math, 
	//to find out whether an integer is a power of two. 
	public boolean isIntegerPowerOfTwo(int val)
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
		if(oneBitLocs.size() == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//http://www.cprogramming.com/tutorial/powtwosol.html
	//beautiful solution; 0100-1 = 0011 0100&0011 = 0
	
	public boolean is_power(int x)
	{
	    return (((x-1) & x)==0);
	}

    public int findMissingOne(int[] array)
    {
    	int preCal = 1;
    	for(int i= 2; i<array.length+2; i++)
    	{
    		preCal = preCal^i;
    	}
    	for(int i= 0; i< array.length; i++)
    	{
    		preCal = preCal^array[i];
    	}
    	return preCal;
    }
}
