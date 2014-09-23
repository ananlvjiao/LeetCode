
package LeetCode.test;

//import SearchForARange.Solution;
//import SingleNumber.Solution;
//import RemoveDuplicatesFromSortedList.*;
//import RemoveDuplicatesFromSortedArray.*;
//import LeetCode.UniquePath.Solution;
//import LeetCode.LinkedList.*;
//import LeetCode.ReverseInteger.*;
//import LeetCode.CanJump.*;
import java.util.ArrayList;



//import LeetCode.LRUCache.*;
//import LeetCode.LinkedList.*;
//import LeetCode.LinkedList.Solution;
//import LeetCode.MaxPointsOnALine.*;
import LeetCode.Helper.*;
//import LeetCode.Permutation.*;
//import LeetCode.Array.*;
//import GoogleITV.*;
import SortingAlgorithms.*;
//import LeetCode.StringSearch.*;
//import LeetCode.Practise.*;
//import LeetCode.Tree.*;
import LeetCode.Last50s.*;

public class TestSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution bsolution = new Solution();
		/* Test Block for Search for a range Prob*/
		//int[] result = solution.searchRange(new int[]{2,2}, 1);
	    //System.out.println("result is :["+result[0]+","+ result[1]+"]");

		/* Test Block for Single Number Prob*/
//		int result = solution.singleNumber(new int[]{2,1, 1,7,7,9, 9,2,4, 4, 34});
//		System.out.println("result is :["+result+"]");
		
		/* Test Remove Duplicates From Sorted List II*/
//		ListNode node = new ListNode(1);
//		node.next = new ListNode(1);
//		node.next.next = new ListNode(2);
//		node.next.next.next = new ListNode(4);
		//node.next.next.next.next = new ListNode(3);
		//node.next.next.next.next.next = new ListNode(5);
//		ListNode newNode = solution.deleteDuplicates(node);
//		while(newNode != null)
//		{
//			System.out.println(newNode.val);
//			newNode = newNode.next;
//		}
		
		/*Remove Duplicates From Sorted Array*/
//		int[] A= new int[]{1,1,1,2,2,3};
//		int len = solution.removeDuplicates(A);
//		System.out.println(len);
//		for(int i = 0; i< A.length; i++)
//		{System.out.println(A[i]);}
		
		/*Unique Path*/
		//int[][] obstacleGrid = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		//int[][] obstacleGrid = new int[][] {{0,1}};
		//System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
		//System.out.println(solution.uniquePaths(100, 80));
//		
//		int[][] grid = new int[][] {{1,2},{1,1}};
//		System.out.println(bsolution.minPathSum(grid));
//		
		//System.out.println(solution.reverse(-10200));
		
		/* Test linked list cycle*/
//		ListNode node = new ListNode(1);
//		ListNode node2 = new ListNode(1);
//		ListNode node3 = new ListNode(2);
//		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(3);
//		ListNode node6 = new ListNode(5);
//		
//		node.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node2;
//		node4.next = node5;
//		node5.next = node2;
//		
//		ListNode head = node;
//		System.out.println(solution.hasCycle(node));
//		int count = 6;
//		while(count>0)
//		{System.out.println(node);
//			node = node.next;
//			count--;}
//		
//		System.out.println(solution.detectCycle(head));
		
//		System.out.println(solution.numTrees(4));
//		System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 5));
//		System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2));
//		System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 7));
//		System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 0));
		
		//System.out.println(solution.climbStairs_S(100));
		//System.out.println(solution.climbStairs(70));
		
//		System.out.println(solution.romanToInt(""));
//		System.out.println(solution.romanToInt(null));
//		System.out.println(solution.romanToInt("serw"));
//		System.out.println(solution.romanToInt("MMVIII"));
		
//		ListNode node = new ListNode(0);
//		ListNode node2 = new ListNode(1);
//		ListNode node3 = new ListNode(2);
//		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(3);
//		ListNode node6 = new ListNode(5);
//		
//		node.next = node3;
//		node2.next = node4;
//		node3.next = node5;
//		node4.next = node6;
//
//		ListNode head = solution.mergeTwoLists(node, node2);
//		int count = 6;
//		while(count>0)
//		{System.out.println(head.val);
//		head = head.next;
//			count--;}
		
		//[1,2,4,5,6], [3]
		//int[] A = new int[] {};
		

		//solution.merge(new int[]{1,2,4,5,6, 0}, 5, new int[]{3}, 1);
		
