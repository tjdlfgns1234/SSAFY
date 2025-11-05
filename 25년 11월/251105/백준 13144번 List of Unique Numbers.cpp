#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 10'000'000'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

constexpr int MAX = 100'001;

int n;
int arr[MAX];

/*
    G4 13144 List of Unique Numbers
    슬라이딩 윈도우 + 집합
*/

set<int> chk;
void solve();

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
	cin >> n;

	for (int i = 0; i < n; i++) cin >> arr[i];

	ll ans = 0;

	ll l = 0,  cnt = 0;
	for (int i = 0; i < n; i++) {
		if (chk.count(arr[i]) == 0) 
			chk.insert(arr[i]), cnt++, ans+= cnt;
		else 
			chk.erase(arr[l]), cnt--, l++, i--;
	}
	cout << ans;
}