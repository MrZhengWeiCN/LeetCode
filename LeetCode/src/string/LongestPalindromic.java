package string;

public class LongestPalindromic {

	public String longestPalindrome(String s) {
		String result = null;
		int len = 0;
		// 使用暴力解法
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String substring = s.substring(i, j);
				if (isPalindrome(substring)) {
					if (substring.length() > len) {
						len = substring.length();
						result = substring;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 使用动态规划的
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome2(String s) {
		int len = s.length();
		int maxlen = 0;
		String result = null;
		boolean[][] dp = new boolean[len][len];
		int left = 0, right = 0;
		for (int j = 0; j < len; j++) {
			for (int i = 0; i < j; i++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					if (j - i + 1 > maxlen) {
						maxlen = j - i + 1;
						result = s.substring(i, j+1);
						left = i;
						right = j;
					}
				}
			}
		}
		if (left == 0 && right == 0)
			return s.charAt(0) + "";
		return result;
	}

	private boolean isPalindrome(String substring) {
		for (int i = 0, j = substring.length() - 1; i <= j; i++, j--) {
			if (substring.charAt(i) != substring.charAt(j))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String string = "abababababababgegergreebabababababfthtrhabababababab";
		LongestPalindromic longestPalindromic = new LongestPalindromic();
		Long starLong = System.currentTimeMillis();
		String longestPalindrome = longestPalindromic
				.longestPalindrome2(string);
		System.out.println(longestPalindrome);
		System.out.println((System.currentTimeMillis() - starLong) + "豪秒");
	}
}
