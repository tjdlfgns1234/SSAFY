import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자할당 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int arr[] = new int[8];
	static int count=0;
	
	static boolean calcu(String al, int s[]) {
		switch (al) {
			case "D":
				if(arr[3]!=s[1]+s[2])return false;
				break;
			case "H":
				if(arr[7]!=s[3]+s[4])return false;
				break;
			case "A":
				if(arr[0]!=s[5]+s[8]+s[11]+s[3])return false;
				break;
			case "B":
				if(arr[1]!=s[6]+s[9]+s[12]+s[4])return false;
				break;
			case "C":
				if(arr[2]!=s[7]+s[10]+s[13])return false;
				break;
			case "E":
				if(arr[4]!=s[5]+s[6]+s[7]+s[1])return false;
				break;
			case "F":
				if(arr[5]!=s[8]+s[9]+s[10]+s[2])return false;
				break;
			case "G":
				if(arr[6]!=s[11]+s[12]+s[13])return false;
				break;
		}
		return true;
		
	}
	// D -> H (1-4) 나머지
	static void permu(int k , boolean visit[] , int storage[]) {
		if(k==3) {
			if(!calcu("D",storage))return;
		}
		else if(k==5) {
			if(!calcu("H",storage))return;
		}
		else if(k==8) {
			if(!calcu("E",storage))return;
		}
		else if(k==11) {
			if(!calcu("F",storage))return;
		}
		else if(k==12) {
			if(!calcu("A",storage))return;
		}
		else if(k==14) {
			if(!calcu("B",storage))return;
			if(!calcu("C",storage))return;
			if(!calcu("G",storage))return;
			count++;
			return;
		}
		
		for(int i=1;i<=13;i++) {
			if(visit[i])continue;
			visit[i] = true;
			storage[k]=i;
			permu(k+1,visit,storage);
			visit[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<8;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		permu(1,new boolean[14] , new int[14]);
		System.out.println(count);
	}

}
