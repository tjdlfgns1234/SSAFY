#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100001
#define INF 987654321
using namespace std;

int n, m;
int arr[501][501];
int dp[501][501];
int ans = 0;
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

void solve();
int dfs(int x, int y);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n >> m;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> arr[i][j], dp[i][j] = -1;


	cout << dfs(0, 0) << '\n';
	//for (int i = 0; i < n; i++) {
	//	for (int j = 0; j < m; j++)
	//		cout << dp[i][j] << " ";
	//	cout << '\n';
	//}
	//cout << test;
	
}
int dfs(int x, int y) {
	if (x == n - 1 && y == m - 1) {
		return 1;
	}
	// test++;

	if (dp[x][y] != -1) return dp[x][y];

	int ret = 0;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || nx >= n || ny < 0 || ny >= m)
			continue;

		if (arr[nx][ny] < arr[x][y])
			ret += (dp[nx][ny] = dfs(nx,ny));
	}

	
	return dp[x][y] = ret;
}