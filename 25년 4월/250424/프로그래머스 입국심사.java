import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long ans = 1000000000000000l;
        
        long l = 0, r = 1000000000000000l;
        
        while(l<=r){
            long mid = l + (r-l)/2;
            
            if(chk(times, n, mid)){
                ans=Math.min(ans, mid);
                r = mid-1;
            }
            else
                l = mid + 1;      
        }
        
        return ans;
    }
    
    public boolean chk(int[] times,int n, long mid){
        long ret = 0;
        
        for(int i = 0; i < times.length;i++){
            ret += mid / times[i];
            if(ret >= n)
                return true;
        }
        
        if(ret >= n)
            return true;
        else
            return false;  
    }
    
    
}