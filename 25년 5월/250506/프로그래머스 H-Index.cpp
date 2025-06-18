#include <bits/stdc++.h>
#define all(x) x.begin(),x.end()
#define MAX 10001
using namespace std;

int cnt[MAX] = {0};

int solution(vector<int> citations) {
    int ans = 0;
    
    for(auto& i: citations) cnt[i]++;
    
    int sum = citations.size(), cur = 0; // cur h번 미만으로 인용되
    for(int h = 0; h < MAX; h++){
        if( cur + cnt[h]<= h && h <= sum-cur){
            // cout << h << '\n'; // 가능한 H값 중 최댓값
            ans = max(ans, h); 
        }
            
        cur += cnt[h];
    }
    
    
    return ans;
}