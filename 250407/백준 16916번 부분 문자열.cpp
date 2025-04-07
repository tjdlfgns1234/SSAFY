#include<bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define k 347
#define MOD 1000000007
#define INF 987654321
#define ll long long
using namespace std;

string a, b;
int ans = 0;
ll arr[1'000'001] = { 0 };
void solve();

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> a >> b;

	ll key = 0;

	arr[0] = 1;

	int n = a.size();
	int m = b.size();
	for (int i = 1; i <= 1'000'000; i++)
		arr[i] = (arr[i - 1] * k) % MOD;


	for (int i = 0; i < m; i++) 
		key = (key + b[i] * arr[m-1-i]) % MOD;
	

	ll hash = 0;

	for (int i = 0; i < m; i++) 
		hash = (hash + a[i] * arr[m-1-i]) % MOD;
	

	for (int i = 0; i <=  n-m; i++) {
		// cout << key << " " << hash << '\n';
		if (key == hash) {
			if (a.substr(i, m) == b) {
				cout << 1;
				return;
			}
		}
		if (i + m < n) {
			hash = (hash - a[i] * arr[m - 1] % MOD + MOD) % MOD;
			hash = (hash * k) % MOD;
			hash = (hash + a[i + m]) % MOD;
		}
	}
	cout << 0;
}