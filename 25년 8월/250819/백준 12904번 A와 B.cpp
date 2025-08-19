#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

/*
    G5, string, Greedy, Implementation
*/

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
    string s, t;
    cin >> s >> t;

    int ans = 0;
    for (int i = t.size() -1; i >= 0; i--) {
        if (t[i] == 'A') t.pop_back();
        else t.pop_back(), reverse(all(t));
         
        // cout << t << '\n';


        if (s == t) ans = 1;
    }


    cout << ans << '\n';
}