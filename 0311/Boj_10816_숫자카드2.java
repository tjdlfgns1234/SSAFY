import java.util.*;
import java.io.*;

public class Boj_10816_숫자카드2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> count = new HashMap<>();
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(count.containsKey(key)) {
                int cnt = count.get(key);
                count.replace(key,cnt+1);
            }
            else {
                count.put(key,1);
            }
        }
        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();  //안쓰면 시간초과
        for (int i = 0; i < num; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (count.containsKey(key)) {
                sb.append(count.get(key) + " ");
            }
            else
                sb.append(0 + " ");
        }
        System.out.println(sb);
    }
}
