#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define ll long long
#define MAX 2501
#define INF 987654321
using namespace std;

struct Edge {
	ll e, c;
};

struct Pair {
	ll e, c, oil;
};

int n, m, k;
ll dist[MAX][MAX];
ll oil[MAX];
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
	cin >> n >> m;

	for (int i = 1; i <= n; i++)  cin >> oil[i];

	int s, e, c;
	for (int i = 0; i < m; i++) {
		cin >> s >> e >> c;

		// 양방향
		arr[s].push_back({ e,c });
		arr[e].push_back({ s,c });
	}

	for (int i = 0; i < MAX; i++)
		for (int j = 0; j < MAX; j++)
			dist[i][j] = LLONG_MAX;

	priority_queue<Pair>pq;

	// 1번 부터 n번 도로까지
	pq.push({ 1,0, oil[1]}); // 초기값
	dist[1][oil[1]] = 0;

	while (!pq.empty()) {
		Pair cur = pq.top();
		pq.pop();

		if (dist[cur.e][cur.oil] < cur.c)
			continue;

		for (auto& next : arr[cur.e]) {
			ll next_e = next.e;
			ll d = next.c;
			ll next_oil = min(cur.oil, oil[next_e]);
			ll next_c = cur.c + cur.oil * d; // 더 작은 걸로 주유해서 옴 (무조건 최적)

			if (next_c < dist[next_e][next_oil])
				pq.push({ next_e, next_c, next_oil }), dist[next_e][next_oil] = next_c;
		}
	}
	ll ans = LLONG_MAX;
	for (int i = 1; i <= MAX; i++) 
		ans = min(ans, dist[n][i]);
	

	cout << ans;
}