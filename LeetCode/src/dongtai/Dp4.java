package dongtai;

import java.util.ArrayList;

/**
 * triangle
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2017年12月3日下午10:28:06
 */
public class Dp4 {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
		for (int i = triangle.size()-2; i >=0; i--) {
			for (int j = 0; j < triangle.get(i+1).size()-1; j++) {
				int min=Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
				min += triangle.get(i).get(j);
				triangle.get(i).set(j, min);
			}
		}
		return triangle.get(0).get(0);
	}
}
