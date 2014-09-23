package LeetCode.Permutation;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < num.length; i++) {
			result = permuteOneInteger(result, num[i]);
		}
		return result;
	}

	public ArrayList<ArrayList<Integer>> permuteOneInteger(
			ArrayList<ArrayList<Integer>> lists, int num) {
		ArrayList<ArrayList<Integer>> newlists = new ArrayList<ArrayList<Integer>>();
		if (lists.size() == 0) {
			ArrayList<Integer> newlist = new ArrayList<Integer>();
			newlist.add(num);
			newlists.add(newlist);
			return newlists;
		}

		for (int i = 0; i < lists.size(); i++) {
			ArrayList<Integer> list = lists.get(i);
			for (int j = 0; j <= list.size(); j++) {

				ArrayList<Integer> newlist = new ArrayList<Integer>(list);
				newlist.add(j, num);
				newlists.add(newlist);
			}

		}
		return newlists;
	}

	public ArrayList<ArrayList<Integer>> permuteRecursive(int[] num, int k) {
		ArrayList<ArrayList<Integer>> newlists = new ArrayList<ArrayList<Integer>>();
		if (k == 0) {
			ArrayList<Integer> newlist = new ArrayList<Integer>();
			newlist.add(num[k]);
			newlists.add(newlist);
			return newlists;
		}
		ArrayList<ArrayList<Integer>> preResult = permuteRecursive(num, k - 1);
		for (int i = 0; i < preResult.size(); i++) {
			ArrayList<Integer> list = preResult.get(i);
			for (int j = 0; j <= list.size(); j++) {
				ArrayList<Integer> newlist = new ArrayList<Integer>(list);
				newlist.add(j, num[k]);
				newlists.add(newlist);
			}
		}
		return newlists;
	}

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// the pattern is if it is a dup one, then stop till find the same one
		if (num.length == 0)
			return new ArrayList<ArrayList<Integer>>();
		else
			return permuteUniqueRecursive(num, num.length - 1);
	}

	public ArrayList<ArrayList<Integer>> permuteUniqueRecursive(int[] num, int k) {
		ArrayList<ArrayList<Integer>> newlists = new ArrayList<ArrayList<Integer>>();
		if (k == 0) {
			ArrayList<Integer> newlist = new ArrayList<Integer>();
			newlist.add(num[k]);
			newlists.add(newlist);
			return newlists;
		}

		ArrayList<ArrayList<Integer>> prelists = permuteUniqueRecursive(num,
				k - 1);
		for (int i = 0; i < prelists.size(); i++) {
			boolean stop = false;
			ArrayList<Integer> list = prelists.get(i);
			for (int j = 0; j <= list.size(); j++) {
				if (!stop) {
					ArrayList<Integer> newlist = new ArrayList<Integer>(list);
					newlist.add(j, num[k]);
					newlists.add(newlist);
				}
				if (j < list.size() && list.get(j) == num[k]) {
					stop = true;
				}
			}
		}
		return newlists;
	}

	public String getPermutation(int n, int k) {
		// the total is n*(n-1)*..1
		if (k < 1 || n < 1)
			return "";
		if (n == 1 && k == 1)
			return "1";
		int maxK = 1;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			nums.add(i + 1);
			maxK *= (i + 1);
		}
		if (k > maxK)
			return "";
		k=k-1;
		while (n >= 1) {
			maxK = maxK/n;
			int i = k / maxK;
			k = k % maxK;
			int val = nums.remove(i);
			sb.append(val);
			n--;
		}
		//sb.append(nums.remove(0));
		return sb.toString();

	}

	 public void nextPermutation(int[] num) {
	        //1342=> 1432 find the last 2 ascending nums then revert, if no, then reverse all
	        //check for the reverse all case
	        if(num.length == 1) return;
	        for(int i= num.length-1; i>= 1; i--)
	        {
	            if(num[i]>num[i-1])
	            {
            		int x = 1;
                    while(i+x<num.length && num[i-1]< num[i+x])
                    {
                        x++;
                    }
                    //swap i+x-1, i-1
                    swapElements(num, i+x-1, i-1);
                    swapElementsInBetween(num, i, num.length-1);
                    return;
	            }
	        }
	        //reverse all
	        int low = 0; int high = num.length-1;
	        swapElementsInBetween(num, low ,high);
	    }
	    
	    public void swapElementsInBetween(int[] num, int low, int high)
	    {
	        while(low<high)
	        {
	            swapElements(num, low, high);
	            low++;
	            high--;
	        }
	    }
	    
	    public void swapElements(int[] num, int m, int n)
	    {
	        int temp = num[m];
	        num[m] = num[n];
	        num[n] = temp;
	    }
	
}
