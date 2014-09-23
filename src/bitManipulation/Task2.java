package bitManipulation;

public class Task2 {
   //page 92
	public char[] printBinary(double val)
	{
		if(val>1 || val< 0)
		{
			return new char[]{'E','R','R','O','R'};
		}
		char[] result = new char[32];
		int limit = 32;
		int i=0;
		while(i< limit && val != 0)
		{
			if(val*2>=1)
			{
				result[i]='1';
				val = val*2-1;
			}
			else
			{
				result[i]='0';
				val = val *2;
			}
			i++;
			
		}
		if(i== limit && val!= 0)
		{
			return new char[]{'E','R','R','O','R'};
		}
		return result;
	}
}
