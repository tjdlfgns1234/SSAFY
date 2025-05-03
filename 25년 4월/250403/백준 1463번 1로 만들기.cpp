#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <algorithm>
#include <stack>
#include <set>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100001
#define INF 987654321
using namespace std;

int n, ans = INF;
void solve();
void bfs(int n,int cnt);
int dp[1'000'001] = { 0 };

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n;

	for (int i = 0; i <= n; i++)
		dp[i] = INF;

	bfs(n, 0);

	//for (int i = 1; i <= n; i++)
	//	cout << dp[i] << " ";


	cout << ans;
}
void bfs(int n, int cnt) {
	if (n == 1) {
		ans = min(cnt, ans);

		return;
	}

	dp[n] = cnt;

	if (n % 3 == 0)
		if(dp[n/3] > cnt+1)
			bfs(n / 3, cnt + 1);
	if (n % 2 == 0)
		if (dp[n / 2] > cnt + 1)
			bfs(n / 2, cnt + 1);
	
	if(dp[n-1] > cnt+1)
		bfs(n - 1, cnt + 1);
}
