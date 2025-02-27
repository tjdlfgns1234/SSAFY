#include <bits/stdc++.h>
#define ll long long
#define ull unsigned long long

using namespace std;

int cnt = 1;

void solve();

int main()
{
	
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int t;
	cin >> t;

	while(t--)
		solve();

	return 0;
}
void solve() {
	ull n, m;
	cin >> n >> m;

	vector<ull> arr(n);

	for (auto& i : arr) cin >> i;
	
	ull ans = 0;
	ull l = 1, r = 10000000000000000000;
	while (l<=r) {
		ull mid = l + (r - l) / 2;
	
		ull sum = 0;
		// cout << mid << '\n';
		for (auto& i : arr)
			sum += i / mid;

		if (sum >= m)
			ans = mid, l = mid + 1;
		else
			r = mid - 1;
	}

	cout << "#" << cnt++ << " " << ans << '\n';
}