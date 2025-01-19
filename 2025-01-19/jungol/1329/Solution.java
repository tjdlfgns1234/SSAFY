import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) throws Exception {
        // Input file redirection
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim()); // Number of test cases

        // Input validation
        if (!isValidInput(N)) {
            System.out.println("INPUT ERROR!");
            return;
        }
        drawTriangle(N);
    }

    // Input validation method
    private static boolean isValidInput(int N) {
        return (N > 0 && N <= 100 && isOdd(N));
    }

    // Check if a number is odd
    private static boolean isOdd(int N) {
        return N % 2 == 1;
    }

    // Draw Type 1 Triangle
    private static void drawTriangle(int N) {
        for (int i = 0; i < N; i++) {
            if (i < N / 2) {
                printLine(' ', i);
                printLine('*', (1 + i * 2));
            } else {
                printLine(' ', N - 1 - i);
                printLine('*', N - (i - (N / 2)) * 2);
            }
            System.out.println();
        }
    }

    // Utility method to print characters in a line
    private static void printLine(char ch, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(ch);
        }
    }
}