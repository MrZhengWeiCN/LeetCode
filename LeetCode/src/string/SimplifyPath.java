package string;

import java.util.LinkedList;

/**
 * 简化系统路径 Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2018年1月28日下午9:50:53
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
