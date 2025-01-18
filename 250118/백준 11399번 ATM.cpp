#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


void solve();

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	solve();

	return 0;
}
void solve() {
	int n;
    cin >> n;

    vector<int> arr(n), dp(n);
    for(auto& i : arr) cin >> i;

    sort(all(arr));
    int ans = 0, idx =0;
    for(auto&i : arr) dp[idx++] = dp[idx-1] + i;
    idx = 0;
    for(auto&i : dp) ans += dp[idx++];
    
    cout << ans;
}