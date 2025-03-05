import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 암호문3_1230 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t=1; t<=10; ++t) {

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<String> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String ctrl = st.nextToken();
                if (ctrl.equals("I")) { // 삽입
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < y; ++i) {
                        list.add((x+i), st.nextToken());
                    }
                } else if (ctrl.equals("D")) { // 삭제
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < y; ++i) {
                        list.remove(x);
                    }
                } else if (ctrl.equals("A")) {
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < y; ++i) {
                        list.add(st.nextToken());
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            for (int i=0; i<10; ++i) {
                sb.append(list.get(i)).append(" ");
            }
            System.out.println(sb);
        }
    }
}
