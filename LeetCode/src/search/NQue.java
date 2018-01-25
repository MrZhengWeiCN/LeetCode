package search;

import java.util.ArrayList;
import java.util.Arrays;

public class NQue {

	public ArrayList<String[]> solveNQueens(int n) {
		// 先初始化
		ArrayList<String[]> result = new ArrayList<>();
		String[] round = new String[n];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++)
			sb.append(".");
		Arrays.fill(round, sb.toString());
		// 开始执行
		doSolveNQueens(0, n, n, result, round);
		return result;
	}

	public void doSolveNQueens(int nowRows, int rows, int cols,
			ArrayList<String[]> result, String[] round) {
		if (nowRows == rows) {
			String[] copyOf = Arrays.copyOf(round, round.length);
			result.add(copyOf);
		}
		// 查询这一行那一列可以添加
		for (int j = 0; j < cols; j++) {
			if (canAdd(nowRows, rows,j,cols, round)) {
				//这一步的操作
				char[] charArray = round[nowRows].toCharArray();
				charArray[j] = 'Q';
				String string = String.valueOf(charArray);
				round[nowRows] = string;
				//执行下一步
				doSolveNQueens(nowRows+1, rows, cols, result, round);
				//回溯
				charArray = round[nowRows].toCharArray();
				charArray[j] = '.';
				string = String.valueOf(charArray);
				round[nowRows] = string;
			}
		}
	}

	private boolean canAdd(int nowRows, int rows,int nowCols ,int cols, String[] round) {
		// 判断这cols列是否可以放置
		for (int i = 0; i <= nowRows; i++) {
			if (round[i].charAt(nowCols) == 'Q')
				return false;
		}
		// 判断反斜行是否可以
		for (int i = nowRows - 1, j = nowCols - 1; i >= 0 && j >= 0; i--, j--) {
			if (round[i].charAt(j) == 'Q')
				return false;
		}
		// 判断正斜行是否可以
		for (int i = nowRows - 1, j = nowCols + 1; i >= 0 && j<cols; i--, j++) {
			if (round[i].charAt(j) == 'Q')
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		NQue nQueue = new NQue();
		ArrayList<String[]> solveNQueens = nQueue.solveNQueens(1);
		System.out.println(solveNQueens.size());
	}
}
