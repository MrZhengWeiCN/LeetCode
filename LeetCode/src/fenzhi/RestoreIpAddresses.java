package fenzhi;

import java.util.ArrayList;

public class RestoreIpAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {

		ArrayList<String> result = new ArrayList<>();

		int length = s.length();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				for (int m = 1; m <= 3; m++) {
					for (int n = 1; n <= 3; n++) {
						if (i + j + m + n == length) {
							String one = s.substring(0, i);
							String two = s.substring(i, i + j);
							String three = s.substring(i + j, i + j + m);
							String four = s.substring(i + j + m, i + j + m + n);

							if ((Integer.valueOf(one) >= 0 && Integer
									.valueOf(one) <= 255)
									&& (Integer.valueOf(two) >= 0 && Integer
											.valueOf(two) <= 255)
									&& (Integer.valueOf(three) >= 0 && Integer
											.valueOf(three) <= 255)
									&& (Integer.valueOf(four) >= 0 && Integer
											.valueOf(four) <= 255)) {
								if (one.length() == 1 || one.charAt(0) != '0')
									if (two.length() == 1
											|| two.charAt(0) != '0')
										if (three.length() == 1
												|| three.charAt(0) != '0')
											if (four.length() == 1
													|| four.charAt(0) != '0')
												result.add(one + "." + two
														+ "." + three + "."
														+ four);
							}
						}
					}
				}
			}
		}

		return result;

	}
}
