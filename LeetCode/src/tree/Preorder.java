package tree;

import java.util.ArrayList;

/**
 * ǰ�����
* Title:
* Description: 
* Company: 
* @author ֣ΰ
* @date 2018��1��9������10:25:53
 */
public class Preorder {

	public ArrayList<Integer> preorderTraversal(TreeNode root) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		doPreorderTraversal(root, result);
		return result;
	}

	private void doPreorderTraversal(TreeNode root,
			ArrayList<Integer> result) {
		if (root != null) {
			result.add(root.val);
			doPreorderTraversal(root.left, result);
			doPreorderTraversal(root.right, result);
		}
	}
}
