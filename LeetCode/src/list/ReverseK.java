package list;

/**
 * Created by Zhwei on 2018/2/17.
 */
public class ReverseK {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;
        //统计长度
        int len = 0;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        ListNode cur = head,temp;
        while(head!=null) {
            len++;
            head = head.next;
        }
        //以k为分割
        for (int i = 0; i < len / k; i++) {
            //K段的链表进行反转。
            for (int j = 1; j < k; j++) {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            //下一group，调整pre和cur
            pre = cur;
            cur = cur.next;
        }
        return fake.next;
    }

    public static void main(String[] args) {
        ReverseK reverseK = new ReverseK();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node = reverseK.reverseKGroup(node, 2);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
