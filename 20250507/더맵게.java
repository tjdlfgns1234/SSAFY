import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int t:scoville) {
            pq.add((long)t);
        }
        int cnt = 0;
        boolean flag = false;
        while(pq.size()>=2) {
            long sm = pq.poll();
            long sm2 = pq.poll();
            
            if(sm>=K) {
                flag = true;
                break;
            }
            
            sm = sm+sm2*2;
            pq.add(sm);
            cnt++;
        }
        if(!flag)
            if(pq.poll()>=K)
                flag = true;
        if(flag)
            return cnt;
        return -1;
    }
}