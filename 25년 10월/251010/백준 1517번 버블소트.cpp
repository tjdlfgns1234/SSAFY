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

struct Num {
	int value; // 값
	int init_value; // 초기 값
	int idx; // 초기 인덱스
};

constexpr int MAX = 500'001;
constexpr int TREESIZE = (1 << 20) + 1;

void solve();
void update(int node, int s, int e, int idx);
ll query(int node, int s, int e, int l, int r);

int n;
vector<ll> seg(TREESIZE);
vector<Num> arr(MAX);

bool compare_idx(const Num& x, const Num& y) {
	return x.idx < y.idx;
}

bool compare_value(const Num& x, const Num& y) {
	return x.value < y.value;
}

/*
	P5, Cordinate Compression, segment Tree
*/

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

	for (int i = 1; i <= n; ++i)
		cin >> arr[i].value, arr[i].idx = i, arr[i].init_value = arr[i].value;

	// 좌표 압축을 위한 정렬
	sort(arr.begin() + 1, arr.begin() + n + 1, compare_value);

	for (int i = 1; i <= n; i++) {
		if (arr[i].init_value == arr[i - 1].init_value)
			arr[i].value = arr[i - 1].value;
		else
			arr[i].value = i;
	}

	// 원복
	sort(arr.begin() + 1, arr.begin() + n + 1, compare_idx);

	ll ans = 0;
	for (int i = 1; i <= n; ++i) {
		ans += query(1, 1, MAX, arr[i].value + 1, MAX);

		update(1, 1, MAX, arr[i].value);
	}

	cout << ans;
}
ll query(int node, int s, int e, int l, int r) {
	if (r < s || e < l) return 0;

	if (l <= s && e <= r) {
		return seg[node];
	}

	int mid = (s + e) >> 1;

	return query(node * 2, s, mid, l, r) + query(node * 2 + 1, mid + 1, e, l, r);
}

void update(int node, int l, int r, int idx) {
	if (r < idx || l > idx) return;

	if (l == r) {
		seg[node]++;
		return;
	}

	int mid = (l + r) >> 1;

	update(node * 2, l, mid, idx);
	update(node * 2 + 1, mid + 1, r, idx);

	seg[node] = seg[node * 2] + seg[node * 2 + 1];
}