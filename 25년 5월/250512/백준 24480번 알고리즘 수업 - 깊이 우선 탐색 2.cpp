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
ll cost[MAX] = { 0 };

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
		sort(rall(arr[i]));// vit[i] = -1;;
	
	dfs(start);

	for (int i = 1; i <= n; i++)
		cout << vit[i] << '\n';
}
void dfs(int cur) {
	vit[cur] = cnt++;

	for (auto& i : arr[cur]) 
		if (!vit[i])
			vit[i] = true, dfs(i);

}