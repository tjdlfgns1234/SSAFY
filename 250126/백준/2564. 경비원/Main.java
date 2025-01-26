import java.io.*;
import java.util.*;
// 외곽에만 건물이 있을 수 있음.
// 1 -> 북 + 서쪽에서부터 거리
// 2 -> 남 + 서쪽에서부터 거리
// 3 -> 서 + 북쪽으로부터 거리
// 4 -> 동 + 북쪽으로부터 거리
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	String[] size = br.readLine().split(" ");
    	int horizontal = Integer.parseInt(size[0]); // 가로
    	int vertical = Integer.parseInt(size[1]);	// 세로
    	int n = Integer.parseInt(br.readLine()); // 상점의 개수
    	ArrayList<ArrayList<Integer>> arr = new ArrayList<>(); // 상점 좌표 담는 ArrayList
    	for (int i = 0 ; i < n ; i++) {
    		arr.add(new ArrayList<>()); // arr 초기화
    		String[] input = br.readLine().split(" ");
    		arr.get(i).add(0, Integer.parseInt(input[0]));
    		arr.get(i).add(1, Integer.parseInt(input[1]));
    	}
    	String[] tmp = br.readLine().split(" ");
    	int loc = Integer.parseInt(tmp[0]); 	// 동근이의 동서남북
    	int locDiff = Integer.parseInt(tmp[1]);	// 거리
    	
    	int result = 0;
    	for (int i = 0 ; i < n ; i++) {
    		int dist;
    		if(loc == arr.get(i).get(0)) { // 같은 행 또는 열에 있다면
    			result += Math.abs(locDiff-arr.get(i).get(1)); // 절대값만 구함
    			continue;
    		} else {
    			if (loc == 1) { // 동근이가 북쪽이고
    				if (arr.get(i).get(0) == 3) { // 상점이 서쪽
    					dist = arr.get(i).get(1) + locDiff;
    					result += dist;
    				} else if (arr.get(i).get(0) == 4) { // 상점이 동쪽
    					dist = (horizontal - locDiff) + arr.get(i).get(1);
    					result += dist;
    				} else { // 상점이 반대편 (양방향)
    					int dist1 = arr.get(i).get(1) + locDiff + vertical; // 반시계
    					int dist2 = (horizontal - arr.get(i).get(1)) + (horizontal - locDiff) + vertical;
    					dist = Math.min(dist1, dist2);
    					result += dist;
    				}
    			} else if (loc == 2) { // 남쪽
    				if (arr.get(i).get(0) == 3) { // 상점이 서쪽
    					dist = locDiff + (vertical - arr.get(i).get(1));
    					result += dist;
    				} else if (arr.get(i).get(0) == 4) { // 상점이 동쪽
    					dist = (horizontal - locDiff) + (vertical - arr.get(i).get(1));
    					result += dist;
    				} else { // 상점이 반대편 (양방향)
    					int dist1 = (horizontal - locDiff) + (horizontal - arr.get(i).get(1)) + vertical; // 반시계
    					int dist2 = locDiff + arr.get(i).get(1) + vertical;
    					dist = Math.min(dist1, dist2);
    					result += dist;
    				}
    			} else if (loc == 3) { // 서쪽
    				if (arr.get(i).get(0) == 1) { // 상점이 북쪽
    					dist = arr.get(i).get(1) + locDiff;
    					result += dist;
    				} else if (arr.get(i).get(0) == 2) { // 상점이 남쪽
    					dist = (vertical - locDiff) + arr.get(i).get(1);
    					result += dist;
    				} else { // 상점이 반대편 (양방향)
    					int dist1 = (vertical - locDiff) + (vertical - arr.get(i).get(1)) + horizontal; // 반시계
    					int dist2 = locDiff + horizontal + arr.get(i).get(1);
    					dist = Math.min(dist1, dist2);
    					result += dist;
    				}
    			} else if (loc == 4) { // 동쪽
    				if (arr.get(i).get(0) == 1) { // 상점이 북쪽
    					dist = locDiff + (vertical - arr.get(i).get(1));
    					result += dist;
    				} else if (arr.get(i).get(0) == 2) { // 상점이 남쪽
    					dist = (vertical - locDiff) + (vertical - arr.get(i).get(1));
    					result += dist;
    				} else { // 상점이 반대편 (양방향)
    					int dist1 = locDiff + horizontal + arr.get(i).get(1); // 반시계
    					int dist2 = (vertical-locDiff) + horizontal + (vertical-arr.get(i).get(1));
    					dist = Math.min(dist1, dist2);
    					result += dist;
    				}
    			}
    		}
    	}
    	System.out.println(result);
    }
}
