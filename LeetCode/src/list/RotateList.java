package list;

/**
 * 
 ��Ŀ;����һ��������������ת���ұߵ�k��λ�ã�����k�ǷǸ��ġ� ����: 1->2->3->4->5->NULL,ΪK = 2��
 * ����4->5->1->2->3->NULL��
 * 
 * Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��7������9:01:59
 */
public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
		// ������ɻ����ҳ��Ͽ����Ͽ�����
		int len = 0;
		ListNode pre = head;
		while (pre != null) {
			len++;
			pre = pre.next;
		}
		int k = n%len;
		k = n-k;
		//�ɻ�
		pre.next = head;
		//��ʼ�Ͽ�����
		for (int i = 0; i < k; i++) {
			pre = pre.next;
		}
		head = pre.next;//�µĽڵ�
		pre.next = null;//���ӶϿ����Ͽ�
		return head;
	}
}
