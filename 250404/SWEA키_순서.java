import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SWEA키_순서 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            int[][] adjmat = new int[n][n];
            int[][] adjmatReverse = new int[n][n];
            for(int i = 0; i < m; i++){
                String[] line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0])-1;
                int b = Integer.parseInt(line[1])-1;

                adjmat[a][b] = 1;
                adjmatReverse[b][a] = 1;
            }

            int result = 0;
            for(int i = 0; i < n; i++){
                Queue<Integer> queue = new ArrayDeque<>();
                boolean[] v = new boolean[n];
                //setting
                queue.offer(i);
                v[i] = true;
                int count = 0;
                
                while(!queue.isEmpty()){
                    int target = queue.poll();
                    
                    for(int j = 0; j < n; j++){
                        int next = adjmat[target][j];
                        if(next == 1 && v[j] == false){
                            queue.offer(j);
                            count++;
                            v[j] = true;
                        }
                    }
                }

                //setting
                queue.offer(i);
                v = new boolean[n];
                v[i] = true;
                int reverseCount = 0;
                while(!queue.isEmpty()){
                    int target = queue.poll();
                    
                    for(int j = 0; j < n; j++){
                        int next = adjmatReverse[target][j];
                        if(next == 1 && v[j] == false){
                            queue.offer(j);
                            reverseCount++;
                            v[j] = true;
                        }
                    }
                }

                if(reverseCount + count == n-1){
                    result++;
                }

                System.out.println(count + " " + reverseCount + " " + i);
            }

            System.out.println("#"+t+" "+ result);
        }
    }
}
