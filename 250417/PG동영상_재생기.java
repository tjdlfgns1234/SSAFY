import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoLen = 0;
        String[] videoSplit  = video_len.split(":");
        int vm = Integer.parseInt(videoSplit[0]);
        int vs = Integer.parseInt(videoSplit[1]);
        videoLen = vm*60 + vs;
        
        int p = 0;
        String[] posSplit  = pos.split(":");
        int pm = Integer.parseInt(posSplit[0]);
        int ps = Integer.parseInt(posSplit[1]);
        p = pm*60 + ps;
        
        int s = 0;
        String[] sSplit  = op_start.split(":");
        int sm = Integer.parseInt(sSplit[0]);
        int ss = Integer.parseInt(sSplit[1]);
        s = sm*60 + ss;
        
        int e = 0;
        String[] eSplit  = op_end.split(":");
        int em = Integer.parseInt(eSplit[0]);
        int es = Integer.parseInt(eSplit[1]);
        e = em*60 + es;
        
        for(String cmd : commands){
            if(cmd.equals("next")){
                if(s <= p && e >= p){
                    p = e;
                }
                p += 10;
                if(s <= p && e >= p){
                    p = e;
                }
                if(p > videoLen) p = videoLen;
            }else if(cmd.equals("prev")){
                if(s <= p && e >= p){
                    p = e;
                }
                p -= 10;
                if(s <= p && e >= p){
                    p = e;
                }
                if(p < 0) p = 0;
            }
        }
        String min = Integer.toString(p/60);
        String sec = Integer.toString(p%60);
        answer = (min.length() == 1 ? "0"+min : min) +":"+ (sec.length() == 1 ? "0"+sec : sec);
        
        
        return answer;
    }
}