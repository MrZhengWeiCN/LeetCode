package list;


/**
 * ��תһ������ Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��7������4:47:40
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
		// �ҵ���ʼ�ڵ㣬��ʼ��תֱ��n�ڵ�
		for (int i = 0; i < n - m; i++) {
			ListNode temp = start.next;
			start.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}
		//����ͷ�ڵ�
		return fake.next;
	}

	
}
