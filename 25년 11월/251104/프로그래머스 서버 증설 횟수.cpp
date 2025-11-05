#include <bits/stdc++.h>

using namespace std;

/*
    사람이 m명 늘어날때마다 서버 1대 추가
    m명 미만이면 서버 증설이 필요 없음.
    증설한 서버는 k시간 운영 => 이후 반납
    (n+1) * m 미만이라면 최소 n대의 증설 서버 운영
    
    현재 시간의 서버 대수, 현재 시간의 플래이어 수
*/

int player_cnt[24] = {0};
int server =0;
int TIME_MAX = 24;

int solution(vector<int> players, int m, int k) {
    int ans = 0;

     for(int i = 0; i < TIME_MAX; i++)
         player_cnt[i] = m-1;

    for(int i = 0; i < TIME_MAX; i++){
        
        if(players[i] >player_cnt[i]){
            // 감당 못할 경우
            
            int pad = players[i] - player_cnt[i];
            pad = pad / m + (pad%m != 0);
            ans += pad;
            
            for(int j =i; j < min(i+k, TIME_MAX);j++)
                player_cnt[j] += m * pad;
        }
        
    
    }
    
    // for(int i = 0; i < TIME_MAX; i++){
    //     cout << player_cnt[i] << '\n';
    // }
    
    return ans;
}