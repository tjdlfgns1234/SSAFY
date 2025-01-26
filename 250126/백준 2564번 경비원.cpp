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
int dist(int sx, int sy, int x, int y);
pii trans(int x, int y);

int n, m; // 블록의 길이
int t; // 상점의 개수

int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,1,-1 };

int chk[101][101] = { 0 }; // 탐색
pair<int, int> arr[101];

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    solve();

    return 0;
}
void solve() {
    cin >> m >> n >> t;



    for (int i = 1; i <= t; i++) 
        cin >> arr[i].first >> arr[i].second;
  
    int x, y;
    cin >> x >> y; // 동근이의 좌표

    int ans = 0;

    for (int i = 1; i <= t; i++) 
        ans += dist(x, y, arr[i].first, arr[i].second);

   
    cout << ans;
}
int dist(int sx, int sy, int x, int y) {
    memset(chk, 0, sizeof(chk));

    for (int i = 1; i < n; i++)
        for (int j = 1; j < m; j++)
            chk[i][j] = 1; // 지나갈수 없음 

    int px, py;
    tie(px, py) = trans(sx, sy); // 상점 최표
    chk[px][py] = 2; // 동근이 위치

    tie(px, py) = trans(x, y); // 상점 최표
    queue <tuple<int,int,int>> q;

    chk[px][py] = 1;

    q.push({ px,py,0 });


    ////  배열 확인
    //for (int i = 0; i <= n; i++) {
    //    for (int j = 0; j <= m; j++)
    //        cout << chk[i][j] << ' ';
    //    cout << '\n';
    //}
    //cout << '\n';

    int ret = 987654321;

    while (!q.empty()) {
        int a, b, c;
        tie(a, b,c) = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = a + dx[i];
            int ny = b + dy[i];

            if (nx < 0 || nx >n || ny < 0 || ny > m || chk[nx][ny] == 1)
                continue;


            if (chk[nx][ny] == 2) {
                ret = min(ret, c+1);
                continue;
            }

            chk[nx][ny] = 1;
            q.push({ nx, ny, c + 1 });
        }
    }


    return ret;
}
pii trans(int x, int y){
    pii ret;
    if (x == 1)  // 북쪽이면
        ret.first = 0, ret.second = y;
    else if (x == 2)  // 남쪽이면
        ret.first = n, ret.second = y;
    else if (x == 3)  // 서쪽이면
        ret.first = y, ret.second = 0;
    else if (x == 4)  // 동쪽이면
        ret.first = y, ret.second = m;

    return ret;

}