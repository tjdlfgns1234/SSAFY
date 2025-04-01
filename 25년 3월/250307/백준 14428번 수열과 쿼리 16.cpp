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
ll init(ll node, ll start, ll end);
void update(ll node, ll start, ll end, ll idx, ll x);
ll query(ll node, ll l, ll r, ll start, ll end);

ll arr[1000001];
vector<ll> seg((1 << 21) + 1);
int n;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	freopen("input.txt", "r", stdin);
	
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
		cin >> a >> b >> c;

		if (a == 1) { // update
			update(1, 0, n - 1, b - 1, c);
		}
		else if (a == 2) { // query
			cout << query(1, b - 1, c - 1, 0, n - 1) + 1<< '\n';
		}
	}
}

// 세그먼트 트리 초기화
ll init(ll node, ll start, ll end) {
	if (start == end)
		return seg[node] = start; // 인덱스만 저장

	ll mid = start + (end - start) / 2;

	ll left = init(node * 2, start, mid);
	ll right = init(node * 2 + 1, mid + 1, end);

	if (arr[left] < arr[right])
		return seg[node] = left;
	else if (arr[left] == arr[right])
		return seg[node] = min(left, right);
	else
		return seg[node] = right;
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

	ll left = seg[node * 2];
	ll right = seg[node * 2 + 1];

	if (arr[left] < arr[right])
		seg[node] = left;
	else if (arr[left] == arr[right])
		seg[node] = min(left, right);
	else
		seg[node] = right;
}

// 가장 작은 인덱스 구하기
ll query(ll node, ll l, ll r, ll start, ll end) {
	if (l > end || r < start) return -1;
	if (l <= start && r >= end) return seg[node];
	ll mid = start + (end - start) / 2;

	ll left = query(node * 2, l, r, start, mid);
	ll right = query(node * 2 + 1, l, r, mid + 1, end);

	// 없는 경우도 리턴 해주어야 함.
	if (left == -1)
		return right;
	else if (right == -1)
		return left;

	if (arr[left] < arr[right])
		return left;
	else if (arr[left] == arr[right])
		return min(left, right);
	else
		return right;
} 