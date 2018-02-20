package array;

import java.util.Arrays;

public class SumClosest {
	public int threeSumClosest(int[] num, int target) {
		//ÏÈÅÅĞò
		Arrays.sort(num);
		int reuslt = num[0]+num[1]+num[2];
		for (int i = 0; i < num.length-2; i++) {
			int start = i+1;
			int end = num.length-1;
			while(start<end){
				int sum = num[i]+num[start]+num[end];
				if(sum<target)
					start++;
				else
					end--;
				if(Math.abs(target-sum)<Math.abs(target-reuslt)){
					reuslt = sum;
				}
			}
		}
		return reuslt;
	}

	public static void main(String[] args) {
		SumClosest closest = new SumClosest();
		int[] num = {0,2,1,-3};
		int i = closest.threeSumClosest(num, 1);
		System.out.println(i);
	}
}
