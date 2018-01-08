package list;

public class CopyRandomListNode {

	public RandomListNode copyRandomList(RandomListNode head) {

		if(head == null || (head.next == null && head.random == null))
            return head;
       RandomListNode A = head;
       //先复制
       while(A!=null){
           RandomListNode B = A.next;
           RandomListNode CopyA = new RandomListNode(A.label);
           A.next = CopyA;
           CopyA.next = B;
           A = B;
       }
       //复制额外的指针
       A = head;
       while(A!=null&&A.next!=null){
           if(A.random!=null){
               A.next.random = A.random.next;
           }
           A = A.next.next;
       }
       RandomListNode result = head.next;
       //断开连接
       A = head;
       while(A.next.next!=null){
           RandomListNode a = A.next;
           RandomListNode B = a.next;
           RandomListNode b = B.next;
           a.next = b;
           A.next = B;
           A = B;
       }
       return result;
	}

	public static void main(String[] args) {
		CopyRandomListNode node = new CopyRandomListNode();
		RandomListNode A = new RandomListNode(1);
		A.next = new RandomListNode(2);
		RandomListNode copyRandomList = node.copyRandomList(A);
		while (copyRandomList != null) {
			System.out.println(copyRandomList.label);
			copyRandomList = copyRandomList.next;
		}
	}
}
