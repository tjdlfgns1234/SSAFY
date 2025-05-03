#include <bits/stdc++.h>
using namespace std;
int videoToTime(string video_len);
string TimeTovideo(int time);

string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    int time = videoToTime(pos);
    int end = videoToTime(video_len);
    int x = videoToTime(op_start);
    int y = videoToTime(op_end);    
    if( x <= time && time <=y)
        time = y;
    
    for(auto c :commands){
        if(c == "next")
            time = min(time+10, end);
        else if(c == "prev")
            time = max(time-10, 0);
        
        if( x <= time && time <=y)
            time = y;  
    }
    
    return TimeTovideo(time);
}

int videoToTime(string s){
    int ret = 0;
    
    ret += stoi(s.substr(0,2))*60;
    ret += stoi(s.substr(3,2));
    
    return ret;
}
string TimeTovideo(int time){
    string ret = "";
    
    if(time / 60 < 10)
        ret += "0" + to_string(time/60);
    else
         ret += to_string(time/60);
    ret += ":";
        
    if(time % 60 < 10)
        ret += "0" + to_string(time%60);
    else
         ret += to_string(time%60);
    
    return ret;
}