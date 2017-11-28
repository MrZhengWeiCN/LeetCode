package array;

/**
 * 排序数组转为二叉搜索树
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2017年11月14日下午5:47:09
 */
public class Array4 {
	public TreeNode sortedArrayToBST(int[] num) {
		
		TreeNode head = run(num,0,num.length-1);
		
		return head;
	}

	private TreeNode run(int[] num, int i, int j) {
		if(i>j)
			return null;
		//这句是关键点，节点的位置
		int mid = (i+j)/2+(i+j)%2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = run(num, i, mid-1);
		node.right = run(num, mid+1, j);
		return node;
	}
}
