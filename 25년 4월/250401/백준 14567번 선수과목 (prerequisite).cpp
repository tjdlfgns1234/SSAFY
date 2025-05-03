#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <algorithm>
#include <stack>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 1001

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
int ans[MAX + 1] = {0};
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
	cin >> n >> m;

	int x, y;
	for (int i = 0; i < m; i++) {
		cin >> x >> y;

		// 단방향
		g[x].push_back(y);
		indeg[y]++;
		// g[y].push_back(x);
	}

	queue<int> q;

	for (int i = 1; i <= n; i++)
		if (indeg[i] == 0)
			q.push(i), ans[i] = 1;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();
	
		for (auto& next : g[cur]) {
			indeg[next]--;

			if (indeg[next] == 0) {
				q.push(next);
				ans[next] = ans[cur] + 1;
			}
		}
	}


	for (int i = 1; i <= n; i++)
		cout << ans[i] << " ";
}