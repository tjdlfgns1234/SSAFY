#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int p[MAX][21] = {0};
int d[MAX] = { 0 };

vector<vector<int>> arr(MAX);

void solve();
void dfs(int cur);
int get_depth(int n);
int lca(int a,int b);

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
	int n;
	cin >> n;

	int a, b;
	for (int i = 0; i < n-1; i++) {
		cin >> a >> b;

		arr[a].push_back(b);
		arr[b].push_back(a);
	}

	d[1] = 1;
	dfs(1); // root는 1로 고정

	int h = get_depth(n);

	for (int i = 1; i <= h; i++) 
		for (int j = 2; j <= n; j++) 
			if (p[j][i-1]) 
				p[j][i] = p[p[j][i - 1]][i-1];
			
		
	int m;
	cin >> m;

	int s, e;
	for (int i = 0; i < m; i++) {
		cin >> s >> e;

		cout << lca(s, e) << '\n';
	}
}
int get_depth(int n) {
	int ret = 0;

	while (n > 0) {
		ret++;
		n = n / 2;
	}
	return ret;
}
void dfs(int cur) {
	for (auto& i : arr[cur])
		if (!d[i])
			d[i] = d[cur] + 1, p[i][0] = cur, dfs(i);
}
int lca(int x, int y) {
	if (d[x] < d[y]) swap(x, y);

	int diff = d[x] - d[y];

	for (int i = 0; diff > 0; i++) {
		if (diff & 1)
			x = p[x][i];
		diff = diff >> 1;
	}

	if (x != y) { // 깊이를 맞췄는데 다를 경우, 테이블에 저장되어 있는 
		for (int i = 20; i >= 0; i--) {
			if (p[x][i] != p[y][i]) {
				x = p[x][i];
				y = p[y][i];
			}
		}
		x = p[x][0];
	}

	return x;
}