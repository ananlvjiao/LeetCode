package LeetCode.LRUCache;

import java.util.HashMap;

//import LeetCode.Helper.*;

public class LRUCache {
	private class ListNode {
		int val;
		int key;
		ListNode prev = null;
		ListNode next = null;

		public ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	int capacity = 0;
	ListNode head = null;
	ListNode tail = null;
	HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		ListNode node = map.get(key);
		if (node == null) {
			return -1;
		} else {
			if (node == tail) {
				return node.val;
			}
			if (node == head) {
				if(node.next != null)
				{
					// modify the headkey
					node.next.prev = null;
					head = node.next;
				}
				else
				{
					return node.val;
				}
			} else {
				// take the node out
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}

			tail.next = node;
			node.prev = tail;
			node.next = null;
			tail = tail.next;
			return node.val;
		}
	}

	public void set(int key, int value) {
		if (map.size() == 0 && map.size() < capacity) {
			ListNode node = new ListNode(key,value);
			head = tail = node;
			map.put(key, node);
			return;
		}
		int val = get(key);
		if (val == -1) {
			// not exist
			ListNode newNode = new ListNode(key,value);
			tail.next = newNode;
			newNode.prev = tail;
			tail = tail.next;
			map.put(key, newNode);
			if (map.size() > capacity) {
				// remove the head
				map.remove(head.key);
				head = head.next;
			}
		} else {
			ListNode node = map.get(key);
			node.val = value;
			
		}

	}
}