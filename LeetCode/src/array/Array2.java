package array;

/**
 * 股票只能交易两次 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年11月14日下午1:02:10
 */
public class Array2 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int buy1 = -prices[0],buy2=-prices[0],sell1=0,sell2=0;
		for(int price:prices){
			buy1 = Math.max(buy1,-price);
			sell1 = Math.max(sell1, buy1+price);
			//保证了第二次购买只是在股票下跌的时候买入的
			buy2 = Math.max(buy2, sell1-price);
			sell2 = Math.max(sell2, buy2+price);
			System.out.println(buy1+"|"+sell1+"|"+buy2+"|"+sell2);
		}
		return sell2;
	}

	public static void main(String[] args) {
		Array2 array2 = new Array2();
		int[] a = { 1,2,4,2,5,7,2,4,9,0};
		System.out.println(array2.maxProfit(a));
	}
}
