package string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<>();
		Map<String, ArrayList<String>> map = new HashMap<>();
		for (String string : strs) {
			String key = sortString(string);
			if(!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(string);
		}
		for (String string : map.keySet()) {
			ArrayList<String> arrayList = map.get(string);
			if(arrayList.size()>1) 
				result.addAll(arrayList);
		}
		return result;
	}
	
	public String sortString(String s){
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
}
