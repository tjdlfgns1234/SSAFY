// 1 5 10 50 - I V X L
// 4개의 숫자 중 N개를 뽑는 중복 조합

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main16922 {

    static int N;
    static Set<Integer> set = new HashSet<>();
    static int[] arr = {1, 5, 10, 50};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        recursive(0, 0, 0);

        System.out.println(set.size());

    }

    public static void recursive(int count, int prev, int sum) {

        if (count == N) {
            set.add(sum);
            return;
        }

        for (int i = prev; i<4; ++i) {
            recursive(count+1, i, sum + arr[i]);
        }
    }
}