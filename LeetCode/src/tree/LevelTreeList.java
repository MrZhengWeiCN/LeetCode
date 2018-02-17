package tree;

import java.util.LinkedList;

public class LevelTreeList {

	public void connect(TreeLinkNode root) {
		if(root==null) return;
		LinkedList<TreeLinkNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeLinkNode pre = new TreeLinkNode(0);
			for (int i = 0; i < size; i++) {
				TreeLinkNode first = queue.pollFirst();
				if(first.left!=null) queue.add(first.left);
				if(first.right!=null) queue.add(first.right);
				pre.next = first;
				pre = pre.next;
				if(i == size-1) pre.next = null;
			}
		}
	}
}
