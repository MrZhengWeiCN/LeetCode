package string;

import java.util.HashMap;

/**
 * 字符串中最长的不重复的子串 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年2月6日下午10:09:30
 */
public class LongestNoRepeat {

	public int lengthOfLongestSubstring(String s) {
		// 滑动窗口
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int threshold = 0;
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			char  c = s.charAt(i);
			//如果存在就要刪除一個元素所以需要map.get(c)+1
			threshold = Math.max(threshold,map.containsKey(c)?map.get(c)+1:0);
			maxLen = Math.max(maxLen, i-threshold+1);
			map.put(c, i);
		}
		return maxLen;
	}
}
