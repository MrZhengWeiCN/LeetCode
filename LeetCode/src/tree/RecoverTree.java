package tree;

/**
 * 恢復搜索树出错的两个节点 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月21日下午7:55:15
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
