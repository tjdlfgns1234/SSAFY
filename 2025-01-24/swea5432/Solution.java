package solving.swea5432;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        URL input = Solution.class.getResource("input.txt");
        System.setIn(new FileInputStream(input.getPath()));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            String line = sc.next();
            int barCount = 0;
            int barCutCount = 0;
            for (int i = 0; i < line.length(); i++) {
                char nowChar = line.charAt(i);
                if (nowChar == '(') {
                    if (line.charAt(i + 1) == ')') {
                        barCutCount += barCount;
                        i += 1;
                        continue;
                    }
                    barCount += 1;
                    barCutCount += 1;
                } else if (nowChar == ')') {
                    barCount -= 1;
                }
            }
            System.out.printf("#%d %d\n", testCase, barCutCount);
        }
        sc.close();
    }
}