//		TreeNode treeNode = solution.sortedArrayToBST(new int[] {1,2});
//		TreeNode.printTree(treeNode);
		
//		ArrayList<ArrayList<Integer>> result = solution.generate(3);
//		ArrayList<Integer> result1 = solution.getRow(0);
//		ArrayList<Integer> result2 = solution.getRow(1);
//		ArrayList<Integer> result3 = solution.getRow(2);
//		ArrayList<Integer> result4 = solution.getRow(3);
//		ArrayList<Integer> result5 = solution.getRow(4);
		
//		System.out.println(solution.evalRPN(new String[] {"0","3","/"}));
		
//		System.out.println(solution.intToRoman(4));
		
		
//		TreeNode treeNode = TreeNode.BuildTreeBFS(
//				new String[]{"-3","-4","0","#","#","0",
//										"1","#","7","#","-3"});
//		TreeNode treeNode = TreeNode.BuildTreeBFS(
//				new String[]{"10","5","15","#","#","6","20"});
//		TreeNode treeNode = TreeNode.BuildTreeBFS(
//				new String[]{"1","2"});
//		TreeNode treeNode = TreeNode.BuildTreeBFS(
//				new String[]{"5","4","8","11","#","13","4","7","2","#","#","#","1"});
//		TreeNode treeNode = TreeNode.BuildTreeBFS(
//		new String[]{"5","4","8","11","#","13","4","7","2","5","1"});
//		TreeNode.printTree(treeNode);
		//ArrayList<Integer> result1 = TreeNode.postorderTraversal(treeNode);
		//bsolution.flatten(treeNode);
		//TreeNode.printTree(treeNode);
//		ArrayList<ArrayList<Integer>> test = bsolution.pathSum(treeNode, 22);
//		System.out.println(test.size());
//		TreeNode  root = bsolution.buildTree_Pre( new int[]{1,2,4,5,3,6,7},new int[]{4, 2,5,1,6,3,7});
		//ListNode node = ListNode.BuildLinkList(new int[]{1,2,3,4,5});
		//TreeNode treeNode = bsolution.sortedListToBST(node);
//		TreeNode.printTree(treeNode);
//		System.out.println(bsolution.isValidBST(treeNode));
		
//		ArrayList<ArrayList<Integer>> test = bsolution.zigzagLevelOrder(treeNode);
//		System.out.println(test.size());
//		boolean test2 = true;
//		System.out.println(!test2);
		
//		ListNode list = ListNode.BuildLinkList(new int[] {3,4,3,2,5,2});
//		//list = bsolution.removeNthFromEnd(list, 5);
//		list = bsolution.partition(list, 3);
//		ListNode.PrintList(list);
		//System.out.println(bsolution.canJump(new int[]{2,0,0}));
		
//		LRUCache cache = new LRUCache(2);
//		cache.set(2, 1);
//		cache.set(1, 1);
//		cache.set(2, 3);
//		cache.set(4, 1);
//		
//		System.out.println(cache.get(1));
//		System.out.println(cache.get(2));
		
