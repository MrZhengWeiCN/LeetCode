package search;

import java.util.ArrayList;
import java.util.Arrays;

public class NQue {

	public ArrayList<String[]> solveNQueens(int n) {
		// �ȳ�ʼ��
		ArrayList<String[]> result = new ArrayList<>();
		String[] round = new String[n];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++)
			sb.append(".");
		Arrays.fill(round, sb.toString());
		// ��ʼִ��
		doSolveNQueens(0, n, n, result, round);
		return result;
	}

	public void doSolveNQueens(int nowRows, int rows, int cols,
			ArrayList<String[]> result, String[] round) {
		if (nowRows == rows) {
			String[] copyOf = Arrays.copyOf(round, round.length);
			result.add(copyOf);
		}
		// ��ѯ��һ����һ�п������
		for (int j = 0; j < cols; j++) {
			if (canAdd(nowRows, rows,j,cols, round)) {
				//��һ���Ĳ���
				char[] charArray = round[nowRows].toCharArray();
				charArray[j] = 'Q';
				String string = String.valueOf(charArray);
				round[nowRows] = string;
				//ִ����һ��
				doSolveNQueens(nowRows+1, rows, cols, result, round);
				//����
				charArray = round[nowRows].toCharArray();
				charArray[j] = '.';
				string = String.valueOf(charArray);
				round[nowRows] = string;
			}
		}
	}

	private boolean canAdd(int nowRows, int rows,int nowCols ,int cols, String[] round) {
		// �ж���cols���Ƿ���Է���
		for (int i = 0; i <= nowRows; i++) {
			if (round[i].charAt(nowCols) == 'Q')
				return false;
		}
		// �жϷ�б���Ƿ����
		for (int i = nowRows - 1, j = nowCols - 1; i >= 0 && j >= 0; i--, j--) {
			if (round[i].charAt(j) == 'Q')
				return false;
		}
		// �ж���б���Ƿ����
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
