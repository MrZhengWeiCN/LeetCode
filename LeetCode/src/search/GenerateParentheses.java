package search;

import java.util.ArrayList;

/**
 * DFS,N对括号的不同组合
 * Created by Zhwei on 2018/1/25.
 */
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        String round = "";
        doGenerateParenthesi(0,0,n,result,round);
        return  result;
    }

    private void doGenerateParenthesi(int left,int right,int target,ArrayList<String> result,String round) {
        if(right==target)
            result.add(new String(round));
        if(left<target){//只要左括号小于target时就可以加左括号
            doGenerateParenthesi(left+1,right,target,result,round+"(");
        }
        if(left>right){//只有左括号大于右括号时才可以添加右括号
            doGenerateParenthesi(left,right+1,target,result,round+")");
        }
    }
}
