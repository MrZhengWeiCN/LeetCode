package search;

import java.util.ArrayList;

public class Combinations {
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<Integer> round = new ArrayList<>();
		doCombine(1, n, k, result, round);
		return result;
	}

	// k��ʾȡ���ٸ�����ӵ�list�У�start��ʾ�����￪ʼȡ
	private void doCombine(int start, int n, int k,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> round) {
		if (k == 0) {
			result.add(new ArrayList<>(round));
			return;
		}
		if (start > n)// ��������ȡ��
			return;
		round.add(start);
		doCombine(start + 1, n, k - 1, result, round);
		// �����ȡ�أ�
		round.remove(round.size() - 1);
		doCombine(start + 1, n, k, result, round);
	}
	
	public static void main(String[] args){
		Combinations combinations = new Combinations();
		ArrayList<ArrayList<Integer>> combine = combinations.combine(2, 1);
		System.out.println(combine.size());
	}
}
