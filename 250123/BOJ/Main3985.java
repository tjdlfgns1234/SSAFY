import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3985 {
    /**
     * 길이 L미터의 롤 케이크 -> 1~L까지의 조각
     * N명에게 나누어줌 -> P번 ~ K번까지 원함 -> 중복이면 못먹음
     * 첫째 줄에는 가장 K-P가 가장 큰 번호 / 둘째 줄에는 실제로 가장 긴 조각 먹는 번호 -> 겹치면 더 작은 번호
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] cake = new int[L];
        int first = -1;
        int firstMax = Integer.MIN_VALUE;
        int second = -1;
        int secondMax = Integer.MIN_VALUE;

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int curr = r-l;
            if (firstMax < curr) {
                firstMax = curr;
                first = i+1;
            }

            int count = 0;

            for (int j=l-1; j<r; ++j) {
                if (cake[j] == 0) {
                    ++count;
                    cake[j] = 1;
                }
            }

            if (secondMax < count) {
                secondMax = count;
                second = i+1;
            }
        }

        System.out.println(first);
        System.out.println(second);

    }

}
