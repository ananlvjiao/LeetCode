package LeetCode.StringSearch;

import java.util.*;


public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int count = L.length;
        if(count == 0 || S.length()==0)
            return indices;
        
        int dictLen = L[0].length();
        int last = S.length() - dictLen * count;
        if(last < 0 )
            return indices;
        //build hash map for L;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i< count; i++)
        {
            if(map.get(L[i])== null)
            {
                map.put(L[i], -1);
            }
        }
        int mSize = map.size();
        int mCount = 0;
        for(int i = 0; i<= last; i++)
        {
            String s = S.substring(i, i+dictLen);
            if(map.get(s) != null)
            {
	            while(map.get(s) != null)
	            {
	                int index = map.get(s);
	                if(index == -1)
	                {
	                    map.put(s, i);
	                    mCount ++;
	                }
	                else
	                {
	                    int rCount = resetPartialMap(map, index);
	                    map.put(s, i);
	                    mCount -=rCount;
	                    mCount ++;
	                }
	                if(mCount == mSize) break;
	                i = i+ dictLen;
	                if(i> S.length()) break;
	                s = S.substring(i, i+dictLen);
	            }
	            int minIndex = resetMap(map);
	            if(minIndex!= -1)
	            {
	                indices.add(minIndex);
	            }
            }
        }
        return indices;
    }
    
    public int resetPartialMap(HashMap<String, Integer> map, int index)
    {
    	int count = 0;
        Iterator iter = map.keySet().iterator();
        while(iter.hasNext())
        {
           String key = (String) iter.next();
           if(map.get(key) < index)
           {
        	   	count++;
                map.put(key, -1);
           }
        }
        return count;
    }
    
    public int resetMap(HashMap<String, Integer> map)
    {
        int size = map.size();
        int count = 0;
        int minIndex =0;
        Iterator iter = map.keySet().iterator();
        while(iter.hasNext())
        {
           String key = (String) iter.next();
           int index = map.put(key, -1);
           if(index!= -1)
           {
               if(count==0 || index < minIndex)
               {
                   minIndex = index;
               }
               count++;
           }
        }
        if(count == size)
        {
            return minIndex;
        }
        else
        {
            return -1;
        }
    }

    public int BFPatternMatching(String S, String T)
    {
    	int si = 0; int ti = 0; 
    	while(si<S.length() && ti<T.length())
    	{
    		if(S.charAt(si)== T.charAt(ti))
    		{
    			si++; ti++;
    		}
    		else
    		{
    			if(ti==0 && si==S.length()-T.length()+1)
    			{
    				return 0;
    			}
    			si= si-ti+1;
    			ti=0;
    		}
    		
    	}
    	if(ti==T.length())
    	{
    		return si-ti+1;
    	}
    	else
    	{
    		return 0;
    	}
    }

    public int KMPPatternMatching(String S, String T)
    {
    	int[] Tkmp = buildKMPTable(T);
    	int sLen = S.length();
    	int tLen= T.length();
    	int i = 0;
    	int j= 0;
    	while(i < sLen && j< tLen)
    	{
    		if(T.charAt(j) == S.charAt(i))
    		{
    			i++; j++; 
    		}
    		else
    		{
    			if(j==0)
    			{
    				if(i==sLen- tLen +1)
    					return 0;
    				else 
    					i++;
    			}
    			j = Tkmp[j];
    		}
    	}
    	if(j==tLen)
    	{
    		return i-j+1;
    	}
    	else
    	{
    		return 0;
    	}
    }
    
    public int[] buildKMPTable( String T)
    {
    	int len = T.length();
    	int[] Tkmp = new int[len];
    	if(len ==0) return Tkmp;
    	Tkmp[0] = -1; 
    	if(len<2) return Tkmp ;
    	Tkmp[1]= 0;
    	for(int i= 2; i< len; i++)
    	{
			int cIndex = Tkmp[i-1];
			if(T.charAt(cIndex)==T.charAt(i-1))
			{
				Tkmp[i]= Tkmp[i-1]+1;
			}
    	}
    	return Tkmp;
    }
    
}
