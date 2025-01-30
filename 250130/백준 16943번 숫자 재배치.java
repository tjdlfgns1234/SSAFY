import java.io.*;
import java.util.*;

public class Main {

    static String n;
    static int[] num = new int[12];
    static int m;
    static int ans = -1;
    static int length = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = st.nextToken();
        m = Integer.parseInt(st.nextToken());

        String[] str = n.split("");

        for(String i : str)
            num[length++] = Integer.parseInt(i);
        
        recursive(new boolean[length], new int[length], 0, 0);

        System.out.print(ans);
        // bw.write(sb.toString());
        // bw.flush();
    }

    public static void recursive(boolean[] sel,int[] arr ,int idx, int cnt) {
        if (cnt == length) {
            sb.setLength(0);
            
            for (int i = 0; i < length; i++) 
                sb.append(num[arr[i]]);

            int tmp = Integer.parseInt(sb.toString());
            
            if(tmp < m && Integer.toString(tmp).length() == length)
                ans = Math.max(tmp,ans);

            return;
        }
        if (idx >= length) {
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!sel[i]) {
                arr[idx] = i;
                sel[i] = true;
                recursive(sel, arr, idx + 1, cnt + 1);
                sel[i] = false;
                arr[idx] = 0;
            }
        }
    }
}