package list;

/**
 * 寻找链表中环的入口点 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月3日下午9:46:46
 */
public class Linked_list_cycleII {

	public ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
}
