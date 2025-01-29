package solving.baekjoon2164;

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();
        int N = sc.nextInt(); // 카드숫자

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        while (deque.size() > 1) {
            // 버림
            deque.poll();
            // 제일 앞의 것을 빼어 뒤로 놓는다.
            deque.add(deque.poll());
        }
        System.out.println(deque.poll());
        sc.close();
    }
}
