package array;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {//б�ԽǷ�ת
			for (int j = 0; j < n-i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-j-1][n-i-1];
				matrix[n-j-1][n-i-1] = temp;
			}
		}
		for (int i = 0; i < n/2; i++) {//ˮƽ��ת
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-i-1][j];
				matrix[n-i-1][j] = temp;
			}
		}
	}
}
