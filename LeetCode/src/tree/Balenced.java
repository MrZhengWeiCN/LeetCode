package tree;

/**
 * 判断一棵树是否是平衡的
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2018年1月16日下午8:39:24
 */
public class Balenced {

	public boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		if(Math.abs(getDept(root.left)-getDept(root.right))>1)
			return false;
		return isBalanced(root.left)&&isBalanced(root.right);
	}
	
	public int getDept(TreeNode root){
		if(root==null)
			return 0;
		int left = getDept(root.left)+1;
		int right = getDept(root.right)+1;
		return left>right?left:right;
	}
}
