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

}
