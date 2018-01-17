package tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * �뵽�˵ݹ�
* Title:
* Description: 
* Company: 
* @author ֣ΰ
* @date 2018��1��13������8:20:00
 */

public class Minimum_Depth {

	public int run(TreeNode root) {
		LinkedList<TreeNode> linkedList = new LinkedList<>();
		if(root==null) return 0;
		linkedList.add(root);
		int dept = 0;
		while (linkedList.size()>0) {
			dept++;
			int s = linkedList.size();
			for (int i = 0; i < s; i++) {
				TreeNode first = linkedList.getFirst();
				linkedList.removeFirst();
				if(first.left!=null) linkedList.addLast(first.left);
				if(first.right!=null) linkedList.addLast(first.right);
				if(first.left==null&&first.right==null) return dept;
			}
		}
		return dept;
	}
}
