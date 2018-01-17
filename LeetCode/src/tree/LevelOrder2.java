package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ���Ž��в������ Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��16������8:56:48
 */
public class LevelOrder2 {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> aa = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root==null)
			return aa;
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			ArrayList<Integer> a = new ArrayList<>();
			for(int i=0;i<size;i++){
				TreeNode poll = queue.poll();
				a.add(poll.val);
				if(poll.left!=null)
					queue.add(poll.left);
				if(poll.right!=null)
					queue.add(poll.right);
			}
			aa.add(0, a);
		}
		/*Collections.reverse(aa);*/
		return aa;
	}
}
