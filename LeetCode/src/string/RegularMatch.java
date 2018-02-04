package string;

/**
 * 正则表达式匹配，使用dynamic programm来解决
 * *表示前面的字符是一个或者多个
 * Created by Zhwei on 2018/2/4.
 */
public class RegularMatch {
    public boolean isMatch(String s, String p) {

        //dp[i][j]表示S前i个和P前J个是否匹配
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //s="",p="a*b*c*d*e*f*"是匹配的
        for (int i = 2; i <= p.length(); i+=2) {
            if (p.charAt(i-1) == '*')
                dp[0][i] = true;
            else
                break;
        }
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 1; j <=p.length() ; j++) {
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')
                    dp[i][j] = dp[i-1][j-1];
                if(p.charAt(j-1)=='*'){
                    //如果*表示前面的字符为0个，
                    if(p.charAt(j-2)!=s.charAt(i-1)&&p.charAt(j-2)!='.')
                        dp[i][j] = dp[i][j-2];
                    else
                        //如果*表示字符可以为0个（dp[i][j-1])或者一个(dp[i-1][j]）也可以0个dp[i][j-2]
                        dp[i][j] = dp[i][j-2]||dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        RegularMatch regularMatch = new RegularMatch();
        boolean aab = regularMatch.isMatch("", "c*a*");
        System.out.println(aab);
    }
}
