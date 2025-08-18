#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 10'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
void init();

/*
    G5, DP
    S1 난도보다 오히려 깔끔하게 푼 문제
    기본부터 시작해 쌓아올라가서 깔끔하게 풀었다.
*/

int n;
int dp[4][MAX];

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    // freopen("input.txt", "r", stdin);

    int t = 1;
    cin >> t;

    while (t--)
        init(), solve();

    return 0;
}
void init() {
    memset(dp, 0, sizeof(dp));
}
void solve() {
    cin >> n;

    // 초기식
    for (int i = 0; i <= n; i++) dp[1][i] = 1;

    int k = 3;
    for (int i = 2; i <= k; i++) {
        for (int j = 1; j <= n; j++) {
            dp[i][j] = dp[i - 1][j];

            if (i == j)
                dp[i][j] += 1;

            if(j> i)
                dp[i][j] += dp[i][j - i]; 
        }
    }


    cout << dp[k][n] << '\n';
}