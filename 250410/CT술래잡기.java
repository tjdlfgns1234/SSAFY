import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class CT술래잡기{
	static int n;
	static int[][] map;
	//위 0, 오른쪽 1, 아래 2, 왼쪽 3
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] runners;
	static int[] catcher;
	static int[][] runnerMap;
	static int[][] moveMap;
	static boolean isDirectMap;
	static int[][] dMap;
	static int[][] rMap;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int h = Integer.parseInt(line[2]);
		int k = Integer.parseInt(line[3]);
		
		//맵 초기화
		map = new int[n][n];
		
		//x, y, d
		runners = new int[m][4];
		
		//이동 맵
		isDirectMap = true;
		dMap = makeDMap();
		rMap = makeRMap();
		moveMap = dMap;
		
		//러너 입력
		for(int i = 0; i < m; i++) {
			line = br.readLine().split(" ");
			runners[i] = new int[] { 
					Integer.parseInt(line[0])-1, 
					Integer.parseInt(line[1])-1, 
					Integer.parseInt(line[2]) == 1 ? 1 : 2,
							0
							};
		}
		updateRunnerMap();
		
		//나무 입력
		for(int i = 0; i < h; i++) {
			line = br.readLine().split(" ");
			//나무는 9
			map[Integer.parseInt(line[0])-1][Integer.parseInt(line[1])-1] = 9;
		}
		
		//catcher 초기화
		catcher = new int[] {n/2, n/2, 0};
		
		int result = 0;
		
		for(int t = 1; t <= k ; t++) {
			//도망자 이동
			moveRunners();
			updateRunnerMap();
			
			// 술래 이동
			moveCatcher();
			
			//술래 잡기
			int catched = catchRunners();
			
			result += (t * catched);
			
		}
		
		System.out.println(result);
		
	}
	
	static int catchRunners() {
		int cx = catcher[0];
		int cy = catcher[1];
		int d = catcher[2];
		int catched = 0;
		for(int i = 0; i < 3; i++) {
			int nx = cx + (dx[d] * i);
			int ny = cy + (dy[d] * i);
			if(checkBound(nx, ny)) {
				//나무인지 확인
				if(map[nx][ny] != 9) {
					catched += runnerMap[nx][ny];
					killRunner(nx, ny);
				}
			}
		}
		return catched;
	}
	
	static void killRunner(int x, int y) {
		for(int i = 0; i < runners.length; i++) {
			int[] runner = runners[i];
			if(runner[0] == x && runner[1] == y && runners[i][3] == 0) {
				runners[i][3] = 1;
			}
		}
	}
	
	static void moveCatcher() {
		int cx = catcher[0];
		int cy = catcher[1];
		int d = catcher[2];
		
		int nx = cx + dx[d];
		int ny = cy + dy[d];
		
		if(moveMap[nx][ny] != 9) {
			catcher[0] = nx;
			catcher[1] = ny;
			catcher[2] = moveMap[nx][ny];
		}else {
			if(isDirectMap) {
				isDirectMap = false;
				moveMap = rMap;
				catcher[0] = nx;
				catcher[1] = ny;
				catcher[2] = moveMap[nx][ny];
			}else {
				isDirectMap = true;
				moveMap = dMap;
				catcher[0] = nx;
				catcher[1] = ny;
				catcher[2] = moveMap[nx][ny];
			}
		}
		
//		int[][] temp = new int[n][n];
//		temp[catcher[0]][catcher[1]] = catcher[2];
//		for(int i = 0; i< n; i++) {
//			System.out.println(Arrays.toString(temp[i]));
//		}
//		System.out.println();
		
		
	}
	
	static void updateRunnerMap() {
		int[][] newMap = new int[n][n];
		for(int[] runner : runners) {
			//도망자 1
			if(runner[3] == 0) {
				newMap[runner[0]][runner[1]]++;
			}
			
		}
		
		runnerMap = newMap;
		
//		for(int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(runnerMap[i]));
//		}
//		System.out.println();
		
		
	}
	//전체 러너들 이동
	static void moveRunners() {
		for(int i = 0; i< runners.length; i++) {
			int[] runner = runners[i];
			int cx = runner[0];
			int cy = runner[1];
			int d = runner[2];
			
			//술래와의 거리가 3이하인 도망자 움직이기
			int dist = Math.abs(catcher[0] - cx) + Math.abs(catcher[1] - cy);
			if(dist <= 3) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(checkBound(nx, ny)) {
					if(catcher[0] != nx || catcher[1] != ny) {
						runners[i][0] = nx;
						runners[i][1] = ny;
					}
				}else {
					d = (d + 2) % 4;
					nx = cx + dx[d];
					ny = cy + dy[d];
					if(catcher[0] != nx || catcher[1] != ny) {
						runners[i][0] = nx;
						runners[i][1] = ny;
						runners[i][2] = d;
					}
				}
			}
		}
	}
	
	static int[][] makeDMap(){
		int[][] newMap = new int[n][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(newMap[i], -1);
		}
		int cx = n/2;
		int cy = n/2;
		int d = 0;
		
		newMap[cx][cy] = d;
		
		while(true) {
			int nx = cx + dx[d];
			int ny = cy + dy[d];
			
			if(checkBound(nx, ny)) {
				//방향 결정
				int nnx = nx + dx[(d+1)%4];
				int nny = ny + dy[(d+1)%4];
				if(checkBound(nnx, nny)) {
					if(newMap[nnx][nny] == -1) {
						d = (d+1)%4;
					}
				}
			}else {
				newMap[cx][cy] = 9;
				break;
			}
			
			newMap[nx][ny] = d;
			cx = nx;
			cy = ny;
		}
		
//		for(int i = 0; i< n; i++) {
//			System.out.println(Arrays.toString(newMap[i]));
//		}
//		System.out.println();
		return newMap;
	}
	
	static int[][] makeRMap(){
		int[][] newMap = new int[n][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(newMap[i], -1);
		}
		int cx = 0;
		int cy = 0;
		int d = 2;
		
		newMap[cx][cy] = d;
		while(true) {
			if(cx == n/2 && cy == n/2) {
				newMap[cx][cy] = 9;
				break;
			}
			
			int nx = cx + dx[d];
			int ny = cy + dy[d];
			
			if(!checkBound(nx, ny) || newMap[nx][ny] != -1) {
				d = (d -1 + 4) % 4;
				newMap[cx][cy] = d;
			}else if(checkBound(nx, ny)){
				newMap[nx][ny] = d;
				cx = nx;
				cy = ny;
			}
			
		}
		
//		for(int i = 0; i< n; i++) {
//			System.out.println(Arrays.toString(newMap[i]));
//		}
//		System.out.println();
		
		
		
		return newMap;
		
	}
	
	static boolean checkBound(int nx, int ny) {
		if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
			return true;
		}
		return false;
	}
}
	

