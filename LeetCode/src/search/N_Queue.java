package search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * N 皇后问题 Created by Zhwei on 2018/1/24.
 */
public class N_Queue {
	
	ArrayList<String[]> result = new ArrayList<>();
	
	public ArrayList<String[]> solveNQueens(int n) {
		String[] round = new String[n];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(".");
		}
		Arrays.fill(round, sb.toString());
		doSolveNQueue(n, 0, round, result);
		return result;
	}

	public void doSolveNQueue(int totalRows, int rowsIndex, String[] round,
			ArrayList<String[]> result) {
		if (rowsIndex == totalRows) {
			result.add(round);
			return;
		}
		int cols = totalRows;
		for (int j = 0; j < cols; j++) {
			if (canPut(rowsIndex, totalRows, j, round)) {
				char[] charArray = round[rowsIndex].toCharArray();
				charArray[j] = 'Q';
				String string = String.valueOf(charArray);
				round[rowsIndex] = string;
				doSolveNQueue(totalRows, rowsIndex + 1, round, result);
				charArray = round[rowsIndex].toCharArray();
				charArray[j] = '.';
				string = String.valueOf(charArray);
				round[rowsIndex] = string;
			}
		}
	}

	private boolean canPut(int rowsIndex, int totalRows, int cols,
			String[] round) {
		// 检查列
		for (int i = 0; i < totalRows; i++) {
			if (round[i].charAt(cols) == 'Q') {
				return false;
			}
		}
		// 检查反斜线
		for (int i = rowsIndex - 1, j = cols - 1; i >= 0 && j >= 0; i--, j--) {
			if (round[i].charAt(j) == 'Q') {
				return false;
			}
		}
		// 检查斜线
		for (int i = rowsIndex - 1, j = cols + 1; i >= 0 && j < totalRows; i--, j++) {
			if (round[i].charAt(j) == 'Q') {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		N_Queue n_Queue = new N_Queue();
		ArrayList<String[]> solveNQueens = n_Queue.solveNQueens(4);
		System.out.println(solveNQueens.size());
	}
}
