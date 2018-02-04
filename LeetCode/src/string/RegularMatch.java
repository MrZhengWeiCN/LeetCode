package string;

/**
 * ������ʽƥ�䣬ʹ��dynamic programm�����
 * *��ʾǰ����ַ���һ�����߶��
 * Created by Zhwei on 2018/2/4.
 */
public class RegularMatch {
    public boolean isMatch(String s, String p) {

        //dp[i][j]��ʾSǰi����PǰJ���Ƿ�ƥ��
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //s="",p="a*b*c*d*e*f*"��ƥ���
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
                    //���*��ʾǰ����ַ�Ϊ0����
                    if(p.charAt(j-2)!=s.charAt(i-1)&&p.charAt(j-2)!='.')
                        dp[i][j] = dp[i][j-2];
                    else
                        //���*��ʾ�ַ�����Ϊ0����dp[i][j-1])����һ��(dp[i-1][j]��Ҳ����0��dp[i][j-2]
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
