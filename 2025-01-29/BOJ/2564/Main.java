import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main
{	
	static int W = 0;
	static int H = 0;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        
        // 1 : 북     2 : 님     3 : 서    4 : 동
        // locate[][1 : 방향,    2 : 거리]
        int[][] locate = new int[N][2];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st2.nextToken());
        	int y = Integer.parseInt(st2.nextToken());
        	locate[i][0] = x;
        	locate[i][1] = y;
		}
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int home_dire = Integer.parseInt(st3.nextToken());
    	int home_locate = Integer.parseInt(st3.nextToken());
        	
        int home_dist = find_dist(home_locate, home_dire);
    	int result = 0;
    	int temp_a = 0;
    	int temp_b = 0;
    	for (int i = 0; i < N; i++) {
    		temp_a = Math.abs(home_dist - find_dist(locate[i][1], locate[i][0]));
    		temp_b = Math.abs(2 * H + 2 * W - temp_a);
    		result += Math.min(temp_a, temp_b);
		}
    	System.out.println(result);
    	
    }
    
    
    // 1직선 북 -> 동 -> 남 -> 서
    static int find_dist(int locate, int dire) {
    	int temp_result = 0;
    	
    	switch(dire) {
    		case 1: // 북
    			temp_result = locate;
    			break;
    		case 4: // 동
    			temp_result = W + locate;
    			break;
    		case 2: // 남
    			temp_result = 2 * W + H - locate; 
    			break;
    		case 3: // 서
    			temp_result = 2 * W + 2 * H - locate;
    			break;
    	}
    	
    	
    	return temp_result;
    }
}
