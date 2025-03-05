import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쿼드트리_1992 {
	
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		
		map = new int[N][N];
		for (int i=0; i<N; ++i) {
			String s = br.readLine();
			for (int j=0; j<N; ++j) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		divide(0, 0, N);
		System.out.println(sb);
		
	}
	
	public static void divide(int r, int c, int size) {
		
		if (isZip(r, c, size)) {
			sb.append(map[r][c]);
			return;
		}
		
		sb.append("(");
		
		int newSize = size / 2;
		divide(r, c, newSize);
		divide(r, c+newSize, newSize);
		divide(r+newSize, c, newSize);
		divide(r+newSize, c+newSize, newSize);
		
		sb.append(")");
	}
	
	public static boolean isZip(int startR, int startC, int size) {
		int v = map[startR][startC];
		for (int r=startR; r<startR+size; ++r) {
			for (int c=startC; c<startC+size; ++c) {
				if (map[r][c] != v) {
					return false;
				}
			}
		}
			
		return true;
	}
	
}
