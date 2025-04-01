import java.io.*;
import java.util.*;
 
public class Solution {
    static int win = 0,lose = 0;
    static int[] arr = new int[9]; // 점수 배열
    static int[] arr2 = new int[9]; // 점수 배열
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int testcase = 1 ; testcase <= T ; testcase++) {
            st =new StringTokenizer(br.readLine());
            for(int i = 0; i < 9;i++) 
                arr[i] = Integer.parseInt(st.nextToken());
         
            int s = 0;
            for(int i = 1; i <= 18;i++) {
                boolean f = false;
                for(int j = 0; j < 9;j++)
                    if(arr[j] == i) {
                        f = true;
                        break;
                    }
                if(!f)
                    arr2[s++] = i;
            }
             
            win = 0;
            lose = 0;
            solve();
             
            sb.append("#" + testcase + " " + win + " " + lose + "\n");
        }
        System.out.print(sb.toString());
    }
     
    public static void solve() {
        // 1 ~ 18까지의 수가 적힌 18장의 카드
        // 총점이 같으면 무승부
        // 아홉 라운드를 끝내고 총점을 따졌을때, 총점이 더 높은 사람이 이게임의 승자
        // 두 카드에 적힌 수의 합만큼 점수을 얻음
        // 9! 돌리는 순열 문제
        dfs(new boolean[9],new int[9], 0, 0, 0);
         
    }
     
    public static void dfs(boolean [] vit,int[] sel, int idx, int sumA, int sumB) {
        if(idx == 9) {

            if(sumA < sumB) 
                win++;
            else if(sumA== sumB)
                return;
            else
                lose++;
            return;
        }
         
        if(idx >  sel.length)
            return;
         
        for(int i = 0; i < sel.length;i++) 
            if(!vit[i]) {
                sel[idx] = i;
                vit[i] = true;
	      	if(arr[idx] < arr2[sel[idx]])
                    dfs(vit,sel,idx+1, sumA+arr[idx] + arr2[sel[idx]], sumB);
                else if(arr[idx] > arr2[sel[idx]])
                    dfs(vit,sel,idx+1, sumA, sumB + arr[idx] + arr2[sel[idx]]);
                vit[i] = false;
                sel[idx] = 0;
            }
    }
}