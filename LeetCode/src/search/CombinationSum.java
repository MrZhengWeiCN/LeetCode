package search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Zhwei on 2018/1/24.
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> round = new ArrayList<>();
        Arrays.sort(candidates);
        //dfsһ��Ҫ��һ��indexָʾ��
        doCombinationSum(0, target, candidates, round, result);
        return result;
    }

    public void doCombinationSum(int index, int target, int[] candidates, ArrayList<Integer> round, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(round));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) return;//�Ż���
            round.add(candidates[i]);
            doCombinationSum(i, target - candidates[i], candidates, round, result);
            round.remove(round.size() - 1);
        }
    }
}
