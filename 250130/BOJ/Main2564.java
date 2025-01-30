import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2564 {
    static int width;
    static int height;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        
        int N = Integer.parseInt(br.readLine());
        int[] points = new int[N+1]; // 펼치면 어차피 직선 (북 서 남 동) 순이고 입력은 북1 남2 서3 동4, 남북은 왼쪽으로부터 거리, 동서는 위로부터의 거리
        // 북은 width - 거리 / 동은 height - 거리

        for (int i=0; i<points.length; ++i) {
            st = new StringTokenizer(br.readLine());
            int direct = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            points[i] = findPoint(direct, distance);
        }

        int result = 0;

        for (int i=0; i<N; ++i) {
            result += findMinDistance(points[i], points[N]);
        }

        System.out.println(result);

    }

    public static int findPoint(int direct, int distance) {
        int point = 0;
        if (direct == 1) { //북
            point = width - distance;
        }
        else if (direct == 2) { //남
            point = width + height + distance;
        }
        else if (direct == 3) { //서
            point = width + distance;
        }
        else { //동
            point = width*2 + height + (height - distance);
        }

        return point;
    }

    public static int findMinDistance(int store, int me) {
        int distance = 0;
        int length = height*2 + width*2;
        if (me > store) {
            distance = Math.min(me - store, length-me + store);
        }
        else {
            distance = Math.min(store - me, length-store + me);
        }

        return distance;
    }
}
