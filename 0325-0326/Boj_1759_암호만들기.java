import java.util.*;
import java.io.*;

public class Boj_1759_암호만들기 {
    static int L,C;
    static char[] alpha;
    static Set<Character> vow = Set.of('a', 'e', 'i', 'o', 'u');
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());  //알파벳 소문자
        C = Integer.parseInt(st.nextToken());  //암호 문자 종류
        //가능성 있는 암호 모두

        //최소 한 개 모음, 최소 두 개 자음

        alpha = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        //암호는 무조건 사전 순
        dfs(0,0,0, new StringBuilder());
    }

    public static void dfs(int idx, int depth, int mo, StringBuilder sel) {
        if (depth == L) {
            //다 뽑음
            if (mo >= 1 && L - mo >= 2) {
                System.out.println(new String(sel));
            }
            return;
        }

        if (idx == C) return;

        //뽑기
        sel.append(alpha[idx]);
        if (vow.contains(alpha[idx])) {
            dfs(idx+1, depth+1,mo+1,sel);
        }
        else {
            dfs(idx+1,depth+1,mo,sel);
        }

        //백트래킹
        sel.deleteCharAt(sel.length() - 1);

        //안뽑기
        dfs(idx+1,depth,mo,sel);
    }

}
