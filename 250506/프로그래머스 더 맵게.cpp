#include <bits/stdc++.h>
#define all(x) x.begin,x.end()
#define ll long long 

/*
    설명에 있는대로 작업을 반복하기만 하면됨
*/

using namespace std;

int solution(vector<int> scoville, int K) {
    ll ans = 0, small = -1;
    priority_queue<ll> pq;
    
    for(auto& i: scoville)
        pq.push(-i);
    
    if(K == 0)
        return 0;
    
    // pq는 max-heap
    if(!pq.empty()){
        small = -pq.top();
        pq.pop();
    }
    
    while(!pq.empty()){
        ll cur = -1;
        cur = -pq.top(), pq.pop();

        
        if(min(small, cur)>= K)
            break;
        
        small = max(small, cur)*2 + min(small, cur), ans++;
        pq.push(-small);
        small = -pq.top(), pq.pop();
    }
    
    if(small < K)
        ans = -1;
  
    
    return ans;
}