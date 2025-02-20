import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String args[]) throws Exception {

        // System.setIn(new FileInputStream("./noj.am/swea/solving/7272/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            String sentence = br.readLine();
            String[] words = sentence.split(" ");

            // 길이가 다르면 비교안함
            if (words[0].length() != words[1].length()) {
                System.out.println("#" + testCase + " DIFF");
            } else if (words[0].length() == words[1].length()) {
                boolean isSame = true;
                int wordLength = words[0].length();
                for (int i = 0; i < wordLength; i++) {
                    char char1 = words[0].charAt(i);
                    char char2 = words[1].charAt(i);

                    if (!sameGroup(char1, char2)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    System.out.println("#" + testCase + " SAME");
                } else {
                    System.out.println("#" + testCase + " DIFF");
                }
            } else {
                // 여기서는 아무 작업도 하지 않습니다.
            }

        }

        br.close();

    }

    private static boolean sameGroup(char char1, char char2) {
        // jdk 8버전이하의 경우 Set.of() 사용불가
        // Set<Character> charset1 = Set.of('B');
        // Set<Character> charset2 = Set.of('A', 'D', 'O', 'P', 'Q', 'R');
        // Set<Character> charset3 = Set.of('C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        // 'M', 'N', 'S', 'T', 'U', 'V', 'W',
        // 'X', 'Y', 'Z');

        Set<Character> charset1 = new HashSet<>(Arrays.asList('B'));
        Set<Character> charset2 = new HashSet<>(Arrays.asList('A', 'D', 'O', 'P', 'Q', 'R'));
        Set<Character> charset3 = new HashSet<>(
                Arrays.asList('C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
                        'Z'));

        if ((charset1.contains(char1) && charset1.contains(char2)) ||
                (charset2.contains(char1) && charset2.contains(char2)) ||
                (charset3.contains(char1) && charset3.contains(char2))) {
            return true;
        } else {
            return false;
        }
    }
}
