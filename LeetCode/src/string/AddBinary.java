package string;

/**
 * Created by Zhwei on 2018/1/29.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int la = a.length()-1;
        int lb = b.length()-1;
        int r1=0,r2=0,advanced=0;
        StringBuilder sb = new StringBuilder();
        while(la>=0||lb>=0||advanced!=0){
            if(la>=0) r1 = a.charAt(la--) - '0';
            if(lb>=0) r2 = b.charAt(lb--) - '0';
            int sum = r1+r2+advanced;
            sb.append(sum%2);
            advanced = sum/2;
            r1 = 0;
            r2 = 0;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String s = addBinary.addBinary("1001", "10101");
        System.out.println(s);
    }
}
