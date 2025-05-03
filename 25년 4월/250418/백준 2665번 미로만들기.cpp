#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <string>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100001
#define INF 987654321
using namespace std;

struct Pair {
	int x, y, c;
};

int n, m, k;
string arr[51];
int cost[51][51];
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
	cin >> n;

	int sx, sy, ex, ey;
	// cin >> sx >> sy >> ex >> ey;

	sx = 1, sy = 1, ex = n, ey = n;
	sx--, sy--, ex--, ey--;

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cost[i][j] = INF;


	queue <Pair> q;
	int p = arr[sx][sy] - '0';
	p = !p;
	q.push({ sx,sy,p,});
	cost[sx][sy] = p;

	while (!q.empty()) {
		Pair cur = q.front();
		q.pop();

		// cout <<"x : " << cur.x << " y : " << cur.y << " Time: "<< cur.time << "\n";

		for (int i = 0; i < 4; i++) {
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			if (arr[nx][ny] == '0') {
				if (cur.c + 1 < cost[nx][ny])
					cost[nx][ny] = cur.c + 1, q.push({ nx,ny,cur.c + 1 });
			}
			if (arr[nx][ny] == '1')
				if (cur.c < cost[nx][ny]) {
					cost[nx][ny] = cur.c, q.push({ nx,ny, cur.c });
					// cout << nx << " " << ny << " " << cost[nx][ny][0] << '\n';
				}
		}
	}

	//for (int i = 0; i < n; i++) {
	//	for (int j = 0; j < n; j++) 
	//		cout << (cost[i][j] == INF ? -1 : cost[i][j]) << " ";
	//	
	//	cout << '\n';
	//}



	int ans = cost[ex][ey];

	cout << ans;
}