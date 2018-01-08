package list;

public class MergeLlists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)return l2;
		if (l2 == null)return l1;
		ListNode pre = new ListNode(0);
		ListNode fake = pre;
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				pre.next = l1;
				pre = pre.next;
				l1 = l1.next;
			}else {
				pre.next = l2;
				pre = pre.next;
				l2 = l2.next;
			}
		}
		if(l1==null)pre.next = l2;
		if(l2==null)pre.next = l1;
		return fake.next;
	}
}
