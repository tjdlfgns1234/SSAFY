import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적록색약 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static char[][] map;
    static int R,G,B;
    static int R2,B2;
    static boolean visited[][];
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};

    static void dfs(int y, int x , int color){
        for(int i=0;i<4;i++){
            int ny = dy[i]+y;
            int nx = dx[i]+x;
            if(ny<0||ny>=N||nx<0||nx>=N)continue;
            if(map[ny][nx] !=color)continue;
            if(visited[ny][nx]==true)continue;
            visited[ny][nx]=true;
            dfs(ny,nx,color);
        }

    }

    static void dfs1(int y, int x , int color){
        for(int i=0;i<4;i++){
            int ny = dy[i]+y;
            int nx = dx[i]+x;
            if(ny<0||ny>=N||nx<0||nx>=N)continue;
            if(color=='R' || color=='G'){
                if(map[ny][nx] =='B')continue;
            }
            else{
                if(map[ny][nx] !=color)continue;
            }
            if(visited[ny][nx]==true)continue;
            visited[ny][nx]=true;
            dfs1(ny,nx,color);
        }

    }



    public static void main(String[] args)throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0;i<N;i++){
            String temp = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = temp.charAt(j);
            }
        }
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]==true)continue;
                visited[i][j]=true;
                if(map[i][j]=='R'){
                    R++;
                }
                else if(map[i][j]=='G'){
                    G++;
                }
                else{
                    B++;
                }
                dfs(i,j,map[i][j]);
            }
        }

        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]==true)continue;
                visited[i][j]=true;
                if(map[i][j]=='R' || map[i][j]=='G'){
                    R2++;
                }
                else{
                    B2++;
                }
                dfs1(i,j,map[i][j]);
            }
        }
        System.out.print((R+B+G)+" ");
        System.out.println((R2+B2));

    }

}
