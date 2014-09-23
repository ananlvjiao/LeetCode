package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.tree.TreeNode;

import LeetCode.Helper.Interval;
import SortingAlgorithms.Sort;

public class Solution {

	// http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/

	public int removeDuplicates_I(int[] A) {

		if (A.length == 0 || A.length == 1) {
			return A.length;
		}

		int curCursor = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[curCursor]) {
				curCursor++;
				A[curCursor] = A[i];

			}
		}
		return curCursor + 1;
	}

	// http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
	public int removeDuplicates(int[] A) {

		if (A.length < 3) {
			return A.length;
		}

		int curCursor = 0;
		int count = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[curCursor] == A[i]) {
				if (count < 2) {
					curCursor++;
					A[curCursor] = A[i];
				}
				count++;
			} else {
				curCursor++;
				A[curCursor] = A[i];
				count = 1;

			}
		}

		return curCursor + 1;
	}

	// http://oj.leetcode.com/problems/merge-sorted-array/
	public void merge(int A[], int m, int B[], int n) {
		// assume A.length = m +n ;
		if (n == 0 || m == 0)
			return;
		for (int i = A.length - 1; i >= 0; i--) {
			if (m == 0 && n == 0)
				break;
			else if (m == 0) {
				A[i] = B[n - 1];
				n--;
			} else if (n == 0) {
				A[i] = A[m - 1];
				m--;
			}
			// compare m and n
			else {
				if (A[m - 1] > B[n - 1]) {
					A[i] = A[m - 1];
					m--;
				} else {
					A[i] = B[n - 1];
					n--;
				}
			}
		}
	}

	public int search(int[] A, int target) {
		if (A.length == 0)
			return -1;
		return findPivotPoint(A, 0, A.length - 1, target);
		// for sorted: if target < A[start] or target > A[end] then -1

	}

	public int findPivotPoint(int[] A, int start, int end, int target) {
		if (start < end) {
			if (target == A[start])
				return start;
			if (target == A[end])
				return end;
			int middle = (start + end) / 2;
			// pivot in the left
			if (A[middle] < A[end]) {
				if (target < A[middle]) {
					return findPivotPoint(A, start, middle - 1, target);
				} else if (target > A[middle] && target < A[end]) {
					return findTargetInSortedArray(A, middle + 1, end, target);
				} else if (target > A[end]) {
					return findPivotPoint(A, start, middle - 1, target);
				} else {
					return middle;
				}
			}
			// pivot in the right;
			if (A[middle] > A[end]) {
				if (target < A[start]) {
					return findPivotPoint(A, middle + 1, end, target);
				} else if (target > A[start] && target < A[middle]) {
					return findTargetInSortedArray(A, start, middle - 1, target);
				} else if (target > A[middle]) {
					return findPivotPoint(A, middle + 1, end, target);
				} else {
					return middle;
				}
			}
		}
		return -1;
	}

	public int findTargetInSortedArray(int[] A, int start, int end, int target) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (A[middle] > target) {
				return findTargetInSortedArray(A, start, middle - 1, target);
			} else if (A[middle] < target) {
				return findTargetInSortedArray(A, middle + 1, end, target);
			} else {
				return middle;
			}
		}
		return -1;
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> newList = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			newList.add(newInterval);
			return newList;
		}

		for (int i = 0; i < intervals.size(); i++) {
			Interval intv = intervals.get(i);
			// check start
			if (newInterval.start > intv.start && newInterval.start > intv.end) {
				newList.add(intv);
				continue;
			}

			// merge start
			if (newInterval.start < intv.start) {
				intv.start = newInterval.start;
			}

			if (newInterval.end < intv.end) {
				newList.add(intv);
				return newList;
			}
			// merge it, check the new's end
			int nextI = i + 1;
			while (nextI < intervals.size()
					&& newInterval.end >= intervals.get(nextI).start
					&& newInterval.end >= intervals.get(nextI).end) {
				nextI++;

			}
			if (nextI == intervals.size()) {
				intv.end = newInterval.end;
				newList.add(intv);
				return newList;
			}
			if (newInterval.end < intervals.get(nextI).start) {
				// merge all
				intv.end = newInterval.end;
				newList.add(intv);
				return newList;
			}
			if (newInterval.end < intervals.get(nextI).end) {
				// merge all
				intv.end = intervals.get(nextI).end;
				newList.add(intv);
				return newList;
			}

		}
		newList.add(newInterval);
		return newList;
	}

	public ArrayList<Integer> getDigits(int x) {

		ArrayList<Integer> digits = new ArrayList<Integer>();
		if (x == 0) {
			digits.add(0);
			return digits;
		}
		while (x != 0) {
			digits.add(0, x % 10);
			x = x / 10;
		}
		return digits;
	}

	public boolean hasSumOf3(int[] num, int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			map.put(num[i], 0); 
		}
		int[] sums2 = new int[num.length];
		for (int i = 0; i < num.length; i++) {
			sums2[i] = sum - num[i];
		}

		for (int i = 0; i < num.length; i++) {
			int times = map.get(num[i]);
			map.put(num[i], times + 1);
			for (int j = 0; j < num.length; j++) {
				int ntimes = map.get(num[j]);
				if (ntimes > 0)
					continue;
				map.put(num[j], ntimes + 1);
				int val = sums2[i] - num[j];
				if (map.get(val) != null && map.get(val) == 0) {
					return true;
				}
				map.put(num[j], ntimes);
			}
			map.put(num[i], times);
		}
		return false;
	}

	public ArrayList<ArrayList<Integer>> threeSum_1(int[] num) {
		// sort the int[] num

		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
		// ArrayList<ArrayList<Integer>> result = new
		// ArrayList<ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int[] sums2 = new int[num.length];
		for (int i = 0; i < num.length; i++) {
			ArrayList<Integer> list = map.get(i);
			if (list == null) {
				list = new ArrayList<Integer>();
			}
			list.add(i);
			map.put(num[i], list);
			sums2[i] = 0 - num[i];
		}

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int val = sums2[i] - num[j];
				ArrayList<Integer> list = map.get(val);
				if (list != null) {
					for (int k = 0; k < list.size(); k++) {
						if (list.get(k) != i && list.get(k) != j) {
							result.add(orderArray(num[i], num[j],
									num[list.get(k)]));
						}
					}
				}
			}
		}
		return new ArrayList<ArrayList<Integer>>(result);
	}

	public ArrayList<Integer> orderArray(int m, int n, int k) {
		ArrayList<Integer> tup = new ArrayList<Integer>();
		int max = 0;
		int mid = 0;
		int min = 0;
		if (m >= n && m >= k) {
			max = m;
			if (n >= k) {
				mid = n;
				min = k;
			} else {
				mid = k;
				min = n;
			}
		}

		else if (n >= m && n >= k) {
			max = n;
			if (m >= k) {
				mid = m;
				min = k;
			} else {
				mid = k;
				min = m;
			}
		}

		else if (k >= n && k >= m) {
			max = k;
			if (n >= m) {
				mid = n;
				min = m;
			} else {
				mid = m;
				min = n;
			}
		}

		tup.add(min);
		tup.add(mid);
		tup.add(max);

		return tup;
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// sort the int[] num
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
		int n = num.length;
		if (n < 3)
			return new ArrayList<ArrayList<Integer>>(result);
		Arrays.sort(num);
		int[] sums2 = new int[n];
		for (int i = 0; i < n; i++) {
			int sum = 0 - num[i];
			int low = i + 1;
			int high = n - 1;
			while (low < high) {
				if (num[low] + num[high] == sum) {
					ArrayList<Integer> tup = new ArrayList<Integer>();
					tup.add(num[i]);
					tup.add(num[low]);
					tup.add(num[high]);
					result.add(tup);
					low++;
					high--;
				} else if (num[low] + num[high] > sum) {
					high--;
				} else {
					low++;
				}
			}
		}
		return new ArrayList<ArrayList<Integer>>(result);

	}

	public int threeSumClosest(int[] num, int target) {
		// sort the int[] num
		int n = num.length;
		if (n < 3)
			return 0; 
		int min = Integer.MAX_VALUE;
		Arrays.sort(num);
		for (int i = 0; i < n; i++) {
			int diff = target - num[i];
			int low = i + 1;
			int high = n - 1;
			while (low < high) {
				int sum = num[low] + num[high];
				
				if (Math.abs(target - (sum + num[i])) < Math.abs(target - min)) {
					min = sum + num[i];
				}
				if (sum == diff)
					return min;
				else if (sum > diff) {
					high--;
				} else {
					low++;
				}
			}
		}
		return min;

	}
	
	
}