//백트래킹
import java.util.*;
class Solution {
    static int power;
    static int answer;
    static int n;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        power = k;
        
        n = dungeons.length;
        visited = new boolean[n];
        
        dfs(0, dungeons);
        
        return answer;
    }
    
    static void dfs(int cnt, int[][] dungeons) {
        //탐색
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && power >= dungeons[i][0]) {
                visited[i] = true;
                power -= dungeons[i][1];
                dfs(cnt+1, dungeons);
                visited[i] = false;
                power += dungeons[i][1];
            }
        }
        answer = Math.max(answer, cnt);
        return;
    }
}
