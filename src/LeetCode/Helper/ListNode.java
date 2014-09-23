package LeetCode.Helper;

//Definition for singly-linked list.
public class ListNode {
  public int val;
  public ListNode next;
  public ListNode(int x) {
      val = x;
      next = null;
  }
  
  
  public static ListNode BuildLinkList(int[] array)
  {
	 if(array.length == 0) return null;
	 
	 ListNode head = new ListNode(array[0]);
	 ListNode pointer = head;
	 for(int i = 1 ; i< array.length; i++)
	 {
		 head.next = new ListNode(array[i]);
		 head = head.next;
	 }
	 return pointer;
  }
  
  public static void PrintList(ListNode head)
  {
	  while(head!= null)
	  {
		  System.out.print(head.val + "=>");
		  head = head.next;
	  }
  }
}
//
