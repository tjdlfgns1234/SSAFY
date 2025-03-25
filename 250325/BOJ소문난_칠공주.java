import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class BOJ소문난_칠공주{
    static char[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int result = 0; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        int[][] pos = new int[25][2];

        for(int i = 0; i < 5; i++){
            String line = br.readLine();
            for(int j = 0; j < 5; j++){
                map[i][j] = line.charAt(j);
                pos[(i*5) + j] = new int[]{i,j};
            }
        }

        comb(pos, new int[7][2], 0, 0,0);

        System.out.println(result);
        
    }

    //조합 구하기
    static void comb(int[][] pos, int[][] sel, int depth, int idx, int cy_count){
        if(sel.length == depth){
            //다 연결 되어 있는지 체크
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] v = new boolean[5][5];
            int count = 0;
            //초기 값 넣기
            queue.add(sel[0]);
            v[sel[0][0]][sel[0][1]] = true;
            while(!queue.isEmpty()){
                int[] target = queue.poll();
                count++;
                int tx = target[0];
                int ty = target[1];
                
                for(int i = 0; i < 4;i++){
                    int nx = tx+dx[i];
                    int ny = ty+dy[i];
                    if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && v[nx][ny] == false){
                        //sel에 있는지 확인
                        for(int j = 0; j < 7; j++){
                            if(nx == sel[j][0] && ny == sel[j][1]){
                                queue.offer(new int[]{nx,ny});
                                v[nx][ny] = true;
                            }
                        }
                    }
                }
            }

            if(count == 7){
                result++;
            }

            return;
        }

        if(pos.length == idx) return;

        //만약 임도연 파 3명 이상
        if(cy_count == 3){
            //이다솜 파만 넣기
            if(map[pos[idx][0]][pos[idx][1]] == 'S'){
                sel[depth] = pos[idx];
                comb(pos, sel, depth+1, idx+1,cy_count);

                //이다솜 파인데도 불구하고 안넣음
                comb(pos, sel, depth, idx+1,cy_count);
            }else{ //Y파는 그냥 넘어감
                comb(pos, sel, depth, idx+1,cy_count);
            }
        }else{
            //아무나 넣기
            //단, 임도연 파인지는 체크
            if(map[pos[idx][0]][pos[idx][1]] == 'Y'){
                cy_count++;
                sel[depth] = pos[idx];
                comb(pos, sel, depth+1, idx+1,cy_count);

                //안 넣음
                cy_count--;
                comb(pos, sel, depth, idx+1,cy_count);
            }else{
                sel[depth] = pos[idx];
                comb(pos, sel, depth+1, idx+1,cy_count);
                
                comb(pos, sel, depth, idx+1,cy_count);
            }
        }

    }
}