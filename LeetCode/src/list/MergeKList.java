package list;

import java.util.ArrayList;

/**
 * ʹ�ò����������������� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��7������9:24:56
 */
public class MergeKList {

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if(lists.size()==1)
			return lists.get(0);
		return mergeList(lists,0,lists.size()-1);
	}

	private ListNode mergeList(ArrayList<ListNode> lists, int lo, int hi) {
		if(hi<=lo) return lists.get(lo);//һֱ���֣�֪����һ������
		int mid = (lo+hi)/2;
		ListNode l1 = mergeList(lists, lo, mid);
		ListNode l2 = mergeList(lists, mid+1, hi);
		return merge(l1,l2);
	}

	//�ϲ�
	private ListNode merge(ListNode l1, ListNode l2) {
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
