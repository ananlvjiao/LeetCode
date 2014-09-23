package LeetCode.Helper;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for binary tree
 */
public class TreeNode implements Comparable {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public static void printTree(TreeNode root) {
		if (root != null) {
			System.out.println("=>" + root.val);
			printTree(root.left);
			printTree(root.right);
		} else {
			System.out.println("=> #");
		}
	}

	public static TreeNode CreateTreeNode(String x) {
		if (x.equals("#")) {
			return null;
		}
		TreeNode treeNode = new TreeNode(Integer.parseInt(x));
		return treeNode;
	}

	public static TreeNode BuildTreeBFS(String[] inputs) {
		if (inputs.length == 0)
			return null;
		Queue<TreeNode> nodeQ = new PriorityQueue<TreeNode>(inputs.length);
		TreeNode root = TreeNode.CreateTreeNode(inputs[0]);
		nodeQ.add(root);

		for (int i = 1; i < inputs.length; i++) {
			if (nodeQ.isEmpty()) {
				TreeNode node = TreeNode.CreateTreeNode(inputs[i]);
				nodeQ.add(node);
			} else {
				TreeNode node = nodeQ.remove();
				TreeNode left = TreeNode.CreateTreeNode(inputs[i]);
				node.left = left;
				if (left != null) {
					nodeQ.add(left);
				}
				i++;
				if (i < inputs.length) {

					TreeNode right = TreeNode.CreateTreeNode(inputs[i]);
					node.right = right;
					if (right != null) {
						nodeQ.add(right);
					}
				}
			}
		}
		return root;

	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
