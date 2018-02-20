package array;

public class SpiralMatrix2 {

	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int value = 1;
		for (int level = 0; level < n / 2 + n % 2; level++) {
			for(int i = level;i<n-level;i++) 
				result[level][i] = value++;//第一行
			for (int i = level+1; i < n-level; i++) {
				result[i][n-level-1] = value++;//最后一列
			}
			for (int i = n-level-2; i >= level; i--) {
				result[n-level-1][i] = value++;//最后一行
			}
			for (int i = n-level-2; i >=level+1; i--) {
				result[i][level] = value++;//第一列
			}
		}
		return result;
	}
}
