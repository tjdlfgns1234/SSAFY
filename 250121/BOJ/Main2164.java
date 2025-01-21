import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


//카드2
public class Main2164 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new LinkedList<>();

        for (int i=1; i<=N; ++i) {
            list.add(i);
        }

        while (list.size() > 1) {
            list.remove(0);
            int tmp = list.remove(0);
            list.add(tmp);
        }

        System.out.println(list.get(0));

    }

}
