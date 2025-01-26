import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	// 사람 번호
        	int N = Integer.parseInt(st.nextToken());
        	// 문제 번호
        	int M = Integer.parseInt(st.nextToken());
        	
        	int[][] arr = new int[N][M];
        	
        	for (int i = 0; i < N; i++) {
        		StringTokenizer st2 = new StringTokenizer(br.readLine());
        		for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}
				
			}
        	
        	// 1등한 사람 수와 문제 수
        	// cnt로 세기
        	int max_cnt = 0;
        	int result_people = 0;
        	int temp_cnt;
        	for (int i = 0; i < N; i++) {
				temp_cnt = 0;
				for(int j = 0; j < M; j++) {
					if(arr[i][j] == 1) {
						temp_cnt +=1;
					}
				}
				
				if(max_cnt < temp_cnt) {
					result_people = 1;
					max_cnt = temp_cnt;
				}
				else if(max_cnt == temp_cnt) {
					result_people += 1;
				}
			}
        	
        	System.out.printf("#%d %d %d\n",t, result_people, max_cnt);
        	
        }
    }

}
