import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main16943 {

    static int A, B, result;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        result = -1;
        list = new ArrayList<>();

        while (A > 0) {
            list.add(A % 10);
            A /= 10;
        }

        Collections.sort(list, Collections.reverseOrder());
        recursive(new StringBuilder(), new boolean[list.size()]);


        System.out.println(result);
    }

    public static void recursive(StringBuilder sb, boolean[] v) {
        if (result != -1) return;

        if (sb.length() == list.size()) {
            if (Integer.parseInt(sb.toString()) < B) {
                result = Integer.parseInt(sb.toString());
            }
            return;
        }

        for (int i=0; i<list.size(); ++i) {
            if (!v[i]) {
                if (sb.length() == 0 && list.get(i) == 0) {
                    continue;
                }

                v[i] = true;
                sb.append(list.get(i));
                recursive(sb, v);
                sb.deleteCharAt(sb.length()-1);
                v[i] = false;
            }
        }
    }

}
