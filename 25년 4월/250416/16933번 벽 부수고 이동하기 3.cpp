#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100001
#define INF 987654321
using namespace std;

struct Pair {
	int x, y, c, time;
};

int n, m, k;
string arr[1001];
int cost[1001][1001][11];
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
	cin >> n >> m >> k;

	int sx, sy, ex, ey;
	// cin >> sx >> sy >> ex >> ey;

	sx = 1, sy = 1, ex = n, ey = m;
	sx--, sy--, ex--, ey--;

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			for(int l = 0; l < k+1;l++)
				cost[i][j][l] = INF;


	queue <Pair> q;
	q.push({ sx,sy,0, 0 });
	cost[sx][sy][0] = 0;

	while (!q.empty()) {
		Pair cur = q.front();
		q.pop();

		// cout <<"x : " << cur.x << " y : " << cur.y << " Time: "<< cur.time << "\n";

		if (cur.x == ex && cur.y == ey) 
			break;
		
		for (int i = 0; i < 4; i++) {
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if (arr[nx][ny] == '1') {
				if (cur.c < k) {
					if (cur.time % 2 == 0) {
						if (cur.time + 1 < cost[nx][ny][cur.c + 1])
							cost[nx][ny][cur.c + 1] = cur.time + 1, q.push({ nx,ny,cur.c+1, cur.time + 1 });
					}
					else {
						q.push({ cur.x,cur.y,cur.c, cur.time + 1 });
					}

				}
			}
			if (arr[nx][ny] == '0')
				if (cur.time + 1 < cost[nx][ny][cur.c]) {
					cost[nx][ny][cur.c] = cur.time + 1, q.push({ nx,ny, cur.c, cur.time+1 });
					// cout << nx << " " << ny << " " << cost[nx][ny][0] << '\n';
				}
		}
	}

	//for (int l = 0; l < k+1; l++) {
	//	for (int i = 0; i < n; i++) {
	//		for (int j = 0; j < m; j++)
	//			cout << (cost[i][j][l] == INF ? -1 : cost[i][j][l]) << " ";
	//		cout << '\n';
	//	}
	//	cout << '\n';
	//}



	int ans = cost[ex][ey][0];
	for (int i = 0; i < k+1; i++)
		ans = min(ans , cost[ex][ey][i]);
	if (ans == INF)
		cout << -1;
	else
		cout << ans+1;
}