package string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ���ֵ�ȫ����DFS���Ӷȹ����ˡ�
* Title:
* Description: 
* Company: 
* @author ֣ΰ
* @date 2018��2��7������9:50:53
 */
public class Permutation {

	static int time = 0;
	public String getPermutation(int n, int k) {
		int[] number = new int[n];
		for (int i = 0; i < n; i++) {
			number[i] = i+1;
		}
		boolean[] added = new boolean[n];
		time = k;
		ArrayList<Integer> result = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		doCore(number,n,result,sb,added);
		/*Collections.sort(result);*/
		return result.get(result.size()-1).toString();
	}

	private void doCore(int[] number, int k, ArrayList<Integer> result,
			StringBuffer sb,boolean[] added) {
		if(time == 0)
			return ;
		if(k==0){
			String string = new String(sb.toString());
			result.add(Integer.valueOf(string));
			time--;
			return;
		}
		for (int i = 0; i < added.length; i++) {
			if(!added[i]){
				sb.append(number[i]);
				added[i] = true;
				doCore(number, k-1, result, sb, added);
				//�������
				added[i] = false;
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
	public static void main(String[] args){
		Permutation permutation = new Permutation();
		long start = System.currentTimeMillis();
		String str = permutation.getPermutation(9,792861534);
		System.out.println(str);
		System.out.println("��ʱ:"+(System.currentTimeMillis()-start)+" ms");
	}
}
