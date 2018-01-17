package tree;

/**
 * 判断是否存在和为sum 的path Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月13日下午10:41:39
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		
		if(root==null) return false;
		if(root.val==sum&&root.left==null&&root.right==null) return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
