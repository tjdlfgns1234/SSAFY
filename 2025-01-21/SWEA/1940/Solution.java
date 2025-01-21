import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int speed = 0;
			int ac = 0;
			int result = 0;
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				if(st.countTokens() > 1) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						ac = Integer.parseInt(st.nextToken());
						speed += ac;
						result += speed;
					}
					else {
						ac = Integer.parseInt(st.nextToken());
						if(speed - ac < 0) {
							continue;
						}
						speed -= ac;
						result += speed;
					}
				}
				else {
					result += speed;
				}
				
			}
			System.out.printf("#%d %d\n", t+1, result);
			
			
		}
	
	}
	
}
