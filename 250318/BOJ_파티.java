import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_파티 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2])-1;

        int[][] adjmat = new int[n][n];
        for(int i = 0; i < m; i++){
            line = br.readLine().split(" ");
            int f = Integer.parseInt(line[0])-1;
            int t = Integer.parseInt(line[1])-1;
            int v = Integer.parseInt(line[2]);

            adjmat[f][t] = v;
        }

        int[] save = new int[n];
        for(int i = 0; i < n; i++){
            save[i] = dijkstra(adjmat, i)[x];
        }

        int[] save2 = dijkstra(adjmat, x);
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            result[i] = save[i] + save2[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < result.length; i++){
            if( max < result[i]){
                max = result[i];
            }
        }
        System.out.println(max);

        


    }

    static int[] dijkstra(int[][] adjmat, int start){
        int[] dist = new int[adjmat.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, start});

        while(!pq.isEmpty()){
            int[] target = pq.poll();
            int cd = target[0];
            int cn = target[1];

            //현재 확정된 최단 경로보다 큰 경우
            if(cd > dist[cn]) continue;

            for (int i = 0; i < adjmat.length; i++) {
                // 인접행렬에서 값이 0이면 연결된 간선이 없다고 가정합니다.
                if (adjmat[cn][i] != 0) {
                    int nd = cd + adjmat[cn][i]; // 새로운 누적 거리 계산
                    if (nd < dist[i]) {
                        dist[i] = nd;
                        pq.offer(new int[]{nd, i});
                    }
                }
            }
        }

        return dist;
        


        
    }
}