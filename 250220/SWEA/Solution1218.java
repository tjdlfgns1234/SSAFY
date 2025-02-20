import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1218 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t=1; t<=10; ++t) {

            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();

            int idx = 0;
            Deque<String> stack = new ArrayDeque<>();

            String open = "{[(<";
            String close = "}])>";



            int result = 1;

            while (idx < s.length()) {
                String curr = String.valueOf(s.charAt(idx));

                if (open.contains(curr)) {
                    stack.push(curr);
                }
                else {
                    String string;
                    switch (curr) {
                        case "}":
                            string = "{";
                            break;
                        case "]":
                            string = "[";
                            break;
                        case ")":
                            string = "(";
                            break;
                        default:
                            string = "<";
                            break;
                    }

                    String pop = stack.pop();
                    if (!pop.equals(string)) {
                        result = 0;
                        break;
                    }
                }
                ++idx;
            }

            if (!stack.isEmpty()) {
                result = 0;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(result);
            System.out.println(sb);
        }
    }

}