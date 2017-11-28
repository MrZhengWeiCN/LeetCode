package array;

/**
 * ��Ʊ����һ��������� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2017��11��14������4:40:13
 */
public class Array3 {
	public int maxProfit(int[] prices) {
		int buy=prices[0];
		int profit = 0;
		for(int price:prices){
			buy = Math.min(buy, price);
			profit = Math.max(profit, profit-buy);
		}
		return profit;
	}
}
