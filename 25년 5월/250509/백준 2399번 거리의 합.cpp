#include <iostream>
#include <vector>
#define ll long long
using namespace std;

void solve();

int n;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	solve();

	return 0;
}
void solve() {
	cin >> n;
	
	vector<int> arr(n);

	for (auto&i : arr) cin >> i;

	ll ans = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			ans += abs(arr[i] - arr[j]);
	
	cout << ans;
}