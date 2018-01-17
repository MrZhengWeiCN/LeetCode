package tree;

/**
 * ����·������ Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��13������9:38:28
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

	// �ҵ������������ֵ
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
