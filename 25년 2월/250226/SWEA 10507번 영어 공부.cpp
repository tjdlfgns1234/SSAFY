#include <bits/stdc++.h>
#define MAX 10000

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int n, p, cnt = 1;
int arr[200001];
bool dp[1000001];

void solve();
void init();

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	cin >> t;

	while (t--)
		solve(), init();

	return 0;
}
void solve() {
	cin >> n >> p;

	for (int i = 0; i < n; i++) cin >> arr[i], dp[arr[i]] = true;

	ll ans = 0ll; // long long이 됨

	// 연속 공부 기간! => 전날 보다 1씩 더 쌓임
	ll score = 0, hack = p; // 현재 점수와 날짜, 현재 해킹권
	int l = 0, r = 0;
	for (int i = 0; i <= 1000000 && r <= 1000000; i++) {
		if (dp[i]) { // 공부한 날이면
		}
		else { // 공부하지 않은 날이면
			if (hack > 0)  // hack을 할 수 있으면
				hack--;
			else  // hack도 사용할 수 없으면
				while (l <= r)  // 해킹권을 사용한 날짜까지 뒤에서 접근
					if (!dp[l]) {
						l++, score -= 1;
						break;
					}
					else
						l++, score -= 1;
		}
		r++;
		score += 1;
		ans = max(ans, score);
		//cout << "# " << l << ' ' << r  << " " << score << '\n';
	}

	// cout << ans;
   cout << "#" << cnt++ << ' ' << ans << '\n';
}
void init() {
	// memset(arr,0, sizeof(arr);
	memset(dp, false , sizeof(dp));
}
