package tree;

/**
 * �ж��Ƿ���ں�Ϊsum ��path Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��13������10:41:39
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		
		if(root==null) return false;
		if(root.val==sum&&root.left==null&&root.right==null) return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
