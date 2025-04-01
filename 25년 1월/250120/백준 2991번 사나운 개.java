import java.io.*;
import java.util.*;

class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" "); // 입력받은 값을 공백을 기준으로 나눔

	    int a = Integer.parseInt(input[0]); 
        int b = Integer.parseInt(input[1]); 
        int c = Integer.parseInt(input[2]); 
        int d = Integer.parseInt(input[3]);
        
        int arr[] = new int[3];

        input = br.readLine().split(" ");

        for(int i = 0; i < 3;i++){
            arr[i] = Integer.parseInt(input[i]);
            arr[i]--; 
        }
        

        for(int i = 0; i < 3; i++){
            int tmp = 0;
            if(arr[i] % (a+b) < a)
                tmp++;
            if(arr[i] % (c + d) < c)
                tmp++;


            System.out.println(tmp);
        }

	
        bw.flush();
        bw.close();
        br.close();
    }
}