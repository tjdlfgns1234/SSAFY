//Java11은 통과 Java8은 시간초과
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String agrs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		boolean flag = false;
		String result = "";
		String temp = "";
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				if (temp.length() > 0) {
					StringBuilder sb = new StringBuilder(temp);
					result += sb.reverse().toString();
					temp = "";
				}
				flag = true;
				result += "<";
				continue;
			}
			
			if (str.charAt(i) == '>') {
				result += ">";
				flag = false;
				continue;
			}
			
			if (str.charAt(i) == ' ') {
				StringBuilder sb = new StringBuilder(temp);
				result += sb.reverse().toString() + " ";
				temp = "";
				continue;
			}
			
			if (flag == false) {
				temp += str.charAt(i);
				continue;
			}
			else {
				result += str.charAt(i);
				
			}
			
		}
		if (temp.length() > 0) {
			StringBuilder sb = new StringBuilder(temp);
			result += sb.reverse().toString();
			temp = "";
		}
		
		System.out.println(result);
		
		
	}
}
