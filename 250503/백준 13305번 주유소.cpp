#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define ll long long
#define MAX 100001
#define INF 987654321
using namespace std;

struct Edge {
	ll e, c;
};

struct Pair {
	ll e, c, roads;
};

int n;
ll dist[MAX];
ll oil[MAX];


void solve();

bool operator< (const Pair& a, const Pair& b) {
	return a.c > b.c;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	//freopen("input.txt", "r", stdin);

	solve();

	return 0;
}
void solve() {
	cin >> n;
	
	for (int i = 0; i < n-1; i++) cin >> dist[i];
	for (int i = 0; i < n; i++) cin >> oil[i];
	
	ll ans = 0, cur = 0;
	for (int i = 0; i < n-1; i++) {
		if (cur == 0)
			cur = oil[i];
		else if (cur > oil[i])
			cur = oil[i];

		// cout << dist[i] << " " << oil[i] << '\n';

		ans += dist[i] * cur;
	}

	cout << ans;
}