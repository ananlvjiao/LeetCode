package LeetCode.ReverseInteger;

public class Solution {
	
	public int reverse(int x) {
        int result = 0;
        int absX = Math.abs(x);
        while(absX >= 10 )
        {
            int d = absX%10;
            absX = absX/10;
            result = result * 10;
            result = result + d;
        }
        result = result * 10;
        result = result + absX;
        if(x< 0)
        {return -result;}
        else
        {return result;}
    }

}
