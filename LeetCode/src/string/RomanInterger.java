package string;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������ת��������
 * ���������Ǵ�С�����
 * ��ͬ��������д������ʾ����������Щ������ӵõ��������磺��=3��
 * С�������ڴ�����ֵ��ұߡ�����ʾ����������Щ������ӵõ������� �磺��=8����=12��
 * С�����֡������� ��X �� C���ڴ�����ֵ���ߡ�����ʾ�������ڴ�����С���õ��������磺��=4����=9��
 * Created by Zhwei on 2018/2/3.
 */
public class RomanInterger {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int preValue = 0;
        //Ӧ�ô��ҵ������
        for (int i = s.length()-1; i >=0 ; i--) {
            int curValue = map.get(s.charAt(i));
            if(curValue<preValue)
                result -= curValue;
            else
                result += curValue;
            preValue = curValue;
        }
        return result;
    }
}
