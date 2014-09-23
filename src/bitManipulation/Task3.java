package bitManipulation;

import java.util.ArrayList;

public class Task3 {
	//page 92
	//get binary presentation
//	public int getNextSmallest(ArrayList<Integer> bits)
//	{
//		int len = bits.size();
//		if(bits.get(len-1)==0)
//		{
//			while(bits)
//			
//		}
//	}
//	
//	public int getNextBiggest(ArrayList<Integer> bits)
//	{}
	
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
}
