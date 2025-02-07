import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * i에게 A[i]만큼 돈을 주면 1달 친구
 * 총 k원 보유
 * 친구의 친구 = 친구
 */
public class Main16562 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 친구관계 수
        int K = Integer.parseInt(st.nextToken()); // 가진 돈

        int[] prices = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<prices.length; ++i) {
            prices[i] = Integer.parseInt(st.nextToken());
        }


        List<List<Integer>> friends = new ArrayList<>();
        for (int i=0; i<=N; ++i) {
            friends.add(new ArrayList<Integer>());
        }

        for (int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        boolean[] v = new boolean[N+1];

        Queue<Integer> q = new ArrayDeque<>();

        //처음 조건을 어떻게??
        List<List<Integer>> list = new ArrayList<>();

        int idx = 0;
        for (int i=1; i<=N; ++i) {
            if (!v[i]) {
                list.add(new ArrayList<Integer>());
                q.offer(i);
                v[i] = true;
                list.get(idx).add(i);
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int f : friends.get(curr)) {
                        if (!v[f]) {
                            q.offer(f);
                            v[f] = true;
                            list.get(idx).add(f);
                        }
                    }
                }
                ++idx;
            }
        }

        int result = 0;
        for (int i=0; i<list.size(); ++i) {
            int min = Integer.MAX_VALUE;
            for (int j=0; j<list.get(i).size(); ++j) {
                int friend = list.get(i).get(j);
                min = Math.min(min, prices[friend]);
            }
            result += min;
        }

        if (result <= K) {
            System.out.println(result);
        }
        else {
            System.out.println("Oh no");
        }
    }

}