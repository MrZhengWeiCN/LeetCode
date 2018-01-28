package string;

import java.util.LinkedList;

/**
 * ��ϵͳ·�� Title: Description: Company:
 * 
 * @author ֣ΰ
 * @date 2018��1��28������9:50:53
 */
public class SimplifyPath {

	public String simplifyPath(String path) {
		LinkedList<String> queue = new LinkedList<>();
		String[] split = path.split("/");
		for (String string : split) {
			if ("".equals(string) || ".".equals(string))
				continue;
			if ("..".equals(string)) {
				if (!queue.isEmpty())
					queue.pollLast();
			} else
				queue.add(string);
		}
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()){
			sb.append("/");
			sb.append(queue.pollFirst());
		}
		if(sb.length() == 0) return "/";
		return sb.toString();
	}
}
