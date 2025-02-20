package solving.baekjoon1935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * baekjoon 1935
 * 후위 계산식 2
 * 입력을 받아 스택에 저장 후 연산자를 만나면 두 피연산자를 꺼내와 연산 후 다시 스택에 저장
 * 모든 연산이 끝난 후 스택에 남은 나머지 하나의 숫자를 출력
 * 주의 할 점은 - / 의 경우에는 교환법칙이 성립하지 않으므로
 * 스택에서 꺼낸 피연산자의 순서를 잘 생각하자
 */

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int numCount = Integer.parseInt(br.readLine().trim());
            String formula = br.readLine().trim();
            double[] num = new double[numCount];
            for (int i = 0; i < numCount; i++) {
                num[i] = Integer.parseInt(br.readLine().trim()) * 1.0;
            }
            Deque<Double> deque = new ArrayDeque<>();
            for (int i = 0; i < formula.length(); i++) {
                char nowChar = formula.charAt(i);
                if (nowChar >= 'A' && nowChar <= 'Z') {
                    deque.push(num[nowChar - 'A'] * 1.0);
                } else {
                    double num2, num1, res;
                    switch (nowChar) {
                        case '+':
                            num2 = deque.pop();
                            num1 = deque.pop();
                            res = num1 + num2;
                            deque.push(res);
                            break;
                        case '-':
                            num2 = deque.pop();
                            num1 = deque.pop();
                            res = num1 - num2;
                            deque.push(res);
                            break;
                        case '*':
                            num2 = deque.pop();
                            num1 = deque.pop();
                            res = num1 * num2;
                            deque.push(res);
                            break;
                        case '/':
                            num2 = deque.pop();
                            num1 = deque.pop();
                            res = num1 / num2;
                            deque.push(res);
                            break;
                        default:
                            break;
                    }
                }
            }
            System.out.printf("%.2f\n", deque.pop());
        }
    }
}
