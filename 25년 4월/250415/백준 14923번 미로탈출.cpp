#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100001
#define INF 987654321
using namespace std;

struct Pair {
	int x, y, c;
};

int n, m;
int arr[1001][1001];
int cost[1001][1001][2];
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,-1, 0, 1 };

void solve();

int main() {
	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	// freopen("input.txt", "r", stdin);

	solve();

	return 0;
}
void solve() {
	cin >> n >> m;

	int sx, sy, ex, ey;
	cin >> sx >> sy >> ex >> ey;

	sx--, sy--, ex--, ey--;

	memset(arr, 0, sizeof(arr));

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> arr[i][j];


	for (int i = 0; i < n; i++) 
		for (int j = 0; j < m; j++)
			cost[i][j][0] = INF, cost[i][j][1] = INF;

	
	queue <Pair> q;
	q.push({sx,sy,0});
	cost[sx][sy][0] = 0;

	while (!q.empty()) {
		Pair cur = q.front();
		q.pop();

 		for (int i = 0; i < 4; i++) {
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if (arr[nx][ny] == 1) {
				if (cur.c == 0) {
					if (cost[cur.x][cur.y][cur.c] + 1 < cost[nx][ny][cur.c+1])
						cost[nx][ny][cur.c+1] = cost[cur.x][cur.y][cur.c] + 1, q.push({ nx,ny,1});
				}
			
			}

			if (arr[nx][ny] == 0)
				if (cost[cur.x][cur.y][cur.c] + 1 < cost[nx][ny][cur.c]) {
					cost[nx][ny][cur.c] = cost[cur.x][cur.y][cur.c] + 1, q.push({ nx,ny, cur.c });
					// cout << nx << " " << ny << " " << cost[nx][ny][0] << '\n';
				}
		}
	}
    
	int ans = min(cost[ex][ey][0], cost[ex][ey][1]);
	if (ans == INF)
		cout << -1;
	else
		cout << ans;
}