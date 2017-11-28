package array;

/**
 * remove-element Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年11月28日上午10:53:23
 */
public class Array14 {

	public int removeElement(int[] A, int elem) {
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if(A[i]!=elem) A[index++] = A[i];
		}
		return index;
	}
}
