package LeetCode.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import LeetCode.Helper.ListNode;
import LeetCode.Helper.TreeNode;

public class Solution {

	
	// http://oj.leetcode.com/problems/merge-two-sorted-lists/
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null && l2 != null) {
			return l2;
		}
		if (l1 != null && l2 == null) {
			return l1;
		}

		ListNode l1_cursor = l1;
		ListNode l2_cursor = l2;
		ListNode head = null;
		ListNode cursor = null;
		// int cursor_I = 0;

		while (l1_cursor != null || l2_cursor != null) {
			if (l1_cursor == null) {
				cursor.next = l2_cursor;
				// cursor = cursor.next;
				break;
			} else if (l2_cursor == null) {
				cursor.next = l1_cursor;
				// cursor = cursor.next;
				break;
			} else if (l1_cursor.val < l2_cursor.val) {
				if (head == null) {
					head = l1_cursor;
					cursor = head;

				} else {
					cursor.next = l1_cursor;
					cursor = cursor.next;
				}
				l1_cursor = l1_cursor.next;
			} else {
				if (cursor == null) {
					head = l2_cursor;
					cursor = head;
				} else {
					cursor.next = l2_cursor;
					cursor = cursor.next;

				}
				l2_cursor = l2_cursor.next;
			}
		}

		return head;

	}

	
	//http://oj.leetcode.com/problems/merge-k-sorted-lists/
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
			if(lists == null) return null;
			
			int i = 0;
			while(i< lists.size())
			{
				if(lists.get(i) == null)
				{lists.remove(i); }
				else
				{i++;}		
			}
			int size = lists.size();
			if(size== 0) return null;
			if(size == 1) return lists.get(0);
			
		 	//heap sort, build heap
			buildHeap(lists);
			ListNode head = lists.get(0);
			ListNode min = head;
			while(lists.size() > 0)
			{
				if(min.next== null)
				{
					//remove one from
					lists.remove(0);
					if(lists.size()>0)
					{
						buildHeap(lists);
						min.next = lists.get(0);
					}
				}
				else
				{
					ListNode next = min.next;
					lists.set(0, next);
					downHeap(lists, 0, lists.size()-1);
					ListNode newMin = lists.get(0);
					min.next = newMin;
					min = newMin;
				}
			}
		
			return head;
	    }

	//buttom up
	public void buildHeap(ArrayList<ListNode> lists)
	{
		int size = lists.size();
		int start = (size-2)/2; //start is assigned the index in a of the last parent node
		while(start >=0)
		{
			//sift down the node at index start to the proper place such that all nodes below
	        //the start index are in heap order
			downHeap(lists, start, size-1);
			start--;
		
		}
	}

	public void downHeap(ArrayList<ListNode> heap, int start, int end)
	{
        int root = start;
        while(root*2 +1 <= end)
        {
        	int child = root*2 +1;// left
        	int swap = root;
        	
        	if(heap.get(swap).val > heap.get(child).val)
        	{
        		swap = child;
        	}
        	if( child+1 <=end && heap.get(swap).val> heap.get(child+1).val)
        	{
        		swap = child + 1;
        	}
        	if(swap!= root)
        	{
        		//swap elem
    			ListNode temp = heap.get(swap);
    			heap.set(swap,heap.get(root));
    			heap.set(root, temp);
    			root = swap;
        	}
        	else
        		return;
        }
	}
	
	
	// http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
	// keep the distinct ones
	public ListNode deleteDuplicates_I(ListNode head) {

		if (head == null) {
			return head;
		}

		ListNode m = new ListNode(head.val);
		; // cursor to construct new list
		ListNode newHead = m;
		int curVal = m.val;

		// m = m.next;
		ListNode n = head.next; // cursor to find new value node

		while (n != null) {
			if (curVal != n.val) {
				m.next = new ListNode(n.val);
				m = m.next;
				curVal = n.val;
			}
			n = n.next;
		}

		return newHead;

	}

	// http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = null;
		ListNode p = null; // cursor for newHead
		ListNode n = head.next;
		ListNode m = head; // m save the start point of each node

		boolean isDistinct = true;
		while (n != null) {
			if (n.val == m.val) {
				isDistinct = false;
			} else {
				if (isDistinct) {
					if (p != null) {
						p.next = new ListNode(m.val);
						p = p.next;
					} else {
						p = new ListNode(m.val);
						newHead = p;
					}
				}
				// special case when n is the last node
				if (n.next == null) {
					if (p == null) {
						newHead = n;
					} else {
						p.next = n;
					}
					return newHead;
				}
				m = n;
				isDistinct = true;

			}
			n = n.next;
		}

		return newHead;
	}

	// http://oj.leetcode.com/problems/linked-list-cycle/
	public boolean hasCycle_L(ListNode head) {
		HashMap<ListNode, Integer> listmap = new HashMap<ListNode, Integer>();

		while (head != null) {
			// int key = head.val;
			if (listmap.get(head) == null) {
				listmap.put(head, 1);
			} else {
				return true;
			}
			head = head.next;
		}
		return false;

	}

	public ListNode detectCycle(ListNode head) {
		HashMap<ListNode, Integer> listmap = new HashMap<ListNode, Integer>();

		while (head != null) {
			// int key = head.val;
			if (listmap.get(head) == null) {
				listmap.put(head, 1);
			} else {
				return head;
			}
			head = head.next;
		}
		return null;
	}

	public boolean hasCycle(ListNode head) {

		ListNode p_s = head;
		ListNode p_f = head;
		while (p_s != null && p_f != null && head.next != null) {
			p_s = p_s.next;
			p_f = p_f.next.next;
			if (p_s == p_f) {
				return true;
			}
		}
		return false;
	}

	// http://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode faster = head;
		ListNode slow = head;

		int times = 0;
		int steps = n;
		while (slow != null) {
			while (faster.next != null && steps > 0) {
				faster = faster.next;
				steps--;
			}
			if (faster.next == null) {
				// cal distance from faster to slow
				int dis = times * (n - 1) + (n - steps) - n;
				while (dis > 0) {
					slow = slow.next;
					dis--;
				}
				if (dis == 0) {
					// remove node
					ListNode node = slow.next;
					slow.next = node.next;
					return head;
				} else if (dis == -1) {
					head = head.next;
					return head;
				}

			} else if (steps == 0) {
				// reset steps
				steps = n;
				slow = slow.next;
				times++;
			}

		}

		return head;
	}

	// http://oj.leetcode.com/problems/partition-list/
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;

		ListNode lpointer = null, gpointer = null;
		if (head.val < x) {
			lpointer = head;
		} else {
			gpointer = head;
		}

		while (lpointer != null || gpointer != null) {
			while (lpointer != null && lpointer.next != null) {
				if (lpointer.next.val < x) {
					lpointer = lpointer.next;
				} else {
					break;
				}
			}
			if (lpointer != null && lpointer.next == null)
				break;
			if (gpointer == null) {
				gpointer = lpointer.next;
			}
			while (gpointer != null && gpointer.next != null) {
				if (gpointer.next.val >= x) {
					gpointer = gpointer.next;
				} else {
					break;
				}
			}
			if (gpointer != null && gpointer.next == null)
				break;
			if (gpointer != null && lpointer != null) {
				// move the smaller one to lpointer 1, take gpointer.next
				ListNode sNext = gpointer.next;
				gpointer.next = gpointer.next.next;

				ListNode lNext = lpointer.next;
				lpointer.next = sNext;
				sNext.next = lNext;
				lpointer = lpointer.next;
			} else if (gpointer != null && lpointer == null) {
				// move the smaller one to lpointer 1, take gpointer.next
				ListNode sNext = gpointer.next;
				gpointer.next = gpointer.next.next;

				sNext.next = head;
				head = sNext;
				lpointer = head;
			}
		}

		return head;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode prev = null;
        int i =1; 
        ListNode startPrev = null;
        while(curr!= null)
        {

            if(i>=m && i< n)
            {
                startPrev = prev; // save start's prev
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                
            }
            else if( i== n)
            {
            	ListNode next = curr.next;
                curr.next = prev;
                //reconnect
                ListNode start = startPrev.next;
                startPrev.next = curr;
                start.next = next;
                curr = next;
            }
            else 
            {
            	prev = curr;
                curr = curr.next;
            }
            i++;
        }
        return head;
    }

	 public void reorderList(ListNode head) {
	        
	        //find the length
	        int count = 0;
	        ListNode cur = head;
	        while(cur!= null)
	        {
	            count++;
	            cur = cur.next;
	        }
	        if(count<3) return;
	        //find the middle point of the list, recheck the odd and even cases
	        int middle = (count-1)/2;
	        ListNode midPointer = head;
	        while(middle>0)
	        {
	            midPointer = midPointer.next;
	            middle--;
	        }
	        //reverse the right half
	        ListNode prev = midPointer;
	        ListNode curr2 = midPointer.next;
	        while(curr2!= null)
	        {
	            ListNode next = curr2.next;
	            curr2.next = prev;
	            prev = curr2;
	            curr2 = next;
	        }
	        ListNode tailCur = prev;
	        ListNode headCur = head;
	        //set 2 pointers : one move from the begining and one move from the end till they meet
	        while(headCur!= tailCur && headCur.next != tailCur)
	        {
	            ListNode hNext = headCur.next;
	            ListNode tNext = tailCur.next;
	            
	            headCur.next = tailCur;
	            tailCur.next = hNext;
	            
	            headCur = hNext;
	            tailCur = tNext;
	        }
	        if(headCur == tailCur)
	        {
	            headCur.next = null;
	        }
	        if(headCur.next == tailCur)
	        {
	            tailCur.next = null;
	        }
	        
	        return;
	    }
}
