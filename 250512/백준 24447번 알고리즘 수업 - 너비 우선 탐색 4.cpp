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

int n, m, start;
vector<vector<int>> arr(MAX);
ll vit[MAX] = { 0 };
ll cost[MAX] = { 0 };

void solve();

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
		sort(all(arr[i])), vit[i] = -1;;
	
	queue<int> q;
	q.push(start);
	vit[start] = 1;
	cost[start] = 0;
	
	int cnt = 1;
	while (!q.empty()) {
		int curr = q.front();
		q.pop();

		vit[curr] = cnt++;
		// cout << curr << '\n';
		for (auto& i : arr[curr]) {
			// cout << i << '\n';
			if (vit[i]==-1) {
				vit[i] = 1;
				cost[i] = cost[curr] + 1;
				q.push(i);
			}
		}
	}

	ll ans = 0;
	for (int i = 1; i <= n; i++)
		ans += vit[i] * cost[i];
		// cout << vit[i]*cost[i] << '\n';
	cout << ans;
}