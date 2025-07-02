#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 100'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

struct p {
	int to, dist;
};

bool operator< (const p& a, const p& b) {
	return a.dist > b.dist; // C++는 max-heap을 사용하기 때문
}

void solve();
vector<vector<p>> g(100'001);
int dist[100'001];
bool vit[100'001] = { false };

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	// cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	int n, m;
	cin >> n >> m;

	int a, b, c;
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;
		
		g[a].push_back({ b,c });
		g[b].push_back({ a,c });
	}

	for (int i = 1; i <= n; i++) dist[i] = INF;

	int ans = 0;
	priority_queue<p> pq;

	dist[1] = 0;
	pq.push({ 1, 0 });

	while (!pq.empty()) {
	
		p cur = pq.top();
		pq.pop();

		if (vit[cur.to]) continue;

		vit[cur.to] = true;
		ans += cur.dist;
	
		for (auto& i : g[cur.to]) {
			if (i.dist < dist[i.to]) {
				dist[i.to] = i.dist;
				pq.push({ i.to, dist[i.to] });
			}
		}
	}
	cout << ans;
}