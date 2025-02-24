#define _CRT_SECURE_NO_WARNINGS
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
void dfs(int idx, int cnt);
bool check(int idx, int k);
int n, m, ans, cnt = 1;
string s[9];

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
    n = 9;
    for (int i = 0; i < n; i++) cin >> s[i];

    dfs(0, 0);

    // cout << ans;
   //  cout << "#" << cnt++ << ' ' << ans << '\n';
}
void dfs(int idx,int cnt) {
    if (cnt == n*n) {
        for (auto i : s)
            cout << i << '\n';
        
        exit(0);
        return;
    }

    int nx = idx / n;
    int ny = idx % n;

    if (s[nx][ny] == '0')  // 무조건 채워 넣어야함
        for (int i = 1; i <= n; i++) {
            if (check(idx, i)) { // 
                s[nx][ny] = '0' + i;
                dfs(idx + 1, cnt + 1);
                s[nx][ny] = '0';
            }
            else
                s[nx][ny] = '0';
        }
    else 
        dfs(idx + 1, cnt + 1);
    
}
bool check(int idx, int k) {
    int nx = idx / n;
    int ny = idx % n;

    char target= '0' + k;

    // 행 확인
    for (int i = 0; i < n; i++)
        if (s[nx][i] == target) return false;

    // 열 확인
    for (int i = 0; i < n; i++)
        if (s[i][ny] == target) return false;

    // 속한 사각형 확인
    int sx = (nx / 3) * 3;
    int sy = (ny / 3) * 3;
    nx = sx, ny = sy;
    for (int i = nx; i < sx+3; i++)
        for (int j = ny;j < sy+3;j++)
           if (s[i][j] == target) return false;

    return true;
}