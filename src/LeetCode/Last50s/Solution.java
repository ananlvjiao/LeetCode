package LeetCode.Last50s;

import java.util.ArrayList;

public class Solution {
	
	//http://oj.leetcode.com/problems/decode-ways/
	public int numDecodings(String s) {
		if(s== null|| s.length() == 0) return 0;

		int len = s.length();
		int[] dp = new int[len+1];  
	    dp[0] = 1;  
	    
	    if (isValid(s.substring(0,1))) dp[1] = 1;  
	    else dp[1] = 0;  
		
		
		for(int i= 2; i<= len; i++)
		{
			 if (isValid(s.substring(i-1,i)))  
	                dp[i] = dp[i-1];  
	            if (isValid(s.substring(i-2,i)))  
	                dp[i] += dp[i-2];  
		}
		
		return dp[len];
	}
	 public boolean isValid(String s){  
	        if (s.charAt(0)=='0') return false;  
	        int code = Integer.parseInt(s);  
	        return code>=1 && code<=26;  
	    }  

	 public ArrayList<String> restoreIpAddresses(String s) {
	        ArrayList<String> results = new ArrayList<String>();
	        
	        if (s == null || s.length() == 0) return results;
	        restoreIPs(results, s, "", 4);
	        return results;
	    }
	    
	    
	    public void restoreIPs(ArrayList<String> results, String s, String ip, int count)
	    {
	        int len = s.length();
	        if(count== 1) {
	        	if(len==0) return;
        		if(!isValidIPAddress(s)) return;
        		else{results.add(ip+"."+s); return;}
	        }
	        else
	        {
	        	if(count != 4)
	        	{
	        		ip =ip+".";
	        	}
	            if(len>=1 && isValidIPAddress(s.substring(0, 1)))
	            {
	                restoreIPs(results, s.substring(1,len), ip+s.substring(0,1), count-1);
	            }
	            if(len>=2 && isValidIPAddress(s.substring(0,2)))
	            {
	                restoreIPs(results, s.substring(2,len), ip+s.substring(0,2), count-1);
	            }
	            if(len>=3 && isValidIPAddress(s.substring(0,3)))
	            {
	                restoreIPs(results, s.substring(3,len), ip+s.substring(0,3), count-1);
	            }
	        }
	        
	    }
	    
	    public boolean isValidIPAddress(String s)
	    {
	    	int val =0;
	    	try{
	    		if(s.startsWith("0") && s.length()>1) return false;
	    		val = Integer.parseInt(s);
	    		if(val >= 0 && val<= 255) return true;
		        else return false;
	    	}
	    	catch(Exception ex)
	    	{
	    		return false;
	    	}
	        
	    }

	    public ArrayList<Integer> findCommons(int[] A, int[] B)
	    {
	        if(A== null || B == null) return null;
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        int aLen = A.length;
	        int bLen = B.length;
	        int i = 0; int j= 0;
	        while(i<aLen && j<bLen){
	           while(A[i]<B[j]&& i<aLen){i++;}

	           while(A[i]>B[j]&& j<bLen){j++;} 
	           //compare if the same
	           if(A[i]==B[j]){result.add(A[i]);}
	           i++; j++;
	        }
	        return result;
	    }
}
