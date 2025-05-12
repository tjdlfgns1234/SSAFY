#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define ll long long
#define MAX 100'001
#define INF 987654321
using namespace std;

struct Edge {
	ll e, c;
};

int n, m, start, cnt = 1;
vector<vector<int>> arr(MAX);
ll vit[MAX] = { 0 };
ll depth[MAX] = { 0 };

void solve();
void dfs(int cur);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	//freopen("input.txt", "r", stdin);

	solve();

	return 0;
}
void solve() {
	cin >> n >> m >> start;

	int s, e, c;
	for (int i = 0; i < m; i++) {
		cin >> s >> e;

		// 양방향
		arr[s].push_back(e);
		arr[e].push_back(s);
	}

	for (int i = 1; i <= n; i++)
		sort(all(arr[i])), depth[i] = -1;;
	
	depth[start] = 0;
	dfs(start);

	ll ans = 0;
	for (int i = 1; i <= n; i++)
		ans += depth[i] * vit[i];
		// cout << depth[i]*vit[i] << '\n';
	cout << ans;
}
void dfs(int cur) {
	
	vit[cur] = cnt++;

	for (auto& i : arr[cur]) 
		if (depth[i]==-1)
			depth[i] =depth[cur]+1,dfs(i);

}