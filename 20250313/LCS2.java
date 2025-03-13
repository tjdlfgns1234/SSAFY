import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String s2 = st.nextToken();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
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
		
		char[] data = new char[map[s1.length()][s2.length()]];

		int x = s2.length();
		int y = s1.length();
		int len = map[y][x]-1;
		while(true) {
			if(len==-1)
				break;
			if(map[y][x] == map[y][x-1] && map[y][x] == map[y-1][x])
				y--;
			else if(map[y][x]-1 == map[y][x-1] && map[y][x]-1 == map[y-1][x]) {
				data[len] = s1.charAt(y-1);
				len--;
				x--;
				y--;
			} else {
				if(map[y][x-1]-map[y-1][x] > 0)
					x--;
				else
					y--;
			}
		}
		bw.write(Integer.toString(map[s1.length()][s2.length()]));
		bw.write("\n");
		for(int i=0; i<data.length; i++)
			bw.write(data[i]);
		bw.flush();
	}
}
