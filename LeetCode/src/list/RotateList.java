package list;

/**
 * 
 题目;给定一个链表，将链表旋转到右边的k个位置，其中k是非负的。 例如: 1->2->3->4->5->NULL,为K = 2，
 * 返还4->5->1->2->3->NULL。
 * 
 * Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月7日下午9:01:59
 */
public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
		// 将链表成环，找出断开处断开即可
		int len = 0;
		ListNode pre = head;
		while (pre != null) {
			len++;
			pre = pre.next;
		}
		int k = n%len;
		k = n-k;
		//成环
		pre.next = head;
		//开始断开连接
		for (int i = 0; i < k; i++) {
			pre = pre.next;
		}
		head = pre.next;//新的节点
		pre.next = null;//连接断开处断开
		return head;
	}
}
