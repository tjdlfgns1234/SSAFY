import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long M;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        long result=0;
        long max=0;
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] =Long.parseLong(st.nextToken());
            max = Math.max(max,arr[i]);
        }

        long l=0,r=max;
        while (l<=r){
            long mid = (l+r)/2;
            long localMid=0;
            for(int i=0;i<N;i++){
                long temp = arr[i] - mid;
                if(temp<=0)continue;
                localMid+=temp;
            }
            if(localMid<M){
                r = mid-1;
            }
            else {
                result = Math.max(result,mid);
                l = mid+1;
            }
        }
        System.out.println(result);
    }

}
