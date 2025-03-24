import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

class BOJ적녹색약{
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = line.charAt(j);
            }
        }

        System.out.print(bfsForNomal(map) + " " + bfsForSackyak(map));
    }

    static int bfsForNomal(char[][] map){
        int n = map.length;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int result = 0;
        boolean[][] v = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Queue<int[]> queue = new ArrayDeque<>();
                if(!v[i][j]){
                    char targetValue = map[i][j];
                    queue.offer(new int[]{i,j});
                    v[i][j] = true;
                    while (!queue.isEmpty()) {
                        int xdx;
                        int ydy;
                        int[] pos = queue.poll();
                        for(int k = 0; k < 4; k++){
                            xdx = pos[0] + dx[k];
                            ydy = pos[1] + dy[k];
                            if(xdx >= 0 && xdx < n && ydy >= 0 && ydy < n && targetValue == map[xdx][ydy] && !v[xdx][ydy]){
                                queue.offer(new int[]{xdx,ydy});
                                v[xdx][ydy] = true;
                            }
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }

    static int bfsForSackyak(char[][] map){
        int n = map.length;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int result = 0;
        boolean[][] v = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Queue<int[]> queue = new ArrayDeque<>();
                if(!v[i][j]){
                    char targetValue = map[i][j];
                    queue.offer(new int[]{i,j});
                    v[i][j] = true;
                    while (!queue.isEmpty()) {
                        int xdx;
                        int ydy;
                        int[] pos = queue.poll();
                        for(int k = 0; k < 4; k++){
                            xdx = pos[0] + dx[k];
                            ydy = pos[1] + dy[k];
                            if(xdx >= 0 && xdx < n && ydy >= 0 && ydy < n && !v[xdx][ydy]){
                                if((targetValue == 'R' || targetValue == 'G') && (map[xdx][ydy] == 'R' || map[xdx][ydy] == 'G')){
                                    queue.offer(new int[]{xdx,ydy});
                                    v[xdx][ydy] = true;
                                }else if(targetValue == map[xdx][ydy]){
                                    queue.offer(new int[]{xdx,ydy});
                                    v[xdx][ydy] = true;
                                }

                            }
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }
}