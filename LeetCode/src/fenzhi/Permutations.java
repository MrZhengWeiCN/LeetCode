package fenzhi;

import java.util.ArrayList;

/**
 * 不能保证顺序,全排列。
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2018年1月1日下午9:46:20
 */
public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int begin = 0;
		int end = num.length-1;
		doPermute(result, begin, end, num);
		return result;
	}

	public void doPermute(ArrayList<ArrayList<Integer>> result, int begin,
			int end, int[] num) {
		if(begin==end){
			ArrayList<Integer> list = new ArrayList<>();
			for (Integer i : num) {
				list.add(i);
			}
			result.add(list);
			return ;
		}
		
		for (int i = begin; i <= end; i++) {
			swap(num,begin,i );
			doPermute(result, begin+1, end, num);
			swap(num,begin,i );
		}
	}

	private void swap(int[] num, int a, int b) {
		int tem=num[a];
		num[a]=num[b];
		num[b]=tem;
	}
	
	public static void main(String[] args){
		Permutations permutations = new Permutations();
		int[] a = {1,1,2};
		ArrayList<ArrayList<Integer>> permute = permutations.permute(a);
		for (ArrayList<Integer> arrayList : permute) {
			for (Integer integer : arrayList) {
				System.out.print(integer);
			}
			System.out.println();
		}
	}
}
