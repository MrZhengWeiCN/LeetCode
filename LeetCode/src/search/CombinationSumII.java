package search;

import java.util.ArrayList;
import java.util.Arrays;

/**�����ظ�
 * Created by Zhwei on 2018/1/25.
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> round = new ArrayList<>();
        Arrays.sort(candidates);
        //dfsһ��Ҫ��һ��indexָʾ��
        doCombinationSum2(0, target, candidates, round, result);
        //��resultȥ��
        return result;
    }

    public void doCombinationSum2(int index, int target, int[] candidates, ArrayList<Integer> round, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(round));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) return;//�Ż���
            round.add(candidates[i]);
            doCombinationSum2(i+1, target - candidates[i], candidates, round, result);
            round.remove(round.size() - 1);
        }
    }
    public static void main(String[] args){
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = {10,1,2,7,6,1,5};
        ArrayList<ArrayList<Integer>> result = combinationSumII.combinationSum2(candidates,8);
        System.out.print(result.size());
    }
}
