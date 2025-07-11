#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 10001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
bool chk(int mid);

int n, m;
vector<int> arr(MAX);

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
    cin >> n;

    int sum = 0, ma = 0;
    for(int i = 0; i < n;i++) cin >> arr[i], sum+= arr[i], ma = max(ma,arr[i]);
    
    cin >> m;

    if(sum <= m){
        cout << ma;
        return;
    }
    
    int l = 1, r = 1'000'000'000;

    int ans = 0;
    while(l <= r){
        int mid = l+(r-l)/2;

        // cout << l << " " << r << " "  << mid<< '\n';
        if(chk(mid))
            l = mid + 1, ans = mid;
        else
            r = mid - 1;   
    }

    cout << ans;
}
bool chk(int mid){
    int sum = 0;

    for(int i = 0; i < n;i++)
        sum += min(mid, arr[i]);

    if(sum <= m)
        return true;
    else
        return false;
}