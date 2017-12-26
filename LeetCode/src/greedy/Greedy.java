package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����Ǯ����
* Title:
* Description: 
* Company: 
* @author ֣ΰ
* @date 2017��12��18������12:42:58
 */
public class Greedy {

	public List<Integer> change(int money,int[] limit){
		//Arrays.sort(limit);
		List<Integer> result = new ArrayList<>();
		int left = money;
		int i = 0;
		while(left>0){
			if((left - limit[i])<0){
				i++;
			}else {
				left -= limit[i];
				result.add(limit[i]);
			}
		}
		return result;
	} 

	public static void main(String[] args) {
		Greedy greedy = new Greedy();
		int money = 96;
		int[] limit = {50,20,10,5,1};
		List<Integer> change = greedy.change(money, limit);
		for (Integer integer : change) {
			System.out.println(integer);
		}
	}
}
