package LinkedListAndArray;

public class TestSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();

		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(1);
		node1.next.next = new ListNode(2);
		node1.next.next.next = new ListNode(4);
		node1.next.next.next.next = new ListNode(3);
		node1.next.next.next.next.next = new ListNode(5);
		
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(1);
		node2.next.next = new ListNode(2);
		//node2.next.next.next = node1.next.next;
		
		System.out.println(solution.checkIf2ListMerged(node1, node2));
//		ListNode newNode = solution.deleteDuplicates(node);
		
	}

}
