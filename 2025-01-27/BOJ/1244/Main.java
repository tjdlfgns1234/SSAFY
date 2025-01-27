import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main
{	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] map = new int [N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
        
        int student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int gender = Integer.parseInt(st2.nextToken());
        	int idx = Integer.parseInt(st2.nextToken());
        	if(gender == 1) map = man(idx, map);
        	else map = woman(idx, map);
        	
		}
        
        for (int i = 1; i < N+1; i++) {
			System.out.printf("%d ", map[i]);
			if (i % 20 == 0) System.out.println();
		}
    }
    
    static int[] woman(int idx, int[] arr) {
    	int temp_idx = 1;
    	if(arr[idx] == 0) arr[idx] = 1;
    	else arr[idx] = 0;
    	
    	while(true) {
    		if(idx - temp_idx >= 1 && idx + temp_idx < arr.length) {
    			if(arr[idx - temp_idx] == arr[idx + temp_idx]) {
    				if (arr[idx - temp_idx] == 1) {
    					arr[idx - temp_idx] = 0;
    					arr[idx + temp_idx] = 0;
    				}
    				else {
    					arr[idx - temp_idx] = 1;
    					arr[idx + temp_idx] = 1;
    				}
    				temp_idx += 1;
    			}
    			else break;
    		}
    		else break;
    	}
    	
    	
    	return arr;
	}

	static int[] man(int idx, int[] arr) {
    	int mul_idx = 1;
    	while(mul_idx * idx < arr.length) {
    		
    		if (arr[mul_idx * idx] == 1) {
    			arr[mul_idx * idx] = 0;
    		}
    		else {
    			arr[mul_idx * idx] = 1;
    		}
    		mul_idx += 1;
    	}
    	
    	return arr;
    }
}
