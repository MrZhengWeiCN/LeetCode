package array;

/**
 * next-permutation Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年11月27日下午10:00:07
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
            //如果后两位是递增的，直接交还后两位即可
			if (num[length - 1] > num[length - 2]) {
				int temp = num[length - 1];
				num[length - 1] = num[length - 2];
				num[length - 2] = temp;
			} else {
                //如果不是，记录下需要交还的下标index
				while (index >= 1&&num[index - 1] >= num[index]) index--;
                //交还index和后边剩下数组的值
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
                //将后边所有的值进行排序
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
