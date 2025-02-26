package solving.baekjoon16943;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * 두 정수 A와 B가 주어질 때 A에 포함된 숫자의 순서를 섞어 C를 만든다
 * C중에서 B보다 작으면서 가장 큰 값을 구하자
 * C는 0으로 시작할 수 없다
 */

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = toNum(br.readLine().trim());
        // T = 1;

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");

            // 자릿 수 차이를 먼저 비교한다.
            // 0번째가 더 큰 자릿수의 경우 무조건 타겟 보다 크다.
            if (line[0].length() > line[1].length()) {
                bw.write(-1 + "");
                bw.newLine();
                continue;
            }

            char[] cArr = line[0].toCharArray();

            // 0번째의 자릿수가 더 작은 경우, 소트 결과를 reverse 한 것이
            // 가장 타겟과 가까운 수이다.
            if (line[0].length() < line[1].length()) {
                bw.write(sortAndReverse(cArr));
                bw.newLine();
                continue;
            }

            Arrays.sort(cArr);
            int target = toNum(line[1]);

            // 시작을 0으로 할 수 없다.
            while (cArr[0] == '0') {
                cArr = nextPermutaion(cArr);
            }

            // 가장 작은 A가 B보다 크다면 -1 을 출력
            int prev = toNum(cArr);
            if (prev >= target) {
                bw.write(-1 + "");
                bw.newLine();
                continue;
            }

            int temp = prev;
            while (temp <= target || temp == -1) {
                prev = temp;
                cArr = nextPermutaion(cArr);
                temp = toNum(cArr);

                // 다음 순열이 나오지 않고 동일 순열이 반복되면
                if (prev == temp)
                    break;
            }
            bw.write("" + prev);
            bw.newLine();
        }
        bw.flush();
    }

    private static String sortAndReverse(char[] cArr) {
        Arrays.sort(cArr);
        return (new StringBuilder(String.valueOf(cArr)).reverse().toString());
    }

    private static char[] nextPermutaion(char[] cArr) {
        // 피봇 찾기 (오름차순으로 정렬한 뒤 뒤에서부터 탐색하며 값이 줄어드는 경우가 피봇)
        // 다시 뒤에서 찾으며 피봇보다 큰 수가 나오면 스왑 (이때문에 무조건 스왑할 경우가 존재한다. 감소했기 때문)
        // 이 후 피봇 뒷부분을 reverse 한다
        int pivot = -1;
        int lastIdx = cArr.length - 1;
        for (int i = 1; i < cArr.length; i++) {
            // find pivot
            if (cArr[lastIdx - i] < cArr[lastIdx - i + 1]) {
                pivot = lastIdx - i;
                break;
            }
        }
        if (pivot == -1) {
            // if pivot is not found(already desc) return input arr
            return cArr;
        }
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[lastIdx - i] > cArr[pivot]) {
                // swap
                char temp = cArr[lastIdx - i];
                cArr[lastIdx - i] = cArr[pivot];
                cArr[pivot] = temp;
                break;
            }
        }

        // reverse
        Arrays.sort(cArr, pivot + 1, cArr.length);

        return cArr;
    }

    private static int toNum(char[] cArr) {
        return Integer.parseInt(String.valueOf(cArr));
    }

    private static int toNum(String trim) {
        return Integer.parseInt(trim);
    }
}
