package search;

import java.util.ArrayList;

/**
 * DFS,N�����ŵĲ�ͬ���
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
        if(left<target){//ֻҪ������С��targetʱ�Ϳ��Լ�������
            doGenerateParenthesi(left+1,right,target,result,round+"(");
        }
        if(left>right){//ֻ�������Ŵ���������ʱ�ſ������������
            doGenerateParenthesi(left,right+1,target,result,round+")");
        }
    }
}
