package dongtai;

import java.util.Set;

/**
 * word-break
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2017年12月11日下午9:49:36
 */
public class Dp9 {

	 public boolean wordBreak(String s, Set<String> dict) {
	        //使用d[i]表示s[0-i]是否可以匹配
	        //d[i] = d[j]&&(s[j+1→i]也是单词)
	        //j表示分词坐标，0<j<i.
	        //以leetcode为例
	        //d[8]=d[4]&&(s[5-8]=code也是单词) 所以为true
	        //d[4] = d[0]&&(s[1-4]=leet也是单词) 所以为true
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
