import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String s2 = st.nextToken();
		
		int[][] map = new int[s1.length()+1][s2.length()+1];
		for(int i=1; i<s1.length()+1; i++) {
			for(int j=1; j<s2.length()+1; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					map[i][j] = map[i-1][j-1]+1;
				} else {
					map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
				}
			}
		}
		
		System.out.println(map[s1.length()][s2.length()]);
	}
}
