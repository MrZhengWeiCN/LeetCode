package list;

/**
 * 判断链表是否又环 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月3日下午9:35:52
 */
public class Linked_list_cycle {

	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast!=null&&fast.next!=null){
			if(slow==fast)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
}
