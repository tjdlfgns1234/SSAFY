import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Solution
{	
	static int max_asc = -1;
	static int max_desc = 1001;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
        	int[] bus = new int[5001];
        	// 버스노선 N개
        	int N = Integer.parseInt(br.readLine());

        	for (int i = 0; i < N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				for(int j = A; j <= B; j++) {
					bus[j] += 1;
				}
			}
        	
        	// P는 j번째 줄 버스지나는 개수
        	int P = Integer.parseInt(br.readLine());
        	System.out.printf("#%d ", t);
        	for (int j = 0; j < P; j++) {
				int c = Integer.parseInt(br.readLine());
				System.out.printf("%d ", bus[c]);
			}
        	System.out.println();
        }
    }

}
