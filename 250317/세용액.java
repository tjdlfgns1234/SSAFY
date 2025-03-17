import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 세용액 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static Long[] arr;
    static Long max = Long.MAX_VALUE;
    static List<Long> result;

    public static void main(String[] args)throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new Long[N];
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0;i<N-2;i++){
            threeSum(i);
        }

        Collections.sort(result);

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }

    }

    static void threeSum(int index){
        int left =index+1, right = arr.length-1;

        while (left<right){
            long sum = arr[index] + arr[left]+ arr[right];
            long absSum = Math.abs(sum);
            if(absSum<max){
                max = absSum;
                result = new ArrayList<>();
                result.add(arr[index]);
                result.add(arr[left]);
                result.add(arr[right]);
            }

            if(sum>0){
                right--;
            }
            else{
                left++;
            }
        }

    }


}
