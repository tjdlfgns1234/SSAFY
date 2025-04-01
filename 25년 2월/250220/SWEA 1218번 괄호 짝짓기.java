import java.io.*;
import java.util.*;

public class Solution {
	static String s;
	static int ans = 0;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        // int T = Integer.parseInt(br.readLine());
        int T = 10;
        for (int testcase = 1 ; testcase <= T ; testcase++) {
        	st = new StringTokenizer(br.readLine());
            s = br.readLine();
        	ans = 1;
            solve();
        	
        	sb.append("#" + testcase + " " + ans +  "\n");
        }
        System.out.print(sb.toString());
    }
    
    public static void solve() {
    	// 괄호 짝짓기
    	char [] pair = {'[', '{', '(','<'};
     	char [] pair2 = {']', '}', ')','>'};
    	
    	int[] arr = {0,0,0,0};
     	
     	for(int i = 0; i < s.length();i++) {
     		for(int j = 0; j < pair.length;j++) 
     			if(s.charAt(i) == pair[j]) 
     				arr[j]++;     				
     			
     		for(int j = 0; j < pair2.length;j++) 
         		if(s.charAt(i) == pair2[j]) 
         			if(arr[j] > 0)
         				arr[j]--;
         			else 
         				ans =0;			
     	}
     	
    	for(int j = 0; j < arr.length;j++) 
 			if(arr[j] != 0) 
 				ans =0;	  
    }
}
