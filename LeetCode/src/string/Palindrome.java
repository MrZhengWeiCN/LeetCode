package string;

import java.util.ArrayList;

/**
 * 找到字符串S所有的回文
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2018年1月28日下午9:18:31
 */
public class Palindrome {

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		ArrayList<String> round = new ArrayList<>();
		doPartition(0,s,round,result);
		return result;
	}

	private void doPartition(int start, String s, ArrayList<String> round,
			ArrayList<ArrayList<String>> result) {
		if(start==s.length()){
			result.add(new ArrayList<String>(round));
			return;
		}
		if(start>s.length()){
			return;
		}
		for (int i = start+1; i <= s.length(); i++) {
			if(isPalindrome(s.substring(start, i))){
				round.add(s.substring(start, i));
				doPartition(i, s, round, result);
				round.remove(round.size()-1);
			}
		}
	}
	private boolean isPalindrome(String substring) {
		for (int i = 0,j = substring.length()-1; i <=j; i++,j--) {
			if(substring.charAt(i)!=substring.charAt(j))
				return false;
		}
		return true;
	}

	public static void main(String[] args){
		Palindrome palindrome = new Palindrome();
		ArrayList<ArrayList<String>> partition = palindrome.partition("aabb");
		System.out.println(partition.size());
	}
}
