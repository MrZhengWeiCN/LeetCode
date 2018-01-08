package list;


/**
 * 反转一段链表 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月7日下午4:47:40
 */
public class Reverse_inkedlistii {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode pre = fake;
		ListNode start = head;
		for (int i = 1; i < m;) {
			pre = pre.next;
			start = start.next;
		}
		// 找到开始节点，开始反转直到n节点
		for (int i = 0; i < n - m; i++) {
			ListNode temp = start.next;
			start.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}
		//返回头节点
		return fake.next;
	}

	
}
