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
int n, cnt = 1;;

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
    cin >> n;

    int arr[10] = { 0 };
    
    int x = n;
    int f = 0;
    for (; ; ) {
        string s = to_string(x);
        // cout << s << '\n';
        for (auto c : s) 
            arr[c - '0']++;

        for (int j = 0; j < 10; j++)
            if (arr[j] == 0)
                f = 1;
        if (!f) {
            cout <<"#" << cnt++ << ' ' << x << '\n';
            return;
        }
        x += n;
        f = 0;
    }
}