//		ListNode list1 = ListNode.BuildLinkList(new int[] {1,4,5,7});
//		ListNode list2 = ListNode.BuildLinkList(new int[] {2,3});
//		ListNode list3 = ListNode.BuildLinkList(new int[] {6,9});
//		ListNode list4 = ListNode.BuildLinkList(new int[] {8});
//		
//		ArrayList<ListNode> lists = new ArrayList<ListNode>();
//		lists.add(null);
//		lists.add(null);
//		lists.add(null);
//		lists.add(null);
//		
//		(0,9),(138,429),(115,359),(115,359),(-30,-102),(230,709),(-150,-686),(-135,-613),
//		(-60,-248),(-161,-481),(207,639),(23,79),(-230,-691)
//		(-115,-341),(92,289),(60,336),(-105,-467),(135,701),(-90,-394),(-184,-551),(150,774)
//		ListNode.PrintList(bsolution.mergeKLists(lists));
//		Point[] points = new Point[21];
//		points[0] = new Point(0, 9);
//		points[1] = new Point(138, 429);
//		points[2] = new Point(115, 359);
//		points[3] = new Point(115, 359);
//		points[4] = new Point(-30, -102);
//		points[5] = new Point(230, 709);
//		points[6] = new Point(-150, -686);
//		points[7] = new Point(-135, -613);
//		points[8] = new Point(-60, -248);
//		points[9] = new Point(-161,-481);
//		points[10] = new Point(207,639);
//		points[11] = new Point(23,79);
//		points[12] = new Point(-230,-691);
//		points[13] = new Point(-115,-341);
//		points[14] = new Point(92,289);
//		points[15] = new Point(60,336);
//		points[16] = new Point(-105,-467);
//		points[17] = new Point(135,701);
//		points[18] = new Point(-90,-394);
//		points[19] = new Point(-184,-551);
//		points[20] = new Point(150,774);
//		(0,-12),(5,2),(2,5),(0,-5),(1,5),(2,-2),(5,-4),(3,4),(-2,4),
//		(-1,4),(0,-5),(0,-8),(-2,-1),(0,-11),(0,-9)
//		Point[] points = new Point[15];
//		points[0] = new Point(0,-12);
//		points[1] = new Point(5,2);
//		points[2] = new Point(2,5);
//		points[3] = new Point(0,-5);
//		points[4] = new Point(1,5);
//		points[5] = new Point(2,-2);
//		points[6] = new Point(5,-4);
//		points[7] = new Point(3,4);
//		points[8] = new Point(-2,4);
//		points[9] = new Point(-1,4);
//		points[10] = new Point(0,-5);
//		points[11] = new Point(0,-8);
//		points[12] = new Point(-2,-1);
//		points[13] = new Point(0,-11);
//		points[14] = new Point(0,-9);
//		System.out.println(bsolution.maxPoints(points));

//		System.out.println(bsolution.isNumber(" 2e"));
//		System.out.println(bsolution.isNumber(" 0.1 "));
//		System.out.println(bsolution.isNumber("3."));
//		System.out.println(bsolution.isNumber("-.3"));
//		System.out.println(bsolution.isNumber("0.e2"));
//		System.out.println(bsolution.isNumber(" +0e-"));
		
//		char[][] sudoku = new char[][]{
//								{'5','3','.','.','7','.','.','.','.'},
//								{'6','.','.','1','9','5','.','.','.'},
//								{'.','9','8','.','.','.','.','6','.'},
//								{'8','.','.','.','6','.','.','.','3'},
//								{'4','.','.','8','.','3','.','.','1'},
//								{'7','.','.','.','2','.','.','.','6'},
//								{'.','6','.','.','.','.','2','8','.'},
//								{'.','.','.','4','1','9','.','.','5'},
//								{'.','.','.','.','8','.','.','7','9'}
//								};
//		bsolution.solveSudoku(sudoku);
//		System.out.println("done");
		
//		Sort sort = new Sort();
//		System.out.println(sort.findValueIndex(new int[]{1,3,5, 7}, 6));
		
//		UndirectedGraphNode node = new UndirectedGraphNode(0);
//		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
//		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
//		
//		node.neighbors.add(node1);
//		node.neighbors.add(node2);
//		
//		node1.neighbors.add(node2);
//		node2.neighbors.add(node2);
//		
//		UndirectedGraphNode newNode = bsolution.cloneGraph(node);
		
//		System.out.println(bsolution.search(new int[]{1,2,3,4,5,6}, 4));
		
		//ArrayList<ArrayList<Integer>> result = bsolution.permuteUnique(new int[]{1,3,7,1});
		//System.out.println(bsolution.getPermutation(3,6));
//		int[] nums = new int[]{2,3,1};
//		bsolution.nextPermutation(nums);
		
//		ArrayList<Integer> digits = bsolution.getDigits(0);
//		ArrayList<Interval> intervals = new ArrayList<Interval>();
//		intervals.add(new Interval(1,5));
		//intervals.add(new Interval(6,8));
//		Interval newInt = new Interval(0,3);
//		intervals = bsolution.insert(intervals, newInt);
//		System.out.println(bsolution.hasSumOf3(new int[]{1,2,3,4,5,6},7));
//		System.out.println(bsolution.threeSumClosest(new int[]{ 1,1,-1,-1,3}, -1));
//		double x = 1.0f/3;
//		System.out.println(x);
//		byte[] test = new byte[]{1,1,1,0,2,3, (byte) 274};
//		for(int i = 0; i< test.length; i++)
//		{
//		System.out.println(test[i]);
//		}
//		ArrayList<ArrayList<Integer>> result = bsolution.threeSum(
//				new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6});
	
