package stack;

/**
 * trapping-rain-water Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2017��12��28������10:20:22
 */
public class Trapping_rain_water {

	public int trap2(int[] A) {
		int sum = 0;
		int start = 0;
		int end = start;
		while (start < A.length - 1) {
			if (A[start] <= A[start + 1]) {
				start++;
				end++;
			} else {
				for (int j = start + 1; j < A.length; j++) {
					// ֻ�ж�ס��ʱ��End��ֵ�Ż�ı䣬
					if (A[j] >= A[start]) {
						end = j;
						break;
					}
				}
				for (int i = start; i < end; i++) {
					sum += A[start] - A[i];
				}
				// �±�ı�
				if (end > start)
					start = end;
				else {
					start++;
					end++;
				}
			}
		}
		return sum;
	}

	public int trap(int[] A) {
	 	return Math.max(trap2(A),trap2(reverse(A)));
	}

	// ���鷴ת
	public int[] reverse(int arr[]) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i]; // ��������
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		Trapping_rain_water tWater = new Trapping_rain_water();
		int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};

		System.out.println(tWater.trap(a));
	}

}
