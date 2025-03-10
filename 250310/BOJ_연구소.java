
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class BOJ_연구소 {
    static int[][] map;
    static List<int[]> twos;
    static List<int[]> ones;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int m;
    static int result = 0;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();  
    map = new int[n][m];

    List<int[]> walls = new ArrayList<>();
    twos = new ArrayList<>();
    ones = new ArrayList<>();

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            map[i][j] = sc.nextInt();
            if(map[i][j] == 0){
                walls.add(new int[]{i,j});
            }
            if(map[i][j] == 2){
                twos.add(new int[]{i,j});
            }
            if(map[i][j] == 1){
                ones.add(new int[]{i,j});
            }
        }
    }

    comb(walls, new int[3][2], 0, 0);

    System.out.println(result);
}
static void comb(List<int[]> walls, int[][] sel, int idx, int depth){
    if(depth == sel.length){
        //setting
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] v = new boolean[n][m];
        
        for(int i = 0; i < twos.size(); i++){
            queue.offer(twos.get(i));
            v[twos.get(i)[0]][twos.get(i)[1]] = true;
        }

        for(int i = 0; i < sel.length; i++){
            v[sel[i][0]][sel[i][1]] = true;
        }

        for(int i = 0; i < ones.size(); i++){
            v[ones.get(i)[0]][ones.get(i)[1]] = true;
        }

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int i = 0; i < 4; i++){
                int xdx = pos[0] + dx[i];
                int ydy = pos[1] + dy[i];

                if(xdx >= 0 && xdx < n && ydy >= 0 && ydy < m && !v[xdx][ydy]){
                    queue.offer(new int[]{xdx,ydy});
                    v[xdx][ydy]= true;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(v[i][j] == false){
                    count++;
                }
            }
        }
        if(result < count){
            result = count;
        }
        return;
    }
    if(idx == walls.size()){
        return;
    }

    sel[depth] = walls.get(idx);
    comb(walls, sel, idx+1, depth+1);

    comb(walls, sel, idx+1, depth);
}
}
