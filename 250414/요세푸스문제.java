import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 요세푸스문제 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();

    static List<Integer> list= new ArrayList<>();

    public static void main(String[] args)throws Exception {
        st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        K--;
        for(int i=1;i<=N;i++){
            list.add(i);
        }
        int point = K;
        sb.append("<");
        while (true){
            int temp = list.get(point);
            if(list.size()==1){
                sb.append(temp);
                break;
            }
            else{
                sb.append(temp+", ");
            }
            list.remove(point);
            point = point+K;
            point = point%list.size();
        }
        sb.append(">");
        System.out.println(sb);

    }

}


