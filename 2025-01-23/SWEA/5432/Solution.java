import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String str = br.readLine();
			
			Stack<Character> stick = new Stack<>();
			int result = 0;
			boolean flag = false;
			for(char temp : str.toCharArray()) {
				if (temp == '(') {
					stick.add('(');
					if (flag) {
						flag = false;
					}
				}
				else {
					if (flag) {
						stick.pop();
						result += 1;
					}
					else {
						stick.pop();
						result += stick.size();
						flag = true;
					}
				}
			}
			result += stick.size();
			System.out.printf("#%d %d\n",t+1, result);
			
		}
	}
	
}

