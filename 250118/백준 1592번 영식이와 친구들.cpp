#include <iostream>
#include <algorithm>
#include <string.h>
#include <vector>
#include <queue>
#include <stack>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 4000001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

int dp[51] = { 0 };

int n, m, l;
int ans = 0;


int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	solve();

	return 0;
}
void solve() {
	cin >> n >> m >> l;

	int target = 0;
	while (1) {
		// cout << target + 1 << '\n';
		dp[target]++;

		if (dp[target] == m)
			break;
		ans++;
		int nx;
		if (dp[target] & 1) 
			nx = (target + l) % n;
		else
			nx = (target-l+n) % n;

		target = nx;

	}
	cout << ans;
}