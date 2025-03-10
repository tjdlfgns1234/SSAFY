import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게으른백곰 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int N,K;

    public static void main(String[] args)throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[1000001];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x]=g;
        }

        if(K>=500000){
            long sum=0;
            for(int i=0;i<=1000000;i++){
                sum+=arr[i];
            }
            System.out.println(sum);
            return;
        }

        long sum=0;
        for(int i=0;i<=K+K;i++){
            sum+=arr[i];
        }
        long result=sum;

        int l=0,r=K+K;

        while (true){
            sum-=arr[l];
            l++;r++;
            if(r==1000001)break;
            sum+=arr[r];
            result = Math.max(result,sum);
        }
        System.out.println(result);

    }
}
