package array;

import java.util.Arrays;

/**
 * ongest-common-prefix
* Title:
* Description: 
* Company: 
* @author 郑伟
* @date 2017年12月21日下午7:57:27
 */
public class Array15 {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length==0)
			return "";
		if(strs.length==1)
			return strs[0];
        Arrays.sort(strs);
        int arrayLength = strs.length;
        int length=Math.min(strs[0].length(),strs[arrayLength-1].length());
        int prefix = -1;
        for(int i=0;i<length;i++){
            if(strs[0].charAt(i)!=strs[arrayLength-1].charAt(i)){
            	prefix = i;
            	break;
            }
        }
        if(prefix == -1){
            return strs[0];
        }
        return strs[0].substring(0, prefix);
    }
	
	public int reverse(int x) {
		int tail = 0;
		int revNum = 0;
		int preVule = 0;
		while(x!=0){
			tail = x%10;//后一位
			revNum = tail+preVule*10; 
			//判断是否溢出的地方
			if((revNum-tail)/10!=preVule){
				return 0;
			}
			preVule = revNum;
			x = x/10;
		}
		return revNum;
	}

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		Array15 array15 = new Array15();
		System.out.println(array15.longestCommonPrefix(strs));
		System.out.println(array15.reverse(-1000000000));
	}

}
