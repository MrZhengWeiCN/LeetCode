package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转换到整数
 * 罗马数字是从小到大的
 * 相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
 * 小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
 * 小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
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
        //应该从右到左计算
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
