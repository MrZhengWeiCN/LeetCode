package simulate;

public class Solution3 {

	public int add(int a, int b) {
		int sum = a;
		int arr = b;// ��ʾ��λ
		while (arr != 0) {
			sum = a ^ b;
			arr = (a & b) << 1;
			a = sum;
			b = arr;
		}
		return sum;
	}

	public int minus(int a, int b) {
		// bΪ����,�ȱ�ɸ���
		b = add(~b, 1);
		return add(a, b);
	}

	public int multi(int a, int b) {
		// bΪ����
		for (int i = 0; i < b - 1; i++) {
			a = add(a, a);
		}
		return a;
	}

	public int divide(int dividend, int divisor) {
		// a��������bΪ����
		int a = dividend;
		int b = divisor;
		if(a==1)
			return 0;
		if(b==0)
			try {
				throw new Exception("����������Ϊ0��");
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		int result = 0;
		if (a > 0 && b > 0) {
			while (a > 0) {
				a = minus(a, b);
				if (a >= 0)
					result++;
			}
			return result;
		} else if (a < 0 && b > 0) {
			a = add(~a, 1);
			return add(~divide(a, b), 1);// �����Ϊ����
		} else if (a > 0 && b < 0) {
			b = add(~b, 1);
			return add(~divide(a, b), 1);
		} else if (a < 0 && b < 0) {
			a = add(~a, 1);
			b = add(~b, 1);
			return divide(a, b);
		}
		return result;
	}

	public static void main(String[] args) {
		Solution3 solution3 = new Solution3();
		System.out.println(solution3.add(2, 3));
		System.out.println(solution3.minus(15, 3));
		System.out.println(solution3.multi(5, 2));
		System.out.println(solution3.divide(15,3));
	}

}
