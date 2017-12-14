package dongtai;

import java.util.Set;

/**
 * word-break
* Title:
* Description: 
* Company: 
* @author ֣ΰ
* @date 2017��12��11������9:49:36
 */
public class Dp9 {

	 public boolean wordBreak(String s, Set<String> dict) {
	        //ʹ��d[i]��ʾs[0-i]�Ƿ����ƥ��
	        //d[i] = d[j]&&(s[j+1��i]Ҳ�ǵ���)
	        //j��ʾ�ִ����꣬0<j<i.
	        //��leetcodeΪ��
	        //d[8]=d[4]&&(s[5-8]=codeҲ�ǵ���) ����Ϊtrue
	        //d[4] = d[0]&&(s[1-4]=leetҲ�ǵ���) ����Ϊtrue
	        int len = s.length();
	        boolean[] dp = new boolean[len+1];
	        dp[0] = true;
	        for(int i=1;i<=len;i++){
	            for(int j=0;j<=i;j++){
	                if(dp[j]==true&&dict.contains(s.substring(i,j))){
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[len];
	    }
}
