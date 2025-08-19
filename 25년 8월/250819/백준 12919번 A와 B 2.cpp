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
    G5, string, brute force, DFS
*/


string s;
int ans = 0;
void dfs(int cnt, string& cmp);

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
    string t;
    cin >> s >> t;

    ans = 0;

    dfs(t.size() - 1, t);

    cout << ans << '\n';
}
void dfs(int cnt, string& cmp) {
    if (cnt == s.size() - 1) {
        if (s == cmp) 
            ans = 1;
        return;
    }
    
    // cout << s << " " << cmp << '\n';


    if (cmp[cnt] == 'A') {
        cmp.pop_back();
        dfs(cnt - 1, cmp);
        cmp += 'A';
    }

    if (cmp[0] == 'B') {
        reverse(all(cmp));
        cmp.pop_back();
        dfs(cnt - 1, cmp);
        cmp += 'B';
        reverse(all(cmp));
    }
}