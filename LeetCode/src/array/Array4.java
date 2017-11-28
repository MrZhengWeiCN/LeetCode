package array;

/**
 * ��������תΪ����������
* Title:
* Description: 
* Company: 
* @author ֣ΰ
* @date 2017��11��14������5:47:09
 */
public class Array4 {
	public TreeNode sortedArrayToBST(int[] num) {
		
		TreeNode head = run(num,0,num.length-1);
		
		return head;
	}

	private TreeNode run(int[] num, int i, int j) {
		if(i>j)
			return null;
		//����ǹؼ��㣬�ڵ��λ��
		int mid = (i+j)/2+(i+j)%2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = run(num, i, mid-1);
		node.right = run(num, mid+1, j);
		return node;
	}
}
