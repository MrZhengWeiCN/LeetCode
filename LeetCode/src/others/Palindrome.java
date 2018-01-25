package others;

/**
 * 一个整数是否为回文
 * Created by Zhwei on 2018/1/25.
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        //求最高位
        int high = 1;
        while(true){
            if(x/high>0&&x/high<10){
                break;
            }
            high *= 10;
        }
        while(x!=0){
            int left = x/high;
            int right = x%10;
            if(left!=right) return false;
            x=(x%high)/10;
            high /= 100;//因为去掉了开头和结尾，所以最高位少了两位
        }
        return true;
    }

    public static void main(String[] args){
        Palindrome palindrome = new Palindrome();
        System.out.print(palindrome.isPalindrome(12321));
    }
}
