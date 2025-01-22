package BAEKJOON.solving.b2941;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BAEKJOON/solving/b2941/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        // nextInt 로 받은 뒤 개행문자를 처리하기 위한 sc.nextLine();
        sc.nextLine();

        // 한 줄을 입력 받은 뒤 스택에 집어넣고, 하나씩 팝하며 검사 (if문으로)
        // 힌트 들은 방법은 버퍼를 사용해 최대 3글자 씩모아놓고, 크로아티아 알파벳임이 확인되면 내보낸다.
        for (int testCase = 1; testCase <= T; testCase++) {
            String line = sc.nextLine();
            char[] cArr = line.toCharArray();
            int countAlphabet = 0;

            Deque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < cArr.length; i++) {
                deque.push(cArr[i]);
            }
            while (!deque.isEmpty()) {
                char nowChar = deque.pop();
                char next = ' ';
                if (nowChar == '=') {
                    if (!deque.isEmpty())
                        next = deque.peek();
                    if (next == 'z') {
                        deque.pop();
                        if (!deque.isEmpty()) {
                            next = deque.peek();
                        }
                        if (next == 'd') {
                            deque.pop();
                            countAlphabet += 1;
                            continue;
                        }
                        countAlphabet += 1;
                        continue;
                    } else if (next == 's' || next == 'c') {
                        deque.pop();
                        countAlphabet += 1;
                        continue;
                    } else {
                        // 여기 들어오면 입력 오류!
                        System.out.println("여기 들어오면 오류 1");
                    }
                } else if (nowChar == '-') {
                    if (!deque.isEmpty())
                        next = deque.peek();
                    if (next == 'c' || next == 'd') {
                        deque.pop();
                        countAlphabet += 1;
                        continue;
                    }
                } else if (nowChar == 'j') {
                    if (!deque.isEmpty())
                        next = deque.peek();
                    if (next == 'l' || next == 'n') {
                        deque.pop();
                        countAlphabet += 1;
                        continue;
                    }
                }
                countAlphabet += 1;
            }
            System.out.println(countAlphabet);
        }

        sc.close();
    }
}
