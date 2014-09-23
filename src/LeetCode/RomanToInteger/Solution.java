package LeetCode.RomanToInteger;

import java.util.ArrayList;

public class Solution {
	public int romanToInt(String s) {
		// I 1
		// V 5
		// X 10
		// L 50
		// C 100
		// D 500
		// M 1,000
		if(s== null) return 0;
		int count = s.length();
		int result = 0;
		int i = 0;
		while (i < count) {
			switch (s.charAt(i)) {
			case 'M':
				result += 1000;
				break;
			case 'D':
				result += 500;
				break;
			case 'C':
				if(i+1<count && s.charAt(i+1)== 'D')
				{
					result += 400;
					i++;
				}
				else if(i+1<count && s.charAt(i+1)== 'M')
				{
					result += 900;
					i++;
				}
				else
				{
					result += 100;
				}
				break;
			case 'L':
				result += 50;
				break;
			case 'X':
				if(i+1<count && s.charAt(i+1)== 'L')
				{
					result += 40;
					i++;
				}
				else if(i+1<count && s.charAt(i+1)== 'C')
				{
					result += 90;
					i++;
				}
				else
				{
					result += 10;
				}
				break;
			case 'V':
				result += 5;
				break;
			case 'I':
				if(i+1<count && s.charAt(i+1)== 'V')
				{
					result += 4;
					i++;
				}
				else if(i+1<count && s.charAt(i+1)== 'X')
				{
					result += 9;
					i++;
				}
				else
				{
					result += 1;
				}
				break;
			default:
				return 0;
			}
			i++;
		}
		return result;

	}
	
	
	public String intToRoman(int num) {
//		I	1 IV 4 IX 9
//		V	5
//		X	10 XL 40 XC 90
//		L	50
//		C	100 CD 400 CM 900
//		D	500
//		M	1,000
		ArrayList<String> sa = new ArrayList<String>();
		String romans = new String("IVXLCDM");
        
        int r_index = 0;
        int ten = 10;
        while(num!= 0)
        {
        	int digit = num%ten;
        	num = num/ten;
        	sa.add(digitToRomans(r_index, digit, romans));
        	r_index +=2;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i= sa.size()-1; i>=0; i--)
        {
        	sb.append(sa.get(i));
        }
        return sb.toString();
	}
	
	public String digitToRomans(int r_index, int digit, String romans)
	{
		StringBuilder sb = new StringBuilder();
		if(digit>=5)
    	{
    		if(digit==9)
    		{
    			sb.append(romans.charAt(r_index));
    			sb.append(romans.charAt(r_index + 2));
    		}
    		else
    		{
    			sb.append(romans.charAt(r_index +1));
    			digit = digit-5;
    			while(digit!=0)
    			{
    				sb.append(romans.charAt(r_index));
    				digit --;
    			}
    		}
    	}
    	else
    	{
    		if(digit==4)
    		{
    			sb.append(romans.charAt(r_index));
    			sb.append(romans.charAt(r_index + 1));
    		}
    		else
    		{
    			while(digit!=0)
    			{
    				sb.append(romans.charAt(r_index));
    				digit --;
    			}
    		}
    	}
		return sb.toString();
	}
	
}
