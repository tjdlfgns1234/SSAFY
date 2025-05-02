#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> arr(20001);
int vit[20001];


int solution(int n, vector<vector<int>> edge) {
    
    for(auto& i : edge){
        arr[i[0]].push_back(i[1]);
        arr[i[1]].push_back(i[0]);
        
        
    }
    
    queue<int> q;
    q.push(1);
    vit[1] = 1;
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        
        for(auto& next : arr[cur])
            if(!vit[next])
                vit[next] = vit[cur] + 1, q.push(next); 
    }

    int v = 0, ans = 0;
    for(int i = 1; i <= n;i++)
        v = max(v, vit[i]);
    
     for(int i = 1; i <= n;i++)
        if(v == vit[i]) ans++;
    
    return ans;
}