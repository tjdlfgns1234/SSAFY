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


constexpr int SIZE = 1 << 20;
constexpr int TREESIZE = SIZE << 1;


ll n, m;
ll arr[SIZE];
ll seg[TREESIZE + 1];
ll lazy[TREESIZE + 1]; 	// lazy에는 반전 시켜야할 횟수를 저장

/*
    P4, lazy Segment Tree
    * Lazy Propagation을 이용한 구간 업데이트
    * XOR 연산을 이용한 구간 합 구하기
*/


void solve();
ll init(ll node, ll s, ll e);
void update_lazy(ll node, ll s, ll e);
void update(ll node, ll s, ll e, ll l, ll r,ll diff);
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
	cin >> n ;
	
	for (int i = 0; i < n; i++) cin >> arr[i];

	init(1, 0, n - 1);

	cin >> m;

	while (m--) {
		ll o, s, t;
		cin >> o;

		ll diff = 0;
		if (o == 1) {
			cin >> s >> t >> diff;
			update(1, 0, n - 1, s, t , diff);
		}
		else if (o == 2) {
			cin >> s;
			cout << query(1, 0, n - 1, s, s) << '\n';
		}
	}

	//cout << (1 ^ 2 ^ 3 ^ 4 ^ 5 )<< '\n';
	//cout << (1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 9) << '\n';
}

// 세그먼트 트리 초기화 함수
ll init(ll node, ll s, ll e) {
	if (s == e) return seg[node] = arr[s];
	
	ll mid = (s + e) >> 1;
	return seg[node] = init(node * 2, s, mid) ^ init(node * 2 + 1, mid + 1, e);
}

// Lazy 값을 자식 노드로 전파하고 현재 노드를 갱신하는 함수
void update_lazy(ll node, ll s, ll e) {
	if (lazy[node] != 0) {
		// 횟수가 홀수 인 경우만 업데이트
		// xor은 2번 하면 자기자신으로 돌아옴
		if ((e - s + 1) & 1) seg[node] ^= lazy[node];

		if (s != e) {
			// 전파하고 값을 버림
			lazy[node * 2] ^= lazy[node];
			lazy[node * 2 + 1] ^= lazy[node];
		}
		lazy[node] = 0;
	}
}

// 특정 구간의 값을 갱신하는 함수
void update(ll node, ll s, ll e, ll l, ll r, ll diff) {
	update_lazy(node, s, e); // 현재 노드의 lazy 값 먼저 처리
	if (l > e || r < s) return;

	if (l <= s && e <= r) {
		// 횟수가 홀수 인 경우만 업데이트
		// xor은 2번 하면 자기자신으로 돌아옴
		if( (e-s + 1) & 1 ) seg[node] ^= diff;

		if (s != e) {
			// lazy에는 Xor 해야할 수를 저장
			lazy[node * 2] ^=  diff;
			lazy[node * 2 + 1] ^=  diff;
		}
		return;
	}
	ll mid = (s + e) >> 1;
	update(node * 2, s, mid, l, r, diff);
	update(node * 2 + 1, mid + 1, e, l, r, diff);
	seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
}

// 특정 구간의 합을 구하는 함수
ll query(ll node, ll s, ll e, ll l, ll r) {
	update_lazy(node, s, e); // 현재 노드의 lazy 값 먼저 처리
	if (l > e || r < s) return 0;
	
	if (l <= s && e <= r) return seg[node];
	
	ll mid = (s + e) >> 1;
	
	return  query(node * 2, s, mid, l, r) ^ query(node * 2 + 1, mid + 1, e, l, r);
}