package array;

/**
 * first-missing-positive Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年11月22日上午11:06:41
 */
public class Array9 {

	public int firstMissingPositive(int[] A) {
		if(A==null||A.length==0)
			return 1;
		int[] array = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if(A[i]>0&&A[i]<=A.length){
				array[A[i]-1] = A[i];
			}
		}
		for (int i = 0; i < array.length; i++) {
			if(array[i]==0)
				return i+1;		
		}
		return array.length+1;
	}
	
	public static void main(String[] arStrings){
		Array9 array9 = new Array9();
		int[] a ={3,4,-1,1,4};
		System.out.println(array9.firstMissingPositive(a));
	}
}
