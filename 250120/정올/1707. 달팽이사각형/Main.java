import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine()); // 정사각형 크기
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
        	arr.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                arr.get(i).add(0); // 열을 0으로 채움
            }
        }
        //System.out.println(arr);
        
        int i;
        int num = 1;
        int m = n;
        int x = 0, y = -1;
        //arr.get(x).set(y, num++);
        while (m > 0) {
            for (i = 1 ; i <= m ; i++) { // 오른쪽으로 이동
                y++;
                arr.get(x).set(y, num++);
            }
            
            m--;
            for (i = 1 ; i <= m ; i++) { // 아래로 이동
                x++;
                arr.get(x).set(y, num++);
            }
            
            for (i = 1 ; i <= m ; i++) { // 왼쪽으로 이동
                y--;
                arr.get(x).set(y, num++);
            }
            
            m--;
            for (i = 1 ; i <= m ; i++) { // 위로 이동
                x--;
                arr.get(x).set(y, num++);
            }
        }
        
        for (int t = 0 ; t < n ; t++) {
        	for (int k = 0 ; k < n ; k++) {
        		bw.write(arr.get(t).get(k) + " ");
        	}
        	bw.write("\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
