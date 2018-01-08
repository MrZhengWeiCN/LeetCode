package list;

/**
 * �Ƴ�������n���ڵ� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��7������10:11:26
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
		//��ʱ��slow���ǵ�����N���ڵ�
		pre.next = slow.next;
		return fake.next;
	}
	
}
