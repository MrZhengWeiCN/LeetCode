package tree;

/**
 * 判断是否是有效的二叉树搜索树。 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月21日下午8:36:16
 */
public class ValidBST {

	boolean result = true;
	TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
	public boolean isValidBST(TreeNode root) {
		inOrder(root);
		return result;
	}
	private void inOrder(TreeNode root) {
		if(root==null){
			return;
		}
		inOrder(root.left);
		if(preNode.val>root.val){
			result = false;
		}
		preNode = root;
		inOrder(root.right);
	}
}
