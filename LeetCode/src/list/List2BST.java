package list;


public class List2BST {

	public TreeNode sortedListToBST(ListNode head) {
		if(head==null){
			return null;
		}
		if (head.next==null) {
			return new TreeNode(head.val);
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = head;
		while(fast!=null&&fast.next!=null){
			pre = slow;
			slow = slow.next;
			fast =fast.next.next; 
		}
		TreeNode root = new TreeNode(slow.val);
		root.right = sortedListToBST(slow.next);
		pre.next = null;//断开前后链表
		root.left = sortedListToBST(head);
		return root;
	}
	
	
	public static void main(String[] args){
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		List2BST list2bst = new List2BST();
		TreeNode sortedListToBST = list2bst.sortedListToBST(node);
		System.out.println(sortedListToBST.val);
		System.out.println(sortedListToBST.left.val);
		System.out.println(sortedListToBST.right.val);
	}
}
