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
void plant(int time);
void explosion(int time);

int r, c, n;
string s[201];
int arr[201][201] = { 0 };
int mp[201][201] = { 0 };
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
    cin >> r >> c >> n;

    for (int i = 0; i < r; i++) 
        cin >> s[i];

    
    // 초기 셋팅
    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            if (s[i][j] == 'O')
                arr[i][j] =  0;



    for (int time = 2; time <= n; time++) {
        plant(time);
        time++;
        if (time > n)
            break;
        explosion(time);
    }
    


    for (int i = 0; i < r; i++)
        cout << s[i] << '\n';
    
}
void plant(int time) {
    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            if (s[i][j] == '.')
                arr[i][j] = time , s[i][j] = 'O';
}
void explosion(int time) {
    int dx[4] = { -1,1,0,0 };
    int dy[4] = { 0,0, -1,1 };

    memset(mp, 0, sizeof(mp));

    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            if (arr[i][j] == time-3 && s[i][j] == 'O') {
                arr[i][j] = 0, s[i][j] = '.';

                int nx, ny;
                for (int k = 0; k < 4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c)
                        continue;

                    mp[nx][ny] = 1;
                }
            }


    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            if (mp[i][j] == 1)
                s[i][j] = '.', arr[i][j] = 0;
}