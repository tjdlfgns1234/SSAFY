import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5215 {

    static int max; //여러 조합 중 최댓값을 저장할 변수
    static int L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; ++t) {
            max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            //맛, 칼로리
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; ++j) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            recursive(arr, 0, 0, 0);
            System.out.println("#" + t + " " + max);
        }
    }

    /**
     * @param arr   원본배열
     * @param idx   원본배열의 인덱스
     * @param score 현재 맛 점수
     * @param cal   현재 칼로리
     */
    public static void recursive(int[][] arr, int idx, int score, int cal) {
        // basis part
        if (cal > L) {
            return;
        }

        if (idx == arr.length) {
            max = Math.max(max, score);
            return;
        }

        // inductive part
        // 해당 재료를 선택한 경우
        recursive(arr, idx + 1, score + arr[idx][0], cal + arr[idx][1]);

        // 해당 재료를 선택하지 않는 경우
        recursive(arr, idx + 1, score, cal);
    }
}
