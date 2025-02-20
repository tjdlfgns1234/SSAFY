package solving.swea1289;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 인풋 들어오는대로 0으로 시작해서 값이 바뀔때 마다 + 1;
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            String line = sc.next();
            char start = '0';
            int countChange = 0;
            for (int i = 0; i < line.length(); i++) {
                char nowChar = line.charAt(i);
                if (start != nowChar) {
                    countChange += 1;
                    start = nowChar;
                }
            }
            System.out.printf("#%d %d\n", testCase, countChange);
        }
        sc.close();
    }
}
