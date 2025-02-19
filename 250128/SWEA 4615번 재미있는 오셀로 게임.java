import java.util.*;

public class Solution {

    static int t,n,m, B,W;
    static int[] dx = {1,-1, 1,-1, 0, 0, 1 ,-1};
    static int[] dy = {1, -1, -1, 1, 1, -1, 0, 0};
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        t = sc.nextInt();

        for(int testCase = 1; testCase <= t; testCase++){
            n = sc.nextInt();
            m = sc.nextInt();
            B = 0; W =0;
            // 좌표는 1부터 시작
            int[][] mp = new int[n+1][n+1];

            // B : 1, W : 2
            // 초기화
            mp[n/2][n/2] = 2;
            mp[n/2][n/2+1] = 1;
            mp[n/2+1][n/2] = 1;
            mp[n/2+1][n/2+1] = 2;
          

            int x,y,z;
            for(int i = 0; i < m;i++){
                x = sc.nextInt();
                y = sc.nextInt();
                z = sc.nextInt();

                mp[x][y] = z;
                Reverse(mp,x,y,z);
                // print(mp);
                
            }
            sum(mp);
            System.out.println("#" + testCase + " " + B +" " + W);
            // print(mp);
        }
    }

    private static void sum(int[][] arr) {
        for(int i = 1; i <= n;i++)
            for(int j = 1; j <=n;j++)
                if(arr[i][j] == 1)
                    B++;
                else if(arr[i][j] == 2)
                    W++;

    }
    
    
     private static void print(int[][] arr) {
        for(int i = 1; i <= n;i++){
            for(int j = 1; j <=n;j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    private static void Reverse(int[][] mp,int x,int y, int color) {
        for(int i = 0; i<8;i++){
            int nx = x;
            int ny = y;
            int cnt = 0; // 사이의 돌의 개수
            while(true){
                nx = nx + dx[i];
                ny = ny + dy[i];
           
                // 밖으로 나가지 않기 위한 것
                // 돌이 놓이지 않은 경우도 계산
                if(nx <= 0 || nx > n || ny <= 0 || ny > n || mp[nx][ny] == 0)
                    break; 
    
                cnt++;
                // 만나면 뒤집어줌
                if(color == mp[nx][ny]){
                    // System.out.println(nx+ " " + ny);
                    for(int j = 0; j < cnt; j++){
           
                        nx = nx - dx[i];
                        ny = ny - dy[i];
                        mp[nx][ny] = color;
                    }
                    break;
                }
            }
        }

    }
}