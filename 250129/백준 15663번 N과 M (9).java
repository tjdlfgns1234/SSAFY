import java.io.*;
import java.util.*;

public class Main {

    static int n = 1;
    static int [] num = new int[9];
    static int m;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>(); 
    
    // 질문 하기
    // 다 만들고 나서 해쉬맵으로 분리 했는데
    // 이거보다 좋은 방법이 있나?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n;i++)
            num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num, 1 , n+1);    
        
        
        recursive(new boolean[n + 1], new int[n + 1], 1, 0);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void recursive(boolean[] sel, int[] arr, int idx, int cnt) {
        if (cnt == m) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 1; i <= m; i++) 
                tmp.append(num[arr[i]]).append(" ");
            if(set.contains(tmp.toString()) == false){
                set.add(tmp.toString());
                sb.append(tmp.toString());
                sb.append("\n");
            }
            
            return;
        }
        if (idx >= arr.length) 
            return;
        

        for (int i = 1; i < arr.length; i++) {
            if(sel[i] == false){
                arr[idx] = i;
                sel[i] = true;
                // if(num[arr[idx-1]] <= num[arr[idx]])
                recursive(sel, arr, idx + 1, cnt + 1);
                sel[i] = false;
                arr[idx] = 0;     
            }
        }
    }
}