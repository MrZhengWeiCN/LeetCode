package array;

/**
 * 排序数组最多出现两个重复的数组 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年11月20日下午10:00:46
 */
public class Array6 {

	public int removeDuplicates(int[] A) {
		/*
		 * int currentValue=0; int currentTimes=0; int totalNumber=0; for (int i
		 * = 0; i < A.length; i++) { if(currentValue==A[i]){ currentTimes++;
		 * }else { currentValue = A[i]; currentTimes = 1; } if(currentTimes<=2){
		 * A[totalNumber++] = A[i]; } } return totalNumber;
		 */
		// 简单版
		if (A.length <= 2)
			return A.length;
		int total = 2;
		for (int i = 2; i < A.length; i++) {
			 //这里第一次写成了A[i-2]要注意错误原因
			if (A[i] != /*A[i - 2]*/A[total - 2])
				A[total++] = A[i];
		}
		return total;
	}
}
