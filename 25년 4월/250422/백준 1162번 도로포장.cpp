#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define ll long long
#define MAX 10001
#define INF 987654321
using namespace std;

struct Edge {
	ll e, c;
};

struct Pair {
	ll e, c, roads;
};

int n, m, k;
ll cost[MAX][21];
vector<vector<Edge>> arr(MAX);

void solve();

bool operator< (const Pair& a, const Pair& b) {
	return a.c > b.c;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	//freopen("input.txt", "r", stdin);

	solve();

	return 0;
}
void solve() {
	cin >> n >> m >> k;


	int s, e, c;
	for (int i = 0; i < m; i++) {
		cin >> s >> e >> c;

		// 양방향
		arr[s].push_back({ e,c });
		arr[e].push_back({ s,c });
	}

	for (int i = 0; i <= n; i++)
		for (int j = 0; j < 21; j++)
			cost[i][j] = LLONG_MAX;
		
	priority_queue<Pair>pq;

	// 1번 부터 n번 도로까지
	pq.push({ 1,0, 0 }); // 초기값
	cost[1][0] = 0;

	while (!pq.empty()) {
		Pair cur = pq.top();
		pq.pop();

		if (cost[cur.e][cur.roads] <  cur.c )
			continue;

		for (auto& next : arr[cur.e]) {
			if (cur.c + next.c < cost[next.e][cur.roads])
				pq.push({ next.e , cur.c + next.c, cur.roads }), cost[next.e][cur.roads] = cur.c +next.c;
			if (cur.roads < k) {
				if (cur.c < cost[next.e][cur.roads+1])
					pq.push({ next.e , cur.c , cur.roads+1 }), cost[next.e][cur.roads+1] = cur.c;
			}
		}
	}
	ll ans = LLONG_MAX;
	for (int i = 1; i <= k; i++) 
		ans = min(ans, cost[n][i]);

	cout << ans;
}