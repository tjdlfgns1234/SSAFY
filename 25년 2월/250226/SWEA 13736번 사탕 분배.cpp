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

int a, b, k;
int ans = 0, cnt = 1;
void solve();

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    freopen("input.txt", "r", stdin);

    int t = 1;
    cin >> t;

    while (t--)
        solve();

    return 0;
}
int pow(int q, int mod) {
    ll ret = 1;
    ll n = 2;
    while (q > 0) {
        if (q & 1) 
            ret = (ret * n) % mod;
        
        n = (n * n) % mod;
        q /= 2;
    }
    return (int)ret;
}
void solve() {
    cin >> a >> b >> k;
    // ans = 1234567890;
    int sum = a + b;
    int max = sum / 2;

    int ret = ((ll)pow(k, sum) * (ll)a) % sum;
    if (ret > max)
        ans = sum - ret;
    else
        ans = ret;

    // cout << ans;
    cout << "#" << cnt++ << ' ' <<ans << '\n';
}