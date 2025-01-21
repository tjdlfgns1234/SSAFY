import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	// a(공격) b(쉼) / c(공격) d(쉼)
    	// p(우체부) m(우유) n(신문)
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String[] arr1 = br.readLine().split(" ");
    	String[] arr2 = br.readLine().split(" ");
    	int a = Integer.parseInt(arr1[0]);
    	int b = Integer.parseInt(arr1[1]);
    	int c = Integer.parseInt(arr1[2]);
    	int d = Integer.parseInt(arr1[3]);
    	
    	for (int i = 0 ; i < arr2.length ; i++) {
    		int sum = 0;
    		int num = Integer.parseInt(arr2[i]);
    		int num1 = num;
    		while (true) {
    			num1 -= a;
    			if (num1 <= 0) {
    				sum++; // 공격 받으니 +
    				break;
    			}
    			num1 -= b;
    			if (num1 <= 0) {
    				break;
    			}
    		}
    		int num2 = num;
    		while (true) {
    			num2 -= c;
    			if (num2 <= 0) {
    				sum++; // 공격 받으니 +
    				break;
    			}
    			num2 -= d;
    			if (num2 <= 0) {
    				break;
    			}
    		}
    		System.out.println(sum);
    	}
    }
}
