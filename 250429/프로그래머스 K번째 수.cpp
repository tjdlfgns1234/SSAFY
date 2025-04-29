#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> comm) {
    vector<int> ans;
    
    for(int i = 0; i < comm.size();i++){
        int a = comm[i][0], b = comm[i][1], c = comm[i][2];
        
        vector<int> tmp;
        for(int j = a-1; j < b;j++)
            tmp.push_back(arr[j]);
        
        sort(all(tmp));
        
        ans.push_back(tmp[c-1]);
    }    
    
    return ans;
}