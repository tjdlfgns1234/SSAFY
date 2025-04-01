#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <algorithm>
#include <stack>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 501

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

struct Edge{
	int e, c;
};

vector<vector<int>> g(MAX);
bool vit[MAX + 1] = { false };
ll ans[MAX + 1] = { 0 };
ll cost[MAX + 1] = {0};
int indeg[MAX + 1] = { 0 };
stack<int> rev;
int n, m, cnt = 1;

void solve();

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	//cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	cin >> n;

	int x, y;
	for (int i = 1; i <= n; i++) {
		cin >> x;
		y = 0;
		cost[i] = x;

		// 단방향
		while (1) {
			cin >> y;

			if (y == -1)
				break;

			g[y].push_back(i);
			indeg[i]++;
		}
		// g[y].push_back(x);
	}

	queue<int> q;
	int chk = 0;

	for (int i = 1; i <= n; i++)
		if (indeg[i] == 0)
			q.push(i), chk++;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();
	
		// cout << cur << " ";

		for (auto& next : g[cur]) {
			indeg[next]--;
			if (ans[next] == 0)
				ans[next] = cost[cur]+ ans[cur];
			else
				ans[next] = max(ans[next], cost[cur] + ans[cur]);

			if (indeg[next] == 0) {
				q.push(next); 
				chk++;
			}
		}
	}
	// cout << chk << " " << n << '\n';
	

	for (int i = 1; i <= n; i++)
		cout << ans[i] + cost[i] << "\n";
}