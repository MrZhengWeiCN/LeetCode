package tree;

import java.util.ArrayList;

public class PathSum2 {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

		ArrayList<ArrayList<Integer>> aa = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		hasPathSum(root, sum, aa, a);
		return aa;
	}

	public void hasPathSum(TreeNode root, int sum,
			ArrayList<ArrayList<Integer>> aa, ArrayList<Integer> a) {

		if (root.val > sum) {
			return;
		}
		if (root.val == sum && root.left == null && root.right == null) {
			a.add(root.val);
			aa.add(new ArrayList<>(a));
			a.remove(a.size() - 1);
			return;
		}
		a.add(root.val);
		hasPathSum(root.left, sum - root.val, aa, a);
		hasPathSum(root.right, sum - root.val, aa, a);
		a.remove(a.size() - 1);
	}
	
	public static void main(String[] args){
		PathSum2 pathSum2 = new PathSum2();
		TreeNode node = new TreeNode(1);
		pathSum2.pathSum(node, 0);
	}
}
