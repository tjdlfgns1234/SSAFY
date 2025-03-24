import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 두용액 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long[] arr;

    public static void main(String[] args) throws Exception{

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr= new long[N];
        List<Long> result= new ArrayList<>();;
        for(int i=0;i<N;i++){
            arr[i] =Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long max = Long.MAX_VALUE;
        int l=0,r=arr.length-1;
        while (l<r){
            long sum = arr[l]+arr[r];
            long temp = Math.abs(sum);
            if(temp<max){
                max = temp;
                result = new ArrayList<>();
                result.add(arr[l]);
                result.add(arr[r]);
            }

            if(sum>0){
                r--;
            }
            else{
                l++;
            }
        }

        Collections.sort(result);

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }

    }
}
