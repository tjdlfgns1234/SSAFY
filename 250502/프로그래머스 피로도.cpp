#include <bits/stdc++.h>

using namespace std;
bool chk[8] = {false};
int ans = 0;
void exp(int k, vector<vector<int>>& dungeons,int stage);

int solution(int k, vector<vector<int>> dungeons) {
    // 입장시 필요한 최소 피로도
    // 소모 피로도
    // 최소 필요 피로도 > 소모 피로도 보다 항상 큼
    // 1이상 1000 이하의 자연수
    // 두개가 같은 던전이 있을 수도 있다.
        
    exp(k, dungeons, 0);
    
    return ans;
}
void exp(int k, vector<vector<int>>& d,int stage){
    ans = max(ans, stage);
    for(int i = 0; i < d.size();i++){
        if(chk[i])
           continue; 
        
        if(k - d[i][0] >= 0){
            chk[i] = true;
            exp(k-d[i][1],d,stage+1);
        }
        chk[i] = false;
    }
}