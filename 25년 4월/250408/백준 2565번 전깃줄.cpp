#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define k 256
#define MOD 127
#define INF 987654321
#define ll long long
using namespace std;

int n;
void solve();

int dp[101] = { 0 };

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n;

	vector<pair<int,int>> arr(n);

	for (auto& i : arr)
		cin >> i.first >> i.second;

	sort(all(arr));

	//for (auto& i : arr)
	//	cout << i.second << '\n';

	for (int i = 0; i <= n; i++)
		dp[i] = 1;

	for (int i = 1; i <= n; i++)
		for (int j = 1; j < i; j++)
			if (arr[j-1].second < arr[i-1].second)
				dp[i] = max(dp[j] + 1, dp[i]);

	//cout << "-------------------------\n";
	int ans = 0;
	for (int i = 1; i <= n; i++)
		ans = max(ans, dp[i]);
		//cout << dp[i] << " ";

	cout << n - ans;
}