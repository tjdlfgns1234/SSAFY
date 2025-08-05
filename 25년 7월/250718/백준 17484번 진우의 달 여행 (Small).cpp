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

// DP
// 점화식은 잘 세웠는데 구현이 오래걸렸고, 답지를 봤다.
// 오래걸렸던 이유는 더미를 만들어 구현을 더쉽게 할려 했으나
// 너무 많은 것을 고려해야 했다. 
// 결론 기본에 충실하자


int n, m;
int arr[6][6], dp[6][6][5];

int dy[4] = {0, -1,0,1};

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

    for(int i = 0; i < n; i++) 
        for(int j = 0; j < m;j++)
            cin >> arr[i][j];

    for(int i = 0; i < n; i++) 
        for(int j = 0; j < m;j++)
            for(int l = 0; l < 5;l++) // 구현이 편하도록 양끝에 패딩 추가
                dp[i][j][l] = MAX;
    
    // base case 지구에서 출발 할때
    for(int j = 0; j < m;j++)
        for(int l = 1; l <= 3;l++)
            dp[0][j][l]= arr[0][j];

    for(int i = 1; i < n; i++) {
        for(int j = 0; j < m; j++) {
            for(int l = 1; l <= 3; l++) {
                int pre = j - dy[l];
                if(pre < 0 || pre >= m) continue; // 인덱스 범위 체크
    
                for(int k = 1; k <= 3; k++) {
                    if(k == l) continue; // 연속 같은 방향 불가
                    dp[i][j][l] = min(dp[i][j][l], dp[i-1][pre][k] + arr[i][j]);
                }
            }
        }
    }
    
    int ans = MAX;
    for(int i = 0; i < m;i++) 
        for(int j = 1; j <= 3;j++)
            ans = min(ans, dp[n-1][i][j]);
    
    cout << ans;
    
}