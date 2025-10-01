#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 1e9
#define sum(a) (a*(a+1)/2)

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

constexpr int MAX = 201;

void solve();

vector<int> arr(MAX);
int dp[MAX] = { 0 };


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
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) cin >> arr[i];

	/*
		번호 순서대로
		어떻게?

		1. naive한 방법
		3 7 4 2 6 1 4

		3 6 4 5 2 6 1
	
		3 4 5 2 6 1 7

		1 3 4 5 2 6 7

		1 2 3 4 5 6 7
	*/

	
	for (int i = 0; i < n; i++) dp[i] = 0;

	for (int i = 0; i < n; i++) {
		if (dp[i] == 0) dp[i] = 1;
		for (int j = i + 1; j < n; j++)
			if (arr[i] < arr[j])
				dp[j] = max(dp[i] + 1, dp[j]);
	}
	
	cout << n - *max_element(dp, dp + n);
}