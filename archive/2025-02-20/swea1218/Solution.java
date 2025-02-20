package swea.swea1218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    static final int T = 10;

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int res = check(sb, br);
            valid(sb, tc, res);
        }
        System.out.print(sb.toString());
    }

    private static int check(StringBuilder sb, BufferedReader br) throws Exception {
        int N = Integer.parseInt(br.readLine().trim());
        String line = br.readLine().trim();
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            char now = line.charAt(i);
            if (isOpen(now)) {
                dq.push(now);
            } else if (isClose(now)) {
                if (!isMatch(dq.pop(), now)) {
                    return 0;
                }
            }
        }
        // 중간에 잘못됨을 검출하지 못한경우
        if (dq.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private static void valid(StringBuilder sb, int tc, int res) {
        sb.append("#" + tc + " " + res + "\n");
    }

    private static boolean isOpen(char c) {
        return (c == '<' || c == '(' || c == '[' || c == '{');
    }

    private static boolean isClose(char c) {
        return (c == '>' || c == ')' || c == ']' || c == '}');
    }

    private static boolean isMatch(char open, char close) {
        return (open == '<' && close == '>') ||
                (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
