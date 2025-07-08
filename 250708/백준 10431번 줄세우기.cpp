#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 20
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

vector<int> arr(MAX);
int n;

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

    for(auto& i : arr) cin >> i;

    int ans = 0;
    
    for(int i = MAX-1; 0 <= i;i--)
        for(int j = i-1; 0 <= j;j--)
            if(arr[j] > arr[i])
                swap(arr[i],arr[j]), ans++;
    
    cout << n << " " << ans << '\n';
}