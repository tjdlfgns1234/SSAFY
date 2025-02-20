import java.util.*;
import java.io.*;

public class Solution3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t < 11; t++) {
			int n = Integer.parseInt(br.readLine());
			
			String word = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < word.length(); i++) {
				stack.add(word.charAt(i));
				stackpop(stack);
			}
			
			if(stack.isEmpty()) {
				System.out.println("#" + t + " 1");
			}
			else {
				System.out.println("#" + t + " 0");
			}
		}

	}
	static void stackpop(Stack<Character> stack) {
		char temp;
		while(stack.size() > 1) {
			temp = stack.pop();
			if(stack.peek() == '(' && temp == ')') {
				stack.pop();
			}
			else if(stack.peek() == '{' && temp == '}') {
				stack.pop();
			}
			else if(stack.peek() == '[' && temp == ']') {
				stack.pop();
			}
			else if(stack.peek() == '<' && temp == '>') {
				stack.pop();
			}
			else {
				stack.add(temp);
				break;
			}
		}
	}

}
