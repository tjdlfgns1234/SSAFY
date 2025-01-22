import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int result = 0;
		int idx = 0;
		while(idx < word.length() - 1) {
			switch(word.charAt(idx)) {
			case 'c':
				if(word.charAt(idx+1) == '=' || word.charAt(idx+1) == '-') {
					idx += 1;
					result += 1;
				}
				else {
					result += 1;
				}
				break;
			case 'd':
				if(word.charAt(idx+1) == 'z') {
					if(idx < word.length() - 2) {
						if(word.charAt(idx+2) == '=') {
							idx += 2;
							result += 1;
						}
						else {
							result += 1;
						}
					}
					else {
						result += 1;
					}
				}
				else if(word.charAt(idx+1) == '-') {
					idx += 1;
					result += 1;
				}
				else {
					result += 1;
				}
				break;
			case 'l':
				if(word.charAt(idx+1) == 'j') {
					idx += 1;
					result += 1;
				}
				else {
					result += 1;
				}
				break;
			case 'n':
				if(word.charAt(idx+1) == 'j') {
					idx += 1;
					result += 1;
				}
				else {
					result += 1;
				}
				break;
			case 's':
				if(word.charAt(idx+1) == '=') {
					idx += 1;
					result += 1;
				}
				else {
					result += 1;
				}
				break;
			case 'z':
				if(word.charAt(idx+1) == '=') {
					idx += 1;
					result += 1;
				}
				else {
					result += 1;
				}
				break;
			case '-':
				idx += 1;
				break;
			case '=':
				idx += 1;
				break;
			default:
				result += 1;
				break;
			
			}
			idx += 1;
		}
		if (idx < word.length()) {
			if (word.charAt(idx) != '-' && word.charAt(idx) != '-') {
				result += 1;
			}
			
		}
		System.out.println(result);
	}
	
}
