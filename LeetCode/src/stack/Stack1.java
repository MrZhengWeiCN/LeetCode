package stack;

/**
 * trapping-rain-water Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年12月28日上午11:16:17
 */
public class Stack1 {

	public int trap(int[] A) {
		if(A.length<=2)
			return 0;
		int len = A.length;
		int leftMax = A[0],rigthMax = A[len-1];
		int i =1,j=len-2;
		int sum = 0;
		while(i<=j){
			//木桶理论，找右最大值
			if(leftMax>rigthMax){
				sum += Math.max(0, rigthMax-A[j]);
				rigthMax = Math.max(rigthMax, A[j]);
				j--;
			}else {
				sum += Math.max(0, leftMax-A[i]);
				leftMax = Math.max(leftMax, A[i]);
				i++;
			}
		}
		return sum;
	}
	
	public static void main(String[] args){
		Stack1 stack1 = new Stack1();
		int a[] = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
		System.out.println(stack1.trap(a));
	}
}
