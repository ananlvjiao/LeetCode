package LinkedListAndArray;

public class Solution {

	public boolean checkIf2ListMerged(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return false;
		}
		ListNode p = head1;
		while (p.next != null) {
			p = p.next;
		}

		p.next = head2;
		p = p.next;
		while (p.next != null) {
			p = p.next;
			if(p==head2)
			{
				return true;
			}

		}
		return false;

	}
	
	//check if a given array contains a pair sum up to a target value
	
	
	//find a missing val in an array contains 1- 100,0000 
    public int findMissingOne(int[] array)
    {
    	int preCal = 1;
    	for(int i= 2; i<array.length+2; i++)
    	{
    		preCal = preCal^i;
    	}
    	for(int i= 0; i< array.length; i++)
    	{
    		preCal = preCal^array[i];
    	}
    	return preCal;
    }

    //Sort a linked list using insertion sort
    //https://oj.leetcode.com/problems/insertion-sort-list/
    public ListNode insertionSort(ListNode head)
    {
        if(head == null || head.next == null) return head;
        ListNode cur = head.next;//start from 1
        ListNode prev = head;
        while(cur != null)
        {
            if(prev.val > cur.val) {
                //take the node out
                ListNode xnode = cur;
                //move cur out
                prev.next = cur.next;

                ListNode curJ = head;
                ListNode prevJ = null;
                while (xnode.val > curJ.val) {
                    prevJ = curJ;
                    curJ = curJ.next;
                }
                //insert it
                if(prevJ == null){
                    head = xnode;
                }
                else {
                    prevJ.next = xnode;
                }
                xnode.next = curJ;

                //reset cur
                cur = prev;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;

    }

    public void insertionSort (int[] array)
    {
        if(array == null) {
            return;
        }
        for(int i=1; i< array.length; i++)
        {
            int j = i;
            while(j>0 && array[j]<array[j-1])
            {
                //swap array[j] array[j-1]
                j=j-1;
            }
        }
    }

    public void insertionSort2 (int[] array)
    {
        if(array == null) {
            return;
        }
        for(int i=1; i< array.length; i++)
        {
            int j = i;
            int x = array[j];
            while(j>0 && array[j]<array[j-1])
            {
                array[j] = array[j-1];
                j=j-1;
            }
            array[j] = x;
        }
    }
}

