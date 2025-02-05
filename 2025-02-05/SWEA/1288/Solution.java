import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String args[]) throws Exception
    {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int t = 1; t < T + 1; t++) {
    		int n = Integer.parseInt(br.readLine());
    		HashSet<Integer> set = new HashSet<>();
    		int idx = 1;
    		String temp;
    		while(set.size() < 10) {
    			temp = Integer.toString(n * idx);
    			for (int i = 0; i < temp.length(); i++) {
					set.add(temp.charAt(i) - '0');
				}
    			idx += 1;
    		}
    		
    		System.out.printf("#%d %d\n", t, n * (idx-1));
		}
    	
    	
    	
		
	}
    
    
}
