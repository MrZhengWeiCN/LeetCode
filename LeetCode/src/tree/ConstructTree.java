package tree;

/**
 * 中序遍历和后序遍历重建二叉树 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月16日下午9:19:37
 */
public class ConstructTree {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int in = inorder.length;
		int post = postorder.length;
		return doBulidTree(inorder, 0, in - 1, postorder, 0, post - 1);
	}

	public TreeNode doBulidTree(int[] inorder, int inStart, int inEnd,
			int[] postorder, int postStart, int postEnd) {
		if(inStart>inEnd)
			return null;
		TreeNode node = new TreeNode(postorder[postEnd]);
		// 找到中序遍历的根节点位置，确定左右子树
		int middle = inStart;
		for (middle = inStart; middle < inEnd; middle++) {
			if (inorder[middle] == node.val)
				break;
		}
		int leftLen = middle - inStart;
		node.left = doBulidTree(inorder, inStart, middle - 1, postorder,
				postStart, postStart + leftLen - 1);
		node.right = doBulidTree(inorder, middle + 1, inEnd, postorder,
				postStart + leftLen, postEnd - 1);
		return node;
	}
}
