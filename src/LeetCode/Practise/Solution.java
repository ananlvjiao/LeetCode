package LeetCode.Practise;

import java.util.*;

import LeetCode.Helper.Interval;
import LeetCode.Helper.ListNode;
import LeetCode.Helper.TreeNode;


public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if(len< 2) return 0;
        int[] val = new int[len];
        for(int i= 0; i< len; i++)
        {
            val[i]= gas[i]-cost[i];
        }
        int startIndex =0;
        int currVal = 0;
        int i = 0;
        while(i< len)
        {
            currVal += val[i];
            while(currVal<0)
            {
                startIndex = getCircleIndex(startIndex-1, len);
                if(startIndex == i) return -1;
                currVal+=val[startIndex];
            }
            i++;
            if(i==startIndex) return startIndex;
        }
        return -1;
    }
    
    public int getCircleIndex(int i, int len)
    {
        if(i<0) return len+i;
        else return i;
    }

    public boolean isMatch(String s, String p) {
        //if "?" match single one
        //if "*" move to next one, and loop p till find match one, aabbcde, a*bcd?
        if(s== null || p == null) return false;
        int sLen= s.length();
        int pLen= p.length();
        
        boolean matches[][] = new boolean[sLen+1][pLen+1];
        
        matches[0][0]= true;

        for(int i= 1; i<= sLen; i++)
        {
            for(int j= 1; j<= pLen; j++)
            {
                char cs = s.charAt(i-1);
                char cp = p.charAt(j-1);
                if(cs == cp || cp == '?') 
                { 
                    matches[i][j] = true && matches[i-1][j-1];
                }
                else if(cp == '*')
                {
                    if(j-1 == 0) {matches[i][j] = true;}
                    for(int k = 1; k<= i; k++)
                    {
                        if(matches[i-k][j-1]) {
                            matches[i][j] = true;
                            break;
                            }
                    }
                    matches[i][j] = false;
                }
                else
                {
                    matches[i][j] = false;
                }
            }
        }
        
        return matches[sLen][pLen];
    }

    public boolean isPalindrome(int x) {
        //negative number
        int absX = Math.abs(x);
        int count = 0;
        while(absX > 0)
        {
            absX = absX/10;
            count++;
        }
        
        x = Math.abs(x);
        while(x<10)
        {
            //get high val
            int h = (int) (x/ Math.pow(10, count-1));
            x = (int) (x- h* Math.pow(10, count-1));
            int l = x % 10;
            x = x/10;
            count = count-2;
            if(h!=l)
            {
                return false;
            }
        }
        return true;
        
    }

    public int minCut(String s) {
        if(s== null) return 0;
        
        int len = s.length();
        if(len < 2) return 0;
        if(isPalindrome(s)) return 0;
        
        int[][] cuts = new int[len][len];
        for(int i = 0; i< len; i++)
        {
            for(int j = 0; j< len; j++)
            {
                cuts[i][j]= -1;
            }
        }
        minCut_D(s, cuts, 0, len-1);
        return cuts[0][len-1]-1;
    }
    
    public int minCut_D(String s, int[][] cuts, int i, int j) {
        int min = 1000000;
        
        for(int k = j; k >= i; k--)
        {
            if (cuts[i][k]== -1)
            {
                if(isPalindrome(s.substring(i, k+1)))
                {
                    if(k == j) 
                    {
                        cuts[i][j] = 1;
                        return cuts[i][j];
                    }
                    else
                    {
                        if(cuts[k+1][j]== -1){
                            cuts[k+1][j] = minCut_D(s, cuts, k+1, j);
                        }
                        if(min> 1 + cuts[k+1][j])
                        {
                            min= 1 + cuts[k+1][j];
                        }
                    }
                }
            }
        }
        cuts[i][j]= min;
        return cuts[i][j];
    }
     public boolean isPalindrome(String s)
    {
        int len = s.length()-1;
        int i = 0;
        while(i<len)
        {
            if(s.charAt(i) != s.charAt(len))
            {
                return false;
            }
            i++;
            len--;
        }
        return true;
    }
     
     public ArrayList<Integer> grayCode(int n) {
         //recursive
         ArrayList<Integer> results = new ArrayList<Integer>();
         if(n<1) return results;
         if(n==1) 
         {
             results.add(0);
             results.add(1);
             return results;
         }
         
         ArrayList<Integer> lastRes = grayCode(n-1);
         results.addAll(lastRes);
         int size = lastRes.size();
         for(int i= size-1; i>=0; i--)
         {
             int val = (int) (lastRes.get(i) + Math.pow(2, n-1));
             results.add(val);
         }
         return results;
     }

     public int[][] generateMatrix(int n) {
         int count = n*n;
         int[][] matrix = new int[n][n];
         int i =1;
         int row = 0; int column = 0;
         int dis = 0;
         boolean first = true;
         while(i<=count)
         {
              if(column == dis && row == dis)
             {
            	  if(first)
            	  {
            		  first = false;
            	  }
            	  else
            	  {
	                 dis++;  
	                 row = dis;
	                 column = dis;
            	  }
                 
             }

             matrix[row][column] = i;
             i++;
             if(row==dis && column < n-dis-1)
             {
                 column++;continue;
             }
             if(column == n-dis-1 && row < n-dis-1)
             {
                 row++;continue;
             }
             if(row==n-dis-1 && column>dis )
             {
                 column--;continue;
             }
             if(column == dis && row >dis)
             {
                 row--;continue;
             }
             
         }
         return matrix;
     }

     public boolean searchMatrix(int[][] matrix, int target) {
         int rowsize = matrix.length;
         int colusize = matrix[0].length;
         
         int row = findRow(0, rowsize-1, target, matrix);
         if(row == -1) return false;
         
         return findValue(0, colusize-1, target, matrix, row);
     }
     
     public int findRow(int low, int high, int target, int[][] matrix)
     {
         if(high<low)
             return -1;    
         int midIndex = (low+high)/2;

         if(matrix[midIndex][0] < target)
         {
             return findRow(midIndex+1, high, target, matrix);
         }
         else if(matrix[midIndex][0] > target)
             return findRow(low, midIndex-1, target, matrix);
         else
             return midIndex;
             
     }
     
     public boolean findValue(int low, int high, int target, int[][] matrix, int row)
     {

         if(high<low)
             return false;
         int midIndex = (low+high)/2;
         if(matrix[row][midIndex] < target)
             return findValue(midIndex+1, high, target, matrix, row);
         else if(matrix[row][midIndex] > target)
             return findValue(low, midIndex-1, target, matrix, row);
         else
             return true;
             
     }

     public ArrayList<ArrayList<Integer>> combine(int n, int k) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
         
         result = combine(0, n, k);
         return result;
         
     }
     
     public ArrayList<ArrayList<Integer>> combine(int m, int n, int k) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
         if(k==1)
         {
             for(int i=m; i< n; i++)
             {
                 ArrayList<Integer> list = new ArrayList<Integer>();
                 list.add(i+1);
                 result.add(list);
             }
         }
         else
         {
              for(int i=m; i< n; i++)
             {
            	 
                 ArrayList<ArrayList<Integer>> prevresult = combine(i+1,n, k-1);
                 for(int j=0; j< prevresult.size(); j++)
                 {
                     prevresult.get(j).add(0, i+1);
                 }
                 result.addAll(prevresult);
             }
         }
         return result;
     }

     public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
         Arrays.sort(num);
         return combine(num, 0, 0, target);
     }
     
     public ArrayList<ArrayList<Integer>> combine(int[] candidates, int m, int times, int target) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
         if( target < 0)
         {
             return result;
         }
         else
         {
             
              for(int i=m; i< candidates.length; i++)
             {
                 if(times== 0)
                 {
                     while(i+1<candidates.length && candidates[i] == candidates[i+1])
                     {
                         times++;
                         i++;
                     }
                 }
                 int next = i;
                 if(times == 0) next = i+1; 
                 if(target-candidates[i]>0)
                 {
                     if(times> 0) {times--;}
                     ArrayList<ArrayList<Integer>> prevresult = combine(candidates, next, times ,target-candidates[i]);
                     for(int j=0; j< prevresult.size(); j++)
                     {
                         prevresult.get(j).add(0,candidates[i]);
                     }
                     result.addAll(prevresult);
                 }
                 else if (target-candidates[i] == 0)
                 {
                     if(times> 0) {times--;}
                     ArrayList<Integer> res = new ArrayList<Integer>();
                     res.add(candidates[i]);
                     result.add(res);
                    
                 }
                 else 
                     break;
             }
         }
         return result;
     }

     public ArrayList<String> letterCombinations(String digits) {
         
         ArrayList<String> optionList = new ArrayList<String>();
         for(int i= 0; i< digits.length(); i++)
         {
             char d = digits.charAt(i);
             optionList.add(digitToString(d));
         }
         return combine(optionList, 0);
     }
     
     public ArrayList<String> combine(ArrayList<String> optionList, int k)
     {
         ArrayList<String> result = new ArrayList<String>();   
         String kStr = optionList.get(k);
         if(k==optionList.size()-1 )
         {
             for(int i=0 ; i< kStr.length(); i++ )
             {
                 String str = new String(String.valueOf(kStr.charAt(i)));
                 result.add(str);
             }
         }
         else
         {
              for(int i=0 ; i< kStr.length(); i++ )
             {
                 ArrayList<String> prevresult = combine(optionList, k+1);
                 for(int j= 0; j< prevresult.size(); j++)
                 {
                     String str = String.valueOf(kStr.charAt(i)) + prevresult.get(j);
                     result.add(str);
                 }
             }
         }
         return result;
     }
     
     public String digitToString(char digit)
     {
         StringBuilder sb = new StringBuilder();
         int val = digit- 48;
         if(val==0 || val == 1)
         {
             return "";
         }
         // a = 97
         for(int i= 0; i< 3; i++)
         {
             int tv = 0;
             if(val>7)
             {
                 tv = (val-2)*3+1;
             }
             else
             {
                tv = (val-2)*3; 
             }
         
             char t = (char) (97+tv+i);
             sb.append(t);
         }
         if(val == 9)
         {
             sb.append('z');
         }
         if(val == 7)
         {
             sb.append('s');
         }
         return sb.toString();
     }
     
     
     public boolean isValid(String s) {
         Stack<Character> pStack = new Stack<Character>();
         for(int i= 0; i< s.length(); i++)
         {
             char c = s.charAt(i);
             if(c=='(' || c=='{' || c=='[')
             {
                 pStack.push(c);
             }
             else
             {
                 if(pStack.isEmpty())
                 {
                     return false;
                 }
                 char cl = pStack.pop();
                 if( (c == ')' && cl=='(') || (cl=='{' && c=='}') || (c ==']' && cl=='['))
                 {
                     continue;
                 }
                 else
                 {
                     return false;
                 }
             }
         }
         return true;
     }

     public int sumNumbers(TreeNode root) {
         int sum = 0;
         ArrayList<Integer> numbers =  getPath(root);
         for(int i=0; i< numbers.size(); i++)
         {
             sum += numbers.get(i);
         }
         return sum;
     }
     
     public ArrayList<Integer> getPath(TreeNode root)
     {
         ArrayList<Integer> results = new ArrayList<Integer>();
         if(root.left == null && root.right == null)
         {
              results.add(root.val);
              return results;
         }
         if(root.left!= null)
         {
             ArrayList<Integer> leftResults = getPath(root.left);
             for(int i = 0; i< leftResults.size(); i++)
             {
                 int newNu = addNumberToHighPos(leftResults.get(i), root.val);
                 results.add(newNu);
             }
         }
         if(root.right!= null)
         {
             ArrayList<Integer> rightResults = getPath(root.right);
             for(int i = 0; i< rightResults.size(); i++)
             {
                 int newNu = addNumberToHighPos(rightResults.get(i), root.val);
                 results.add(newNu);
             }
         }
         return results;
     }
     
     public int addNumberToHighPos(int lows, int high)
     {
         int i = 0;
         int lcnt = lows;
         while(lcnt/10!=0)
         {
        	 lcnt = lcnt/10;
             i++;
         }
         return (int) (high * Math.pow(10,i+1) + lows);
         
     }

     public int divide(int dividend, int divisor) {
         if(dividend == 0 || divisor == 0) return 0;
     
         long absDivident = Math.abs((long)dividend);
         long absDivisor = Math.abs((long)divisor);
         long absDivisor2 = Math.abs((long)divisor);
         
         int result = 0;
         if(absDivisor == 1) result = (int)absDivident;
         else
         {
             int count = 1 ;
             // get maxium pow (2, count)
             while(absDivident > absDivisor)
             {
                 absDivisor = absDivisor<<1;
                 count = count<<1;
             }
             
             while(absDivisor >= absDivisor2)
             {
                 
                 if(absDivident - absDivisor>= 0)
                 {
                     result += count;
                     absDivident -= absDivisor;
                 }
                 else
                 {
                     absDivisor >>= 1;
                     count >>= 1;
                 }
             }
             
         }
         if(dividend> 0 && divisor>0 || dividend<0 &&divisor<0)
         {
             return result;
         }
         else
         {
             return -result;
         }
     }

     public int[] plusOne(int[] digits) {
         if(digits == null) return null;
         int len = digits.length;
         if(len == 0) return digits;
         
         boolean add = true;
         for(int i =len-1; i>=0 ; i--)
         {
             if(add)
             {
                 int val = digits[i]+1;
                 if(val > 9)
                 {
                     digits[i] = val - 10;
                 }
                 else
                 {
                     add = false;
                 }
             }
             else
             {
                 break;
             }
             
         }
         
         if(add)
         {
             int[] ret = new int[len+1];
             ret[0] = 1;
             for(int i= 1; i< len+1; i++)
             {
                 ret[i] = digits[i-1];
             }
             return ret;
         }
         else
         {
             return digits;
         }
     }

     public String addBinary(String a, String b) {
         if(a == null) return b;
         if(b == null) return a;
      int alen = a.length();
      if(alen == 0) return b;
      int blen = b.length();
      if(blen == 0 ) return a;
      
      StringBuilder sb = new StringBuilder();
      int len = Math.max(alen, blen);
      boolean add = false;
      //loop through a to add b
      for(int i= 1; i<= len; i++){
          if((blen-i< 0 ||alen-i < 0) && !add){
              // if blen == alen, it won't reach here
             String left = blen> alen? b.substring(0, blen-i+1) : a.substring(0, alen-i+1);         
             sb.insert(0, left);
             break;
          }
          char ai = alen-i<0 ? '0': a.charAt(alen-i);
          char bi = blen-i < 0 ? '0': b.charAt(blen-i);
          char ci;
          if(add){
              if(ai=='1' && bi=='1'){
                  ci = '1';
              }
              else if (ai=='1' || bi=='1'){
                  ci = '0';
              }
              else{
                  ci= '1';
                  add = false;
              }
          }
          else
          {
              if(ai=='1' && bi=='1'){
                  ci = '0';
                  add = true;
              }
              else if (ai=='1' || bi=='1'){
                  ci = '1';
              }
              else{
                  ci= '0';
              }
          }
          sb.insert(0, ci);
      }
      if(add)
      {
    	  sb.insert(0, '1');
      }
     
      return sb.toString();
     }

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode l3H = null;
         ListNode l3 = null;
         boolean add = false;
         while(l1!= null && l2!= null)
         {
             int val = l1.val + l2.val;
             if(add)
             {
                 val = val + 1;
                 if( val > 9){
                     val = val -10;
                 }
                 else{
                     add = false;
                 }
             }
             else
             {
                if( val > 9){
                     val = val -10;
                     add = true;
                 }
             }
             
             if(l3H == null){
            	 l3H = new ListNode(val);
                 l3 = l3H;
             }
             else
             {
            	 l3.next= new ListNode(val);
            	 l3 = l3.next;
             }
             l1= l1.next;
             l2= l2.next;
         }
         if(l1== null && l2== null)
         {
              if(add)
             {
                 l3.next = new ListNode(1);
                 l3 = l3.next;
             }
         }
         else
         {
             addLeft(l1==null?l2:l1, l3, add);
         }
         
         return l3H;
     }
     
     public void addLeft(ListNode l, ListNode l3, boolean add)
     {
         while(l!= null){
          int val = l.val;
            if(add){
                 val = val + 1;
                 if( val > 9){
                     val = val -10;
                 }
                 else{
                     add = false;
                 }
             }
             else{
                if( val > 9){
                     val = val -10;
                     add = true;
                 }
             } 
             l3.next = new ListNode(val);
             l3 = l3.next;
             l= l.next;
         }
         if(add)
         {
             l3.next = new ListNode(1);
             l3 = l3.next;
         }
     }
     public String multiply(String num1, String num2) {
         if(num1==null || num2== null) return null;
         int len1 = num1.length();
         if(len1== 0) return num2;
         int len2 = num2.length();
         if(len2== 0) return num1;
         
         ArrayList<Integer> digits = new ArrayList<Integer>();
         for(int i=0; i< len1; i++){
             int b = num1.charAt(len1-1-i)-48;
             if(b==0) {continue;}
             int multiHigh = 0;
             int addHigh = 0;
             for(int j= 0; j< len2; j++)
             {
                 int a = num2.charAt(len2-1-j)-48;
                 int val = a*b + multiHigh;
                 multiHigh = val/10;
                 int digit = val% 10;
                 //get exsit val
                 if(i+j<digits.size())
                 {
                     int exDigit = digits.get(i+j);
                     int addVal = exDigit + digit + addHigh;
                     if(addVal > 9)
                     {
                       addVal = addVal -10;
                       addHigh = 1;
                     }
                     else
                     {
                         addHigh = 0;
                     }
                     digits.set(i+j, addVal);
                 }
                 else
                 {
                     digits.add(digit);
                 }
             }
             if(multiHigh>0 || addHigh >0)
             {
                 int fval = multiHigh + addHigh;
                 if( fval> 9){
                     digits.add(fval-10);
                     digits.add(1);
                 }
                 else{
                     digits.add(fval);
                 }
             }
         }
     
         int size = digits.size();
         StringBuilder sb = new StringBuilder();
         for(int i = size-1; i>=0; i--)
         {
             sb.append(digits.get(i));
         }
         return sb.toString();
     }

     public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
         ArrayList<Interval> results = new ArrayList<Interval>();
         if(intervals == null) return null;
         int size = intervals.size();
         if(size<2) return intervals;
         
         //sort intervals based on start point
         Collections.sort(intervals, new Comparator<Interval>(){
             public int compare(Interval i1, Interval i2)
             {
                 if(i1.start < i2.start)
                     return 1;
                 else if (i1.start > i2.start)
                     return -1;
                 else
                     return 0;
             }
         });
         
         Interval newInterval = new Interval();
         for(int i=0; i< size; i++)
         {
             Interval temp = intervals.get(i);
             if(newInterval.start== newInterval.end && newInterval.end==0)
             {
                 newInterval.start= temp.start;
                 newInterval.end = temp.end;
                 continue;
             }
             if(newInterval.end < temp.start)
             {
                 results.add(newInterval);
                 newInterval = new Interval();
             }
             else if(newInterval.end>= temp.start && newInterval.end <= temp.end)
             {
                 newInterval.end = temp.end;
             }
             //else ignore this node
         }
         if(newInterval.start!=0)
             {
                 results.add(newInterval);
             }
         return results;
     }
}
