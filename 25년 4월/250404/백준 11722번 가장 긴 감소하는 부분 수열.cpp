#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 1001
#define INF 987654321
using namespace std;

int n;
int arr[MAX] = { 0 };
int dp[MAX] = { 0 };
void solve();

int main() {
	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> arr[i], dp[i] = 1;;

	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			if (arr[i] > arr[j])
				dp[j] = max(dp[j], dp[i] + 1);
		}
	}

	/*for (int i = 0; i < n; i++)
		cout << dp[i] << " ";*/
	int ans = 0;
	for (int i = 0; i < n; i++)
		ans = max(ans, dp[i]);

	cout << ans;
}