#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 1'000'000'000

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int n, q;

vector<int> arr(100'001);
vector<int> segtree(2 << 18 + 1);

int init(int node, int l, int r);
int query(int node, int l, int r, int tl, int tr);
int update(int node, int l, int r, int tl, int tr);
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

	for (int i = 1; i <= n; i++) // one-based index
		cin >> arr[i];

	init(1,1,n);

	int cmd,l, r;
	cin >> q;

	arr[0] = INF + 1;
	for (int i = 0; i < q; i++) {
		cin >> cmd >>  l >> r;
	
		if (cmd == 1)
			update(1, 1, n, l, r);
		else if (cmd == 2)
			cout << query(1, 1, n, l, r) << '\n';
	}

}
int init(int node, int l, int r){
	if (l == r)
		return segtree[node] = l;

	int mid = (l + r) >> 1;

	int left = init(node * 2, l, mid);
	int right = init(node * 2 + 1, mid + 1, r);

	if (arr[left] <= arr[right])
		return segtree[node] = left;
	else
		return segtree[node] = right;	
}
int query(int node, int l, int r, int tl, int tr) {
	// 최댓값을 찾는 segtree 초기화
	// tl과 tr은 찾고자 하는 구간
	if (tl <= l && r <= tr) 
		return segtree[node];
	
	if (r < tl || tr < l) return 0; // 범위 밖의 값은 갱신되지 않는 값으로 지정

	int mid = (l + r) >> 1;

	int left = query(node * 2, l, mid, tl, tr);
	int right = query(node * 2 + 1, mid + 1, r,tl, tr);

	if (arr[left] <= arr[right])
		return left;
	else
		return right;
}
int update(int node, int l, int r, int idx, int value) {
	if (r < idx || idx < l) return segtree[node]; // 범위 밖의 값은 갱신되지 않는 값으로 지정

	if (idx == l && r == idx) {
		arr[idx] = value;
		segtree[node] = idx;
		return segtree[node];
	}

	int mid = (l + r) >> 1;

	int left = update(node * 2, l, mid, idx, value);
	int right = update(node * 2 + 1, mid + 1, r, idx, value);

	if (arr[left] <= arr[right])
		return segtree[node] = left;
	else
		return segtree[node] = right;
}
