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

int n, m, cnt = 1;

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
void solve() {
    cin >> n >> m;

    map<string, int> mp;

    string s;
    for (int i = 0; i < n; i++) cin >> s, mp.insert({s, 1});

    int ans = 0;
    for (int i = 0; i < m; i++) {
        cin >> s;
        
        if (mp[s])
            ans++;
    }
    
    cout << "#" << cnt++ << ' ' << ans << '\n';
}