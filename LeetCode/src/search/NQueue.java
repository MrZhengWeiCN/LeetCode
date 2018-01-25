package search;

public class NQueue {

	int sum = 0;
	public int totalNQueens(int n) {
		int[][] round = new int[n][n];
		doTotalNQueens(0,n,n,round);
		return sum;
	}

	private void doTotalNQueens(int nowRow, int rows, int cols, int[][] round) {
		if(nowRow==rows){
			sum += 1;
			return;
		}
		for (int j = 0; j < cols; j++) {
			if(canPut(nowRow,rows,j,cols,round)){
				round[nowRow][j] = 1;
				doTotalNQueens(nowRow+1, rows, cols, round);
				round[nowRow][j] = 0;
			}
		}
	}

	private boolean canPut(int nowRow, int rows, int nowCols, int cols, int[][] round) {
		for (int i = 0; i <= nowRow; i++)
			if(round[i][nowCols]==1)
				return false;
		for (int i = nowRow-1,j=nowCols-1; i>=0&&j>=0; i--,j--) {
			if(round[i][j]==1)
				return false;
		}
		for (int i = nowRow-1,j=nowCols+1; i>=0&&j<cols; i--,j++) {
			if(round[i][j]==1)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		NQueue nQueue = new NQueue();
		System.err.println(nQueue.totalNQueens(4));
	}
}
