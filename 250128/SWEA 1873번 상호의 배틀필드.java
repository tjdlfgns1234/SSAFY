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
void mv(const char q);
void shot();

vector<string> s(21);

int cnt = 1;
string tank[4] = { "^","v","<",">" };
int tx, ty;
string dir = ""; // 탱크 방향
int h, w;

int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };

char direction[4] = { 'U', 'D', 'L', 'R' };
char directionTank[4] = { '^', 'v', '<', '>' };

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    int t;
    cin >> t;

    while(t--)
        solve();

    return 0;
}
void solve() {
    cin >> h >> w;

    for (int i = 0; i < h; i++) cin >> s[i];
       
    int n;
    cin >> n;

    string op;
    cin >> op;

    /*
       게임 맵 밖이면 전차가 이동하지 않음.
       포탄이 발사되면 맵밖으로 나가기 전까지 직진
                       벽을 만나면 사라짐
                            강철벽은 포탄만 소멸
                            벽돌벽은 평지로 변화
    */
 
    // 전차 위치 및 방향 확인


    // 탱크 위치와 방향 확인 
    // 전차는 하나뿐임
    for (int i = 0; i < h; i++)
        for (int j = 0; j < w; j++)
            for (auto &k : tank)
                if (s[i][j] == k[0])
                    tx = i, ty = j, dir = s[i][j];
           
    // 이동
    for (auto l : op)
        if (l == 'S')
            shot();
        else
            mv(l);
        

    cout << "#" << cnt++ << ' ';

    for (int i = 0; i < h; i++)
        cout << s[i] << '\n';
}
void mv(const char q) {

    for (int i = 0; i < 4; i++) {
        if (q == direction[i]) {
            int nx = tx + dx[i];
            int ny = ty + dy[i];

            // 전차는 평지이고, 맵 밖이 아닐 때만 이동
            dir = directionTank[i]; // 이동 안해도 방향은 바꿈
            s[tx][ty] = directionTank[i];
            
            if (nx < 0 || nx >= h || ny < 0 || ny >= w || s[nx][ny] != '.')
                continue;

            s[tx][ty] = '.';
            tx = nx, ty = ny;
            s[tx][ty] = directionTank[i];
        }
    }

}
void shot() {
    for (int i = 0; i < 4; i++) {
        if (dir[0] == directionTank[i]) {
            int nx = tx, ny = ty;
            while (1) {
                nx = nx + dx[i];
                ny = ny + dy[i];
                // cout << i << ' ' << nx << ' ' << ny << " " << directionTank[i] << '\n';
                // 포탄은 맵 밖으로 나가면 사람
                // 만약 벽일 때 강철 벽이어도 사라짐
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || s[nx][ny] == '#')
                    return;

                // 그냥 벽이면 부수고 평지로 만듬
                if (s[nx][ny] == '*') {
                    s[nx][ny] = '.';
                    return;
                }
            }
        }
    }
}