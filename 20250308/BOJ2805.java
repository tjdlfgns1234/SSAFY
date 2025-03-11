import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        long tmpSum = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, tree[i]);
            tmpSum += tree[i];
        }

        if (tmpSum < M) {
            System.out.println("0");
            return;
        }

        int mid;
        while (start <= end) { // `<=`로 변경
            mid = (start + end) / 2;
            long sum = 0;
            
            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) { // `>=`가 아닌 `>`여야 함
                    sum += tree[i] - mid;
                }
            }

            if (sum >= M) { // `>=`로 변경
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start - 1); // `end`가 아니라 `start - 1`
    }
}