import java.io.*;
import java.util.*;

public class Main {
	static int minVal = Integer.MAX_VALUE;
	static boolean check = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 구역의 수
		int[] ingu = new int[n+1]; // 구역별 인구수
		int[][] arr = new int[n+1][n]; // 인접 내용
		int mid = n / 2;
		String[] input1 = br.readLine().split(" ");
		for (int i = 1 ; i <= n ; i++) {
			ingu[i] = Integer.parseInt(input1[i-1]);
			String[] input2 = br.readLine().split(" ");
			for (int j = 1 ; j < input2.length ; j++) {
				arr[i][j] = Integer.parseInt(input2[j]);
			}
		}
		int idx = 1;
		ArrayList<Integer> selectedArr = new ArrayList<Integer>();
		for (int i = 1 ; i <= mid ; i++) {
			combination(n, arr, ingu, idx, i, selectedArr);
		}
		
		if (check) {
			System.out.println(minVal);
		} else {
			System.out.println(-1);
		}
    }

	private static void combination(int n, int[][] arr, int[] ingu, int idx, int toSelect, ArrayList<Integer> selectedArr) {
		if (selectedArr.size() == toSelect && connected(n, arr, selectedArr)) {
			for (int i = 0 ; i < selectedArr.size() ; i++) {
				diff(n, selectedArr, ingu);
			}
			return;
		}
		
		if (idx == n+1) {
			return;
		}
		
		selectedArr.add(idx);
		combination(n, arr, ingu, idx+1, toSelect, selectedArr);
		selectedArr.remove(selectedArr.size()-1);
		combination(n, arr, ingu, idx+1, toSelect, selectedArr);
	}

	private static void diff(int n, ArrayList<Integer> selectedArr, int[] ingu) {
	    ArrayList<Integer> notSelectedArr = new ArrayList<>();
	    check = true;
	    for (int i = 1; i <= n; i++) {
	        if (!selectedArr.contains(i)) {
	            notSelectedArr.add(i);
	        }
	    }
	    int selectedSum = 0;
	    int notSelectedSum = 0;
	    for (int i  = 0 ; i < selectedArr.size() ; i++) {
	    	selectedSum += ingu[selectedArr.get(i)];
	    }
	    for (int i  = 0 ; i < notSelectedArr.size() ; i++) {
	    	notSelectedSum += ingu[notSelectedArr.get(i)];
	    }
	    
	    int tmpMin = Math.abs(selectedSum - notSelectedSum);
	    if (tmpMin < minVal) {
	    	minVal = tmpMin;
	    }
	}

	private static boolean connected(int n, int[][] arr, ArrayList<Integer> selectedArr) {
	    ArrayList<Integer> notSelectedArr = new ArrayList<>();
	    for (int i = 1; i <= n; i++) {
	        if (!selectedArr.contains(i)) {
	            notSelectedArr.add(i);
	        }
	    }

	    if (!bfs(arr, selectedArr)) {
	    	return false;
	    }

	    if (!notSelectedArr.isEmpty() && !bfs(arr, notSelectedArr)) {
	    	return false;
	    }

	    return true;
	}
	
	private static boolean bfs(int[][] arr, ArrayList<Integer> area) {
	    if (area.isEmpty()) {
	        return false;
	    }

	    boolean[] visited = new boolean[arr.length];
	    ArrayDeque<Integer> queue = new ArrayDeque<>();
	    
	    queue.offer(area.get(0));
	    visited[area.get(0)] = true;

	    int visitedCount = 0;

	    while (!queue.isEmpty()) {
	        int current = queue.poll();
	        visitedCount++;

	        for (int i = 0; i < arr[current].length; i++) {
	            int next = arr[current][i];

	            if (next == 0) {
	                continue;
	            }

	            if (area.contains(next) && !visited[next]) {
	                visited[next] = true;
	                queue.offer(next);
	            }
	        }
	    }
	    return visitedCount == area.size();
	}
}
