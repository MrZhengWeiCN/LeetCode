package tree;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		return doSymmetric(root.left,root.right);
	}

	public boolean doSymmetric(TreeNode leftNode, TreeNode rightNode) {
		if(leftNode==null&&rightNode==null){
			return true;//比较完了
		}
		if((leftNode==null&&rightNode!=null)||(leftNode!=null&&rightNode==null)){
			return false;
		}
		if (leftNode.val != rightNode.val) {
			return false;
		}
		return doSymmetric(leftNode.right, rightNode.left)
				&& doSymmetric(leftNode.left, rightNode.right);
	}
}
