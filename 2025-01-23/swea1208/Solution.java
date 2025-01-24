package solving.swea1208;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("solving/swea1208/input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = 10;
        final int BOX_NUM = 100;
        for (int testCase = 1; testCase <= T; testCase++) {
            int dumpCountLimit = sc.nextInt();
            int[] boxes = new int[BOX_NUM];
            for (int i = 0; i < BOX_NUM; i++) {
                boxes[i] = sc.nextInt();
            }
            Arrays.sort(boxes);
            for (int i = 0; i < dumpCountLimit; i++) {
                if ((boxes[99] - boxes[0]) <= 1)
                    break;
                boxes[0] += 1;
                boxes[99] -= 1;
                Arrays.sort(boxes);
            }
            int maxBoxDiff = boxes[99] - boxes[0];
            System.out.printf("#%d %d\n", testCase, maxBoxDiff);
        }

        sc.close();
    }
}
