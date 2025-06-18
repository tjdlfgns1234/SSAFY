#include <bits/stdc++.h>

using namespace std;

string solution(vector<string> p, vector<string> c) {
    map<string,int> mp;

    for(auto& i : p)mp[i]++;
    
    
    for(auto& i : c)
       mp[i]--; 
        
    string ans;
        
    for(auto& i : mp){
        int cnt = i.second;
        while(cnt--)
            return i.first;
    }
    
    
    // 완주자 명단도 동명이인 가능
    
    
    return ans;
}