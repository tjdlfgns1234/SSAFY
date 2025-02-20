import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17281 {

    static int[][] plays;
    static int N;
    static int max;
    static int hitman;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        plays = new int[N][9];
        max = Integer.MIN_VALUE;
        hitman = 0;

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; ++j) {
                plays[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 8! 경우의 수 구하기
        // 0~8 나열 경우의 수 0은 무조건 4번째에
        int[] sel = new int[9];
        recursive(sel, 0, new boolean[9]);

        System.out.println(max);
    }

    public static void recursive(int[] sel, int depth, boolean[] v) {
        if (depth == 3) {
            sel[3] = 0;
            recursive(sel, depth+1, v);
        }

        if (depth == sel.length) {
            // 점수 구하기
            // 최댓값 비교
            hitman = 0;
            calcScore(sel);
            return;
        }


        for (int i=1; i<sel.length; ++i) {
            if (!v[i]) {
                v[i] = true;
                sel[depth] = i;
                recursive(sel, depth+1, v);
                v[i] = false;
            }
        }
    }

    public static void calcScore(int[] sel) {
        int score = 0;

        for (int i=0; i<N; ++i) {
            int outCount = 0;
            boolean[] base = new boolean[4];
            while (outCount < 3) {
                int hit = plays[i][sel[hitman]];
                if (hit == 0) {
                    ++outCount;
                }
                else if (hit == 4) {
                    for (int j=1; j<4; ++j) {
                        if (base[j]) {
                            ++score;
                            base[j] = false;
                        }
                    }
                    ++score;
                }
                else /*if (hit == 1)*/ {
                    for (int j=3; j>0; --j) {
                        if (base[j]) {
                            if (j > 3 - hit) {
                                ++score;
                            }
                            else {
                                base[j+hit] = true;
                            }
                            base[j] = false;
                        }
                    }
                    base[hit] = true;
                }

                hitman = (hitman+1) % 9;
            }
        }

        max = Math.max(max, score);
    }
}
