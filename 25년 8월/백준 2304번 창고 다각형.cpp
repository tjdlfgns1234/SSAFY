#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 1001
#define INF 10'000'000'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

/*
	S2, Implementation
	기준을 잡고 오른쪽, 왼쪽을 보면 되는 문제
	구현이 감이 안와서 정답을 봤고, 기준을 잡지 않은게 패인
*/

int n;
int arr[MAX];

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

	int l, h;
	int cur= 0, idx = 0;
	for (int i = 0; i < n; i++) {
		cin >> l >> h;

		arr[l] = h;

		if (cur < h) 
			cur = h,idx = l;
	}


	int ans = 0;
	cur = 0;
	for (int i = 0; i < idx; i++) 
		cur = max(cur, arr[i]), ans += cur;
	
	cur = 0;

	for (int i = MAX-1; i >= idx; i--) 
		cur = max(cur, arr[i]), ans += cur;
	
	cout << ans;

}