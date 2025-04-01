#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define MOD 1000000007
#define MAX 50000
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
ll init(ll node, ll start, ll end);
void update(ll node, ll start, ll end, ll idx, ll x);
ll query(ll node, ll l, ll r, ll start, ll end);

ll arr[100001];
vector<ll> seg((1 << 21) + 1);
int n;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

    int t = 1;
    //cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> arr[i];


	init(1, 0, n - 1); // 세그먼트 트리 초기화

	int t;
	cin >> t;
	while (t--) {
		ll a, b, c;
		cin >> a;

		if (a == 1) { // update
			cin >> b >> c;
			update(1, 0, n - 1, b - 1, c);
		}
		else if (a == 2) { // query
			cout << query(1, 0, n-1, 0, n - 1) + 1 << '\n';
		}
	}
}

// 세그먼트 트리 초기화
ll init(ll node, ll start, ll end) {
	if (start == end)
		return seg[node] = start;

	ll mid = start + (end - start) / 2;

	int lv = init(node * 2, start, mid);
	int rv = init(node * 2 + 1, mid + 1, end);

	if (arr[lv] < arr[rv])
		return seg[node] = lv;
	else if (arr[lv] > arr[rv])
		return seg[node] = rv;
	else
		return seg[node] = min(lv, rv);
}

// 값 업데이트
void update(ll node, ll start, ll end, ll idx, ll x) {
	if (idx < start || idx > end)
		return;

	if (start == end) {
		seg[node] = idx;
		arr[idx] = x; // 원본 배열 값 변경
		return;
	}

	ll mid = start + (end - start) / 2;
	update(node * 2, start, mid, idx, x);
	update(node * 2 + 1, mid + 1, end, idx, x);

	if (arr[seg[node * 2]] < arr[seg[node * 2 + 1]]) 
		seg[node] = seg[node * 2];
	else if (arr[seg[node * 2]] > arr[seg[node * 2 + 1]]) 
		seg[node] = seg[node * 2+1];
	else  
		seg[node] = min(seg[node * 2 + 1], seg[node * 2]);
	
	// seg[node] = seg[node * 2] + seg[node * 2 + 1];
}

// 구간안에 홀수 개수 구하기
ll query(ll node, ll l, ll r, ll start, ll end) {
	if (l > end || r < start) return 0;
	if (l <= start && r >= end) return seg[node];
	ll mid = start + (end - start) / 2;

	int lv = query(node * 2, l, r, start, mid);
	int rv = query(node * 2 + 1, l, r, mid + 1, end);

	if (arr[lv] < arr[rv]) 
		return lv;
	else if (arr[lv] > arr[rv]) 
		return rv;
	else 
		return min(lv, rv);
	

	// return query(node * 2, l, r, start, mid) + query(node * 2 + 1, l, r, mid + 1, end);
}