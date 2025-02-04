import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<= t;i++) {
			String s = br.readLine();
			// System.out.println(s.length());
			int cnt = 0;
			for(int j = 0; j < s.length();j++) {
				if(s.charAt(j) == '(')
					cnt++;
				else if(s.charAt(j) == ')') {
					if(cnt == 0) {
						sb.append("NO\n");
						cnt = -1;
						break;
					}
					cnt--;
				}
					
			}
			if(cnt == 0)
				sb.append("YES\n");
			else if(cnt != -1)
				sb.append("NO\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}