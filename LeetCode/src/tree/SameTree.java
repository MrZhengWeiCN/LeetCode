package tree;

/**
 * 判断两棵树是是否相等。 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月21日下午7:39:07
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
