package cotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고스팟 {
	
	static class pair{
		int y;
		int x;
		int count=0;
		
		public pair(int y,int x , int count) {
			this.y=y;
			this.x=x;
			this.count=count;
		}
	}
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[][] arr;
	static int[][] visited;
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		for(int i=0;i<M;i++) {
			String t = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = t.charAt(j)-'0';
			}
		}
		visited = new int[M][N];
		
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(0,0,0));
		
		for(int i=0;i<M;i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		visited[0][0]=0;
		while(!q.isEmpty()) {
			pair p = q.poll();
			if(p.y==M-1 && p.x==N-1) {
				result = Math.min(p.count, result);
				continue;
			}
			for(int i=0;i<4;i++) {
				int ny = dy[i]+p.y;
				int nx = dx[i]+p.x;
				if(ny<0||ny>=M||nx<0||nx>=N)continue;
				if(arr[ny][nx]==1) {
					if(visited[ny][nx]<=p.count+1)continue;
					visited[ny][nx]=p.count+1;
					q.add(new pair(ny,nx,p.count+1));
				}
				else {
					if(visited[ny][nx]<=p.count)continue;
					visited[ny][nx]=p.count;
					q.add(new pair(ny,nx,p.count));
				}
			}
		}
		
		System.out.println(result);
		
	}

}
