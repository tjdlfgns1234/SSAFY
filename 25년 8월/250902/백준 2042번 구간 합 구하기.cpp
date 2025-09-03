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

constexpr int SIZE = 1'000'001;

void solve();
void update(int r, int idx, ll v);
ll query(int n, int r, int s, int e);


/*
    G1, sqrt Decomposition
*/

ll n, m, k;
ll arr[SIZE];
ll d[SIZE];

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
	cin >> n >> m >> k;

	for (int i = 0; i < n; i++) cin >> arr[i];

	int r = (int)sqrt(n);

	for (int i = 0; i < n; i++) d[i / r] += arr[i];

	int q = m + k;

	int cmd;
	ll a, b, c;
	while (q--) {
		cin >> cmd;
		if (cmd == 1) {
			cin >> a >> b;
			update(r, a - 1, b);
		}
		else if(cmd ==2) {
			cin >> a >> b;
			cout << query(n, r, a - 1, b - 1) << '\n';
		}


	}


}
void update(int r, int idx, ll v) {
	int group = idx / r;
	d[group] = d[group] - arr[idx] + v;
	arr[idx] = v;
}
ll query(int n, int r, int s, int e) {
	ll ans = 0;

	if (s / r == e / r) {
		for (int i = s; i <= e; i++) ans += arr[i];
	
		return ans;
	}

	while (true) {
		ans += arr[s];
		s += 1;

		if (s % r == 0) break;
	}

	while (true) {
		ans += arr[e];
		e -= 1;

		if (e % r == r-1) break;
	}

	int sg = s / r;
	int eg = e / r;

	for (int i = sg; i <= eg; i++) ans += d[i];

	return ans;
}
