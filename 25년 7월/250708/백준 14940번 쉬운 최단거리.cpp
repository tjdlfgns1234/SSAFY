#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 1000
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
void bfs(int sx,int sy);

struct P{
    int x,y, cost;
};

int arr[MAX][MAX];
int dp[MAX][MAX];
int n, m;

int dx[4] = {-1,1,0,0};
int dy[4] = {0, 0, -1, 1};

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	// cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	cin >> n >> m;

    int sx, sy;
    
    for(int i = 0; i < n;i++)
        for(int j = 0; j < m;j++){
            cin >> arr[i][j];
            if(arr[i][j] == 2)
                sx = i, sy = j;
        }

    bfs(sx,sy);
    
    for(int i = 0; i < n;i++){
        for(int j = 0; j < m;j++)
            if(arr[i][j] == 1){
                if(dp[i][j] == 0)
                    cout << -1 << ' ';
                else
                    cout << dp[i][j] << " ";
            }
            else
                cout << 0 << " ";
        cout << '\n';
    }
}
void bfs(int sx,int sy){
    queue<P> q;
    q.push({sx, sy, 0});
    while(!q.empty()){
        P cur = q.front();
        q.pop();
        
        for(int i = 0; i < 4; i++){
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >=m || arr[nx][ny]==0)
                continue;
            if(dp[nx][ny] == 0)
                dp[nx][ny] = cur.cost + 1, q.push({nx,ny,dp[nx][ny]});
        }
    }
}