//		ArrayList<Relation> input = new ArrayList();
//
//		input.add(new Relation("animal", "mammal"));
//		input.add(new Relation("animal", "bird"));
//		input.add(new Relation("lifeform", "animal"));
//		input.add(new Relation("cat", "lion"));
//		input.add(new Relation("mammal", "cat"));
//		input.add(new Relation("animal", "fish"));
//
//		TreePrinter_F.printTree(input);
//		ListNode list1 = ListNode.BuildLinkList(new int[] {1,4,5,6,7});
//		ListNode list2 = ListNode.BuildLinkList(new int[] {2,3});
//		ListNode list3 = ListNode.BuildLinkList(new int[] {6,9});
//		ListNode list4 = ListNode.BuildLinkList(new int[] {8});
//		bsolution.reorderList(list1);
//		ListNode.PrintList(list1);
//		Sort sort = new Sort();
//		int[] a = new int[]{1, 2, 8,4,5};
//		sort.quickSort(a, 0, 4);
//		bsolution.BFPatternMatching("ababcabcacbab", "abcac");
//		bsolution.KMPPatternMatching("ababcabcacbab", "abcac");
//		ArrayList<Integer> result = 
//				bsolution.findSubstring("barfoothefoobarman", new String[]{"bar", "foo"});
//		bsolution.canCompleteCircuit(new int[]{1,2}, new int[]{2,1});
//		bsolution.isMatch("aabbcde", "a*bcd?");
//		int x = bsolution.minCut("ababbbabbaba");
//		bsolution.generateMatrix(4);
//		int[][] matrix = new int[][]{{1, 3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
//		int[][] matrix2= new int[][]{{1},{3}};
//		bsolution.searchMatrix(matrix2, 3);
//		bsolution.combine(3, 2);
//		bsolution.combinationSum2(new int[]{2,2,2}, 4);
//		ArrayList<String> result = bsolution.letterCombinations("237");
//		TreeNode node = new TreeNode(0);
//		node.left = new TreeNode(1);
//		TreeNode node2 =TreeNode.BuildTreeBFS(new String[]{"4","9","0","#","1"});
//		bsolution.sumNumbers(node2);
//		int val = bsolution.divide(-1010369383, -2147483648);
//		String sval = bsolution.addBinary("101111", "10");
//		ListNode l1 =ListNode.BuildLinkList(new int[]{9, 8});
//		ListNode l2= ListNode.BuildLinkList(new int[]{1});
//		ListNode l3 = bsolution.addTwoNumbers(l1, l2);
		
//		Solution2 s2 = new Solution2();
////		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
////		//int[] arr = new int[]{1,2,4,6,8,12,15,17,19,20, 21, 22, 23, 24, 25,26, 34,37,78,55,52,51,50,49,44,33,31,30,28, 23,14,12,2};
////		int[] arr2 = new int[]{2,3,4};
////		boolean exist = s2.binarySearchExt(arr, 77, true);
////		boolean exist1 = s2.findSummit2(arr, 0, arr.length-1, 1);
////		System.out.println("========" + arr.length);
////		boolean exist2 = s2.ifExistInArray(arr, 1);
////		 
////		ArrayList<String[]> results = s2.solveNQueens(4);
//		int[] arr = new int[]{3,4,1,5,7};
//		s2.mergeSort(arr, 0, 4);
//		s2.quickSort(arr, 0, 4);
//		Solution4 s4 = new Solution4();
//		s4.findMostFrequentString("abcabcdeebdababad", 2, 4, 2);
//		s4.anagrams(new String[]{"and","dan"});
//		System.out.println(s4.countAndSay(4));
//		System.out.println(s4.numDecodings("1010"));
		
//		TreeNode root = TreeNode.BuildTreeBFS(new String[]{"5","3","9","2","4", "6", "11"});
//		bsolution.flattenBST(root);
//		TreeNode newRoot = root;
		//while(newRoot.left!= null)
			
//		root.printTree(root);
		
		System.out.println(bsolution.numDecodings("10101112"));
		String s= "010010";
		ArrayList<String> results = bsolution.restoreIpAddresses(s);
		ArrayList<Integer> result = bsolution.findCommons(new int[]{1, 2,3,4}, new int[]{3,4,5});
	}

}
