package swea.swea14510;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int treeCount = Integer.parseInt(br.readLine());
            int maxHeight = 0;
            String[] line = br.readLine().trim().split(" ");
            int[] treeHeight = new int[line.length];
            for (int i = 0; i < treeCount; i++) {
                treeHeight[i] = Integer.parseInt(line[i]);

                // 최대 높이 구하기
                maxHeight = Math.max(maxHeight, treeHeight[i]);
            }

            // 키울 높이
            // 3을 사이클로 해서 사이클 이후 나머지가 0인지 1인지 2인지?
            int dayCount = 0;
            int[] diff = new int[treeCount];
            int oneCount = 0;
            int twoCount = 0;

            for (int i = 0; i < treeCount; i++) {
                diff[i] = maxHeight - treeHeight[i];

                // 무조건 1일로 키워야 되는 경우
                oneCount += diff[i] % 2;
                // 2일로 키우면 효율이 좋은 경우
                twoCount += diff[i] / 2;
            }

            // 무조건 키워야 되는 경우의 수만큼은 2일 3크기 사이클을 돈다.
            int min = Math.min(oneCount, twoCount);
            dayCount += min * 2;

            oneCount -= min;
            twoCount -= min;

            // 무조건 키워야 되는 경우의 수만큼 키웠음에도 1키움이 더 많은 경우
            if (oneCount > 0) {
                dayCount += oneCount * 2 - 1;
            } else if (twoCount > 0) {
                dayCount += (twoCount / 3) * 4;
                twoCount = twoCount % 3;
                if (twoCount == 2)
                    dayCount += 3;
                else if (twoCount == 1)
                    dayCount += 2;
                else if (twoCount == 0) {
                    // do nothing in here
                }
            }

            System.out.println("#" + tc + " " + dayCount);
        }
    }
}

/*
 * 처음 diff 를 계산할 때 / 3 연산을 해주어 1+2 사이클만큼 먼저 계산하고 나머지를 계산하려 했으나,
 * 이 경우 6 2 2 처럼 값이 들어 온다면 처음에 2일로 키우는 것이 더 효율적인 경우를 계산하지 못해 최고의 해가 나오지 않는다.
 * 그러므로 무조건 1일로 키워야 되는 경우의 수를 기록하고
 * 나머지는 2일로 키우는 것이 더욱 효율적이므로 2일로 기록한다.
 * 그 후 1일로 키워야 되는 경우의 수만큼 2일의 경우의 수도 빼주고
 * 2일로 키워야 되는 경우의 나머지를 계산한다.
 * 만약 1일로 키워야 되는 경우의 수가 더 많다면, 2일은 쉬고 1일만 해줘야 한다.
 */