package sort;

/**
 * �������� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��2��15������2:07:17
 */
public class InsertionSort {

	private void insertionCore(int[] num) {
		for (int i = 1; i < num.length; i++) {
			if (num[i - 1] >= num[i]) {
				// ��¼��num[i]��ֵ������Ҫ��
				int val = num[i];
				int j = i - 1;
				while (j >= 0 && num[j] > val) {
					num[j + 1] = num[j];// ���ǰ��ıȺ���Ĵ�ǰ���ֵ�������ƶ�
					j--;
				}
				num[j + 1] = val;
			}
		}
	}

	// ����������Ǽ��Ϊ1��shell����
	private void shellInsertSort(int[] num, int devide) {
		for (int i = devide; i < num.length; i++) {
			if (num[i - devide] >= num[i]) {
				// ��¼��num[i]��ֵ������Ҫ��
				int val = num[i];
				int j = i - devide;
				while (j >= 0 && num[j] > val) {
					num[j + devide] = num[j];// ���ǰ��ıȺ���Ĵ�ǰ���ֵ�������ƶ�
					j -= devide;
				}
				num[j + devide] = val;
			}
		}
	}

	private void shellInsertCore(int[] num, int devide) {
		devide = devide / 2;
		while (devide >= 1) {
			shellInsertSort(num, devide);
			devide = devide / 2;
		}
	}

	// ѡ������
	private void selectionSort(int[] num) {
		for (int i = 0; i < num.length; i++) {
			int min = Integer.MAX_VALUE;
			int minPos = i;
			for (int j = i; j < num.length; j++) {
				if (num[j] <= min) {
					min = num[j];
					minPos = j;
				}
			}
			num[minPos] = num[i];
			num[i] = min;
		}
	}

	// ��Ԫѡ������
	private void selection2Sort(int[] num) {
		for (int i = 0; i < num.length / 2; i++) {
			int min = Integer.MAX_VALUE;
			int minPos = i;
			int max = Integer.MIN_VALUE;
			int maxPos = num.length - 1 - i;
			for (int j = i; j < num.length - i; j++) {
				if (num[j] >= max) {
					max = num[j];
					maxPos = j;
				}
				if (num[j] < min) {
					min = num[j];
					minPos = j;
				}
			}
			num[minPos] = num[i];
			num[i] = min;
			num[maxPos] = num[num.length - 1 - i];
			num[num.length - 1 - i] = max;
		}
	}

	// ð������,ÿ��ʵ���������³�������Ԫ�ؽ�����
	private void Bubble(int[] num) {
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length - 1 - i; j++) {
				if (num[j] > num[j + 1]) {// ������
					int temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}
	}

	// �Ľ���ð������
	private void bubble2(int[] num) {
		int low = 0;
		int high = num.length - 1;
		while (low < high) {
			for (int i = low; i < high; i++) {
				if (num[i] > num[i + 1]) {// ������
					int temp = num[i];
					num[i] = num[i + 1];
					num[i + 1] = temp;
				}
			}
			high--;
			for (int i = high; i > low; i--) {
				if (num[i - 1] > num[i]) {// ����
					int temp = num[i];
					num[i] = num[i - 1];
					num[i - 1] = temp;
				}
			}
			low++;
		}
	}

	private int quickSortCore(int[] num, int low, int high) {
		int pivotkey = num[low];
		while (low < high) {
			while (low < high && pivotkey <= num[high]) {
				--high;
			}
			int temp = num[low];
			num[low] = num[high];
			num[high] = temp;// ��ʱpivotkey��׼����num[high]
			while (low < high && pivotkey >= num[low]) {
				++low;
			}
			temp = num[low];
			num[low] = num[high];
			num[high] = temp;// ��ʱpivotkey�ֶ�׼����num[low]
		}
		return low;// ����pivotkey��Ӧ���±�
	}

	private void quickSort(int[] num, int low, int high) {
		if (low < high) {
			int pivotkeyPos = quickSortCore(num, low, high);
			quickSort(num, low, pivotkeyPos - 1);// ��ߵļ�������
			quickSort(num, pivotkeyPos + 1, high);// �ұߵļ�������
		}
	}

	/**
	 * ��������
	 * 
	 * @param num1
	 * @param num2
	 */
	private void mergeSort_devide(int[] num, int start, int end) {
		if (start < end) {
			// ������ǲ�ͣ��ϸ��
			int mid = (start + end) / 2;
			mergeSort_devide(num, start, mid);// mid��߽�������
			mergeSort_devide(num, mid + 1, end);// mid�ұ߽�������
			mergeSort_merge(num, start, mid, end);// num��midΪ���ޣ��ϲ������Ժ��
		}
	}

	private void mergeSort_merge(int[] num, int start, int mid, int end) {
		// num��midΪ���ޣ��ϲ������Ժ�ģ�ʹ�ö���Ŀռ�
		int[] temp = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;
		while (i <= mid && j <= end) {
			if (num[i] < num[j]) temp[k++] = num[i++]; 
			else temp[k++] = num[j++];
		}
		//���i=mid��˵����ֵ����mid-1������һ��û�и�ֵ��ȥ
		//���i=mid+1,j=end+1��˵��Ū����
		while (i <= mid) temp[k++] = num[i++];
		while (j <= end) temp[k++] = num[j++];
		// ��temp��ֵ����num[mid-end]��
		for (int k2 = 0; k2 < temp.length; k2++)
			num[start + k2] = temp[k2];
	}

	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		int[] num = { 3, 1, 5, 7, 2, 4, 9, 6, 8 };
		/* sort.insertionCore(num); */
		/* sort.shellInsertCore(num, 3); */
		/* sort.selectionSort(num); */
		/* sort.selection2Sort(num); */
		/* sort.Bubble(num); */
		/* sort.bubble2(num); */
		/*sort.quickSort(num, 0, 8);*/
		sort.mergeSort_devide(num, 0, num.length-1);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
}
