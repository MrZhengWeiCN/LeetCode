package array;

public class Array5 {

	public void merge(int A[], int m, int B[], int n) {
		int indexA = m-1,indexB = n-1,indexAll = n+m-1;
		while(indexA>=0&&indexB>=0)
			A[indexAll--] = (A[indexA]>B[indexB]?A[indexA--]:B[indexB--]);
		//如果indexB=0则不需要处理
		while(indexB>=0)
			A[indexAll--] = B[indexB--];
	}
}
