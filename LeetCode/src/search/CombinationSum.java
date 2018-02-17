package search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Zhwei on 2018/1/24.
 */
public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> round = new ArrayList<>();
		Arrays.sort(candidates);
		// dfs一定要加一个index指示。
		doCombinationSum(0, target, candidates, round, result);
		return result;
	}

	public void doCombinationSum(int index, int target, int[] candidates,
			ArrayList<Integer> round, ArrayList<ArrayList<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(round));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (target - candidates[i] < 0)
				return;// 优化点
			round.add(candidates[i]);
			doCombinationSum(i, target - candidates[i], candidates, round,
					result);
			round.remove(round.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum sum = new CombinationSum();
		int[] candidates = { 1,2,3,4,5,6,7 };
		ArrayList<ArrayList<Integer>> combinationSum = sum.combinationSum(
				candidates, 12);
		for (ArrayList<Integer> arrayList : combinationSum) {
			System.out.print("[");
			for (Integer integer : arrayList) {
				System.out.print(integer + ",");
			}
			System.out.println("]");
		}
	}
}
