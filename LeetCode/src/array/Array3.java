package array;

/**
 * 股票交易一次最大利润 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年11月14日下午4:40:13
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
