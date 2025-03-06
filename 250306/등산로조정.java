package test;

import java.util.*;
import java.io.*;

public class 등산로조정 {
	// 지형의 높이는 1 이상 20 이하의 정수이다.
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N ,K;
	static int map[][];
	static int visited[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int result =0;
	static int num=1;
	static class pair{
		int y;
		int x;
		public pair(int y,int x) {
			this.y=y;
			this.x=x;
		}
	}
	
	static void dfs(int y , int x , boolean isBreak , int count) {
		result = Integer.max(result, count);
		//System.out.println("# "+count+" "+y+" "+x);
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny<0||ny>=N||nx<0||nx>=N)continue;
			if(visited[ny][nx]==1)continue;
			if(map[y][x]<=map[ny][nx]) {
				if( !isBreak && (map[ny][nx] - K < map[y][x]) ) {
					visited[ny][nx]=1;
					for(int s=1;s<=K;s++) {
						if(map[ny][nx] - s < map[y][x]) {
							map[ny][nx] -= s;
							dfs(ny,nx,true , count+1);
							map[ny][nx] += s; 
							break;
						}
					}
					visited[ny][nx]=0;
				}
				continue;
			}
			visited[ny][nx]=1;
			dfs(ny,nx,isBreak , count+1);
			visited[ny][nx]=0;
		}
	}
	
	public static void logic()throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result=0;
		map = new int[N][N];
		visited = new int[N][N];
		int max=0;
		List<pair> l = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>max) {
					l = new ArrayList<>();
					l.add(new pair(i,j));
					max = map[i][j];
				}
				else if(map[i][j] == max) {
					l.add(new pair(i,j));
				}
			}
		}
		
		for(int i=0;i<l.size();i++) {
			pair p = l.get(i);
			visited[p.y][p.x]=1;
			dfs(p.y,p.x,false,1);
			visited[p.y][p.x]=0;
		}
		System.out.println("#"+(num++)+" "+result);
	}
	
	
	public static void main(String[] args)throws IOException {
		int tc =Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			logic();
		}
	}
}
