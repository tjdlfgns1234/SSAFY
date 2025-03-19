import java.io.*;
import java.util.*;

class Train {
	int x1, y1, x2, y2, x3, y3;
	int cnt;
	int turn;
	//true = 세로
	boolean way = true;
	
	Train(int x1, int y1, int x2, int y2, int x3, int y3, boolean way, int cnt, int turn) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.way = way;
		this.cnt = cnt;
		this.turn = turn;
	}
}

public class Main {
	static int[][] map;
	static int N;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int[][] train = new int[3][2];
		
		int cntT = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0; j<N; j++) {
				char c = s.charAt(j);
				if(c=='B') {
					train[cntT][0] = j;
					train[cntT][1] = i;
					cntT++;
				} else if(c=='E') {
					map[i][j] = -1;
				} else {
					map[i][j] = c-'0';
				}
			}
		}
		Train t;
		if(train[1][0] - train[0][0] == 1)
			t = new Train(train[0][0], train[0][1], train[1][0], train[1][1], train[2][0], train[2][1], false, 0, 0);
		else
			t = new Train(train[0][0], train[0][1], train[1][0], train[1][1], train[2][0], train[2][1], true, 0, 0);
		bfs(t);
		System.out.println(0);
	}
	static void print() {
		for(int i=0; i<N; i++)
			System.out.println(Arrays.toString(map[i]));
	}
	static void bfs(Train t) {
		Queue<Train> q = new ArrayDeque<>();
		int[][] v = new int[N][N];
		v[t.y1][t.x1] = 1<<0;
		q.add(t);
		
		while(!q.isEmpty()) {
			Train tmp = q.poll();
			if(map[tmp.y1][tmp.x1]==-1 && map[tmp.y2][tmp.x2]==-1 && map[tmp.y3][tmp.x3]==-1) {
				System.out.println(tmp.cnt);
				System.exit(0);
			}
			for(int d=0; d<4; d++) {
				int tx1 = tmp.x1+dx[d];
				int ty1 = tmp.y1+dy[d];
				int tx2 = tmp.x2+dx[d];
				int ty2 = tmp.y2+dy[d];
				int tx3 = tmp.x3+dx[d];
				int ty3 = tmp.y3+dy[d];
				
				if(tx1<0||tx3>=N||ty1<0||ty3>=N||map[ty1][tx1]==1||map[ty2][tx2]==1||map[ty3][tx3]==1||((v[ty1][tx1]&(1<<tmp.turn))!=0))
					continue;
				
				v[ty1][tx1] |= 1<<tmp.turn;
				q.add(new Train(tx1, ty1, tx2, ty2, tx3, ty3, tmp.way, tmp.cnt+1, tmp.turn));
			}
			if(tmp.turn==31)
				continue;
			if(tmp.way) {
				if(tmp.x1==0 || tmp.x1==N-1 || map[tmp.y1][tmp.x1-1]==1 || map[tmp.y1][tmp.x1+1]==1 || map[tmp.y2][tmp.x2-1]==1 || map[tmp.y2][tmp.x2+1]==1 || map[tmp.y3][tmp.x3-1]==1 || map[tmp.y3][tmp.x3+1]==1 ||((v[tmp.y1+1][tmp.x1-1]&(1<<(tmp.turn+1)))!=0))
					continue;
				v[tmp.y1+1][tmp.x1-1] |= 1<<(tmp.turn+1);
				q.add(new Train(tmp.x1-1, tmp.y1+1, tmp.x2, tmp.y2, tmp.x3+1, tmp.y3-1, (!tmp.way), tmp.cnt+1, tmp.turn+1));
			} else {
				if(tmp.y1==0 || tmp.y1==N-1 || map[tmp.y1-1][tmp.x1]==1 || map[tmp.y1+1][tmp.x1]==1 || map[tmp.y2-1][tmp.x2]==1 || map[tmp.y2+1][tmp.x2]==1 || map[tmp.y3-1][tmp.x3]==1 || map[tmp.y3+1][tmp.x3]==1 || ((v[tmp.y1-1][tmp.x1+1]&(1<<(tmp.turn+1)))!=0))
					continue;
				v[tmp.y1-1][tmp.x1+1] |= 1<<(tmp.turn+1);
				q.add(new Train(tmp.x1+1, tmp.y1-1, tmp.x2, tmp.y2, tmp.x3-1, tmp.y3+1, (!tmp.way), tmp.cnt+1, tmp.turn+1));
			
			}
		}
	}
}
