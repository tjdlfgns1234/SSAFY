import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        int[] cake = new int[n];
        
        for (int i = 0; i < n; i++) {
			cake[i] = Integer.parseInt(st2.nextToken());
		}
        
        ArrayList<Integer> mul_cake = new ArrayList<>();
        ArrayList<Integer> nonmul_cake = new ArrayList<>();
        int result = 0;
        
        
        for(int temp : cake) {
        	if (temp == 10) {
        		result += 1;
        		continue;
        	}
        	
        	if(temp % 10 == 0) {
        		mul_cake.add(temp);
        	}
        	else {
        		nonmul_cake.add(temp);
        	}
        }
        
        Collections.sort(mul_cake);
        Collections.sort(nonmul_cake);
        
        while(m > 0) {
        	if(mul_cake.size() > 0) {
        		if(mul_cake.get(0) == 20) {
        			m -= 1;
        			result += 2;
        			mul_cake.remove(0);
        		}
        		else {
        			mul_cake.set(0, mul_cake.get(0) - 10);
        			result += 1;
        			m -= 1;
        		}
        	}
        	else if(nonmul_cake.size() > 0){
        		if(nonmul_cake.get(0) > 10) {
        			nonmul_cake.set(0, nonmul_cake.get(0) - 10);
        			result += 1;
        			m -= 1;
        		}
        		else {
        			nonmul_cake.remove(0);
        		}
        		
        	}
        	else break;
        }
        
        System.out.println(result);
    }

}
