#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 10'000'000'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

/*
    G5, DFS
*/

int n;
int arr[101];

void dfs(int next, int cnt, int start);
vector<int> sel, ans;
int chk[101];

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
	cin >> n;

	for (int i = 1; i <= n; i++) cin >> arr[i];

	
	// 위아래 같은거 먼저 추가
	for (int i = 1; i <= n; i++)
		if (arr[i] == i)
			ans.push_back(i);
	
	for (int i = 1; i <= n; i++) {
		if (arr[i] != i) {
			sel.push_back(i);
			chk[i]++;
			dfs(arr[i], 0, i);
			chk[i]--;
			sel.pop_back();
		}
	}

	sort(all(ans));
	ans.erase(unique(all(ans)), ans.end());

	cout << ans.size() << '\n';

	for (auto& i : ans) cout << i << '\n';
}
void dfs(int next, int cnt, int start) {
	if (start == next) {
		for (auto& i : sel) ans.push_back(i);
		// cout << "CORRET" << '\n';
		return;
	}

	// cout << cnt << " " << next << '\n';

	if (chk[arr[next]]!= 2) {
		sel.push_back(next);
		chk[next]++;
		dfs(arr[next], cnt + 1, start);
		chk[next]--;
		sel.pop_back();
	}
}