#include <bits/stdc++.h>
using namespace std;

bool vit[201];

int solution(int n, vector<vector<int>> computers) {
    int cnt = 0;
    
    memset(vit,false,sizeof(vit));
    queue<int> q;

    for(int i = 0; i < computers.size();++i)
        if(!vit[i]){
            cnt++;
            vit[i] = true;
            q.push(i);
            
            
            while(!q.empty()){
                int top = q.front();
                // cout << top << " " << i << "\n";
                q.pop();
                for(int j = 0; j < computers.size();++j){
                    if(!vit[j] && computers[top][j] &&(top!=j)){
                        q.push(j);
                        vit[j] = true;
                    }  
                }    
            }
        }

    return cnt;
}