import java.util.*;
class PG석유_시추 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public int solution(int[][] land) {
        boolean[][] v = new boolean[land.length][land[0].length];
        int[][] idxMap = new int[land.length][land[0].length];
        
        List<Integer> list = new ArrayList<>();
        int maxAmount = 0;
        
        //한번 탐색하면서 유전의 양 저장
        int idx = 1;
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 1 && !v[i][j]){
                    Queue<int[]> queue = new ArrayDeque<>();
                    int cnt = 0;
                    int x = i;
                    int y = j;

                    idxMap[x][y] = idx;
                    v[x][y] = true;
                    queue.offer(new int[] {x,y});
                    cnt++;
                    while(!queue.isEmpty()){
                        int[] pos = queue.poll();
                        int cx = pos[0];
                        int cy = pos[1];
                        for(int k = 0; k < 4; k++){
                            int nx = cx+dx[k];
                            int ny = cy+dy[k];
                            if(checkBound(nx,ny,land) && !v[nx][ny] && land[nx][ny] == 1){
                                v[nx][ny] = true;
                                cnt++;
                                idxMap[nx][ny] = idx;
                                queue.offer(new int[] {nx,ny});
                            }
                        }
                    }
                    
                    list.add(cnt);
                    idx++;
                }
            }
        }
        
        for(int j = 0; j < land[0].length; j++){
            
            //1자로 내려가기
            int amount = 0;
            boolean[] vi = new boolean[list.size()];
            for(int i = 0; i < land.length; i++){
                if(land[i][j] == 1 && !vi[idxMap[i][j]-1]){
                    amount+=list.get(idxMap[i][j]-1);
                    vi[idxMap[i][j]-1] = true;
                }
            }
            
            maxAmount = Math.max(maxAmount, amount);
        }
        
        return maxAmount;
    }
    
    static boolean checkBound(int x, int y, int[][] land){
        if(x >= 0 && x < land.length && y >= 0 && y < land[0].length){
            return true;
        }
        return false;
    }
}