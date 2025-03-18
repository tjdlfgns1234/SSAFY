import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 동전0 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int result=0;
        for(int i=0;i<N;i++){
            arr[N-i-1] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<N;i++){
            if(K==0)break;
            int m= arr[i];
            if(m>K)continue;
            int count =K/m;
            result+=count;
            K -= count*m;
        }
        System.out.println(result);
    }
}
