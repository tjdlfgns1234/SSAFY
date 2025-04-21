#include <bits/stdc++.h>
#define MAX 501
#define OIL 1
using namespace std;

struct Pair{
    int x,y;
};


/*  석유시추
    수직으로 단 하나만 뚫을 수 있을 때
    가장 많은 석유를 뽑을 수 있는 시추관의 위치
    열과 열 사이에 시추관을 뚫을 수 없다
    
    세로 길이 500, 가로 길이 500
    각 석유마다 번호를 매긴 뒤 BFS
    한번으로 크기를 미리 구해서 배열에 저장

    석유를 한번 보는데 걸리는 시간 O(n)
    석유의 크기를 보는 데 걸리는 시간 O(n)
*/

int cnt[MAX*MAX] = {0};
int new_land[MAX][MAX] = {0}; // 표시된 땅
int idx = 1, n,m;
int dx[4] = {-1,0,1,0};
int dy[4] = {0,-1,0,1};

int drilling(vector<vector<int>>& land);
void count_oil(vector<vector<int>>& land);
void mark_oil(vector<vector<int>>& land, int x, int y);

int solution(vector<vector<int>> land) {
    n = land.size();
    m = land[0].size();
    // cout << n << " " << m;
    count_oil(land); // 오일 개수 세기
   
    // for(int i = 1; i < idx; i++)
    //     cout << i << " " << cnt[i] << "\n"; 
    
    return drilling(land);
}
int drilling(vector<vector<int>>& land){
    int ret = 0;
    for(int i = 0; i < m;i++){
         int sum = 0;
         set<int> s;
         for(int j = 0; j < n;j++)
             if(land[j][i] == 1)
                s.insert(new_land[j][i]);
         
        for(auto i : s)
            sum += cnt[i];
        
        ret = max(ret,sum);
    }
    
    return ret;
}
void count_oil(vector<vector<int>>& land){   
    for(int i = 0; i < n;i++)
        for(int j = 0; j < m;j++)
            if(new_land[i][j] == 0 && land[i][j] == OIL)
                mark_oil(land, i,j);
}

void mark_oil(vector<vector<int>>& land, int x, int y){  
    queue<Pair> q;
    q.push({x,y});
    int mark = idx++;
    new_land[x][y] = mark;
    cnt[mark]++;
    while(!q.empty()){
        Pair cur = q.front();
        q.pop();
        for(int i = 0; i < 4;i++){
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || land[nx][ny] == 0)
                continue;
            
            
            if(new_land[nx][ny] == 0){
                new_land[nx][ny] = mark; 
                cnt[mark]++;
                q.push({nx,ny});
            }
            
        } 
    }

//     for(int i = 0; i < n;i++){
//         for(int j = 0; j < m;j++)
//             cout << new_land[i][j];
//         cout << '\n';
//     }
    
//     cout << '\n';
}

