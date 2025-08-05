#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 1e9

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
	cin >> n >> q;

	for (int i = 1; i <= n; i++) // one-based index
		cin >> arr[i];

	init(1,1,n);

	int l, r;
	for (int i = 0; i < q; i++) {
		cin >> l >> r;
	
	    cout << query(1, 1, n, l, r) << '\n';
	}

}
int init(int node, int l, int r){ // 최댓값을 찾는 segtree 초기화
	if (l == r)
		return segtree[node] = arr[l];

	int mid = (l + r) >> 1;

	 return segtree[node] = min(init(node * 2, l, mid),init(node * 2+1, mid+1,r));
}
int query(int node, int l, int r, int tl, int tr) {
	// 최댓값을 찾는 segtree 초기화
	// tl과 tr은 찾고자 하는 구간
	if (tl <= l && r <= tr) 
		return segtree[node];
	
	if (r < tl || tr < l) return INF; // 범위 밖의 값은 갱신되지 않는 값으로 지정

	int mid = (l + r) >> 1;

	return min(query(node * 2, l, mid, tl, tr), query(node * 2 + 1, mid + 1, r, tl, tr));
}
int update(int node, int l, int r, int idx, int value) {
	if (r < idx || idx < l) return segtree[node]; // 범위 밖의 값은 갱신되지 않는 값으로 지정

	if (idx == l && r == idx) {
		arr[idx] = value;
		segtree[node] = value;
		return segtree[node];
	}

	int mid = (l + r) >> 1;

	return min(update(node * 2, l, mid, idx, value), update(node * 2 + 1, mid + 1, r, idx, value));
}
