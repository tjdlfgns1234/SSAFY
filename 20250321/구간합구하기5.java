import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] sum;
	public static void main(String[] args) throws IOException {
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   
		   int N = Integer.parseInt(st.nextToken());
		   int M = Integer.parseInt(st.nextToken());
		   
		   arr = new int[N+1][N+1];
		   for(int i=1; i<N+1; i++) {
			   st = new StringTokenizer(br.readLine());
			   for(int j=1; j<N+1; j++) {
				   arr[i][j] = Integer.parseInt(st.nextToken());
			   }
		   }
		   
		   for(int i=1; i<N+1; i++) {
			   for(int j=1; j<N+1; j++) {
				   arr[i][j] = arr[i][j] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			   }
		   }
		   
		   for(int i=0; i<M; i++) {
			   st = new StringTokenizer(br.readLine());
			   int sx = Integer.parseInt(st.nextToken());
			   int sy = Integer.parseInt(st.nextToken());
			   int ex = Integer.parseInt(st.nextToken());
			   int ey = Integer.parseInt(st.nextToken());
			   
			   int sum = arr[ex][ey] - arr[sx-1][ey] - arr[ex][sy-1] + arr[sx-1][sy-1];
			   System.out.println(sum);
		   }
	}
}