package array;

/**
 * �������������������ظ������� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2017��11��20������10:00:46
 */
public class Array6 {

	public int removeDuplicates(int[] A) {
		/*
		 * int currentValue=0; int currentTimes=0; int totalNumber=0; for (int i
		 * = 0; i < A.length; i++) { if(currentValue==A[i]){ currentTimes++;
		 * }else { currentValue = A[i]; currentTimes = 1; } if(currentTimes<=2){
		 * A[totalNumber++] = A[i]; } } return totalNumber;
		 */
		// �򵥰�
		if (A.length <= 2)
			return A.length;
		int total = 2;
		for (int i = 2; i < A.length; i++) {
			 //�����һ��д����A[i-2]Ҫע�����ԭ��
			if (A[i] != /*A[i - 2]*/A[total - 2])
				A[total++] = A[i];
		}
		return total;
	}
}
