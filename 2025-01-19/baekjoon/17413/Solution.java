import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("noj.am/BAEKJOON/solving/17413/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            String line = br.readLine().trim();
            Deque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < line.length(); i++) {
                Character thisChar = line.charAt(i);
                if (thisChar == ' ') {
                    while (!deque.isEmpty()) {
                        System.out.print(deque.pop());
                    }
                    System.out.print(thisChar);
                } else if (thisChar == '<') {
                    while (!deque.isEmpty()) {
                        System.out.print(deque.pop());
                    }
                    while (thisChar != '>') {
                        System.out.print(thisChar);
                        i++;
                        thisChar = line.charAt(i);
                    }
                    System.out.print(thisChar);
                } else {
                    deque.push(thisChar);
                }
            }
            while (!deque.isEmpty()) {
                System.out.print(deque.pop());
            }
            System.out.println();

        }
    }
}