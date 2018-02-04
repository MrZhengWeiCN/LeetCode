package string;

/**
 * Created by Zhwei on 2018/2/1.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuffer sb = new StringBuffer();
        int[] result = new int[n1+n2];
        for (int i=n1-1;i>=0;i--){
            for (int j = n2-1; j >=0 ; j--) {
                result[i+j+1] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        for (int i = result.length-1; i >=1 ; i--) {
            result[i-1] += result[i]/10;
            result[i] = result[i]%10;
        }
        //找出第一个不为0的位置
        int index = 0;
        while(index<result.length&&result[index]==0)
            index++;
        if(index==result.length)
            return  "0";
        for (int i = index; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String multiply = multiplyStrings.multiply("0", "758");
        System.out.println(multiply);
    }

}
