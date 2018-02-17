package search;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if(map.containsKey(numbers[i])){
				result[0] = map.get(numbers[i])+1;
				result[1] = i+1;
			}else {
				map.put(target-numbers[i], i);
			}
		}
		return result;
	}
}
