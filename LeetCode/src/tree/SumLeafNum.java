package tree;



public class SumLeafNum {

	public int sumNumbers(TreeNode root) {
		/*if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		if (root.left != null && root.right == null) {
			return Integer.valueOf("" + root.val + sumNumbers(root.left));
		}
		if (root.left == null && root.right != null) {
			return Integer.valueOf("" + root.val + sumNumbers(root.right));
		}
		return Integer.valueOf("" + root.val + sumNumbers(root.left))
				+ Integer.valueOf("" + root.val + sumNumbers(root.right));*/
		return doSumNumbers(root,0);
	}
	
	private int doSumNumbers(TreeNode root, int sum) {
		if(root==null) return 0;
		sum = sum*10+root.val;
		if(root.left==null&&root.right==null) return sum;
		return doSumNumbers(root.left, sum)+doSumNumbers(root.right, sum);
	}

	public static int fun(TreeNode root, int sum) {
        if(root == null) return 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) return sum;
        return fun(root.left, sum) + fun(root.right, sum);
    }


}
