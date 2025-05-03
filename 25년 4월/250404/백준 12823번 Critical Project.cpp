#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100001
#define INF 987654321
using namespace std;

int n, m;
vector<vector<int>> g(MAX);
int in[MAX] = { 0 }, out[MAX] = { 0 };
int layer[MAX] = { 0 }, fp[MAX] = { 0 }, ln[MAX];
set<int> s;

void solve();
void topological_sort();

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n >> m;
	int x, y;
	for (int i = 1; i <= m; i++) {
		cin >> x >> y;

		// 단방향
		g[x].push_back(y), out[x]++, in[y]++;
	}

	topological_sort();

	// cout << ans;
}
void topological_sort()
{
	queue<int> q;

	for (int i = 1; i <= n; i++)
		if (!in[i]) // indeg가 0인 정점 삽입
			q.push(i);


	// 위상 정렬 + layer
	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (auto& i : g[cur]) {
			layer[i] = max(layer[cur] + 1, layer[i]);
			if (--in[i] == 0)
				q.push(i);
		}
	}

	for (int i = 1; i <= n; i++) fp[i] = INF;

	for (int i = 1; i <= n; i++)
		if (out[i] == 0) // DeadEnd
			fp[i] = INF;
		else
			for (auto& next : g[i])
				fp[i] = min(fp[i], layer[next]);

	for (int i = 1; i <= n; i++)
		ln[layer[i]]++;


	vector<int> ans;

	for (int p = 1; p <= n; p++) {
		bool f = false;
		if (ln[layer[p]] == 1) { // 1번 조건 만족
			for (int q = 1; q <= n; q++)
				if (layer[q] < layer[p] && fp[q] > layer[p]) {
					f = true;
					break;
				}
		}
		else
			f = true;
		if (!f)
			ans.push_back(p);
	}




	sort(all(ans));

	cout << ans.size() << '\n';

	// cout << "ans : ";
	for (auto& i : ans)
		cout << i << " ";
}
