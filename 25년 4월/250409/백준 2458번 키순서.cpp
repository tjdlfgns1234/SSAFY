#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define K 256
#define MOD 127
#define MAX 501
#define INF 987654321
#define ll long long
using namespace std;

int n, k;
void solve();
int rev[MAX][MAX];
int g[MAX][MAX];

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n >> k;


	for (int i = 1; i < MAX; i++)
		for (int j = 1; j < MAX; j++)
			if (i == j)
				g[i][j] = 0, rev[i][j] = 0;
			else
				g[i][j] = INF, rev[i][j] = INF;

	int x, y;
	for (int i = 0; i < k; i++) {
		cin >> x >> y;
		g[x][y] = 1;
		rev[y][x] = 1;
	}
	
	for (int l = 1; l <= n; l++)
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				g[i][j] = min(g[i][j], g[i][l] + g[l][j]), rev[i][j] = min(rev[i][j],rev[i][l] + rev[l][j]);

	int ans = 0;
	for (int i = 1; i <= n; i++) {
		bool f = false;
		for (int j = 1; j <= n; j++)
			if (g[i][j] == INF && rev[i][j] == INF) {
				f = true;
				break;
			}
		if (!f)
			ans++;
	}

	cout << ans;

	//for (int i = 1; i <= n; i++) {
	//	for (int j = 1; j <= n; j++)
	//		cout << (rev[i][j] == INF ? "INF" : to_string(rev[i][j])) << " ";
	//	cout << '\n';
	//}
}