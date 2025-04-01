#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 4000001
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


void solve();

int n;
int dp[10001] = { 0 };

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	solve();

	return 0;
}
void solve() {
	cin >> n;

	int ans = 0;


	for (int i = 1; i <= n; i++) {
		int tmp = 1;
		for (int j = 2; j * j <= i; j++) {
			if (i % j == 0)
				tmp++;
		}
		ans += tmp;
	}

	cout << ans;
}