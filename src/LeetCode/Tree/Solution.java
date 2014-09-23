package LeetCode.Tree;

import java.util.*;

import LeetCode.Helper.*;

public class Solution {

	// http://oj.leetcode.com/problems/binary-tree-postorder-traversal/
	public ArrayList<Integer> postorderTraversal_I(TreeNode root) {
		// one stack, one variable
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> firstStack = new Stack<TreeNode>();
		TreeNode prev = null;

		while (root != null || !firstStack.empty()) {
			if (root == null) {
				TreeNode node = firstStack.pop();
				if (node.left == null && node.right == null) {
					result.add(node.val);
					prev = node;
				} else {
					if (prev == node.left) {
						if (node.right != null) {
							firstStack.push(node);
							firstStack.push(node.right);
							root = node.right.left;
							prev = null;
						} else {
							result.add(node.val);
							prev = node;
						}
					} else if (prev == node.right) {
						result.add(node.val);
						prev = node;
					}
				}
			} else {
				firstStack.push(root);
				root = root.left;
			}
		}

		return result;
	}

	public ArrayList<Integer> postorderTraversal_II(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> firstStack = new Stack<TreeNode>();
		Stack<TreeNode> secondStack = new Stack<TreeNode>();
		if (root == null)
			return result;
		firstStack.push(root);
		while (!firstStack.empty()) {
			TreeNode node = firstStack.pop();
			secondStack.push(node);
			if (node.left != null) {
				firstStack.push(node.left);
			}
			if (node.right != null) {
				firstStack.push(node.right);
			}
		}

		while (!secondStack.empty()) {
			result.add(secondStack.pop().val);
		}
		return result;
	}

