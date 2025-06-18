#include<bits/stdc++.h>
#include<unordered_set>
#include<unordered_map>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define k 347
#define MOD 1000000007
#define MAX 10'001
#define INF 987654321
#define ll long long
using namespace std;

int n, m;
vector<vector<int>> arr(MAX);
int d[MAX] = { 0 };
int p[MAX] = { 0 };
void solve();
void bfs();
int lca(int x, int y);

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n;

	int x, y;
	for (int i = 0; i < n-1; i++) {
		cin >> x >> y;
		arr[x].push_back(y);
		arr[y].push_back(x);
	}

	bfs(); // 깊이 탐색

	cin >> m;
	for(int i = 0; i < m;i++)
		cin >> x >> y, cout << lca(x, y) << '\n';


}
void bfs() {
	int root = 1; // 루트는 1로 가정

	queue<int> q;
	q.push(root);
	d[root] = 1;
	p[root] = 1;
	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (auto& i : arr[cur]) 
			if (!d[i])
				q.push(i), p[i] = cur, d[i] = d[cur] + 1;
	}
}
int lca(int x, int y) {
	if (d[x] < d[y]) swap(x, y);

	while (d[x] != d[y])x = p[x];
	while (x != y) x = p[x], y = p[y];

	return x;
}