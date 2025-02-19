package solving.baekjoon10989;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 주어지는 숫자의 갯수에 비해 들어 올 수 있는 숫자의 범위가 많이 적은거 보니
 * 중복되는 숫자들은 카운팅해서 출력하는 개념인 것 같습니다.
 * 그냥 소트하고 빠른 입출력 하니까 풀려버렸네요.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];
        for (int in = 0; in < N; in++) {
            arr[in] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(arr);
        for (int i : arr) {
            sb.append(i + "\n");
        }
        System.out.print(sb.toString());
    }
}
