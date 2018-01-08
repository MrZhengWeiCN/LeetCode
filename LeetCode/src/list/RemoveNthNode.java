package list;

/**
 * 移除倒数第n个节点 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月7日下午10:11:26
 */
public class RemoveNthNode {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pre = new ListNode(0);
		ListNode fake = pre;
		pre.next = head;
		ListNode fast = head;
		ListNode slow = head;
		int step = 0;
		while(fast.next!=null){
			fast = fast.next;
			step++;
			if(step>=n){
				slow = slow.next;
				pre = pre.next;
			}
		}
		//此时的slow就是倒数第N个节点
		pre.next = slow.next;
		return fake.next;
	}
	
}
