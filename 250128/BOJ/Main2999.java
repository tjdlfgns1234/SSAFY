/*
 * 1. R, C 찾기
 * 2. 배치하기
 * 3. 걀과
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2999 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int R = findR(s);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<R; ++i) {
            for (int j=i; j<s.length(); j += R) {
                sb.append(s.charAt(j));
            }
        }

        System.out.println(sb);

    }

    public static int findR(String s) {
        int r = s.length();
        for (int i=(int)Math.floor(Math.sqrt(s.length())); i > 0; --i) {
            if (r % i == 0) {
                return i;
            }
        }

        return 1;
    }
}