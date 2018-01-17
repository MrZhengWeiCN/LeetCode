package tree;

/**
 * 所有路径最大和 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月13日下午9:38:28
 */
public class MaxPathSum {

	public int maxPathSum(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int left = Math.max(0,findMax(root.left));
		int right = Math.max(0,findMax(root.right));
		int max = Integer.MIN_VALUE;
		max = Math.max(max, left+right+max);
		return max;
	}

	// 找到左右子树最大值
	private int findMax(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.val;
		}
		return Math.max(findMax(node.left), findMax(node.right)) + node.val;
	}

}
