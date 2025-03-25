import java.util.*;
import java.io.*;

public class Boj_1759_암호만들기 {
    static int L,C;
    static StringBuilder alpha;
    static String vow =  "aeiou";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());  //알파벳 소문자
        C = Integer.parseInt(st.nextToken());  //암호 문자 종류
        //가능성 있는 암호 모두

        //최소 한 개 모음, 최소 두 개 자음

        alpha = new StringBuilder();
        char[] temp = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            temp[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(temp);
        alpha.append(temp);

        //암호는 무조건 사전 순
        dfs(0,new char[L], 0,0);
    }

    public static void dfs(int idx, char[] sel, int depth, int mo) {
        if (depth == L) {
            //다 뽑음
            if (mo >= 1 && L - mo >= 2) {
                System.out.println(new String(sel));
            }
            return;
        }

        if (idx == C) return;

        sel[depth] = alpha.charAt(idx);
        if (vow.contains(String.valueOf(alpha.charAt(idx)))){
            mo++;
            dfs(idx+1, sel,depth+1,mo);
            dfs(idx+1,sel,depth,--mo);

        }
        else {
            dfs(idx+1, sel,depth+1,mo);
            dfs(idx+1,sel,depth,mo);
        }

    }

}
