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


constexpr int SIZE = 1 << 18;
constexpr int TREESIZE = SIZE << 1;

struct Lazy {
	ll s; 
	ll num;  
	Lazy(ll s = 0, ll num = 0) : s(s), num(num) {}
};

/*
	P2 : lazy segmemnt
    구조체를 통해 뭘 lazy하게 처리하는지가 핵심
*/

ll n, m;
ll arr[SIZE];
ll seg[TREESIZE];
Lazy lazy[TREESIZE]; 


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
	cin >> n;

	for (int i = 0; i < n; i++) cin >> arr[i];

	init(1, 0, n - 1);

	cin >> m;

	while (m--) {
		ll o, s, t;
		cin >> o;

		ll diff = 0;
		if (o == 1) {
			cin >> s >> t;
			diff = 1;
			update(1, 0, n - 1, s-1, t-1, diff);
		}
		else if (o == 2) {
			cin >> s;
			cout << query(1, 0, n - 1, s-1, s-1) << '\n';
		}
	}

	//cout << (1 ^ 2 ^ 3 ^ 4 ^ 5 )<< '\n';
	//cout << (1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 9) << '\n';

	//cout << '\n';
	//for (int i = 1; i <= 32; i++) {
	//	cout << seg[i] << ' ';
	//}

}

// 세그먼트 트리 초기화 함수
ll init(ll node, ll s, ll e) {
	if (s == e) return seg[node] = arr[s];

	ll mid = (s + e) >> 1;
	return seg[node] = init(node * 2, s, mid) + init(node * 2 + 1, mid + 1, e);
}

// Lazy 값을 자식 노드로 전파하고 현재 노드를 갱신하는 함수
void update_lazy(ll node, ll s, ll e) {
	if (lazy[node].s != 0 || lazy[node].num != 0) { // 개별로 비교하기

		ll len = e - s + 1;

		ll val = len * lazy[node].s + lazy[node].num * sum(len - 1);
		seg[node] += val;

		if (s != e) {
			ll mid = (s + e) >> 1;
			ll l = mid - s + 1;

			// 왼쪽 자식은 시작값 그대로, 동일한 증가량
			lazy[node * 2].s += lazy[node].s;
			lazy[node * 2].num += lazy[node].num;

			// 오른쪽 자식은 오프셋 적용
			lazy[node * 2 + 1].s += lazy[node].s + lazy[node].num * l;
			lazy[node * 2 + 1].num += lazy[node].num;
		}
		lazy[node] = Lazy(0,0);
	}
}

// 특정 구간의 값을 갱신하는 함수
void update(ll node, ll s, ll e, ll l, ll r, ll diff) {
	update_lazy(node, s, e); // 현재 노드의 lazy 값 먼저 처리
	if (l > e || r < s) return;

	if (l <= s && e <= r) {
		// 구간 시작점과 증가량 1 을 lazy에 저장
		lazy[node].s += diff + (s - l-1); // 현재 노드 구간 시작점 기준으로 오프셋 보정
		lazy[node].num += 1; // 증가량은 1

		update_lazy(node, s, e);
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

	return  query(node * 2, s, mid, l, r) + query(node * 2 + 1, mid + 1, e, l, r);
}