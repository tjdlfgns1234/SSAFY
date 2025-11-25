#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 2e9
#define sum(a) (a*(a+1)/2)

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

struct Edge {
	int e, cost, time;
};

struct Status {
	int cur, cost, time;
};


constexpr int MAX = 101;
constexpr int MAX_MONEY = 10001;

void solve();
void dijstra(int s);
void init();
/*
    P4, Dijktra

	방향 그래프
	최대 M원까지의 비용만 여행비로 부담
	M원 이하로 사용하면서 도착할 수 있는 가장 빠른길
	가장 짧은 소요시간 출력


	시작점은 1번, 도작점은 N번
*/

vector<vector<Edge>> g(MAX);
int dp[MAX][MAX_MONEY]; // i도착점에 j원을 사용하여 도착한 시간

int n, m, k, curTime;

bool operator<(const Edge x, const Edge y) {
	if (x.cost == y.cost)
		return x.time < y.time;
	return x.cost < y.cost;
}

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	cin >> t;

	while (t--)
		init(), solve();

	return 0;
}
void solve() {
	cin >> n >> m >> k;

	int u, v, c, d;
	for (int i = 0; i < k; i++) {
		cin >> u >> v >> c >> d;
		
		// 방향 그래프
		g[u].push_back({v, c, d});
	}

	for (int i = 1; i < 101; i++) // 간선 정렬
		sort(all(g[i]));

	dijstra(1);
}
void dijstra(int s) {
	queue<Status> q;
	q.push({ s, 0, 0 });
	dp[s][0] = 0;
	while (!q.empty()) {
		Status cur = q.front();
		q.pop();

		if (dp[cur.cur][cur.cost] < cur.time)
			continue;

		if (curTime  < cur.time)
			continue;

		for (auto i : g[cur.cur]) {
			if (cur.cost + i.cost <= m && cur.time + i.time < dp[i.e][cur.cost + i.cost]) {

				// cout << "cur :" << cur.cur << ", next : " << i.e << ", cost : " << cur.cost + i.cost << '\n';

				dp[i.e][cur.cost + i.cost] = cur.time + i.time;

				if (cur.cur == n) {
					// 도착점일 경우
					curTime = cur.time;
					continue;
				}

				q.push({ i.e, cur.cost + i.cost, cur.time + i.time });
			}
		}
	}


	//for (int j = 1; j < 31; j++) {
	//	if (dp[n][j] != INF) // (장소, 돈, 시간)
	//		cout << "(" << n << ", " << dp[n][j] << ", " << j << ") ";
	//	//else
	//	//	cout << "INF" << ' ';
	//}

	int ans = INF;
	for (int i = 0; i < MAX_MONEY; i++)
		ans = min(ans, dp[n][i]);

	if (ans != INF) cout << ans << '\n';
	else cout << "Poor KCM" << '\n';
}
void init() {
	curTime = INF;

	for (int i = 0; i < MAX; i++)
		g[i].clear();

	for (int i = 0; i < MAX; i++)
		for (int j = 0; j < MAX_MONEY; j++)
			dp[i][j] = INF;
}