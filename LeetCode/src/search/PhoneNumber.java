package search;

import java.util.ArrayList;

/**
 * Created by Zhwei on 2018/1/25.
 */
public class PhoneNumber {

    public ArrayList<String> letterCombinations(String digits) {
        String[] dic = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> result = new ArrayList<>();
        String round = "";
        dfs(dic,round,result,digits,0);
        return  result;
    }

    private void dfs(String[] dic, String round, ArrayList<String> result, String digits, int index) {
        if(index==digits.length()){
            result.add(new String(round));
            return;
        }
        int num = digits.charAt(index)-'2';
        //在一个某一个按钮下的三个字母随机添加一个
        for (int i = 0; i < dic[num].length(); i++) {
            round = round + dic[num].charAt(i);
            dfs(dic,round,result,digits,index+1);
            round = round.substring(0,round.length()-1);
        }
    }
}
