import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 배열의 크기
            List<List<Integer>> arr = new ArrayList<>();
            int mid = n / 2;

            for (int j = 0; j < n; j++) {
                List<Integer> numbers = new ArrayList<>();
                String[] tmp = br.readLine().split("");
                for (String tm : tmp) {
                    numbers.add(Integer.parseInt(tm));
                }
                arr.add(numbers);
            }

            int sum = 0;

            // 위쪽 (중심 포함)
            for (int x = 0; x <= mid; x++) {
                for (int y = mid - x; y <= mid + x; y++) {
                    sum += arr.get(x).get(y);
                }
            }

            // 아래쪽
            for (int x = mid + 1; x < n; x++) {
                for (int y = x - mid; y < n - (x - mid); y++) {
                    sum += arr.get(x).get(y);
                }
            }

            bw.write("#" + (i+1) + " "+ sum + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
