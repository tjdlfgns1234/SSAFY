#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 200'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int dp[MAX] = { 0 };

void solve();

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
	string s;
	cin >> s;

	string sa = "";

	// 사이사이에 # 추가

	for (int i = 0; i < s.length(); i++) 
		sa += '#', sa += s[i];
	sa += "#";

	int n = sa.length();

	int r = -1, p = -1;

	for (int i = 0; i < n; i++) {
		if (r < i)
			dp[i] = 0;
		else {
			int ii = 2 * p - i;
			dp[i] = min(r - i, dp[ii]);
		}
	
		while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < n &&
			sa[i - dp[i] - 1] == sa[i + dp[i] + 1])
			dp[i]++;

		if (i + dp[i] > r) {
			r = i + dp[i];
			p = i;
		}
	}

	int ans = 0; 
	for (int i = 0; i < n; i++) 
		ans = max(ans, 2 * dp[i] + 1);
	
	cout << ans / 2;
}