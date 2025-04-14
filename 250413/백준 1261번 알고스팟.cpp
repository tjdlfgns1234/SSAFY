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
string s[101];
int cost[101][101];
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,-1, 0, 1 };

void solve();

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n >> m;

	for (int i = 0; i < m; i++) cin >> s[i];
	for (int i = 0; i < m; i++) 
		for (int j = 0; j < n; j++)
			cost[i][j] = INF;

	queue <Pair> q;
	q.push({0,0,0});
	cost[0][0] = 0;

	while (!q.empty()) {
		Pair cur = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];

			if (nx < 0 || nx >= m || ny < 0 || ny >= n)
				continue;

			if (s[nx][ny] == '1') 
				if (cost[cur.x][cur.y] + 1 < cost[nx][ny])
					cost[nx][ny] = cost[cur.x][cur.y] + 1, q.push({ nx,ny,cost[cur.x][cur.y] + 1 });
			
			if (s[nx][ny] == '0')
				if (cost[cur.x][cur.y] < cost[nx][ny])
					cost[nx][ny] = cost[cur.x][cur.y], q.push({ nx,ny,cost[cur.x][cur.y]});
		}
	}

	//for (int i = 0; i < n; i++) {
	//	for (int j = 0; j < m; j++)
	//		cout << ((cost[i][j]==INF)?(- 1) : cost[i][j]) << ' ';
	//	cout << '\n';
	//}

	cout << cost[m-1][n-1];
}