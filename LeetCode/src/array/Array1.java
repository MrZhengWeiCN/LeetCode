package array;

import java.util.Arrays;

//�����������������
public class Array1 {

	public int longestConsecutive(int[] num) {
		// �����Ǹ��ӶȵĻ�
		if (num == null || num.length == 0)
			return 0;
		Arrays.sort(num);
		int curr = 1;
		int max = 1;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] + 1 == num[i + 1]) {
				curr++;
				if (curr > max)
					max = curr;
			} else if (num[i] == num[i + 1]) {
				continue;
			} else {
				curr=1;
			}
		}
		return max;
	}
}
