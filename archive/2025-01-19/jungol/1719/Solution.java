import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./noj.am/jungol/solving/1719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            String[] input = br.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
            if (N <= 0 || N > 100 || (!isOdd(N)) || M <= 0 || M > 4) {
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
                case 4:
                    triangle4(N);
                    break;

                default:
                    break;
            }
        }
    }

    public static void triangle1(int N) {
        for (int i = 0; i < N; i++) {
            if (i <= N / 2) {
                for (int j = 0; j <= i; j++) {
                    System.out.print('*');
                }
            } else {
                for (int j = N - i; j > 0; j--) {
                    System.out.print('*');
                }

            }
            System.out.println();
        }
    }

    public static void triangle2(int N) {
        for (int i = 0; i < N; i++) {
            if (i <= N / 2) {
                for (int j = N / 2 - i; j > 0; j--) {
                    System.out.print(' ');
                }
                for (int j = 0; j <= i; j++) {
                    System.out.print('*');
                }
            } else {
                for (int j = N / 2; j < i; j++) {
                    System.out.print(' ');
                }
                for (int j = N - i; j > 0; j--) {
                    System.out.print('*');
                }

            }
            System.out.println();
        }

    }

    public static void triangle3(int N) {
        for (int i = 0; i < N; i++) {
            if (i <= N / 2) {
                for (int j = 0; j < i; j++) {
                    System.out.print(' ');

                }
                for (int j = 0; j < N - i * 2; j++) {
                    System.out.print('*');
                }
            } else {
                for (int j = N - i - 1; j > 0; j--) {
                    System.out.print(' ');
                }
                for (int j = 0; j < ((i - N / 2) * 2) + 1; j++) {
                    System.out.print('*');
                }
            }
            System.out.println();
        }
    }

    public static void triangle4(int N) {
        for (int i = 0; i < N; i++) {
            if (i <= N / 2) {
                for (int j = 0; j < i; j++) {
                    System.out.print(' ');

                }
                for (int j = i; j <= N / 2; j++) {
                    System.out.print('*');
                }
            } else {
                for (int j = 0; j < N / 2; j++) {
                    System.out.print(' ');
                }
                for (int j = N / 2; j <= i; j++) {
                    System.out.print('*');
                }
            }
            System.out.println();

        }

    }

    public static boolean isOdd(int N) {
        return N % 2 == 1 ? true : false;
    }

}
