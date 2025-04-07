import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CT자율주행_자동차 {
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		map = new int[n][m];
		
		line = br.readLine().split(" ");
		int cx = Integer.parseInt(line[0]);
		int cy = Integer.parseInt(line[1]);
		int d = Integer.parseInt(line[2]);
		
		for(int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			for(int j = 0; j  < m ; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		
		//현재 위치 셋팅
		map[cx][cy] = 2;
		int count = 1;
		
		//logic
		while(true) {
			//4방향 다 갈 수 없을 경우 체크
			boolean check = true;
			
			//좌로 돌면서 있는지 갈 수 있는지 확인
			for(int i = 0; i < 4; i++) {
				d -= 1;
				if(d < 0) {
					d = 3;
				}
				
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				//들어갈 수 있는 경우
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
					cx = nx;
					cy = ny;
					map[cx][cy] = 2;
					count++;
					check = false;
					break;
				}
			}
			
			//만약에 4방향 다 안되면
			if(check) {
				//뒤로 가야 함
				int nx = cx + dx[(d + 2) % 4];
				int ny = cy + dy[(d + 2) % 4];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1) {
					cx = nx;
					cy = ny;
				}else {
					break;
				}
			}
			
//			//debug
//			for(int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println(cx +  " " + cy);
//			if(count == 9) {
//				break;
//			}
//			
		}
		
		System.out.println(count);
		
		
		

		
	}
}
