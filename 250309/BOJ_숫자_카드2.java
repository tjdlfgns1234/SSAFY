import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_숫자_카드2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Long[] nList = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            nList[i] = Long.parseLong(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        Long[] mList = new Long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            mList[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nList);
        Long[] nListReverse = Arrays.copyOf(nList, n);
        Arrays.sort(nListReverse,(o1,o2)->Long.compare(o2, o1));

        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++){
            long target = mList[i];
            int lb = lowerBound(nList, target);
            int ub = upperBound(nList, target);
            int count = ub - lb;
            sb.append(count).append(" ");
        }
        
        System.out.println(sb.toString());
    }

    static int lowerBound(Long[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static int upperBound(Long[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
