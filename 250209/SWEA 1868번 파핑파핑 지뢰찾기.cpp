#include <bits/stdc++.h>
#include <unordered_map>
#include <unordered_set>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 4000001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


void solve();
bool mine_chk(int x, int y);
void bfs(int x, int y);

int n, b;
int cnt = 1, ans;
string s[301];
bool chk[301][301] = { false };

int dx[8] = { 1,0,-1,0,1,1,-1,-1 };
int dy[8] = { 0,1,0,-1,1,-1,1,-1 };


int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    int t;
    cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    memset(chk, 0, sizeof(chk));
    cin >> n;

    ans = 0;
    for (int i = 0; i < n; i++)
        cin >> s[i];

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            if(!chk[i][j] && mine_chk(i,j) && s[i][j] != '*') // 지뢰가 없는 부분 탐색
                bfs(i, j);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            if (!chk[i][j] && s[i][j] != '*')
                ans++;

    cout << "#" << cnt++ << ' ' << ans << '\n';
}
bool mine_chk(int x, int y) {
    for (int i = 0; i < 8; i++) {
        int nx = dx[i] + x, ny = dy[i] + y;

        if (nx <0 || nx >= n || ny < 0 || ny >= n)
            continue;


        if (s[nx][ny] == '*')
            return false;
    }

    return true;
}
void bfs(int x, int y) {
    queue <pii> q;
    q.push({ x,y });
    chk[x][y] = true;

    while (!q.empty()) {
        int sx, sy;
        tie(sx, sy) = q.front();
        q.pop();


        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + sx, ny = dy[i] + sy;

            if (nx <0 || nx >= n || ny < 0 || ny >= n || chk[nx][ny] || s[nx][ny] == '*')
                continue;

            chk[nx][ny] = true;

            if (mine_chk(nx, ny)) {
                //cout << nx << ' ' << ny << '\n';
                q.push({ nx,ny });
            }

        }
    }

    ans++;
}