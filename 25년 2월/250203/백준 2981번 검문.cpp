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
ll gcd(ll a, ll b);
int n;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    int t = 1;
    // cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> n;

    vector<int> arr(n);


    for (auto& i : arr) cin >> i;

    sort(all(arr));

    vector<int> arr2(n);

    int div = arr[1] - arr[0];
    for (int i = 1; i < n; i++) div = gcd(div, arr[i] - arr[i - 1]);


    for (int i = 2; i <= div; i++) {
        if (div % i == 0) {
            cout << i << ' ';
        }
    }

}
ll gcd(ll a, ll b)
{
    if (b == 0)
        return a;
    else
        return gcd(b, a % b);
}