package dongtai;

import java.util.Stack;

public class LongestParentheses {

	public int longestValidParentheses(String s) {
		int[] dp = new int[s.length()];
		int len = 0;
		for (int i = 1; i < dp.length; i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - 1 - dp[i - 1] >= 0
						&& s.charAt(i - 1 - dp[i - 1]) == '(') {
					if(i-dp[i-1]-1>0){
						dp[i] = dp[i-dp[i-1]-2]+dp[i-1]+2;
					}else {
						dp[i] = dp[i-1]+2;
					}
				}
			}
			len = Math.max(len, dp[i]);
		}
		return len;
	}
	
	public int useStack(String s){
		if(s==null||s.length()<0) return 0;
		int start = -1;
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(')
				stack.push(i);
			else {
				if(stack.isEmpty())
					start = i;
				else {
					stack.pop();
					if(stack.isEmpty())
						max = Math.max(max,i-start);
					else
						max = Math.max(max, i-stack.peek());
				}
			}
		}
		return max;
	}
}
