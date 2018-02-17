package list;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		ListNode preFake = new ListNode(0);
		ListNode preHead = preFake;
		ListNode posFake = new ListNode(0);
		ListNode posHead = posFake;
		while(head!=null){
			if(head.val<x){
				preHead.next = head;
				preHead = preHead.next;
			}else {
				posHead.next = head;
				posHead = posHead.next;
			}
			head = head.next;
		}
		//将pos最后一个节点断开，以免成环
		//pre不需要断，应为我们重新设定pre.next
		posHead.next = null;
		preHead.next = posFake.next;
		return preFake.next;
	}
}
