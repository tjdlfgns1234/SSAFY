import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./swea/solving/1234/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            String line = br.readLine().trim();
            String[] lineSplit = line.split(" ");
            int N = Integer.parseInt(lineSplit[0]);
            String numArr = lineSplit[1];

            Stack<Character> stackChar = new Stack<>();
            for (int i = 0; i < N; i++) {
                char singleChar = numArr.charAt(i);
                if (stackChar.empty()) {
                    stackChar.push(singleChar);
                    continue;
                }

                if (stackChar.peek() == singleChar) {
                    stackChar.pop();
                } else if (stackChar.peek() != singleChar) {
                    stackChar.push(singleChar);
                } else {
                    // 여기는 아무 동작도 하지 않습니다.
                }
            }
            System.out.print("#" + testCase + " ");
            stackChar.forEach(chr -> System.out.print(chr));
            System.out.println();
        }
    }
}
