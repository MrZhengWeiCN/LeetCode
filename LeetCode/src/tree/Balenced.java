package tree;

/**
 * �ж�һ�����Ƿ���ƽ���
* Title:
* Description: 
* Company: 
* @author ֣ΰ
* @date 2018��1��16������8:39:24
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
