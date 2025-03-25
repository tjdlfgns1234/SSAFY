import java.util.*;
import java.io.*;

public class Boj_25947_선물할인 {
    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int budget = Integer.parseInt(st.nextToken());
            int discount = Integer.parseInt(st.nextToken());

            int[] cost = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(cost);

            //최대로 많은 선물 사야됨
            //일단 할인 기회 쓰면서 사다가, 할인 기회 다쓰면 젤 싼거부터 할인 취소 가능한지 판단
            int start = 0;  //처음으로 할인 쓴 인덱스
            int end = 0;
            int curr = 0;

            while(end < N) {
                if (discount >= 1) {
                    //할인 가능
                    if (curr + cost[end] / 2 <= budget) {
                        curr += cost[end++] / 2;
                        discount--;
                    }
                    else {
                        break;  //아 대박 이거 안해서 틀림 ㅜ
                    }
                }

                //할인불가능
                else {
                    //할인 받아도 못 삼
                    if (curr + cost[end] / 2 > budget) break;
                    //기존 할인 취소하기
                    if (curr + cost[start] / 2 + cost[end] / 2 <= budget) {
                        //할인취소가능
                        curr += cost[start++]/2; //다시 반값 더하기
                        curr += cost[end++] / 2;
                    }
                    else {
                        break;
                    }
                }
            }

        System.out.println(end);

    }
}
