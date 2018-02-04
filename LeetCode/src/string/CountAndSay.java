package string;

/**
 * Created by Zhwei on 2018/2/1.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        int i = 1;
        while(i<n){
            i++;
            result = doCountAndSay(result);
        }
        return result;
    }
    private String doCountAndSay(String result) {
        char num =  (result.charAt(0));
        int time = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < result.length(); i++) {
            if(result.charAt(i)==num){
                time++;
                continue;
            }
            //读取前一段
            sb.append(time);
            sb.append(num);
            //设置好后一段
            num = result.charAt(i);
            time = 1;
        }
        //将最后一个数读出来
        sb.append(time);
        sb.append(num);
        return  sb.toString();
    }
}
