package string;

/**
 * Created by Zhwei on 2018/2/3.
 */
public class ImplementStrstr {
    public String strStr(String haystack, String needle) {
        if(haystack.equals("")&&needle.equals(""))
            return "";
        int len1 = haystack.length();
        int len2 = needle.length();
        int i = -1;
        while(i++<=len1-len2){
            String substring = haystack.substring(i, i+len2);
            if(!substring.equals("")&&substring.equals(needle))
                return substring;
            i++;
        }
        return null;
    }

    public static void main(String[] args) {
        ImplementStrstr implementStrstr = new ImplementStrstr();
        System.out.println(implementStrstr.strStr("",""));
    }
}
