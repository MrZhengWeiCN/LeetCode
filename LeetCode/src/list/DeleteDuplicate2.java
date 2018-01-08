package list;

/**
 * 删除重复的节点 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月7日下午7:58:54
 */
public class DeleteDuplicate2 {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = new ListNode(0);
		ListNode fake = pre;
		int thisVal = -10100;
		while (head != null) {
			if (head.val != thisVal) {
				if (head.next == null || head.val != head.next.val) {
					pre.next = head;
					pre = pre.next;
				}
			}
			thisVal = head.val;
			head = head.next;
		}
		pre.next = null;
		return fake.next;
	}

	public static void main(String[] args) {
		DeleteDuplicate2 duplicate2 = new DeleteDuplicate2();
		ListNode pre = new ListNode(1);
		pre.next = new ListNode(2);
		pre.next.next = new ListNode(2);
		ListNode deleteDuplicates = duplicate2.deleteDuplicates(pre);
		while (deleteDuplicates != null) {
			System.out.println(deleteDuplicates.val);
			deleteDuplicates = deleteDuplicates.next;
		}
	}

}
