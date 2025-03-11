import java.util.*;
import java.io.*;
public class Main{
	static final int MAX = 10000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int M= Integer.parseInt(st.nextToken());
		int[][] dist = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(i!=j)
					dist[i][j] = MAX;
			}
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int sn = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			dist[sn][en] = Math.min(dist[sn][en], w);
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(dist[j][i] != MAX && dist[i][k] != MAX)
						dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
				}
 			}
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(dist[i][j] == MAX)
					System.out.print(0+" ");
				else
					System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}
}