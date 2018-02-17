package sort;

/**
 * 插入排序 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年2月15日下午2:07:17
 */
public class InsertionSort {

	private void insertionCore(int[] num) {
		for (int i = 1; i < num.length; i++) {
			if (num[i - 1] >= num[i]) {
				// 记录下num[i]的值，后面要用
				int val = num[i];
				int j = i - 1;
				while (j >= 0 && num[j] > val) {
					num[j + 1] = num[j];// 如果前面的比后面的大，前面的值就往后移动
					j--;
				}
				num[j + 1] = val;
			}
		}
	}

	// 基本排序就是间隔为1的shell排序
	private void shellInsertSort(int[] num, int devide) {
		for (int i = devide; i < num.length; i++) {
			if (num[i - devide] >= num[i]) {
				// 记录下num[i]的值，后面要用
				int val = num[i];
				int j = i - devide;
				while (j >= 0 && num[j] > val) {
					num[j + devide] = num[j];// 如果前面的比后面的大，前面的值就往后移动
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

	// 选择排序
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

	// 二元选择排序
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

	// 冒泡排序,每次实现最大的往下沉，相邻元素交换。
	private void Bubble(int[] num) {
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length - 1 - i; j++) {
				if (num[j] > num[j + 1]) {// 往下走
					int temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}
	}

	// 改进的冒泡排序
	private void bubble2(int[] num) {
		int low = 0;
		int high = num.length - 1;
		while (low < high) {
			for (int i = low; i < high; i++) {
				if (num[i] > num[i + 1]) {// 往下走
					int temp = num[i];
					num[i] = num[i + 1];
					num[i + 1] = temp;
				}
			}
			high--;
			for (int i = high; i > low; i--) {
				if (num[i - 1] > num[i]) {// 往上
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
			num[high] = temp;// 此时pivotkey对准的是num[high]
			while (low < high && pivotkey >= num[low]) {
				++low;
			}
			temp = num[low];
			num[low] = num[high];
			num[high] = temp;// 此时pivotkey又对准的是num[low]
		}
		return low;// 返回pivotkey对应的下标
	}

	private void quickSort(int[] num, int low, int high) {
		if (low < high) {
			int pivotkeyPos = quickSortCore(num, low, high);
			quickSort(num, low, pivotkeyPos - 1);// 左边的继续排序
			quickSort(num, pivotkeyPos + 1, high);// 右边的继续排序
		}
	}

	/**
	 * 并归排序
	 * 
	 * @param num1
	 * @param num2
	 */
	private void mergeSort_devide(int[] num, int start, int end) {
		if (start < end) {
			// 这里就是不停的细分
			int mid = (start + end) / 2;
			mergeSort_devide(num, start, mid);// mid左边进行排序
			mergeSort_devide(num, mid + 1, end);// mid右边进行排序
			mergeSort_merge(num, start, mid, end);// num以mid为界限，合并排序以后的
		}
	}

	private void mergeSort_merge(int[] num, int start, int mid, int end) {
		// num以mid为界限，合并排序以后的，使用额外的空间
		int[] temp = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;
		while (i <= mid && j <= end) {
			if (num[i] < num[j]) temp[k++] = num[i++]; 
			else temp[k++] = num[j++];
		}
		//如果i=mid，说明赋值倒了mid-1，还有一个没有赋值进去
		//如果i=mid+1,j=end+1就说明弄好了
		while (i <= mid) temp[k++] = num[i++];
		while (j <= end) temp[k++] = num[j++];
		// 将temp的值赋给num[mid-end]上
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
