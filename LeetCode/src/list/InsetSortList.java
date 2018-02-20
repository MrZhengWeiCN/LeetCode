package list;

/**
 * Created by Zhwei on 2018/2/20.
 */
public class InsetSortList {

    public ListNode insertionSortList(ListNode head) {

        if(head==null||head.next==null) return  head;
        ListNode fake = new ListNode(0);
        fake.next = insertionSortList(head.next);
        ListNode cur = fake.next,pre=fake;
        while(cur!=null&&head.val>cur.val){
            pre = cur;
            cur = cur.next;
        }
        head.next = cur;
        pre.next= head;
        return fake.next;
    }
}
