package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Z������������� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��16������10:13:58
 */
public class Ztree {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> aa = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root==null)
			return aa;
		queue.add(root);
		int level = 0;
		while(!queue.isEmpty()){
			level++;
			int size = queue.size();
			ArrayList<Integer> a = new ArrayList<>();
			for(int i=0;i<size;i++){
				TreeNode poll = queue.poll();
				a.add(poll.val);
				if(level%2!=0){
					if(poll.left!=null)
						queue.add(poll.left);
					if(poll.right!=null)
						queue.add(poll.right);
				}else {
					if(poll.right!=null)
						queue.add(poll.right);
					if(poll.left!=null)
						queue.add(poll.left);
				}
			}
			aa.add( a);
		}
		return aa;
	}
}
