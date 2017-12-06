package dongtai;

/**
 * decode-ways Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年12月6日下午12:13:19
 */
public class Dp6 {

	public int numDecodings(String s) {
		if (s.length() == 0 || s.charAt(0) == '0')
			return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		if (s.length() > 0 && s.charAt(0) > '0')
			dp[1] = 1;
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) > '0')
				dp[i] = dp[i - 1];
			if (s.charAt(i - 2) > '0') {
				int temp = Integer.parseInt(s.substring(i - 2, i));
				if (temp > 0 && temp <= 26)
					dp[i] = dp[i] + dp[i - 2];
			}
		}
		return dp[s.length()];
	}
	
	public static void main(String[] args){
		Dp6 dp6 = new Dp6();
		System.out.println(dp6.numDecodings("1212"));
	}
}
