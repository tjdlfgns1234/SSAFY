#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 10'001
#define INF 10'000'000'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

struct Road {
	int s, e, c;
};

/*
	S1, dp, SPA
	투 포인터로 배열을 넓혀가면서
	O(1)로 개수 여부를 확인하는게 핵심인 문제
*/


int n, d;
int dp[13][MAX] = { 0 };


bool operator<(const Road& a, const Road& b) {
	if (a.s == b.s)
		return a.e < b.e;
	return a.s < b.s;
}

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
	cin >> n >> d;

	vector<Road> arr(n+1);

	for (int i = 1; i <= n; i++) cin >> arr[i].s >> arr[i].e >> arr[i].c;


	// 초기식 초기화
	for (int i = 0; i <= d; i++) dp[0][i] = i;
	
	sort(arr.begin() + 1, arr.end());

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j < arr[i].e; j++) dp[i][j] = dp[i - 1][j];
		for (int j = arr[i].e; j <= d; j++)  dp[i][j] = min(dp[i - 1][j], dp[i - 1][arr[i].s] + arr[i].c + j - arr[i].e);
	}


	//for (int j = e; j <= d; j++)
	//	cout << dp[5][j] << '\n';


	cout << dp[n][d];
}