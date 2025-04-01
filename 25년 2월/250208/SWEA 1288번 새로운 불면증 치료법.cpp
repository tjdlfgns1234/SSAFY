#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 4000001
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


void solve();
int n, m, cnt = 1;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    int t = 1;
    cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> n >> m;

    int f = 0; // flag
    for (int i = 0; i < n; i++) // 32 비트이므로
        if (!(m & (1 << i)))
            f = 1;

    string ans = "";

    if (!f)
        ans = "ON";
    else
        ans = "OFF";
    cout << "#" << cnt++ << " " << ans << '\n';
}