package list;


/**
 * 链表的反转操作
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2018年1月7日下午7:28:33
 */
public class ReverseList {

	public ListNode reverse(ListNode head){
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode start = head;
		while(start.next!=null){
			ListNode temp = start.next;
			start.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}
		return pre.next;
	}
	
	public ListNode build(int length){
		ListNode head = new ListNode(0);
		ListNode fake = head;
		for (int i = 1; i <= length; i++) {
			head.next = new ListNode(i);
			head = head.next;
		}
		return fake.next;
	}
	
	public static void main(String[] args){
		ReverseList reverseList = new ReverseList();
		ListNode build = reverseList.build(10);
		ListNode reverse = reverseList.reverse(build);
		while(reverse!=null){
			System.out.println(reverse.val);
			reverse = reverse.next;
		}
	}
}
