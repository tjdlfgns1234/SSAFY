#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 3'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

/*
    S1, sliding window, set
*/


int cnt[MAX]; // 개수 저장 배열

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    freopen("input.txt", "r", stdin);

    int t = 1;
    // cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    int n, d, k, c;
    cin >> n >> d >> k >> c;

    vector<int> arr(n);

    for (auto& i : arr) cin >> i;

    set<int> s;

    for (int i = 0; i < k; i++) s.insert(arr[i]) , cnt[arr[i]]++;
    
    s.insert(c); // 쿠폰 추가
    cnt[c]++;
    int ans = s.size();

    int l = 0;
    for (int i = k; i < n+k; i++) {
        l = l % n;
        cnt[arr[l]]--;
        if (cnt[arr[l]] == 0)
            s.erase(arr[l]);
        
        s.insert(arr[i%n]), ans = max(ans, (int)s.size()), cnt[arr[i%n]]++;
        l++;
    }

    cout << ans;

}