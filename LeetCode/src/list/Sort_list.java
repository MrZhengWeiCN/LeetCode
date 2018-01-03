package list;


public class Sort_list {

	public ListNode sortList(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode middle = findMiddle(head);
		ListNode right = sortList(middle.next);
		middle.next = null;//右边链表
		ListNode left = sortList(head);
		return merge(left, right);
	}

	// 找出中间点
	public ListNode findMiddle(ListNode head){
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast!=null&&fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	//合并
	public ListNode merge(ListNode head1,ListNode head2){
		if (head1==null) 
			return head2;
		if(head2==null)
			return head1;
		ListNode result = new ListNode(0);
		ListNode cursor = result;
		while(head1!=null&&head2!=null){
			if(head1.val>=head2.val){
				cursor.next = head2;
				head2 = head2.next;
			}else {
				cursor.next = head1;
				head1 = head1.next;
			}
			cursor = cursor.next;
		}
		if(head1==null)
			cursor.next = head2;
		if (head2==null) {
			cursor.next = head1;
		}
		return result.next;
	}
	
	public static void main(String[] args){
		Sort_list sList = new Sort_list();
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		ListNode sortList = sList.sortList(head);
		while (sortList!=null) {
			System.out.println(sortList.val);
			sortList = sortList.next;
		}
	}
}
