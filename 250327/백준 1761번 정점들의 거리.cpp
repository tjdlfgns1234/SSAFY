#include <iostream>
#include <queue>
#include <algorithm>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 40001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

struct Edge{
	int e, c;
};

vector<vector<Edge>> g(MAX);
int d[MAX + 1] = { 0 };
int p[MAX + 1][21] = { 0 };
int dp[MAX + 1] = { 0 };
bool vit[MAX + 1] = { false };

void solve();
void getDepth(int &div, int &h);
int Lca(int x, int y);
void bfs();

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

	int n, m;
	cin >> n;
	d[1] = 1;

	int s, e, c;
	for (int i = 0; i < n - 1; i++)
	{
		cin >> s >> e >> c;
		g[s].push_back({ e,c });
		g[e].push_back({ s,c });
	}

	bfs();

	int div = n, h = 0;

	getDepth(div, h);

	for (int i = 1; i <= h; i++)
		for (int j = 2; j <= n; j++) // 루트는 1이므로 제외
			if (p[j][i - 1]) // 2^n번째 조상을 저장
				p[j][i] = p[p[j][i - 1]][i - 1];

	cin >> m;

	for (int i = 0; i < m; i++)
	{
		cin >> s >> e;
		cout << dp[s] + dp[e] - 2*dp[Lca(s, e)] << '\n';
	}

	//for (int i = 1; i <= n; i++) 
	//	cout << dp[i] << " ";
	
	

	// cout << ans;
   //  cout << "#" << cnt++ << ' ' << ans << '\n';
}
void getDepth(int &div, int &h)
{
	while (div > 1) {
		div /= 2;
		h++; // 높이가 얼마나 되는지
	}
}
void bfs() {
	// 루트는 1번
	queue <int> q;
	vit[1] = true;
	dp[1] = 0; //  이미 0임
	q.push(1);

	// 깊이 및 부모 기록
	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (auto& i : g[cur])
			if (!vit[i.e]) {
				// 트리는 하나의 경로만 가지고 있다
				dp[i.e] = dp[cur] + i.c;
				q.push(i.e), vit[i.e] = true;
				p[i.e][0] = cur, d[i.e] = d[cur] + 1; // 바로 위 조상을 기록
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