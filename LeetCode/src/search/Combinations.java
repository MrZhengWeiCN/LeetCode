package search;

import java.util.ArrayList;

public class Combinations {
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<Integer> round = new ArrayList<>();
		doCombine(1, n, k, result, round);
		return result;
	}

	// k表示取多少个数添加到list中，start表示从哪里开始取
	private void doCombine(int start, int n, int k,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> round) {
		if (k == 0) {
			result.add(new ArrayList<>(round));
			return;
		}
		if (start > n)// 不能往下取了
			return;
		round.add(start);
		doCombine(start + 1, n, k - 1, result, round);
		// 如果不取呢？
		round.remove(round.size() - 1);
		doCombine(start + 1, n, k, result, round);
	}
	
	public static void main(String[] args){
		Combinations combinations = new Combinations();
		ArrayList<ArrayList<Integer>> combine = combinations.combine(2, 1);
		System.out.println(combine.size());
	}
}
