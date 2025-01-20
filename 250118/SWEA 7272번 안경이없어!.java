import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" "); // 입력받은 값을 공백을 기준으로 나눔
	int T = Integer.parseInt(input[0]); 
        
        String s1 = "CEFGHIJKLMNSTUVWXYZ"; // 이그룹에 속하면 C로 간주
        String s2 = "ADOPQR"; // 이 그룹에 속하면 A로 간주
        String s3 = "B"; // B로 간주
        
		for (int test_case=1; test_case<=T;test_case++) {
			String[] a = br.readLine().trim().split(" ");
	 		StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                
                        for (char  i : a[0].toCharArray()) {
                        for (char j : s1.toCharArray()){
                                if(i == j)
                                sb.append('C');
                        }
                                for (char j : s2.toCharArray()){
                                if(i == j)
                                sb.append('A');
                        }
                                for (char j : s3.toCharArray()){
                                if(i == j )
                                sb.append('B');
                        }
                                }
                for (char i : a[1].toCharArray()) {
                        for (char j : s1.toCharArray()){
                                if(i == j)
                                sb2.append('C');
                        }
                                for (char j : s2.toCharArray()){
                                if(i == j)
                                sb2.append('A');
                        }
                                for (char j : s3.toCharArray()){
                                if(i == j)
                                sb2.append('B');
                        }
                                }
                
                // System.out.println(String.format("#%s %s",sb ,sb2));
                
                if(sb.toString().equals(sb2.toString())){
                        System.out.println(String.format("#%d %s",test_case, "SAME"));
                }
                else{
                System.out.println(String.format("#%d %s",test_case, "DIFF"));
                }
		}	
        	
        
        bw.flush();
        bw.close();
        br.close();
    }
}