import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int exceptCount = 0;
        String[] strings = br.readLine().split(" ");
        StringBuilder resultSb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();

        for (String s : strings) {
            for (int i=0; i<s.length(); ++i) {
                char curr = s.charAt(i);

                if (curr == '<') {
                    ++exceptCount;
                    while (!deque.isEmpty()) {
                        resultSb.append(deque.pollLast());
                    }
                    deque.add(curr);
                }
                else if (curr == '>') {
                    ++exceptCount;
                    deque.add(curr);
                    while (!deque.isEmpty()) {
                        resultSb.append(deque.pollFirst());
                    }
                }
                else {
                    deque.add(curr);
                }
            }
            if (exceptCount % 2 == 0) {
                while (!deque.isEmpty()) {
                    resultSb.append(deque.pollLast());
                }
            }
            else {
                while (!deque.isEmpty()) {
                    resultSb.append(deque.pollFirst());
                }
            }
            resultSb.append(" ");
        }

        System.out.println(resultSb);

    }
}
