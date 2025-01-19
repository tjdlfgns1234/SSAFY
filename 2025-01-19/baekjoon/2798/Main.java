import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        for (int testCase = 1; testCase <= T; testCase++) {
            String[] line = br.readLine().trim().split(" ");
            int N = Integer.parseInt(line[0]), M = Integer.parseInt(line[1]);
            line = br.readLine().trim().split(" ");
            int[] cards = new int[N];
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(line[i]);
            }
            Arrays.sort(cards);
            System.out.println(bestCardsSet(N, M, cards));
        }
    }

    private static int bestCardsSet(int N, int M, int[] cards) {
        int best = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum > best && sum <= M) {
                        best = sum;
                    }
                }
            }
        }
        return best;
    }
}
