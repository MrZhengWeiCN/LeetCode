package greedy;

public class WindowSubstring {

	public String minWindow(String S, String T) {
		int[] store = new int[128];
		int start = 0, end = 0, d = Integer.MAX_VALUE, t = T.length(), head = start;
		for (int i = 0; i < T.length(); i++) {
			store[T.charAt(i)]++;
		}
		while (end < S.length()) {
			// ͳ�ư���T���ַ���
			if (store[S.charAt(end)] > 0) {// ��ǰ�ַ���T��
				t--;
			}
			store[S.charAt(end)]--;//������ζ���Ҫ--����������
			end++;//end���ƶ�
			// �����ַ���
			while (t == 0) {
				if ((end - start) < d) {
					d = end - start;
					head = start;
				}
				// bengin����
				if (store[S.charAt(start)] == 0) {
					t++;
				}
				store[S.charAt(start)]++;
				start++;
			}
		}
		return d == Integer.MAX_VALUE ? "" : S.substring(head, head + d);
	}

	public static void main(String[] args) {
		WindowSubstring substring = new WindowSubstring();
		String S = "ADOBECODEBANC";
		String T = "ABC";
		String minWindow = substring.minWindow(S, T);
		System.out.println(minWindow);
	}
}
