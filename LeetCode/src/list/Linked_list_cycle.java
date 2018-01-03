package list;

/**
 * �ж������Ƿ��ֻ� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��3������9:35:52
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
