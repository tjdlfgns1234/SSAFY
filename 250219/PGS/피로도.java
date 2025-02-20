public class 피로도 {
    int max, N;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        max = Integer.MIN_VALUE;
        N = dungeons.length;

        recursive(0, new boolean[N], k, dungeons);

        answer = max;
        return answer;
    }

    public void recursive(int depth, boolean[] v, int k, int[][] dungeons) {
        for (int i=0; i<N; ++i) {
            if (!v[i]) {
                v[i] = true;
                if (k >= dungeons[i][0]) {
                    recursive(depth+1, v, k-dungeons[i][1], dungeons);
                }
                v[i] = false;
            }
        }

        max = Math.max(max, depth);

    }
}
