package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 找和为target的组合,使用DFS Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年2月9日下午10:18:36
 */
public class Four_Sum {

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> round = new ArrayList<>();
		Set<ArrayList<Integer>> set = new LinkedHashSet<>();
		doFourSum(0, num, target, set, round);
		for (ArrayList<Integer> arrayList : set) {
			result.add(arrayList);
		}
		return result;
	}

	private void doFourSum(int start, int[] num, int target,
			Set<ArrayList<Integer>> set, ArrayList<Integer> round) {
		if (start <= num.length && round.size() == 4&&isDone(round, target)) {
			set.add(new ArrayList<>(round));
			return;
		}
		if (start > num.length)
			return;
		for (int i = start; i < num.length; i++) {
			round.add(num[i]);
			doFourSum(i + 1, num, target, set, round);
			round.remove(round.size() - 1);
		}
	}

	private boolean isDone(ArrayList<Integer> round, int target) {
		int sum = 0;
		for (Integer integer : round) {
			sum += integer;
		}
		return sum == target ? true : false;
	}

	public static void main(String[] args) {
		Four_Sum four_Sum = new Four_Sum();
		int[] num = { -3,-2,-1,0,0,1,2,3 };
		ArrayList<ArrayList<Integer>> fourSum = four_Sum.fourSum(num, 0);
		for (ArrayList<Integer> arrayList : fourSum) {
			System.out.print("[");
			for (Integer integer : arrayList) {
				System.out.print(integer + ",");
			}
			System.out.println("]");
		}
	}
}
