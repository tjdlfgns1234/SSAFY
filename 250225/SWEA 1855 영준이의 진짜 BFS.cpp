#include <iostream>
#include <vector>
#include <queue>
#include <string>
#define SIZE 100001
#define ll long long

using namespace std;

int n, cnt = 1;
vector<int> g[SIZE];
int par[SIZE][20];
int d[SIZE];
bool vit[SIZE];

void init();
void solve();
int lca(int x, int y, int cnt);
ll bfs();

int main() {
	
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);
	int t = 1;
	cin >> t;
	while(t--)
		solve();

	return 0;
}
void solve() {
	init();
	cin >> n;

	par[1][0] = 0;
	d[1] = 0;

	int k;
	for (int i = 2; i <= n; i++) {
		cin >> k;
		g[k].push_back(i);
		par[i][0] = k;
		d[i] = d[k] + 1;
	}
	for (int y = 1; y < 20; y++) 
		for (int x = 1; x <= n; x++) 
			par[x][y] = par[par[x][y - 1]][y - 1];
		
	cout << "#" << cnt++ << " " << bfs() << '\n';
}
void init() {
	for(int i = 0; i < SIZE; i++)
		g[i].clear();

	memset(d, 0, sizeof(d));
	memset(vit, false, sizeof(vit));
}
int lca(int x, int y, int cnt) {
	if (d[x] > d[y]) // depth가 더 깊은게 y로
		swap(x, y);
	if (par[y][0] == x) 
		return 1;
	
	for (int i = 19; i >= 0; i--) 
		if (d[y] - d[x] >= (1 << i)) 
			y = par[y][i], cnt += (1 << i);
	if (par[y][0] != par[x][0]) 
		for (int i = 19; i >= 0; i--)
			if (par[x][i] != par[y][i]){
				cnt += 2 * (1 << i);
				x = par[x][i], y = par[y][i];
			}
		
	if (par[x][0] == par[y][0])
		return cnt + 2;
}
ll bfs() {
	ll ret = 0;
	int pre, cur;
	queue<int> q;
	q.push(1);
	vit[1] = true;
	pre = 1;
	while (!q.empty()) {
		int x = q.front();
		q.pop();

		for (auto next : g[x]) {
			if (vit[next])
				continue;
			q.push(next);
			cur = next;
			vit[next] = true;
			ret += lca(pre, cur, 0);
			pre = cur;
		}
	}
	return ret;
}