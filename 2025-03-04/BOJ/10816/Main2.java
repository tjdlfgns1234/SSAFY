import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int num, result;

        for (int i = 0; i < M; i++) {
            num = Integer.parseInt(st.nextToken());
            result = upper_bound(num) - lower_bound(num);
            sb.append(result + " ");
        }
        System.out.println(sb);

    }
    static int lower_bound(int num){
        int start = 0;
        int end = N;
        int mid;
        while (start < end){
            mid = (start + end) / 2;
            if(arr[mid] < num) start = mid + 1;
            else end = mid;
        }
        return end;
    }

    static int upper_bound(int num){
        int start = 0;
        int end = N;
        int mid;
        while (start < end){
            mid = (start + end) / 2;
            if(arr[mid] <= num) start = mid + 1;
            else end = mid;
        }
        return end;
    }
}
