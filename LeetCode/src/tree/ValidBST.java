package tree;

/**
 * �ж��Ƿ�����Ч�Ķ������������� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��21������8:36:16
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
