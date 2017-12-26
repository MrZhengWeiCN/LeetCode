package simulate;

import java.util.ArrayList;

/**
 * 输出杨辉三角
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2017年12月24日下午9:58:42
 */
public class Solution1 {

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> aalist = new ArrayList<>(numRows);
		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> aList = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				//第一个或者最后一个为1
				if(j==0||j==i) aList.add(1);
				else aList.add(aalist.get(i-1).get(j-1)+aalist.get(i-1).get(j));
			}
			aalist.add(aList);
		}
		return aalist;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		ArrayList<ArrayList<Integer>> generate = solution1.generate(5);
		for (ArrayList<Integer> arrayList : generate) {
			System.out.print("(");
			for (Integer integer : arrayList) {
				System.out.print(integer+",");
			}
			System.out.println(")");
		}
	}

}
