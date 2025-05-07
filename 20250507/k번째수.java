import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        PriorityQueue<Integer> pq;
        for(int c=0; c<commands.length; c++) {
            pq = new PriorityQueue<>();
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];
            
            for(int t=i-1; t<=j-1; t++) {
                pq.add(array[t]);
            }
            
            for(int t=0; t<k-1; t++) {
                pq.poll();
            }
            
            answer[c] = pq.poll();
        }
        return answer;
    }
}