import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1 0 0 0 1 1 0 1
//스위치 켜고 끄기
public class Main1244 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for (int i=0; i<studentNum; ++i) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            int count = 0;
            solve(arr, gender, num);
        }

        int count = 0;
        for (int a : arr) {
            ++count;
            System.out.print(a + " ");
            if (count % 20 == 0) {
                System.out.println();
            }
        }

    }

    public static void solve(int[] arr, int gender, int num) {
        //남자 1 , 여자 2

        int[] d = {-1, 1};

        if (gender == 1) {
            int idx = num;
            while (idx <= arr.length) {
                arr[idx-1] = arr[idx-1] ^ 1;
                idx += num;
            }
        }
        else {
            arr[num-1] = arr[num-1] ^ 1;
            int l = num - 1 + d[0];
            int r = num - 1 + d[1];

            while (isValid(arr, l, r)) {
                arr[l] = arr[l] ^ 1;
                arr[r] = arr[r] ^ 1;

                l += d[0];
                r += d[1];
            }
        }
    }

    public static boolean isValid(int[] arr, int l, int r) {
        return l >= 0 && r <arr.length && arr[l] == arr[r];
    }

}
