package array;

/**
 * 0,1,2数组排序
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2017年11月21日下午9:37:14
 */
public class Array7 {

	public void sortColors(int[] A) {
		int index0 = 0;
		int index2 = A.length-1;
		int i=0;
		int temp;
		while(i<=index2){
			if(A[i]==0){
				temp = A[i];
				A[i++] = A[index0];
				A[index0++] = temp;
			}else if (A[i]==2) {
				temp = A[i];
				A[i] = A[index2];
				A[index2--] = temp;
			}else 
				i++;
		}
	}
	
	void sort(int i,int j){
		int temp = i;
		i = j;
		j = temp;
	}
	
	public static void main(String[] args){
		Array7 array7 = new Array7();
		int[] a = {0,1,2,2,1,0,0,1,2,1};
		array7.sortColors(a);
	}
}
