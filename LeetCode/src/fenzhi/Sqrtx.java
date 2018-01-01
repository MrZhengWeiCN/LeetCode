package fenzhi;

public class Sqrtx {

	// 使用二分法一個一個的查找
	public int sqrt(int x) {
		if(x==0||x==1)
			return x;
		int l = 0;
		int h = x;
		while(l<=h){
			int mid = (l+h)/2;
			if(mid*mid==x){
				return mid;
			}else if (mid*mid>x) {
				h = mid-1;
			}else {
				l = mid+1;
			}
		}
		return h;
	}
	

	public static void main(String[] args) {
		Sqrtx sqrtx = new Sqrtx();
		System.out.println(sqrtx.sqrt(81));
	}

}
