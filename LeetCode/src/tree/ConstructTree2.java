package tree;

/**
 * ǰ������򹹽������� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��16������9:51:16
 */
public class ConstructTree2 {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int pre = preorder.length;
		int in = inorder.length;
		return doBuildTree(preorder, 0, pre - 1, inorder, 0, in - 1);
	}

	public TreeNode doBuildTree(int[] preorder, int preStart, int preEnd,
			int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd)
			return null;
		TreeNode node = new TreeNode(preorder[preStart]);
		// �ҵ��м��
		int middle;
		for (middle = inStart; middle < inEnd; middle++) {
			if (inorder[middle] == node.val)
				break;
		}
		int leftLen = middle - inStart;
		node.left = doBuildTree(preorder, preStart + 1, preStart + leftLen,
				inorder, inStart, middle - 1);
		node.right = doBuildTree(preorder, preStart + leftLen + 1, preEnd,
				inorder, middle + 1, inEnd);
		return node;
	}
}
