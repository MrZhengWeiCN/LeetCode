package tree;

import java.util.ArrayList;

/**
 * 中序遍历
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2018年1月12日下午10:15:02
 */
public class Inorder {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if(root==null)
			return list;
		doInOrder(list,root);
		return list;
	}

	private void doInOrder(ArrayList<Integer> list, TreeNode root) {
		if (root != null) {
			doInOrder(list, root.left);
			list.add(root.val);
			doInOrder(list, root.right);
		}
	}
}
