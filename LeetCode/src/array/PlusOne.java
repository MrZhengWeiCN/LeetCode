package array;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		//将数组看成一个大的整数，然后加1
		int add = 0,sum = 1;//表示进位
		for (int i = digits.length-1; i >=0; i--) {
			sum += add+digits[i];
			add = sum/10;
			digits[i] = sum%10;
			sum = 0;
		}
		if(add!=0){
			int[] result = new int[digits.length+1];
			for (int i = 0; i < digits.length; i++) {
				result[i+1] = digits[i];
			}
			result[0] = add;
			return result;
		}else {
			return digits;
		}
	}
}
