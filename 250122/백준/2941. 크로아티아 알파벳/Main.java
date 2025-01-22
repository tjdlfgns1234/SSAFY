import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] strArr = br.readLine().split("");
    	int pass = strArr.length;
    	boolean check = false; // lj, nj 확인을 위한 check
    	for (int i = 0 ; i < strArr.length ; i++) {
    		String tmp = strArr[i];
    		if (check == true && tmp.equals("j")) {
    			check = false;
    			pass--;
    			continue;
    		} else {
    			check = false;
    		}
    		if (tmp.equals("=") || tmp.equals("-")) {
    			if (strArr[i-1].equals("z")) {
    				if (i >= 2) {
        				if (strArr[i-2].equals("d")) {
        					pass = pass - 2;
        				} else {
        					pass--;
        				}
    				} else {
    					pass--;
    				}
    			} else {
    				pass--;
    			}
    		}
    		if ((tmp.equals("l") || tmp.equals("n")) && !(i == strArr.length-1)) {
    			check = true;
    		}
    	}
    	System.out.println(pass);
    }
}
