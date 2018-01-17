package tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 层序遍历 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月13日下午7:33:25
 */
public class LevelOrder {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> resuArrayList = new ArrayList<ArrayList<Integer>>();
		LinkedList<TreeNode> linkedList = new LinkedList<>();
		if(root==null){
			return resuArrayList;
		}
		linkedList.add(root);
		while (linkedList.size()>0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (TreeNode node : linkedList) {
				list.add(node.val);
			}
			resuArrayList.add(list);
			int s = linkedList.size();
			for (int i = 0; i < s; i++) {
				TreeNode first = linkedList.getFirst();
				linkedList.removeFirst();
				if(first.left!=null){
					linkedList.addLast(first.left);
				}
				if(first.right!=null){
					linkedList.addLast(first.right);
				}
			}
		}
		return resuArrayList;
	}
	
	public static void main(String[] args){
		LevelOrder levelOrder = new LevelOrder();
		TreeNode node = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode rigth = new TreeNode(3);
		node.left = left;
		node.right = rigth;
		levelOrder.levelOrder(node);
	}
}
