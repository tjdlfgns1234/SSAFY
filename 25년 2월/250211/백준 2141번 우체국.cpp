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
pair<int, int> arr[100001];

int cnt = 1;

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
    int n;
    cin >> n;

    ll ans = 0,sum = 0, tmp = 0;
    for (int i = 0; i < n; i++) 
        cin >> arr[i].first >> arr[i].second, sum += arr[i].second;
    
    sort(arr, arr + n);

    sum = (sum+1) / 2;

    for (int i = 0; i < n; i++){
        tmp += arr[i].second;
        if (sum <= tmp) {
            ans = i;
            break;
        }
    }
    
    cout << arr[ans].first;
}