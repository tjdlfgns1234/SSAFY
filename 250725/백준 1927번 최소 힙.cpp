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

// 풀었었던 문제
// 소요시간 3분 미만

int n;

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
    cin >> n;

    priority_queue <int> pq;

    int x;
    for (int i = 0; i < n; i++) {
        cin >> x;

        if (x != 0) 
            pq.push(-x);
        else {
            if (pq.empty())
                cout << 0 << '\n';
            else
                cout << -pq.top() << '\n', pq.pop();
        }
            
    }

}