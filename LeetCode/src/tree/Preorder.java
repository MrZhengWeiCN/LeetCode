package tree;

import java.util.ArrayList;

/**
 * 前序遍历
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2018年1月9日下午10:25:53
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
