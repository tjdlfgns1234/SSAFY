#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define MOD 1000000007
#define MAX 65536
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
void update(ll node, ll start, ll end, ll idx, ll x);
ll kth_query(ll node, ll s, ll e, ll kth);

ll arr[250'001];
vector<ll> seg((1 << 20) + 1);
int n, k;

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	//cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	cin >> n >> k;

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	ll ret = 0;

	for (int i = 0; i < k; i++)
		update(1, 0, MAX, arr[i], 1);

	int mid = k + 1 >> 1; // 중앙값
	ret += kth_query(1, 0, MAX, mid);

	for (int i = k; i < n; i++) {
		update(1, 0, MAX, arr[i - k], -1); // 왼쪽 값을 제거
		update(1, 0, MAX, arr[i], 1); // 오른쪽 값을 추가
		ret += kth_query(1, 0, MAX, mid);
	}
	cout << ret;
}
// 값 업데이트
void update(ll node, ll s, ll e, ll idx, ll x) {
	if (idx < s || idx > e)
		return;

	seg[node] += x;
	// 누적합 쿼리 업데이트
	// remove 연산 시는 -1 쿼리로 처리해주면됨
	if (s == e) return;

	ll m = s + (e - s) / 2;
	update(node * 2, s, m, idx, x);
	update(node * 2 + 1, m + 1, e, idx, x);

	seg[node] = seg[node * 2] + seg[node * 2 + 1];
}

ll kth_query(ll node, ll s, ll e, ll kth) {
	if (s == e) return s; // 리프 노드에 도달하면 해당 위치 반환

	ll m = s + (e - s) / 2;
	ll l = seg[node * 2]; // 왼쪽 자식이 포함하는 개수

	if (kth <= l) return kth_query(node * 2, s, m, kth);
	else return kth_query(node * 2 + 1, m + 1, e, kth - l);
}
