import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쉽게푸는문제 {




    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args)throws Exception {
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int localCount =0;
        int count=0;
        int num=1;
        int sum=0;
        while (count<e){
            if(count>=s-1){
                sum+=num;
            }

            localCount++;
            count++;
            if(localCount==num){
                num++;
                localCount=0;
            }
        }

        System.out.println(sum);
    }
}

