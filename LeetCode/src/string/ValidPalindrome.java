package string;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) return true;
		char[] charArray = s.toLowerCase().toCharArray();
		int length = charArray.length;
		int start = 0, end = length - 1;
		while (start < end) {
			while (!isStr(charArray[start])) {
				start++;
				if (start >= length) return true;//全都是符号，返回true
			}
			while (!isStr(charArray[end])) end--;
			if (charArray[start] != charArray[end]) return false;
			end--;
			start++;
		}
		return true;
	}

	private boolean isStr(char c) {
		if ((c >= 48 && c <= 57) || (c >= 97 && c <= 122)) return true;
		else return false;
	}

	public static void main(String[] args) {
		ValidPalindrome palindrome = new ValidPalindrome();
		String s = ".,";
		System.out.println(palindrome.isPalindrome(s));
	}
}
