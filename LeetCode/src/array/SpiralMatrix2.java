package array;

public class SpiralMatrix2 {

	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int value = 1;
		for (int level = 0; level < n / 2 + n % 2; level++) {
			for(int i = level;i<n-level;i++) 
				result[level][i] = value++;//��һ��
			for (int i = level+1; i < n-level; i++) {
				result[i][n-level-1] = value++;//���һ��
			}
			for (int i = n-level-2; i >= level; i--) {
				result[n-level-1][i] = value++;//���һ��
			}
			for (int i = n-level-2; i >=level+1; i--) {
				result[i][level] = value++;//��һ��
			}
		}
		return result;
	}
}
