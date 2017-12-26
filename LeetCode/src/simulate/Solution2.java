package simulate;

import java.util.ArrayList;

/**
 * 使用O(k)空间,如果要减少空间，有需要废物利用 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年12月24日下午10:07:27
 */
public class Solution2 {

	public ArrayList<Integer> getRow(int rowIndex) {
		rowIndex++;
		ArrayList<Integer> arrayList = new ArrayList<>(rowIndex);
		for (int i = 0; i < rowIndex; i++) {
			for (int j = i; j >= 0; j--) {
				if (j == i)
					arrayList.add(1);
				else if (j == 0) {
					arrayList.set(j, 1);
				} else
					arrayList.set(j, arrayList.get(j - 1) + arrayList.get(j));
			}

		}
		return arrayList;
	}

	public static void main(String[] args) {
		Solution2 solution2 = new Solution2();
		ArrayList<Integer> row = solution2.getRow(0);
		for (Integer integer : row) {
			System.out.println(integer);
		}
	}

}
