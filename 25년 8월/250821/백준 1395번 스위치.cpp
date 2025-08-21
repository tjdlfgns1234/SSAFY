#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


constexpr int SIZE = 1 << 18;
constexpr int TREESIZE = SIZE << 1;

/*
    P3, lazy segment tree
    Lazy propagation을 이용한 구간 업데이트와 쿼리
*/

ll n, m;
ll arr[SIZE];
ll seg[TREESIZE + 1];
ll lazy[TREESIZE + 1]; 	// lazy에는 반전 시켜야할 횟수를 저장

// 함수 프로토타입 선언
void solve();
ll init(ll node, ll s, ll e);
void update_lazy(ll node, ll s, ll e);
void update(ll node, ll s, ll e, ll l, ll r);
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
	cin >> n >> m;
	
	init(1, 0, n - 1);

	while (m--) {
		ll o, s, t;
		cin >> o;

		if (o == 0) {
			// 상태 반전
			cin >> s >> t;
			update(1, 0, n - 1, s - 1, t - 1);
		}
		else if ( o == 1) {
			cin >> s >> t;
			cout << query(1, 0, n - 1, s-1, t-1) << '\n';
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
		// 횟수가 홀수 일 경우 업데이트.
		if (lazy[node] & 1) seg[node] = (e - s + 1) - seg[node];
		
		// 짝수 일 때는 업데이트 할 필요가 없음

		if (s != e) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}
		lazy[node] = 0;
	}
}

// 특정 구간의 값을 갱신하는 함수
void update(ll node, ll s, ll e, ll l, ll r) {
	update_lazy(node, s, e); // 현재 노드의 lazy 값 먼저 처리
	if (l > e || r < s) return;

	if (l <= s && e <= r) {
		// 스위치 상태를 구간별로 반전 시킴
		seg[node] = (e - s + 1) - seg[node];

		if (s != e) {
			// lazy에는 반전 시켜야할 횟수를 저장
			lazy[node * 2] += 1;
			lazy[node * 2 + 1] += 1;
		}
		return;
	}
	ll mid = (s + e) >> 1;
	update(node * 2, s, mid, l, r);
	update(node * 2 + 1, mid + 1, e, l, r);
	seg[node] = seg[node * 2] + seg[node * 2 + 1];
}

// 특정 구간의 합을 구하는 함수
ll query(ll node, ll s, ll e, ll l, ll r) {
	update_lazy(node, s, e); // 현재 노드의 lazy 값 먼저 처리
	if (l > e || r < s) return 0;
	
	if (l <= s && e <= r) return seg[node];
	
	ll mid = (s + e) >> 1;
	
	return  query(node * 2, s, mid, l, r) + query(node * 2 + 1, mid + 1, e, l, r);
}