	// http://oj.leetcode.com/problems/binary-tree-preorder-traversal/
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		// do it recursive first
		ArrayList<Integer> outputs = new ArrayList<Integer>();
		Stack<TreeNode> nStack = new Stack<TreeNode>();
		while (root != null) {
			outputs.add(root.val);
			if (root.left == null && root.right == null) {
				if (!nStack.empty()) {
					root = nStack.pop().right;
				} else {
					break;
				}
			} else if (root.left != null && root.right != null) {
				nStack.push(root);
				root = root.left;
			} else if (root.left != null && root.right == null) {
				root = root.left;
			}

			else if (root.left == null && root.right != null) {
				root = root.right;
			}

		}
		return outputs;
	}

	// http://oj.leetcode.com/problems/binary-tree-inorder-traversal/
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> outputs = new ArrayList<Integer>();
		Stack<TreeNode> nStack = new Stack<TreeNode>();
		while (root != null) {

			if (root.left == null && root.right == null) {
				outputs.add(root.val);
				if (!nStack.empty()) {
					TreeNode node = nStack.pop();
					outputs.add(node.val);
					while (node.right == null && !nStack.empty()) {
						node = nStack.pop();
						outputs.add(node.val);
					}
					root = node.right;
				} else {
					break;
				}
			} else if (root.left != null && root.right != null) {
				nStack.push(root);
				root = root.left;
			} else if (root.left != null && root.right == null) {
				nStack.push(root);
				root = root.left;
			}

			else if (root.left == null && root.right != null) {
				outputs.add(root.val);
				root = root.right;
			}

		}
		return outputs;
	}

	// http://oj.leetcode.com/problems/binary-tree-level-order-traversal/
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null)
			return result;
		// Priority Queue required comparable, so use ArrayList
		ArrayList<TreeNode> nQueue = new ArrayList<TreeNode>();
		int start = 0;
		int end = 0;
		int lp = 0;

		ArrayList<Integer> level = new ArrayList<Integer>();
		nQueue.add(root);
		end++;
		lp = end;

		// when new node add, end ++; when s++; => lp move to start and end
		while (start <= lp) {
			if (start == lp) {
				result.add(level);
				if (lp == end) {
					break;
				}
				level = new ArrayList<Integer>();
				lp = end;
			}
			if (start < lp) {
				TreeNode node = nQueue.get(start);
				level.add(node.val);
				if (node.left != null) {
					nQueue.add(node.left);
					end++;
				}
				if (node.right != null) {
					nQueue.add(node.right);
					end++;
				}
				start++;
			}
		}
		return result;
	}

	//http://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null)
			return result;
		// Priority Queue required comparable, so use ArrayList
		ArrayList<TreeNode> nQueue = new ArrayList<TreeNode>();
		int start = 0;
		int end = 0;
		int lp = 0;

		ArrayList<Integer> level = new ArrayList<Integer>();
		nQueue.add(root);
		end++;
		lp = end;

		// when new node add, end ++; when s++; => lp move to start and end
		while (start <= lp) {
			if (start == lp) {
				result.add(0, level);
				if (lp == end) {
					break;
				}
				level = new ArrayList<Integer>();
				lp = end;
			}
			if (start < lp) {
				TreeNode node = nQueue.get(start);
				level.add(node.val);
				if (node.left != null) {
					nQueue.add(node.left);
					end++;
				}
				if (node.right != null) {
					nQueue.add(node.right);
					end++;
				}
				start++;
			}
		}
		return result;
    }
	
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    		if (root == null)
    			return result;
    		// Priority Queue required comparable, so use ArrayList
    		ArrayList<TreeNode> nQueue = new ArrayList<TreeNode>();
    		int start = 0;
    		int end = 0;
    		int lp = 0;
    		boolean direction = true; //left to right

    		ArrayList<Integer> level = new ArrayList<Integer>();
    		nQueue.add(root);
    		end++;
    		lp = end;

    		// when new node add, end ++; when s++; => lp move to start and end
    		while (start <= lp) {
    			if (start == lp) {
    				result.add(level);
    				direction = !direction;
    				if (lp == end) {
    					break;
    				}
    				level = new ArrayList<Integer>();
    				lp = end;
    			}
    			if (start < lp) {
    				TreeNode node = nQueue.get(start);
    				if(!direction)
    				{
    				    level.add(0, node.val);
    				}
    				else
    				{
    				    level.add(node.val);
    				}
    				if (node.left != null) {
    					nQueue.add(node.left);
    					end++;
    				}
    				if (node.right != null) {
    					nQueue.add(node.right);
    					end++;
    				}
    				start++;
    			}
    		}
    		return result;
        }
        
     //http://oj.leetcode.com/problems/validate-binary-search-tree/
        public boolean isValidBST(TreeNode root) {
            return isValidBSTWithRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        public boolean isValidBSTWithRange(TreeNode root, int min, int max)
        {
            if(root == null) return true;
            if(root.val >= max || root.val <= min) return false;
            return isValidBSTWithRange(root.left, min, root.val) && isValidBSTWithRange(root.right, root.val, max);
            
        }
    
	// http://oj.leetcode.com/problems/balanced-binary-tree
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)
			return false;

		return isBalanced(root.left) && isBalanced(root.right);
	}

	public int getDepth(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(getDepth(root.right), getDepth(root.left));
	}

	// http://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
	public int maxPathSum(TreeNode root) {
		ArrayList<Integer> rootSums = new ArrayList<Integer>();
		ArrayList<Integer> subSums = new ArrayList<Integer>();

		if (root == null)
			return 0;
		int maxSum = root.val;
		maxPathSum_D(root, rootSums, subSums);
		for (int i = 0; i < rootSums.size(); i++) {
			int max = Math.max(rootSums.get(i), subSums.get(i));
			if (max > maxSum) {
				maxSum = max;
			}
		}
		return maxSum;
	}

	public int maxPathSum_D(TreeNode root, ArrayList<Integer> rootSums,
			ArrayList<Integer> subSums) {
		if (root == null)
			return 0;
		int sum = root.val;
		int subSum = root.val;
		int left = maxPathSum_D(root.left, rootSums, subSums);
		int right = maxPathSum_D(root.right, rootSums, subSums);

		// save subSum
		if (left > 0) {
			subSum += left;
		}
		if (right > 0) {
			subSum += right;
		}
		subSums.add(subSum);

		if (left > 0 && right > 0) {
			sum += Math.max(left, right);
		} else {
			if (left > 0) {
				sum += left;
			}
			if (right > 0) {
				sum += right;
			}
		}
		rootSums.add(sum);
		return sum;
	}

	// http://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;

		// swap
		if (root.left != null && root.right != null) {
			TreeNode left = root.left;
			flatten(left);
			TreeNode node = root.right;
			root.right = root.left;

			while (left.right != null) {
				left = left.right;
			}

			left.right = node;
			root.left = null;
			flatten(node);
		} else if (root.right == null) {
			flatten(root.left);
			root.right = root.left;
			root.left = null;
		} else if (root.left == null) {
			flatten(root.right);
		}
	}

	// http://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		if (root.left == null) {
			return 1 + minDepth(root.right);
		}

		if (root.right == null) {
			return 1 + minDepth(root.left);
		}

		return 1 + Math.min(minDepth(root.right), minDepth(root.left));
	}

	// http://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
	public int maxDepth(TreeNode root) {
		// traverse tree
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// http://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null)
			return null;
		TreeNode root = buildTree(num, 0, num.length);
		return root;

	}

	public TreeNode buildTree(int[] num, int s_index, int e_index) {
		if (e_index - s_index == 0)
			return null;
		if (e_index - s_index == 1) {
			TreeNode node = new TreeNode(num[s_index]);
			return node;
		}
		int mid_index = s_index + (e_index - s_index) / 2;
		// build root
		TreeNode node = new TreeNode(num[mid_index]);

		node.left = buildTree(num, s_index, mid_index);
		node.right = buildTree(num, mid_index + 1, e_index);
		return node;

	}

	
    public TreeNode sortedListToBST(ListNode head) {

        
        ListNode pointer = head;
        int count = 0;
        while(pointer != null)
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
        if (e_index - s_index == 1) {
			TreeNode root = new TreeNode(node.val);
			return root;
		}
		int mid_index = s_index + (e_index - s_index) / 2;
		// build root
		TreeNode left = buildTreeWithList(node.next, s_index, mid_index);
		//mid_index
		TreeNode root= new TreeNode(node.val);  
		root.left = left;
		root.right = buildTreeWithList(node.next.next, mid_index+1, e_index);
		return root;
    }
	
	// http://oj.leetcode.com/problems/path-sum/
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.val == sum && root.left == null && root.right == null) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);

	}

	// http://oj.leetcode.com/problems/unique-binary-search-trees/
	public int numTrees(int n) {
		if (n == 0)
			return 0;
		long divider = 1;
		for (int i = 1; i <= n; i++) {
			divider *= i;
		}

		long denominator = 1;
		for (int i = n + 2; i <= 2 * n; i++) {
			denominator *= i;
		}
		return (int) (denominator / divider);
	}

	// http://oj.leetcode.com/problems/same-tree/
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}

		if (!isSameTree(p.left, q.left)) {
			return false;
		}
		if (!isSameTree(p.right, q.right)) {
			return false;
		}

		return true;
	}

	// http://oj.leetcode.com/problems/symmetric-tree/
	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;
		return isSubTreeSymmetric(root.left, root.right);
	}

	public boolean isSubTreeSymmetric(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null) {
			return true;
		}
		if (leftNode == null || rightNode == null) {
			return false;
		}
		if (leftNode.val != rightNode.val) {
			return false;
		}
		return isSubTreeSymmetric(leftNode.left, rightNode.right)
				&& isSubTreeSymmetric(leftNode.right, rightNode.left);
	}

	// http://oj.leetcode.com/problems/path-sum-ii/
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		if (root.val == sum && root.left == null && root.right == null) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(root.val);
			result.add(path);
			return result;
		}
		ArrayList<ArrayList<Integer>> left = pathSum(root.left, sum - root.val);
		if (left != null) {
			result.addAll(left);
		}
		ArrayList<ArrayList<Integer>> right = pathSum(root.right, sum
				- root.val);
		if (right != null) {
			result.addAll(right);
		}
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> path = result.get(i);
			path.add(0, root.val);
		}
		return result;

	}

	// http://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
	public TreeNode buildTree_Post(int[] inorder, int[] postorder) {
		if (postorder.length == 0)
			return null;
		// create root
		int val = postorder[postorder.length - 1];
		TreeNode node = new TreeNode(val);

		int midIndex = findInOrderIndex(inorder, val);
		int leftLength = midIndex - 0;
		int rightLength = postorder.length - midIndex - 1;

		if (leftLength > 0) {
			int[] leftInorder = new int[leftLength];
			int[] leftPostorder = new int[leftLength];
			for (int i = 0; i < leftLength; i++) {
				leftInorder[i] = inorder[i];
				leftPostorder[i] = postorder[i];
			}
			node.left = buildTree_Post(leftInorder, leftPostorder);
		}
		if (rightLength > 0) {
			int[] rightInorder = new int[rightLength];
			int[] rightPostorder = new int[rightLength];

			for (int i = 0; i < rightLength; i++) {
				rightInorder[i] = inorder[midIndex + 1 + i];
				rightPostorder[i] = postorder[midIndex + i];
			}

			node.right = buildTree_Post(rightInorder, rightPostorder);
		}

		return node;
	}

	// http://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
	public TreeNode buildTree_Pre(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		// create root
		int val = preorder[0];
		TreeNode node = new TreeNode(val);

		int midIndex = findInOrderIndex(inorder, val);
		int leftLength = midIndex - 0;
		int rightLength = preorder.length - midIndex - 1;

		if (leftLength > 0) {
			int[] leftInorder = new int[leftLength];
			int[] leftpreorder = new int[leftLength];
			for (int i = 0; i < leftLength; i++) {
				leftInorder[i] = inorder[i];
				leftpreorder[i] = preorder[i + 1];
			}
			node.left = buildTree_Pre(leftpreorder, leftInorder);
		}
		if (rightLength > 0) {
			int[] rightInorder = new int[rightLength];
			int[] rightpreorder = new int[rightLength];

			for (int i = 0; i < rightLength; i++) {
				rightInorder[i] = inorder[midIndex + 1 + i];
				rightpreorder[i] = preorder[midIndex + 1 + i];
			}

			node.right = buildTree_Pre(rightpreorder, rightInorder);
		}

		return node;
	}

	public int findInOrderIndex(int[] inorder, int t) {
		for (int i = 0; i < inorder.length; i++) {
			if (t == inorder[i]) {
				return i;
			}
		}
		return -1;
	}

	// http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
	public void connect(TreeLinkNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;

		TreeLinkNode levelNode = root;
		while (levelNode != null && levelNode.right != null
				&& levelNode.left != null) {
			TreeLinkNode nodeCursor = levelNode;
			while (nodeCursor != null) {
				nodeCursor.left.next = nodeCursor.right;
				if (nodeCursor.next != null) {
					nodeCursor.right.next = nodeCursor.next.left;

				}
				nodeCursor = nodeCursor.next;
			}
			levelNode = levelNode.left;
		}

	}

	//flatten binary search tree to a sorted double linked list
	public void flattenBST(TreeNode root)
	{
		if(root == null) return;
		if(root.left == null && root.right == null) return;
		
		//check unit sub tree
		flattenBST(root.left);
		TreeNode left = root.left;
		while(left.right!=null)
		{
			left = left.right;
		}
		left.right = root;
		root.left = left;
		
		flattenBST(root.right);
		TreeNode right = root.right;
		while(right.left != null)
		{
			right = right.left;
		}
		root.right = right;
		right.left = root;
		
	}
	
}
