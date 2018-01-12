package tree;

import java.util.ArrayList;

public class PostOrder {

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if(root==null)
			return list;
		doPostOrder(list,root);
		return list;
	}

	private void doPostOrder(ArrayList<Integer> list, TreeNode root) {
		if (root != null) {
			doPostOrder(list, root.left);
			doPostOrder(list, root.right);
			list.add(root.val);
		}
	}
}
