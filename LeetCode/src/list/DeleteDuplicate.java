package list;

public class DeleteDuplicate {

	public ListNode deleteDuplicates(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode pre = head;
		ListNode next = head.next;
		while(next!=null){
			if(next.val!=pre.val){
				pre.next = next;
				pre = pre.next;
			}
			next = next.next;
		}
		pre.next = null;
		return head;
	}
}
