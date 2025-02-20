import java.io.*;
import java.util.*;
 
public class Solution {
	static int[] myCard;
	static int[] opCard;
	static int win;
	static int lose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        
        for (int k = 1 ; k <= T ; k++) {
        	String[] input = br.readLine().split(" ");
        	myCard = new int[9];
        	for (int i = 0 ; i < input.length ; i++) {
        		myCard[i] = Integer.parseInt(input[i]); // 규영의 카드 (순서 고정)
        	}
        	opCard = new int[9]; // 인영의 카드
        	int idx = 0;
        	for (int i = 1 ; i <= 18 ; i++) {
        		boolean contains = false;
        		for (int j = 0 ; j < 9 ; j++) {
        			if (myCard[j] == i) {
        				contains = true;
        			}
        		}
        		if (!contains) {
        			opCard[idx] = i;
        			idx++;
        		}
        	}
        	win = 0;
        	lose = 0;
        	idx = 0;
        	int[] setOpCard = new int[9];
        	boolean[] visited = new boolean[9];	// 인영의 방문배열
        	recursive(idx, setOpCard, visited);
        	System.out.printf("#%d %d %d\n", k, win, lose);
        }

    }
    
	private static void recursive(int idx, int[] setOpCard, boolean[] visited) {
		if (setOpCard[8] != 0) {
			check(setOpCard);
			return;
		}
		
		if (idx == 9) {
			return;
		}
		
		for (int i = 0 ; i < 9 ; i++) {
			if (!visited[i]) {
				setOpCard[idx] = opCard[i];
				visited[i] = true;
				recursive(idx+1, setOpCard, visited);
				setOpCard[idx] = 0;
				visited[i] = false;
			}
		}
	}

	private static void check(int[] setOpCard) {
		int myScore = 0;
		int opScore = 0;
		for (int i = 0 ; i < 9 ; i++) {
			if (myCard[i] > setOpCard[i]) {
				myScore += (myCard[i] + setOpCard[i]);
			} else if (myCard[i] == setOpCard[i]) {
				continue;
			} else {
				opScore += (myCard[i] + setOpCard[i]);
			}
		}
		
		if (myScore > opScore) {
			win++;
		} else if (myScore < opScore) {
			lose++;
		} else {
			{}
		}
	}
}
