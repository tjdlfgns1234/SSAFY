import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class CT이상한_체스{
	static int n;
	static int m;
	static int[][] map;
	
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		
		//map 입력
		map = new int[n][m];
		//말 위치 + 종류 확인
		List<int[]> horses = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if(map[i][j] != 0 && map[i][j] != 6) {
					horses.add(new int[] {i, j, map[i][j]});
					}
				}
			}
		
		dfs(horses, copyMap(map), 0);
		System.out.println(result);
		}
	
	static void dfs(List<int[]> horses, int[][] map, int idx) {
		if(idx == horses.size()) {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 0) {
						sum++;
					}
				}
			}

			result = Math.min(result, sum);
			
			return;
		}
		
		int[] target = horses.get(idx);
		int option = target[2];
		
		if(option == 1) { // 첫번째 경우
			//북
			int[][] newMap = goMap(map, 1, target[0], target[1]);
			dfs(horses, newMap, idx+1);
			
			//남
			newMap = goMap(map, 2, target[0], target[1]);
			dfs(horses, newMap, idx+1);
			
			//동
			newMap = goMap(map, 3, target[0], target[1]);
			dfs(horses, newMap, idx+1);
			
			//서
			newMap = goMap(map, 4, target[0], target[1]);
			dfs(horses, newMap, idx+1);
		}else if(option == 2) { // 두번째 경우 2가지 경우의 수
			//북남
			int[][] newMap = goMap(map, 1, target[0], target[1]);
			newMap = goMap(newMap, 2, target[0], target[1]);
			dfs(horses, newMap, idx+1);
			
			//동서
			newMap = goMap(map, 3, target[0], target[1]);
			newMap = goMap(newMap, 4, target[0], target[1]);
			dfs(horses, newMap, idx+1);
		}else if(option == 3) { // 세번째 경우 4가지 경우의 수
			//1 북, 2 남, 3 동, 4 서
			//북동
			int[][] newMap = goMap(map, 1, target[0], target[1]);
			newMap = goMap(newMap, 3, target[0], target[1]);
			dfs(horses, newMap, idx+1);
			
			//동남
			newMap = goMap(map, 3, target[0], target[1]);
			newMap = goMap(newMap, 2, target[0], target[1]);
			dfs(horses, newMap, idx+1);
			
			//남서
			newMap = goMap(map, 2, target[0], target[1]);
			newMap = goMap(newMap, 4, target[0], target[1]);
			dfs(horses, newMap, idx+1);
			
			//서북
			newMap = goMap(map, 4, target[0], target[1]);
			newMap = goMap(newMap, 1, target[0], target[1]);
			dfs(horses, newMap, idx+1);
		}else if(option == 4) { // 4번째 경우 4가지 경우의 수
			//1 북, 2 남, 3 동, 4 서
			//북동서
			int[][] newMap = goMap(map, 1, target[0], target[1]);
			newMap = goMap(newMap, 3, target[0], target[1]);
			newMap = goMap(newMap, 4, target[0], target[1]);
			dfs(horses, newMap, idx+1);
			
			//동북남
			newMap = goMap(map, 3, target[0], target[1]);
			newMap = goMap(newMap, 1, target[0], target[1]);
			newMap = goMap(newMap, 2, target[0], target[1]);
			dfs(horses, newMap, idx+1);
			
			//남서동
			newMap = goMap(map, 2, target[0], target[1]);
			newMap = goMap(newMap, 4, target[0], target[1]);
			newMap = goMap(newMap, 3, target[0], target[1]);
			dfs(horses, newMap, idx+1);
			
			//서북남
			newMap = goMap(map, 4, target[0], target[1]);
			newMap = goMap(newMap, 1, target[0], target[1]);
			newMap = goMap(newMap, 2, target[0], target[1]);
			dfs(horses, newMap, idx+1);
		}else { // 4번째 경우 4가지 경우의 수
			//1 북, 2 남, 3 동, 4 서
			//동서남북
			int[][] newMap = goMap(map, 1, target[0], target[1]);
			newMap = goMap(newMap, 2, target[0], target[1]);
			newMap = goMap(newMap, 3, target[0], target[1]);
			newMap = goMap(newMap, 4, target[0], target[1]);
			dfs(horses, newMap, idx+1);
		}
	}
	
	
	
	static int[][] copyMap (int[][] map){
		int[][] newMap = new int[map.length][map[0].length];
		for(int i = 0; i< map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
		return newMap;
	}
	
	static boolean canGo(int nx, int ny) {
		if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 6) {
			return true;
		}
		return false;
	}
	
	static int[][] goMap(int[][] map, int d, int cx, int cy){
		int[][] newMap = copyMap(map);
		//1 북, 2 남, 3 동, 4 서
		if(d == 1) {
			while(true) {
				int nx = cx - 1;
				int ny = cy;
				if(canGo(nx,ny)) {
					if(newMap[nx][ny] == 0) {
						newMap[nx][ny] = 9;
					}
					cx = nx;
					cy = ny;
				}else {
					break;
				}
			}
		}else if(d == 2) {
			while(true) {
				int nx = cx+1;
				int ny = cy;
				if(canGo(nx,ny)) {
					if(newMap[nx][ny] == 0) {
						newMap[nx][ny] = 9;
					}
					cx = nx;
					cy = ny;
				}else {
					break;
				}
			}
		}else if(d == 3) {
			while(true) {
				int nx = cx;
				int ny = cy+1;
				if(canGo(nx,ny)) {
					if(newMap[nx][ny] == 0) {
						newMap[nx][ny] = 9;
					}
					cx = nx;
					cy = ny;
				}else {
					break;
				}
			}
		}else {
			while(true) {
				int nx = cx;
				int ny = cy-1;
				if(canGo(nx,ny)) {
					if(newMap[nx][ny] == 0) {
						newMap[nx][ny] = 9;
					}
					cx = nx;
					cy = ny;
				}else {
					break;
				}
			}
		}
		
		return newMap;
	}
		
	}
	
