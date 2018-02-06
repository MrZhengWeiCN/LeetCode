package string;

import java.util.HashMap;

/**
 * �ַ�������Ĳ��ظ����Ӵ� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��2��6������10:09:30
 */
public class LongestNoRepeat {

	public int lengthOfLongestSubstring(String s) {
		// ��������
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int threshold = 0;
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			char  c = s.charAt(i);
			//������ھ�Ҫ�h��һ��Ԫ��������Ҫmap.get(c)+1
			threshold = Math.max(threshold,map.containsKey(c)?map.get(c)+1:0);
			maxLen = Math.max(maxLen, i-threshold+1);
			map.put(c, i);
		}
		return maxLen;
	}
}
