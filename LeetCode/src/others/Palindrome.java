package others;

/**
 * һ�������Ƿ�Ϊ����
 * Created by Zhwei on 2018/1/25.
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        //�����λ
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
            high /= 100;//��Ϊȥ���˿�ͷ�ͽ�β���������λ������λ
        }
        return true;
    }

    public static void main(String[] args){
        Palindrome palindrome = new Palindrome();
        System.out.print(palindrome.isPalindrome(12321));
    }
}
