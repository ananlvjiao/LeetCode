package LeetCode.Practise;

import LeetCode.Helper.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution4 {

	public static void func() throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        String line2 = br.readLine();
        String[] nums = line2.split(" ");
        if(nums.length!=3)
        {    System.out.println("error input");
        }
        int k = Integer.parseInt(nums[0]);
        int l = Integer.parseInt(nums[1]);
        int m = Integer.parseInt(nums[2]);
        String line3 = br.readLine();
        System.out.println("enter func");
        findMostFrequentString(line3, k, l, m);
	}
	public static void findMostFrequentString(String s, int k, int l, int m)
    {

        HashMap<String, Integer> dict = new HashMap<String,Integer>();
        int sLen= s.length();
        
        HashSet<Character> hset;
        for(int i= 0; i< sLen; i++ )
        {
        	
            hset = new HashSet<Character>();
            //add k into hset
            for(int a= i; a<i+k; a++)
            {
            	if(a>=sLen){break;}
                char c = s.charAt(a);
                hset.add(c);
                if(hset.size() > m)
                {
                    continue;
                }
            }
                
            for(int j =k; j<= l; j++)
            {
                if(i+j>sLen){break;}
                char c = s.charAt(i+j-1);
                if(hset.size() > m)
                {
                    continue;
                }   
                String subStr = s.substring(i,i+j);
                Integer cnt = dict.get(subStr);
                if(cnt== null)
                {
                    dict.put(subStr, 1);
                }
                else
                {
                    dict.put(subStr,cnt +1);
                }
            }
            
        }
        
        //go through the dict find the most frequency
        int maxCount = 0;
        Iterator iter = dict.keySet().iterator();
        while(iter.hasNext())
        {
            String key = (String)iter.next();
            int count = (Integer) dict.get(key);
            if(count> maxCount)
            {
                maxCount = count;
            }
        }
        
        System.out.println(maxCount);
        
    }

	  public ArrayList<String> anagrams(String[] strs) {
	        if(strs == null) return null;
	        ArrayList<String> result = new ArrayList<String>();
	        if(strs.length == 0) return result;
	        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	        for(String str: strs)
	        {
	            String sortedStr = sortChars(str);
	            ArrayList<String> list = map.get(sortedStr);
	            if(list == null)
	            {
	                list = new ArrayList<String>();
	            }
	            list.add(str);
                map.put(sortedStr, list);
	        }
	        for(ArrayList<String> list : map.values())
	        {
	            if(list.size()>1)
	            {
	                result.addAll(list);
	            }
	        }
		  return result;
		   
	    }
	    public String sortChars(String s)
	    {
	        char[] content = s.toCharArray();
	        Arrays.sort(content);
	        return new String(content);
	    }
	    
	    public TreeNode sortedListToBST(ListNode head) {
	        
	        ListNode pointer = head;
	        int count = 0;
	        while(pointer!= null)
	        {
	            pointer = pointer.next;
	            count++;
	        }
	        
	        if(count == 0) return null;
	        
	        return buildTreeWithList(head, 0, count);
	        
	        
	    }
	    
	    public TreeNode buildTreeWithList(ListNode node, int s_index, int e_index)
	    {
	        if (e_index - s_index == 0)
				return null;
			int mid_index = s_index + (e_index - s_index) / 2;
			// build root
			TreeNode tnode = buildTreeWithList(node.next, s_index, mid_index + 1);
			tnode.left = new TreeNode(node.val);  
			tnode.right = buildTreeWithList(node.next, mid_index, e_index);
			return tnode;
	    }
	    public String countAndSay(int n) {
	       return countAndSay(n, "1");
	    }
	    
	    public String countAndSay(int n, String seq) {
	        if(n==1)
	        return seq;
	        else
	        {
	            StringBuilder sb = new StringBuilder();
	            int count = 1; 
	            int val = seq.charAt(0) -48;
	            for(int i = 1; i<seq.length(); i++)
	            {
	            	int newVal = seq.charAt(i)-48;
	                if(newVal!= val)
	                {
	                    sb.append(count);
	                    sb.append(val);
	                    val = newVal;
	                    count = 1;
	                }
	                else
	                {
	                    count ++;
	                }
	            }
	            sb.append(count);
	            sb.append(val);
	            n--;
	            return countAndSay(n, sb.toString());
	        }
	    }
	    
	    public int numDecodings(String s) {
	    	int[] states = new int[s.length()];
	    	for(int i= 0; i< states.length; i++)
	    	{
	    		states[i] = -1;
	    	}
	        return numDecodings_RM(states, s,0);
	    }
	    
	    public int numDecodings_R(String s, int cur) {
	       if(cur >= s.length())
	       {
	           return 1;
	       }
	       char c = s.charAt(cur);
	       if(c == 49 || c== 50){
	           if(cur+1 < s.length() && s.charAt(cur+1)<55)
	           {
	        	   return numDecodings_R(s, cur+1) 
	            		   + numDecodings_R( s, cur+2);
	           }
	       }
	       
	       return numDecodings_R( s, cur+1); 
	    }
	    
	    public int numDecodings_RM(int[] states, String s, int cur) {
		       if(cur >= s.length()-1)
		       {
		           return 1;
		       }
		       char c = s.charAt(cur);
		       if(c==48) {states[cur]=0; return 0;}
		       if(states[cur]== -1){states[cur] =numDecodings_RM(states, s, cur+1);  }
		       if(states[cur+1]== -1){states[cur+1] =numDecodings_RM(states,s, cur+2);  }
		       else if(c == 49 || c== 50){
		           if(cur+1 < s.length() && s.charAt(cur+1)<55 && s.charAt(cur+1)>48)
		           {
		               
		               return states[cur] + states[cur+1];

		           }
		           else if(s.charAt(cur+1)== 48)
		           {
		        	   return states[cur+1];
		           }	   
		       }
		       return states[cur]; 
		    }
}
