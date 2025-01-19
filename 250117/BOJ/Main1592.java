import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        arr[0] = 1;
        int count = 0;
        int max = arr[0];
        int idx = 0;
        //0~10 -> (10 + x) / 10;
        while (max < M) {
            int curr = arr[idx];
            idx = curr % 2 == 0 ? (N + idx - L) % N : (N + idx + L) % N;
            ++count;
            ++arr[idx];
            max = Math.max(arr[idx], max);
        }

        System.out.println(count);
    }
}
