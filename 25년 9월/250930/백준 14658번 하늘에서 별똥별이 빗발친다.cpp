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

struct Pair {
	int x, y;
};

void solve();

int n, m, l, k;
vector<Pair> arr;
vector<Pair> candidate;



int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);
	
	freopen("input.txt", "r", stdin);

	int t = 1;
	// cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	cin >> n >> m >> l >> k;

	int x, y;
	for (int i = 0; i < k; i++) {
		cin >> x >> y;
		arr.push_back({ x, y });
	}

	int ans = k, cnt = 0;

	for (auto& i : arr) {
		for (auto& j : arr) {
			cnt = 0;
			for (auto& p : arr)
				if (i.x <= p.x && i.x + l >= p.x && j.y <= p.y && j.y + l >= p.y) cnt++;
			ans = min(ans, k - cnt);
		}
	}
	cout << ans;
}