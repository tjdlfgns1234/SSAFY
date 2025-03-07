#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
#define all(a) a.begin(),a.end()
#define SIZE 2000
#define MOD 1000000007
#define e 0.00000001
#define k 347

// beware of min & max value;
// 빈 곳의 개수를 세는 것도 그래프를 잘 푸는 방법중 하나!
// /와 %연산은 배열을 나타낼때 유용하게 쓰인다.
// 배운거 내에서만 쓸 생각을 하자. 
// 평소 연습했던 대로!
// 행렬을 배열로도 쓸 생각하자
// 급하기 풀지 말자

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
ll init(size_t node, size_t start, size_t end);
void update(size_t node, size_t start, size_t end, size_t idx, ll x);
ll query(size_t node, size_t l, size_t r, size_t start, size_t end);

ll arr[1000001];
vector<ll> segtree((1 << 21) + 1);
int n;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// freopen("input.txt", "r", stdin);
	solve();
	return 0;
}

void solve() {
	int u, q;
	cin >> n >> u >> q;

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	init(1, 0, n - 1); // 세그먼트 트리 초기화

	int t = u + q;
	while (t--) {
		ll a, b, c;
		cin >> a >> b >> c;

		if (a == 1) { // update
			update(1, 0, n - 1, b - 1, c);
		}
		else if (a == 2) { // query
			cout << query(1, b - 1, c - 1, 0, n - 1) << '\n';
		}
	}
}

// 세그먼트 트리 초기화
ll init(size_t node, size_t start, size_t end) {
	if (start == end)
		return segtree[node] = arr[start] % MOD;

	size_t mid = start + (end - start) / 2;
	return segtree[node] = (init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end)) % MOD;
}

// 값 업데이트
void update(size_t node, size_t start, size_t end, size_t idx, ll x) {
	if (idx < start || idx > end)
		return;

	if (start == end) {
		segtree[node] = x % MOD;
		arr[idx] = x; // 실제 배열 값도 변경
		return;
	}

	size_t mid = start + (end - start) / 2;
	update(node * 2, start, mid, idx, x);
	update(node * 2 + 1, mid + 1, end, idx, x);

	segtree[node] = (segtree[node * 2] * segtree[node * 2 + 1]) % MOD;
}

// 구간 곱 구하기
ll query(size_t node, size_t l, size_t r, size_t start, size_t end) {
	if (l > end || r < start)
		return 1;

	if (l <= start && r >= end)
		return segtree[node];

	size_t mid = start + (end - start) / 2;
	return (query(node * 2, l, r, start, mid) * query(node * 2 + 1, l, r, mid + 1, end)) % MOD;
}