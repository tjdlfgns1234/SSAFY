import java.io.*;
import java.util.*;

class Virus {
    int x, y, size, dir;

    Virus() {
    }

    Virus(int x, int y, int size, int dir) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dir = dir;
    }

}

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static Virus[] virus;
    static int[] dx = { 0,-1, 1, 0, 0 }; // 1부터 시작이야!
    static int[] dy = { 0 ,0, 0, -1, 1 };
    static int mp[][] = new int[8][8];
    static boolean chk[][];
    static int n, m, k, T, ans; // ans는 m시간 이후 남아있는 미생물의 총합

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int testcase = 1; testcase <= T; testcase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            virus = new Virus[k];
            
            int a,b,c,d;
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
               
                virus[i] = new Virus(a,b,c,d);             
                
            }
            ans = 0;
            
            solve();

            System.out.println("#" + testcase + " " + ans);
        }
    }

    private static void solve() {  
    	for(int i = 0; i < m;i++) {
    		move();
    		merge();
    	}
    	
    	for(int i = 0; i < k;i++)
    		ans += virus[i].size;
    }

	private static void merge() {
		for(int i = 0; i < k;i++) {
			int currX = virus[i].x;
			int currY = virus[i].y;
			
			int currSize = virus[i].size;
			int currDir = virus[i].dir;
			
			for(int j = i+1; j < k;j++) {
				if(currX == virus[j].x && currY == virus[j].y) {
					virus[i].size += virus[j].size; // 값을 더해줌
					
					if(currSize < virus[j].size) {
						// 같은 경우는 주어지지 않으므로 고려 X
						currDir = virus[j].dir;
						currSize = virus[j].size;
					}
					// 합쳐지므로 없는 바이러스 표시
					virus[j].size = 0;	
				}
			}
			virus[i].dir = currDir;
		}
		
	}

	private static void move() {
		// 이동후 약품만 처리
        for (int i = 0; i < k; i++) {
        	int currDir = virus[i].dir;
        	int currSize = virus[i].size;
        	int nx = virus[i].x + dx[currDir];
        	int ny = virus[i].y + dy[currDir];

        	if(nx == 0 || nx == n-1 || ny == 0 || ny == n-1) {
        		// 약품을 만난 경우 이므로
        		currDir = changeDir(currDir); // 방향을 반전 시키고
        		currSize /= 2; // 미생물 수를 반으로 줄임
        	}
        	
        	virus[i].x = nx;
        	virus[i].y = ny;
        	virus[i].dir = currDir;
        	virus[i].size =currSize;
        }
	}

	private static int changeDir(int currDir) {
 		if (currDir == 4)
			return 3;
 		else if (currDir == 3)
 			return 4;
		else if (currDir == 2)
			return 1;
		else if (currDir == 1)
			return 2;	
 		
		return 0;
	}


}
