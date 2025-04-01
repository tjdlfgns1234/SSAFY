#define _CRT_SECURE_NO_WARNINGS
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
int dp[1001][1001];
int cnt = 1;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    // freopen("input.txt", "r", stdin);

    int t = 10;
    cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    string a, b;
    cin >> a >> b;

    for (int i = 1; i <= a.length(); i++)
        for (int j = 1; j <= b.length(); j++)
            if (a[i-1] == b[j-1])
                dp[i][j] = max(dp[i - 1][j - 1] + 1, dp[i][j - 1]);
            else
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);


    cout << "#" << cnt++ << ' ' << dp[a.length()][b.length()] << '\n';
}