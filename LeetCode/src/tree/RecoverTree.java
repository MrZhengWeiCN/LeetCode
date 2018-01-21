package tree;

/**
 * �֏�����������������ڵ� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��21������7:55:15
 */
public class RecoverTree {

	TreeNode one = null;
	TreeNode two = null;
	TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) {
		doInorder(root);
		int temp = one.val;
		one.val = two.val;
		two.val = temp;
	}
	
	private void doInorder(TreeNode root) {
		if(root==null)
			return;
		doInorder(root.left);
		if(one==null&&preNode.val>root.val){
			one = preNode;
		}
		if(one!=null&&preNode.val>root.val){
			two = root;
		}
		preNode = root;
		doInorder(root.right);
	}
}
