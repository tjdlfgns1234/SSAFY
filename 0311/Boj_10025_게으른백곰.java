import java.util.*;
import java.io.*;

public class Boj_10025_게으른백곰 {
    public static void main(String[] args) throws Exception {
        //슬라이딩 윈도우?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  //양동이 수
        int K = Integer.parseInt(st.nextToken());

        int[] ice = new int[4000001]; //얼음 수   k는 2000000까지임!!!
        int max_x = 0;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ice[x] = w;
            max_x = Math.max(max_x, x);
        }

//        System.out.println(Arrays.toString(Arrays.copyOf(ice,max_x+1)));
//        System.out.println(max_x);

        int window = 0;
        for (int i = 0; i <= 2 * K; i++) {
            window += ice[i];
        }

        int end = 2 * K;
        int start = 0;
//        System.out.printf("%d %d\n", end, temp);
        int temp = window;
        while (end <= max_x) {
            temp = temp + ice[++end] - ice[start++];
//            System.out.printf("%d %d\n", end, temp);
            window = Math.max(window, temp);
        }

        System.out.println(window);
    }
}
