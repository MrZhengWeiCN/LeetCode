package array;

/**
 * next-permutation Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2017��11��27������10:00:07
 */
public class Array13 {

	public void revrse(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}

	public void nextPermutation(int[] num) {
		if (num != null && num.length > 1) {
			int length = num.length;
			int index = length - 2;
            //�������λ�ǵ����ģ�ֱ�ӽ�������λ����
			if (num[length - 1] > num[length - 2]) {
				int temp = num[length - 1];
				num[length - 1] = num[length - 2];
				num[length - 2] = temp;
			} else {
                //������ǣ���¼����Ҫ�������±�index
				while (index >= 1&&num[index - 1] >= num[index]) index--;
                //����index�ͺ��ʣ�������ֵ
				if(index!=0){
					for (int i = length - 1; i >= index-1; i--) {
						if (num[i] > num[index-1]) {
							int temp = num[i];
							num[i] = num[index-1];
							num[index-1] = temp;
							break;
						}
					}
				}
                //��������е�ֵ��������
				for (int i = 0; i < length - index; i++) {
					for (int j = index; j < num.length - i - 1; j++) {
						if (num[j] > num[j + 1]) {
							int temp = num[j];
							num[j] = num[j + 1];
							num[j + 1] = temp;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { 3, 2, 1 };
		Array13 array13 = new Array13();
		array13.nextPermutation(num);
	}
}
