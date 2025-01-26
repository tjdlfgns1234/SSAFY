import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main
{	
	static int max_asc = -1;
	static int max_desc = 1001;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
        	int n = Integer.parseInt(br.readLine());
        	int[] num = new int[n]; 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
            max_asc = find_asc(num);
            max_desc = find_desc(num);
            System.out.printf("#%d %d %d\n", t, max_asc, max_desc );
        }
    }
    
    private static int find_desc(int[] arr) {
    	int temp_max = 0;
    	
    	for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i+1]) {
				temp_max = Math.max(temp_max, (arr[i] - arr[i+1]));
			}
		}
    	
    	return temp_max;
	}

	static int find_asc(int[] arr) {
    	int temp_max = 0;
    	
    	for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i+1]) {
				temp_max = Math.max(temp_max, (arr[i+1] - arr[i]));
			}
		}
    	
    	return temp_max;
    }

}
