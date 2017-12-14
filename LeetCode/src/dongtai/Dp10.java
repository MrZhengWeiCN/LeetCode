package dongtai;

/**
 * palindrome-partitioning-ii
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2017年12月14日下午6:23:46
 */
public class Dp10 {

	public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for(int i=0;i<len;i++){
            dp[i] = isPalindrome(s.substring(0,i+1))==true? 0:i;
            for(int j=1;j<i;j++){
                if(isPalindrome(s.substring(j,i+1))){
                    dp[i] = Math.min(dp[i],dp[j-1]+1);
                }else
                    dp[i] = Math.min(dp[i],dp[j-1]+i-j+1);
            }
        }
        return dp[len-1];
    }
    
    public boolean isPalindrome(String s){
      boolean flag = true;
      for(int i=0,j=s.length()-1;i<j;i++,j--){
          if(s.charAt(i) != s.charAt(j)){
              flag = false;
              break;
          }
      }
      return flag;
  }
}
