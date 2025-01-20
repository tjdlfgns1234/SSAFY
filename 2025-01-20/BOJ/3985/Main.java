import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[l];
        int temp_cnt = 0;
        int result_p = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int j = p - 1; j < k; j++) {
                if (arr[j] == 0) {
                    arr[j] = i + 1;
                }
            }
            if(temp_cnt < (k - p + 1) ){
                temp_cnt = k - p + 1;
                result_p = i + 1;
            }
        }

        int result = 0;
        int cnt, temp_cnt2 = 0;
        for (int i = 1; i <= n; i++){
            cnt = 0;
            for (int j = 0; j < l ; j++){
                if (arr[j] == i){
                    cnt ++;
                }
            }
            if (temp_cnt2 < cnt){
                temp_cnt2 = cnt;
                result = i;
            }
        }

        System.out.println(result_p);
        System.out.println(result);
    }
}
