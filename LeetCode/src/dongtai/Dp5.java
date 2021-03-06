package dongtai;

/**
 * edit-distance
* Title:
* Description: 
* Company: 
* @author ֣ΰ
* @date 2017��12��6������10:59:29
 */
public class Dp5 {

	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null)
			return 0;
		if (word1 == null || word1.length() == 0)
			return word2.length();
		if (word2 == null || word2.length() == 0)
			return word1.length();
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= word1.length(); i++)
			dp[i][0] = i;
		for (int j = 1; j <= word2.length(); j++)
			dp[0][j] = j;
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
							dp[i - 1][j - 1]) + 1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
	
	public static void main(String[] args){
		Dp5 dp5 = new Dp5();
		System.out.println(dp5.minDistance("ab", "a"));
	}
}
