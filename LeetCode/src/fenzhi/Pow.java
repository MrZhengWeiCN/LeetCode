package fenzhi;

public class Pow {
	public double pow(double x, int n) {
		if(n>=0)
			return doPow(x, Math.abs(n));
		else
			return 1.0/doPow(x, Math.abs(n));
	}
	
	public double doPow(double x, int n){
		if (n == 0)
			return 1.0;
		double temp = pow(x, n / 2);
		if (n % 2 == 0)
			return temp * temp;
		else
			return temp * temp * x;
	}
	
	public static void main(String[] args){
		Pow pow = new Pow();
		System.out.println(pow.pow(-2.0, -3));
	}
}
