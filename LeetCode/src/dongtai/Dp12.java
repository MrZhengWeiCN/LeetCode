package dongtai;

/**
 * interleaving-string Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年12月14日下午7:41:05
 */
public class Dp12 {

	public boolean isInterleave(String s1, String s2, String s3) {
		int l = s1.length();
		int m = s2.length();
		int n = s3.length();
		if ((l + m) != n)
			return false;
		boolean[][] dp = new boolean[l + 1][m + 1];
		dp[0][0] = true;
		for (int i = 1; i <= l; i++) {
			dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int j = 1; j <= m; j++) {
			dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
		}
		for (int i = 1; i <= l; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i
						- 1 + j)))
						|| (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i
								- 1 + j)));
			}
		}
		return dp[l][m];
	}
}
