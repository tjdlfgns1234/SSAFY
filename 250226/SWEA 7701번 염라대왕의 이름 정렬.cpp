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

int n, cnt = 1;
void solve();

bool compare(const string a, const string b) {
    if (a.size() != b.size())
        return a.size() < b.size();
    else
        return a < b;
}

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    // freopen("input.txt", "r", stdin);

    int t = 1;
    cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> n;

    vector<string> arr(n);

    for (auto& i : arr) 
        cin >> i;
    
    sort(all(arr), compare);

    arr.erase(unique(all(arr)), arr.end());

    cout << "#" << cnt++ << '\n';
    for (auto i : arr)
        cout << i << '\n';

    // cout << ans;
    // cout << "#" << cnt++ << ' ' <<ans << '\n';
}