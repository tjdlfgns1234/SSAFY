import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구간합구하기5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int N,M;

	static int[][] prefix;
	
	public static void main(String[] args)throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		prefix = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//구간합 구하기
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				prefix[i][j]=prefix[i][j-1]+map[i][j];
			}
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int sum=0;
			for(int j=y1;j<=y2;j++) {
				sum+=prefix[j][x2] - prefix[j][x1-1];
			}
			System.out.println(sum);
		}
		
	}
}	
