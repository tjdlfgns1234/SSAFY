import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Improve {
    public static void main(String args[]) throws Exception {
        // Input file redirection
        System.setIn(new FileInputStream("./noj.am/jungol/solving/1719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim()); // Number of test cases

        for (int testCase = 1; testCase <= T; testCase++) {
            String[] input = br.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            // Input validation
            if (!isValidInput(N, M)) {
                System.out.println("INPUT ERROR!");
                return;
            }

            // Execute the corresponding triangle method
            switch (M) {
                case 1:
                    drawTriangleType1(N);
                    break;
                case 2:
                    drawTriangleType2(N);
                    break;
                case 3:
                    drawTriangleType3(N);
                    break;
                case 4:
                    drawTriangleType4(N);
                    break;

                default:
                    break;
            }
        }
    }

    // Input validation method
    private static boolean isValidInput(int N, int M) {
        return (N > 0 && N <= 100 && isOdd(N) && M > 0 && M <= 4);
    }

    // Check if a number is odd
    private static boolean isOdd(int N) {
        return N % 2 == 1;
    }

    // Draw Type 1 Triangle
    private static void drawTriangleType1(int N) {
        for (int i = 0; i < N; i++) {
            int starCount = (i <= N / 2) ? i + 1 : N - i;
            printLine('*', starCount);
        }
    }

    // Draw Type 2 Triangle
    private static void drawTriangleType2(int N) {
        for (int i = 0; i < N; i++) {
            if (i <= N / 2) {
                printLine(' ', N / 2 - i);
                printLine('*', i + 1);
            } else {
                printLine(' ', i - N / 2);
                printLine('*', N - i);
            }
        }
    }

    // Draw Type 3 Triangle
    private static void drawTriangleType3(int N) {
        for (int i = 0; i < N; i++) {
            if (i <= N / 2) {
                printLine(' ', i);
                printLine('*', N - 2 * i);
            } else {
                printLine(' ', N - i - 1);
                printLine('*', 2 * (i - N / 2) + 1);
            }
        }
    }

    // Draw Type 4 Triangle
    private static void drawTriangleType4(int N) {
        for (int i = 0; i < N; i++) {
            if (i <= N / 2) {
                printLine(' ', i);
                printLine('*', N / 2 - i + 1);
            } else {
                printLine(' ', N / 2);
                printLine('*', i - N / 2 + 1);
            }
        }
    }

    // Utility method to print characters in a line
    private static void printLine(char ch, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
