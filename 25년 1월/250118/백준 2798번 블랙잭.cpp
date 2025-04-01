#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


void solve();

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	solve();

	return 0;
}
void solve() {
	int n, m;
    cin >> n >> m;

    vector<int> arr(n);
    for(auto& i : arr) cin >> i;

    int ans = 0;
     for(int i = 0; i < n;i++)
              for(int j = 0; j < n && i != j;j++)
                    for(int k = 0; k < n && k != j && k != i;k++)
                           if(arr[i] + arr[j] + arr[k] <= m)
                               ans = max(ans,arr[i] + arr[j] + arr[k]);

    cout << ans;
}