import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            if(map.isEmpty()){
                map.put(num, 1);
                continue;
            }
            if(map.containsKey(num)){
                map.replace(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }


        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                sb.append(map.get(num) + " ");
            }
            else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);

    }

}
