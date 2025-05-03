#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 10001
using namespace std;

struct Edge {
	int e, cost;
};


int n;
int cost[MAX];
int prereq_count[MAX];
vector<vector<int>> g(MAX);
int indeg[MAX] = { 0 };
int dp[MAX] = { 0 };

void solve();

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> cost[i] >> prereq_count[i];
		int x;
		for (int j = 0; j < prereq_count[i]; j++) {
			cin >> x;

			// 단방향과 차수 표시
			g[x].push_back(i), indeg[i]++;
		}
	}

	queue<int> q;

	for (int i = 1; i <= n; i++) {
		if (indeg[i] == 0) // indeg가 0인 정점 삽입
			q.push(i);
	}


	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		// cout << cur <<  '\n';

		for (auto& next : g[cur]) {
			int e = next;
		
			dp[e] = max(dp[e],dp[cur] + cost[cur]);
			indeg[e]--;

			if (!indeg[e])
				q.push(e);

		}
	}

	int ans = 0;
	for (int i = 1; i <= n; i++) {
		// cout << dp[i] + time[i] << ' ';
		ans = max(ans, dp[i] + cost[i]);
	}
	cout << ans;
} 