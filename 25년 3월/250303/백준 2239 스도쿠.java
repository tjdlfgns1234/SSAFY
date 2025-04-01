import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n = 9;
	static String[] s = new String[n];
	static char [][] arr = new char[n][n];
	static StringTokenizer st;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringBuilder sb = new StringBuilder();
	public static void main (String args[]) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < n;i++) {
			s[i] = br.readLine();
		
		}
		
		for(int i = 0; i < n;i++) 
			for(int j= 0; j < n;j++) {
				arr[i][j] = s[i].charAt(j);
			}
		
		solve();
	}
	public static void solve() {

		dfs(0);
	}
	
	public static void dfs(int idx) {
		if(idx == n*n) {
			for(int i = 0; i < n;i++) {
				for(int j = 0; j < n;j++) 
					sb.append(arr[i][j]);
				sb.append('\n');
			}
			System.out.print(sb.toString());
			System.exit(0);
			return;
		}
		
		int x = idx/n;
		int y = idx%n;
		

		// System.out.println(idx);
		if(arr[x][y] == '0') {
		for(int i =1; i <= n;i++) 
			if(check(idx,i)) {
				dfs(idx+1);	
				arr[x][y] = '0';
			}
		}
		else
			dfs(idx+1);	
	}
	private static boolean check(int idx, int num) {
		int x = idx/n, y = idx%n;
		char sx =(char)(num+'0');

		for(int i = 0; i < n;i++)
			if(arr[i][y] == sx)
				return false;
		
		for(int i = 0; i < n;i++)
			if(arr[x][i] == sx)
				return false;
		
		int nx = (x/3)*3, ny = (y/3)*3;
		
		for(int i = nx; i < nx+3;i++) 
			for(int j = ny; j < ny+3;j++)
				if(arr[i][j] == sx)
					return false;
		
		
		arr[x][y] = sx;
		return true;
	}
	
}
