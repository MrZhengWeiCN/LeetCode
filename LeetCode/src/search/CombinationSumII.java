package search;

import java.util.ArrayList;
import java.util.Arrays;

/**不能重复
 * Created by Zhwei on 2018/1/25.
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> round = new ArrayList<>();
        Arrays.sort(candidates);
        //dfs一定要加一个index指示。
        doCombinationSum2(0, target, candidates, round, result);
        //对result去重
        return result;
    }

    public void doCombinationSum2(int index, int target, int[] candidates, ArrayList<Integer> round, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(round));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) return;//优化点
            round.add(candidates[i]);
            doCombinationSum2(i+1, target - candidates[i], candidates, round, result);
            round.remove(round.size() - 1);
        }
    }
    public static void main(String[] args){
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = { 1,2,3,4,5,6,7 };
        ArrayList<ArrayList<Integer>> result = combinationSumII.combinationSum2(candidates,12);
        for (ArrayList<Integer> arrayList : result) {
			System.out.print("[");
			for (Integer integer : arrayList) {
				System.out.print(integer + ",");
			}
			System.out.println("]");
		}
    }
}
