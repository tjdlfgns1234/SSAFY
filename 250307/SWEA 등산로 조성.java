import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA1949 {
    static int result = 0;
public static void main(String[] args) {
    //1. 등산로는 가장 높은 봉우리에서 시작해야 한다.
    //2. 높은 지형에서 낮은 지형으로 가로 또는 세로 방향으로 연결이 되어야 한다.
    //즉, 높이가 같은 곳 혹은 낮은 지형이나, 대각선 방향의 연결은 불가능하다.
    //긴 등산로를 만들기 위해 딱 한 곳을 정해서 최대 K 깊이만큼 지형을 깎는 공사를 할 수 있다.

    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt();
    for(int t = 1; t <= testCase; t++){
        int n = sc.nextInt();
        int k = sc.nextInt(); // 공사 가능 깊이
        
        int maxPeak = 0;
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] > maxPeak){
                    maxPeak = map[i][j];
                }
            }
        }

        //최대 봉우리 배열
        List<int[]> peaks = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(maxPeak == map[i][j]){
                    peaks.add(new int[]{i,j});
                }
            }
        }

        for(int[] peakPos:peaks){
            boolean[][] v = new boolean[n][n];
            v[peakPos[0]][peakPos[1]] = true;
            dfs(map, peakPos, v, false, k, 1);
        }

        System.out.println("#"+t+" "+result);
        result = 0;

    }
}

static void dfs(int[][] map, int[] cPos, boolean[][] v, boolean uesK, int k, int count){
    //높은 지형에서 낮은 지형으로 가로 또는 세로 방향으로 연결한다.
    int n= map.length;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    boolean check = true;
    for(int i = 0; i < 4; i++){
        int xdx = cPos[0] + dx[i];
        int ydy = cPos[1] + dy[i];
        if(xdx>=0&&xdx<n&&ydy>=0&&ydy<n&&!v[xdx][ydy]){
            //해당 부분이 현재 지형보다 낮은 경우
            if(map[xdx][ydy] < map[cPos[0]][cPos[1]]){
                v[xdx][ydy] = true;
                dfs(map, new int[]{xdx,ydy}, v, uesK, k, count+1);
                v[xdx][ydy] = false;
                check = false;
            }
            for(int q = 1; q <= k;q++){
                if(!uesK && map[xdx][ydy] - q < map[cPos[0]][cPos[1]]){
                    uesK = true;
                    v[xdx][ydy] = true;
                    map[xdx][ydy] -=q;
                    dfs(map, new int[]{xdx,ydy}, v, uesK, q, count+1);
                    uesK = false;
                    v[xdx][ydy] = false;
                    map[xdx][ydy] +=q;
                    check = false;
                }
            }

        }
    }

    if(check){
        if(count > result){
            result = count;
        }
        return;
    }
}
}
