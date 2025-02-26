#include <bits/stdc++.h>
#define MAX 10000
#define SUM(a) (a*(a+1)/2)
using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

ll n, cnt = 1;

void solve();
void init();

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	cin >> t;

	while (t--)
		solve(), init();

	return 0;
}
void solve() {
	cin >> n;

	ull ans = -1;

    // /2라서 2를 곱해야함
	ull r = 2000000000, l = 0;

	while (l <= r) {
		ll mid = l + (r - l) / 2;

		// cout << l << ' ' << r << ' ' << SUM(mid) << '\n';

		if (SUM(mid) < n)
			l = mid+1;
		else if (SUM(mid) > n)
			r = mid-1;
		else {
			ans = mid;
			break;
		}

	}


	// cout << ans;
	if(ans == (ull)-1)
		cout << "#" << cnt++ << ' ' << -1 << '\n';
	else
		cout << "#" << cnt++ << ' ' << ans << '\n';
}
void init() {
	// memset(arr,0, sizeof(arr);
	// memset(dp, false , sizeof(dp));
}
