#include <bits/stdc++.h>
#define MAX 10000

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

vector<vector<int>> g(MAX);
int d[MAX + 1] = { 0 };
int p[MAX + 1][21] = { 0 };
bool vit[MAX + 1] = { false };
int n, m, q, w, cnt = 1;

void solve();
int Lca(int x, int y);
void bfs();
int get_size(int start);
void init();

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	cin >> t;

	while (t--)
		solve(), init();

	return 0;
}
void solve() {

	cin >> n >> m >> q >> w;
	d[1] = 1;

	int x, y;
	for (int i = 0; i < m; i++)
	{
		cin >> x >> y;
		// 항상 부모 자식순
		g[x].push_back(y);
		// g[y].push_back(x);
	}

	bfs();

	int div = n, h = 0;

	while (div > 1) {
		div /= 2;
		h++; // 높이가 얼마나 되는지
	}

	for (int i = 1; i <= h; i++)
		for (int j = 2; j <= n; j++) // 루트는 1이므로 제외
			if (p[j][i - 1]) // 2^n번째 조상을 저장
				p[j][i] = p[p[j][i - 1]][i - 1];

	// cin >> m;

	//for (int i = 0; i < m; i++)
	//{
	//	cin >> x >> y;
	//	cout << Lca(x, y) << '\n';
	//}


	// cout << ans;
   cout << "#" << cnt++ << ' ' << Lca(q,w) << ' ' << get_size(Lca(q, w)) << '\n';
}
void init() {

	for (int i = 0; i < n + 1; i++)
		g[i].clear();

	memset(d, 0, sizeof(d));
	memset(p, 0, sizeof(p));
	memset(vit, false, sizeof(vit));
}
int get_size(int start) {

	queue <int> q;
	vit[start] = true;
	q.push(start);
	memset(vit, false, sizeof(vit));

	int sum = 1; // 서브트리의 크기 수

	while (!q.empty()) {
		int curr = q.front();
		q.pop();

		for (auto& i : g[curr])
			if (!vit[i]) 
				q.push(i), vit[i] = true, sum++;
	}
	return sum;
}
void bfs() {
	// 루트는 1번
	queue <int> q;
	vit[1] = true;
	// d[1] = 0; 이미 0임
	q.push(1);

	// 깊이 및 부모 기록
	while (!q.empty()) {
		int curr = q.front();
		q.pop();

		for (auto& i : g[curr])
			if (!vit[i]) {
				q.push(i), vit[i] = true;
				p[i][0] = curr, d[i] = d[curr] + 1; // 바로 위 조상을 기록
			}
	}
}
int Lca(int x, int y) {
	if (d[x] < d[y]) swap(x, y);
	// 더 깊은 것을 선택

	int diff = d[x] - d[y];

	for (int i = 0; diff > 0; i++) { // 깊이를 맞춰줌
		if (diff & 1)
			x = p[x][i];
		diff = diff >> 1; // 2^n번째로 올려줌
	}

	if (x != y) { // x와 y가 같지 않을 경우
		for (int i = 20; i >= 0; i--)
			if (p[x][i] && p[x][i] != p[y][i]) {
				x = p[x][i];
				y = p[y][i];
			}
		x = p[x][0];
	}


	return x;
}