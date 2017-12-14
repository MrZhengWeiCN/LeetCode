package greedy;

public class Greedy1 {

	public static boolean canJump(int[] A) {
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        for(int i=0;i<A.length&&dp[i];i++){
            for(int j=0;j<=A[i];j++){
                if(i+j<A.length)
                	dp[i+j] = true;
            }
        }
        return dp[A.length-1];
    }
	
	public static void main(String[] args){
		int[] A = {3,2,1,0,4};
		System.out.println(canJump(A));
	}
}
