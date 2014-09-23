package LeetCode.ValidNumber;

public class Solution {
    public boolean isNumber(String s) {
        
        //not valid . + - 
        //negative
        //bigger than double
        String s1 = s.trim();
        if(s1.length() == 0) return false;
        //find index of e/E
        int e_index = hasE(s1);
        if(e_index == -1) return false;
        //if(e_index == s1.length()-1) return false; //e_index is the last return false
        if(e_index == 0)
        {
        	return isValidNumber(s1);
        }
        return isValidNumber(s1.substring(0,e_index)) 
        		&& isValidInteger(s1.substring(e_index+1, s1.length()));

    }
    
    public int hasE(String s)
    {
    	//-1 not valid, 0 no E, i e index
    	boolean oneE = false;
    	int e_index = -1;
    	for(int i =0; i< s.length(); i++)
    	{
    		if(s.charAt(i) == 'e' || s.charAt(i) == 'E')
    		{
    			if(oneE) return -1;
    			if(i==0) return -1;
    			e_index = i;
    			oneE = true;
    		}
    	}
    	if(!oneE) return 0;
    	return e_index;
    }
    
    public int hasSign(String s)
    {
        char head = s.charAt(0);
        if(head == 45| head ==43)
        {
            return 1;
        }
        if((head > 57 || head<48) && head!=46)
        {
            return -1;
        }
        return 0;
    }
    
    public boolean isValidInteger(String s)
    {
    	if(s.length()==0) return false;
    	int hasSign = hasSign(s);
        if(hasSign == -1) return false;
        if(hasSign == 1) 
        {
           s = s.substring(1, s.length());
        }
        if(s.length() == 0) return false;
        for(int i= 0; i< s.length(); i++)
        {
        	char x = s.charAt(i);
	    	if(x > 57 || x< 48 )
	        {
	            return false;
	        }
        } 
    	return true;
    }
    
    public boolean isValidNumber(String s)
    {
    	if(s.length()==0) return false;
    	int hasSign = hasSign(s);
        if(hasSign == -1) return false;
        if(hasSign == 1) 
        {
           s = s.substring(1, s.length());
        }
        return checkNumber(s);
    }
    
    public boolean checkNumber(String s)
    {   	
    	if(s.length() == 0) return false;
        boolean hasPoint = false;
        for(int i= 0; i< s.length(); i++)
        {
            char x = s.charAt(i);
            if((x > 57 || x< 48 ) && x!= 46)
            {
                return false;
            }
            else if(x == 46)
            {
                if(hasPoint) return false;
                else 
                {
                	// if point is the last return false
                	if(i == s.length() -1 && i==0)
                	{
                		return false;
                	}
                	hasPoint = true;
                	
                }
            } 
            
        }
        return true;
    }
}
