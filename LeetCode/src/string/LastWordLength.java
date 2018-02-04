package string;

public class LastWordLength {

	public int lengthOfLastWord(String s) {
		String[] ss = s.split(" ");
		if (ss.length == 0) return 0;
		return ss[ss.length - 1].length();
	}

	public static void main(String[] args) {
		LastWordLength lastWordLength = new LastWordLength();
		int len = lastWordLength.lengthOfLastWord("");
		System.out.println(len);
	}
}
