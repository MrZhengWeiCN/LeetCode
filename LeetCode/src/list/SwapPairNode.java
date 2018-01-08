package list;

public class SwapPairNode {

	public ListNode swapPairs(ListNode head) {

		ListNode fake = new ListNode(0);
		ListNode pre = fake;
		pre.next = head;
		// 不一定保证是双数所以pre.next.next != null
		while (pre.next != null && pre.next.next != null) {
			ListNode node3 = pre.next;
			ListNode node4 = node3.next;
			ListNode node5 = node4.next;
			pre.next = node4;
			node4.next = node3;
			node3.next = node5;
			pre = node3;
		}
		return fake.next;
	}
}
