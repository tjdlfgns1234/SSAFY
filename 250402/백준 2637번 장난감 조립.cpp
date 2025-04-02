#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 101
using namespace std;

struct Edge {
	int e, cost;
};

int n, m;
vector<vector<Edge>> g(MAX);
int indeg[MAX] = { 0 };
int cp[MAX] = { 0 };
int dp[MAX] = { 0 };

void solve();
void calc(int s);

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n >> m;
	int x, y, k;
	for (int i = 1; i <= m; i++) {
		cin >> x >> y >> k;

		// 단방향
		g[y].push_back({x,k}), indeg[x]++;
	}
	for (int i = 1; i <= n; i++) {
		if (indeg[i] == 0) // indeg가 0인 정점 탐색
			calc(i);
	}
	// cout << ans;
}
void calc(int s)
{
	queue<int> q;

	// init
	memset(dp, 0, sizeof(dp));
	dp[s] = 1;

	for (int i = 1; i <= n; i++) cp[i] = indeg[i];

	
	for (int i = 1; i <= n; i++) 
		if (indeg[i] == 0) // indeg가 0인 정점 삽입
			q.push(i);
	

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (auto& next : g[cur]) {
			int e = next.e, cost = next.cost;

			dp[e] += dp[cur] * cost;
			cp[e]--;

			if (!cp[e])
				q.push(e);
		}
	}
	//cout << "-----------------------\n";
	//for (int i = 1; i <= n; i++) {
	//	cout << dp[i] << " ";
	//}
	//cout << "\n-----------------------\n";

	cout << s << " " << dp[n] << '\n';
}
