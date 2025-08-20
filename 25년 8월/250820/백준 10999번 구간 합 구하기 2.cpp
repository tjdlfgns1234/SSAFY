#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 1'000'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


// 전역 변수 선언
ll n, m, k;
ll arr[MAX];
ll seg[(1 << 21) + 1];

/*
    P4, Lazy Segment Tree
*/


// 함수 프로토타입 선언
void solve();
ll init(ll node, ll s, ll e);
void update_lazy(ll node, ll s, ll e);
void update(ll node, ll s, ll e, ll l, ll r, ll diff);
ll query(ll node, ll s, ll e, ll l, ll r);

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
	
	init(1, 0, n - 1);

	ll q = m + k;
	while (q--) {
		ll cmd;
		cin >> cmd;

		ll l, r, diff;
		if (cmd == 1) {
			cin >> l >> r >> diff;
			update(1, 0, n - 1, l - 1, r - 1, diff);
		}
		else if (cmd == 2) {
			cin >> l >> r;
			cout << query(1, 0, n - 1, l - 1, r - 1) << '\n';
		}
	}
}

// 세그먼트 트리 초기화 함수
ll init(ll node, ll s, ll e) {
	if (s == e) return seg[node] = arr[s];
	
	ll mid = (s + e) >> 1;
	return seg[node] = init(node * 2, s, mid) + init(node * 2 + 1, mid + 1, e);
}

// Lazy 값을 자식 노드로 전파하고 현재 노드를 갱신하는 함수
void update_lazy(ll node, ll s, ll e) {
	if (lazy[node] != 0) {
		// 전파할 정보가 많은 경우 lazy가 구조체가 될수도 있음.
		seg[node] += (e - s + 1) * lazy[node];
		// 공통된 부분을 전파한다.
		if (s != e) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}
		lazy[node] = 0;
	}
}

// 특정 구간의 값을 갱신하는 함수
void update(ll node, ll s, ll e, ll l, ll r, ll diff) {
	update_lazy(node, s, e); // 현재 노드의 lazy 값 먼저 처리
	if (l > e || r < s) return;
	if (l <= s && e <= r) {
		seg[node] += (e - s + 1) * diff;
		if (s != e) {
			lazy[node * 2] += diff;
			lazy[node * 2 + 1] += diff;
		}
		return;
	}
	ll mid = (s + e) >> 1;
	update(node * 2, s, mid, l, r, diff);
	update(node * 2 + 1, mid + 1, e, l, r, diff);
	seg[node] = seg[node * 2] + seg[node * 2 + 1];
}

// 특정 구간의 합을 구하는 함수
ll query(ll node, ll s, ll e, ll l, ll r) {
	update_lazy(node, s, e); // 현재 노드의 lazy 값 먼저 처리
	if (l > e || r < s) return 0;
	
	if (l <= s && e <= r) return seg[node];
	
	ll mid = (s + e) >> 1;
	ll lsum = query(node * 2, s, mid, l, r);
	ll rsum = query(node * 2 + 1, mid + 1, e, l, r);
	return lsum + rsum;
}