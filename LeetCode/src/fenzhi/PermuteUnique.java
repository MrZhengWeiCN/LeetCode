package fenzhi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermuteUnique {

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Set<ArrayList<Integer>> set = new HashSet<>();
		int begin = 0;
		int end = num.length - 1;
		doPermute(set, begin, end, num);
		for (ArrayList<Integer> arrayList : set) {
			result.add(arrayList);
		}
		return result;
	}

	public void doPermute(Set<ArrayList<Integer>> set, int begin,
			int end, int[] num) {
		if (begin == end) {
			ArrayList<Integer> list = new ArrayList<>();
			for (Integer i : num) {
				list.add(i);
			}
			set.add(list);
			return;
		}

		for (int i = begin; i <= end; i++) {
			swap(num, begin, i);
			doPermute(set, begin + 1, end, num);
			swap(num, begin, i);
		}
	}

	private void swap(int[] num, int a, int b) {
		int tem = num[a];
		num[a] = num[b];
		num[b] = tem;
	}

	public static void main(String[] args) {
		PermuteUnique permutations = new PermuteUnique();
		int[] a = {2,1,1};
		ArrayList<ArrayList<Integer>> permute = permutations.permuteUnique(a);
		for (ArrayList<Integer> arrayList : permute) {
			for (Integer integer : arrayList) {
				System.out.print(integer);
			}
			System.out.println();
		}
	}

}
