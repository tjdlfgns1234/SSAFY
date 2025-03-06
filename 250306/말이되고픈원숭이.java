package test;

import java.io.*;
import java.util.*;

public class 말이되고픈원숭이 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K ,W,H;
	static int map[][];
	static int visited[][][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int[] kniteY = {-1, -2, -2, -1 , 1, 2, 2, 1};
	static int[] kniteX = {-2, -1, 1, 2 , 2 , 1 , -1 , -2};
	static int result =0;
	static int num=1;
	
	static class pair{
		int y;
		int x;
		int c;
		int k;
		public pair(int y, int x , int c , int k) {
			this.y=y;
			this.x=x;
			this.c=c;
			this.k=k;
		}
	}
	
	static void kniteMove(int y,int x) {
		
	}
	
	public static void main(String[] args)throws IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		visited = new int[H][W][K+1];
		map = new int[H][W];
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		Queue<pair> q = new LinkedList<>();
		q.add(new pair(0,0,0,0));
		visited[0][0][0]=1;
		boolean ischeck = false;
		while(!q.isEmpty()) {
			pair p =q.poll();
			if(p.y==H-1 && p.x==W-1) {
				ischeck = true;
				System.out.println(p.c);
				break;
			}
			//나이트 이동 8 방향
			if(p.k < K) {
				for(int i=0;i<8;i++) {
					int ny = p.y+kniteY[i];
					int nx = p.x+kniteX[i];
					if(ny<0 || ny>=H || nx<0 || nx>=W)continue;
					if(visited[ny][nx][p.k+1]==1)continue;
					if(map[ny][nx]==1)continue;
					visited[ny][nx][p.k+1]=1;
					q.add(new pair(ny,nx,p.c+1,p.k+1));
				}
			}
			//4 방향 이동
			for(int i=0;i<4;i++) {
				int ny = p.y+dy[i];
				int nx = p.x+dx[i];
				if(ny<0 || ny>=H || nx<0 || nx>=W)continue;
				if(visited[ny][nx][p.k]==1)continue;
				if(map[ny][nx]==1)continue;
				visited[ny][nx][p.k]=1;
				q.add(new pair(ny,nx,p.c+1,p.k));
			}
		}
		
		if(!ischeck)System.out.println(-1);
		
	}
}
