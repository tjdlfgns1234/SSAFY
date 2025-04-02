import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 홈방범서비스 {
	
	
	static class pair{
		int y=0;
		int x=0;
		public pair(int y,int x) {
			this.y=y;
			this.x=x;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int map[][];
	static List<pair> l;
	static boolean visited[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int num=1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			logic();
		}
	}
	
	static boolean calcu(int K , int m) {
		int fit = K * K + (K - 1) * (K - 1);
		int sum = m*M;
		return sum-fit>=0?true:false;
	}
	
	static int bfs(int y, int x) {
		Queue<pair> all = new LinkedList<>();
		all.add(new pair(y, x));
		visited[y][x]=true;
		int house= map[y][x]==1?1:0;
		int result=map[y][x]==1?1:0;
		int depth=1;
		while(!all.isEmpty()) {
			Queue<pair> temp = new LinkedList<>();
			while(!all.isEmpty()) {
				temp.add(all.poll());
			}

			while(!temp.isEmpty()) {
				pair p =temp.poll();
				for(int i=0;i<4;i++) {
					int ny = dy[i]+p.y;
					int nx = dx[i]+p.x;
					if(ny<0||ny>=N||nx<0||nx>=N)continue;
					if(visited[ny][nx])continue;
					if(map[ny][nx]==1) {
						house++;
					}
					visited[ny][nx]=true;
					all.add(new pair(ny,nx));
				}
			}
			depth++;
			if(calcu(depth,house)) {
				result = house;
			}
		}
		
		return result;
		
	}
	
	//M = 한집 비용 지불
	private static void logic() throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		l = new ArrayList<>();
		int result=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j]=temp;
				if(temp==1) {
					l.add(new pair(i,j));
				}
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				visited = new boolean[N][N];
				int res = bfs(i,j);
				result = Math.max(result, res);
			}
		}
			
		System.out.println("#"+(num++)+" "+result);
	}
	

			
	
}
