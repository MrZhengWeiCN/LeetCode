package list;

public class Medianofarrays {

	public double findMedianSortedArrays(int A[], int B[]) {

		int m = A.length;
		int n = B.length;
		int[] AB = new int[m+n];
		int indexA = 0;
		int indexB = 0;
		int index = 0;
		//ֻҪ���鵽(m+n)/2�Ϳ�����
		while(index<=(m+n)/2){
			if(A[indexA]<B[indexB]){
				AB[index] = A[indexA];
				indexA++;
			}else {
				AB[index] = B[indexB];
				indexB++;
			}
			index++;
		}
		if((m+n)%2==0){
			//���m+n��ż��
			return AB[(m+n)/2];
		}else {
			return (AB[(m+n)/2]+AB[(m+n)/2-1])/2.0;
		}
	}
}
