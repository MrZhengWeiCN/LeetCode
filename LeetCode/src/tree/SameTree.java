package tree;

/**
 * �ж����������Ƿ���ȡ� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��21������7:39:07
 */
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null){
			return true;
		}
		else if((p==null&&p!=null)||(p!=null&&p==null)){
			return false;
		}else if (p.val!=q.val) {
			return false;
		}else {
			return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
		}
	}
}
