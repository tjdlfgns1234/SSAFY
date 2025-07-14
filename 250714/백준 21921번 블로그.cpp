#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 250'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

int n, m;
vector<int> arr(MAX);

// 15분 가량 소요
// 문제 이해에서 조금 헷갈렸었음.
// 간단한 투포인터 문제

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
    cin >> n >> m;

     for(int i = 0; i < n;i++) cin >> arr[i];

     int sum = 0, cnt = 0;
     for(int i = 0; i < m;i++) sum += arr[i];

     cnt = 1;

     int cur = sum;
     for(int i = m; i < n;i++){
        cur = cur - arr[i-m] + arr[i];
        if(sum < cur)
            sum = cur, cnt=1;
         else if(sum == cur)
             cnt++;
     }

    if(sum == 0)
        cout << "SAD";
    else
        cout << sum << '\n' << cnt;
}

