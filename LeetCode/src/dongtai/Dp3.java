package dongtai;

import java.util.ArrayList;
import java.util.List;

/**
 * gray-code Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年12月1日上午11:55:16
 */
public class Dp3 {

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int num = 1<<n;//==2^n
		int[]  res= new int[num];
		int layer = 0;
		res[0] =0;res[1] = 1;
		for (int i = 2; i < res.length; i++) {
			layer = (int) (Math.log(i)/Math.log(2))+1;
			res[i] = res[(1<<layer)-1-i]+(1<<(layer-1));
		}
		for (int i : res) {
			arrayList.add(i);
		}
		return arrayList;
	}
	public static void main(String[] args){
		Dp3 dp3 = new Dp3();
		dp3.grayCode(4);
	}
}
