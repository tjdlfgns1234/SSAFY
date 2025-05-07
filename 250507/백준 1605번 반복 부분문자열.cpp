#include<bits/stdc++.h>
#include<unordered_set>
#include<unordered_map>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define k 347
#define k2 31
#define MOD 1000000007
#define MOD2 1234567891
#define MAX 100'001
#define INF 987654321
#define ll long long
using namespace std;

string st;
ll arr[MAX] = { 0 };
ll arr2[MAX] = { 0 };
int n;
void solve();

bool Hashing(int size, int n);

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n >> st;

	arr[0] = 1;
	arr2[0] = 1;

	int ans = 0;
	for (int i = 1; i <= MAX; i++)
		arr[i] = (arr[i - 1] * k) % MOD;

	for (int i = 1; i <= MAX; i++)
		arr2[i] = (arr2[i - 1] * k2) % MOD2;



	// 일단 부분 문자열 부터 만들자.

	int l = 0, r = n;
	while (l <= r) {
		int mid = r - (r - l) / 2;
		// cout << mid << '\n';
		if (Hashing(mid, n)) {
			ans = max(ans, mid);
			l = mid + 1;
		}
		else
			r = mid - 1;
	}

	cout << ans;
}
bool Hashing(int size, int n)
{
	set<pair<int, int>> mp;
	ll hash = 0, hash2 = 0;
	for (int i = 1; i <= size; i++) {
		hash = (hash +  st[i - 1] * arr[size - i])%MOD;
		hash2 = (hash2+ st[i - 1] * arr2[size - i]) % MOD2;
	}
	mp.insert( { hash, hash2 } );

	for (int i = size; i < n; i++) {
		hash = ((hash - st[i - size] * arr[size - 1]) % MOD + MOD) % MOD;
		hash = (hash * k + st[i]) % MOD;

		hash2 = ((hash2 - st[i - size] * arr2[size - 1]) % MOD2 + MOD2) % MOD2;
		hash2 = (hash2 * k2 + st[i]) % MOD2;

		if (!mp.insert({hash, hash2}).second)
			return true;
		// cout << hash << '\n';
	}
	// cout << s.size() << " " << ans << '\n';

	return false;
}
