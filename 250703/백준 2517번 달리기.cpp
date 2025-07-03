#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 500'000
#define INF 1'000'000'000

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

struct P {
	int speed; // 달리는 속도
	int idx; // 초기 번호
};


int n, q;

vector<P> arr; // 원본 배열
vector<int> segtree(1<<21);

int query(int node, int l, int r, int tl, int tr);
void update(int node, int l, int r, int idx);
void solve();

bool cmp_speed(const P& a, const P& b) {
	return a.speed < b.speed;
}
bool cmp_idx(const P& a, const P& b) {
	return a.idx < b.idx;
}

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

	int sp;
	for (int i = 0; i < n; i++) { // zero-based index.
		cin >> sp;
		arr.push_back({ sp, i });

		// input is unique.
	}
	// init(1,1,n); // 기존값은 전부 0이므로 상관 없다


	sort(all(arr), cmp_speed); // 속도기준 정렬
	
	// 좌표 압축 시행
	// 상대적인 순위로 바꿔어서 진행
	int cnt = 1;

	for (auto &i : arr) i.speed = cnt++;

	sort(all(arr), cmp_idx); // 원래 인덱스로 돌림

	for (int i = 1; i <= n; ++i) {
		int value = query(1, 1, MAX, 1, arr[i - 1].speed - 1);
		cout << i - value << '\n';

		update(1, 1, MAX, arr[i - 1].speed);
	}
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

	return left + right;
}
void update(int node, int l, int r, int idx) {
	if (r < idx || idx < l) return; // 범위 밖의 값은 갱신되지 않는 값으로 지정

	if (l == r) {
		segtree[node]++;
		return;
	}

	int mid = (l + r) >> 1;

	update(node * 2, l, mid, idx);
	update(node * 2 + 1, mid + 1, r, idx);

	segtree[node] = segtree[node * 2] + segtree[node * 2 + 1]; // 업데이트
}