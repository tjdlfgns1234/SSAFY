import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int temp;
        int left = 0, right = 0;
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(st.nextToken());
            right = Math.max(temp, right);
            arr[i] = temp;
        }



        int mid = 0;
        long sum;
        while (left <= right){
            mid = (left + right) / 2;
            sum = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i] > mid){
                    sum += arr[i] - mid;
                }
            }
             if (sum >= M) {
                 left = mid + 1;
            }
            else {
                 right = mid - 1;
            }
        }
        System.out.println(right);

    }
}
