import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("noj.am/BAEKJOON/solving/1592/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            String[] line = br.readLine().trim().split(" ");
            int N = Integer.parseInt(line[0]), M = Integer.parseInt(line[1]), L = Integer.parseInt(line[2]);
            int totalThrowCount = throwCount(N, M, L);
            System.out.println(totalThrowCount);
        }
    }

    private static int throwCount(int N, int M, int L) {
        int[] reciveCount = new int[N];
        reciveCount[0] = 1;
        int totalThrowCount = 0;
        int ballHolder = 0;
        int diff = L % N;
        while (true) {
            // 탈출조건
            for (int i = 0; i < N; i++) {
                if (reciveCount[i] >= M) {
                    return totalThrowCount;
                }
            }
            if (isOdd(reciveCount[ballHolder])) {
                // throw clockwise
                int nextReciver = ballHolder + diff;
                if (nextReciver >= N) {
                    nextReciver = nextReciver - N;
                    reciveCount[nextReciver] += 1;
                    totalThrowCount += 1;
                    ballHolder = nextReciver;
                } else if (nextReciver < N) {
                    reciveCount[nextReciver] += 1;
                    totalThrowCount += 1;
                    ballHolder = nextReciver;
                } else {
                    // do nothing
                }
            } else if (!isOdd(reciveCount[ballHolder])) {
                // throw counterclockwise
                int nextReciver = ballHolder - diff;
                if (nextReciver < 0) {
                    nextReciver = nextReciver + N;
                    reciveCount[nextReciver] += 1;
                    totalThrowCount += 1;
                    ballHolder = nextReciver;
                } else if (nextReciver >= 0) {
                    reciveCount[nextReciver] += 1;
                    totalThrowCount += 1;
                    ballHolder = nextReciver;
                } else {
                    // do nothing
                }
            } else {
                // Do Nothing
            }
        }
    }

    public static boolean isOdd(int num) {
        return (num % 2 == 1) ? true : false;
    }
}
