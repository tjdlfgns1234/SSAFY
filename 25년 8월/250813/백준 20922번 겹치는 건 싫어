#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 10'000'000'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

/*
	S1, Implementation, two-pointer, map
	투 포인터로 배열을 넓혀가면서
	O(1)로 개수 여부를 확인하는게 핵심인 문제
*/


int n, k;
int arr[2*MAX];
int chk[MAX];


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
	cin >> n >> k;

	for (int i = 0; i < n; i++) cin >> arr[i];
	
	int l = 0, ans = 0;
	for (int i = 0; i < n; i++) {
		chk[arr[i]]++;
		if (chk[arr[i]] <= k) 
			ans = max(ans, i - l + 1);
		else {
			int idx = arr[i]; // 현재 넘치는 수
			// cout << "넘치는 수 : " << idx << '\n';
			while (1)
				if (chk[idx] > k)
					chk[arr[l++]]--;
				else
					break;
		}
	}
	cout << ans << '\n';
}