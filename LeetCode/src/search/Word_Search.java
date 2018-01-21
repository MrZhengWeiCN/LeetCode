package search;


/**
 * ��ά������ҵ��� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��21������9:26:27
 */
public class Word_Search {

	public boolean exist(char[][] board, String word) {
		int h = board.length;
		int w = board[0].length;
		boolean[][] visited = new boolean[h][w];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (doExist(board, i, j, word, 0, visited))
					return true;
			}
		}
		return false;
	}
	public boolean doExist(char[][] board, int i, int j, String word,
			int index, boolean[][] visited) {
		if (word.length() == index)
			return true;// ��ʾƥ�䵹�����һ��
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
				|| visited[i][j] || word.charAt(index) != board[i][j]) 
			return false;
		visited[i][j] = true;
		Boolean result = doExist(board, i+1, j, word, index+1, visited)
				|| doExist(board, i-1, j, word, index+1, visited)
				|| doExist(board, i, j+1, word, index+1, visited)
				|| doExist(board, i, j-1, word, index+1, visited);
		visited[i][j] = false;
		return result;
	}
	
	public static void main(String[] args){
		Word_Search word_Search = new Word_Search();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','D','E'}};
		boolean exist = word_Search.exist(board, "SFDA");
		System.out.println(exist);
	}
}
