package stack;

import java.util.LinkedList;

/**
 * valid-parentheses Title: Description: Company:
 * 
 * @author 郑伟
 * @date 2017年12月30日下午10:27:54
 */
public class Valid_parentheses {

	public boolean isValid(String s) {

		if(s==null||s.length()<2)
			return false;
		LinkedList<Character> stack = new LinkedList<>();
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if(stack.size()==0){
				stack.add(charArray[i]);
				continue;
			}else if (getReverse(stack.getLast())=='x') {
				return false;
			}else if (getReverse(stack.getLast())!=charArray[i]) {
				stack.add(charArray[i]);
			}else {
				stack.removeLast();
			}
		}
		return stack.size()==0?true:false;
	}
	
	public char getReverse(char sympol){
		char result = 'x' ;
		switch (sympol) {
		case '(':
			result = ')';
			break;
		case '[':
			result = ']';
			break;
		case '{':
			result = '}';
			break;
		}
		return result;
	}

	public static void main(String[] args) {
		Valid_parentheses valid_parentheses = new Valid_parentheses();
		String s = "()[]{}";
		System.out.println(valid_parentheses.isValid(s));
	}

}
