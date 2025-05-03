#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int ans = n-lost.size();
    
    sort(all(lost));
    
    set<int> s; // 체육복을 빌려 줄 수 있는 사람들
    for(auto i : reserve) s.insert(i);
    
     for(auto& i : lost){
        if(s.find(i) != s.end()){
            // 값이 있으면
            s.erase(i);// 값을 지움 
            i = -1;
            ans++;
        }
     }
    for(auto i : lost){
       if(s.find(i-1) != s.end()){
            // 값이 있으면
            s.erase(i-1);// 값을 지움 
            ans++;
        }
        else if(s.find(i+1) != s.end()){
            // 값이 있으면
            s.erase(i+1);// 값을 지움 
            
            ans++;
        }
        
    }
    
    return ans;
}