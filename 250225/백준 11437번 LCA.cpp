#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 50000
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

vector<vector<int>> g(MAX);
int d[MAX + 1] = { 0 };
int p[MAX + 1] = { 0 };
bool vit[MAX + 1] = { false };

void solve();
int Lca(int x, int y);
void bfs();

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
	cin >> n;
	d[1] = 1;

	int x, y;
	for (int i = 0; i < n - 1; i++)
	{
		cin >> x >> y;
		g[x].push_back(y);
		g[y].push_back(x);
	}

	bfs();
	cin >> m;

	for (int i = 0; i < m; i++)
	{
		cin >> x >> y;
		cout << Lca(x, y) << '\n';
	}


    // cout << ans;
   //  cout << "#" << cnt++ << ' ' << ans << '\n';
}
void bfs() {
	queue <int> q;
	vit[1] = true;
	q.push(1);


	// 깊이 및 부모 기록
	while (!q.empty()) {
		int curr = q.front();
		q.pop();

		for (auto& i : g[curr])
			if (!vit[i])
				q.push(i), vit[i] = true, p[i] = curr, d[i] = d[curr] + 1;
	}
}
int Lca(int x, int y) {
	if (d[x] < d[y]) swap(x, y);
	// 더 깊은 것을 선택
	while (d[x] != d[y]) x = p[x];
	while (x != y) x = p[x], y = p[y];
	return x;
}