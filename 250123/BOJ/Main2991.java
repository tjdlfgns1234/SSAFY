import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2991 {
    /**
     * 백준 2991 - 사나운 개
     * A분동안 공격적 B분동안  조용 / C분동안 공격적 D분동안 조용
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i=0; i<3; ++i) {
            int time = Integer.parseInt(st.nextToken());
            arr[i] = check(A, B, C, D, time);
        }

        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static int check(int A, int B, int C, int D, int time) {
        int count = 0;
        int l = A;
        while (time > l-A) {
            if (l-A < time && time <= l) {
                ++count;
                break;
            }

            l += A+B;
        }

        l = C;

        while (time >= l-C) {
            if (l-C < time && time <= l) {
                ++count;
                break;
            }

            l += C+D;
        }

        return count;
    }

}
