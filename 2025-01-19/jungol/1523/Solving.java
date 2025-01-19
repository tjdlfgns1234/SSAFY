import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solving {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./noj.am/jungol/solving/1523/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            String[] input = br.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
            if (N <= 0 || N > 100 || M <= 0 || M > 3) {
                System.out.println("INPUT ERROR!");
                return;
            }
            switch (M) {
                case 1:
                    triangle1(N);
                    break;
                case 2:
                    triangle2(N);
                    break;
                case 3:
                    triangle3(N);
                    break;

                default:
                    break;
            }
        }
    }

    public static void triangle1(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void triangle2(int N) {
        for (int i = N; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

    }

    public static void triangle3(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - (i + 1); j++) {
                System.out.print(' ');
            }

            for (int j = 0; j < 1 + (i * 2); j++) {
                System.out.print('*');
            }
            System.out.println();
        }

    }

}
