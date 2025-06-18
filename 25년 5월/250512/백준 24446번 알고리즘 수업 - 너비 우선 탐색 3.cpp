#include <iostream>
#include <vector>
#include <queue>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define ll long long
#define MAX 100'001
#define INF 987654321
using namespace std;

struct Edge {
	ll e, c;
};

int n, m, start;
vector<vector<int>> arr(MAX);
int vit[MAX] = { false };

void solve();

int main() {
	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	//freopen("input.txt", "r", stdin);

	solve();

	return 0;
}
void solve() {
	cin >> n >> m >> start;

	int s, e, c;
	for (int i = 0; i < m; i++) {
		cin >> s >> e;

		// 양방향
		arr[s].push_back(e);
		arr[e].push_back(s);
	}

	for (int i = 1; i <= n; i++)
		vit[i] = -1;
		// sort(rall(arr[i]));
	
	queue<int> q;
	q.push(start);
	vit[start] = 0;

	
	int cnt = 1;
	while (!q.empty()) {
		int curr = q.front();
		q.pop();

		// vit[curr] = cnt++;
		// cout << curr << '\n';
		for (auto& i : arr[curr]) {
			// cout << i << '\n';
			if (vit[i] == -1) {
				vit[i] = vit[curr] + 1;
				q.push(i);
			}
		}
	}

	for (int i = 1; i <= n; i++)
		cout << vit[i] << '\n';

}