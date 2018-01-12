package tree;

import java.util.ArrayList;

/**
 * �������
* Title:
* Description: 
* Company: 
* @author ֣ΰ
* @date 2018��1��12������10:15:02
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
