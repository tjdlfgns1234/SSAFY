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

int arr[10][10] = { 0 };

int ans = 26, sum = 0, one = 0, v = 0;
int num[6] = { 5,5,5,5,5,5 }; // 현재 종이 개수
void fill(int x, int y, int n); //  종이 채우기
void clean(int x, int y, int n); // 종이 비우기
bool isPossible(int x, int y, int n); // 종이 놓을 수 있어?
void dfs(int cnt);

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    solve();

    return 0;
}
void solve() {
    for (int i = 0; i < 10; i++)
        for (int j = 0; j < 10; j++)
            cin >> arr[i][j], one += arr[i][j];

    sum = 0, dfs(0);

    // -1 확인

    // cout << '\n';
    // cout << one << '\n';
    if (ans != 26)
        cout << ans;
    else
        cout << -1;
}
void dfs(int cnt) {
   // cout << one << ' ' << v << '\n';

    if (one == v) {
        ans = min(ans, sum);
        return;
    }


    for (int i = 0; i < 10; i++)
        for (int j = 0; j < 10; j++) {
            if (arr[i][j] == 1) {
                for (int k = 1; k <= 5; k++) {
                    if (num[k] <= 0)
                        continue;
                    if (isPossible(i, j, k)) {
                        fill(i, j, k);
                        dfs(cnt + 1);
                        clean(i, j, k);
                    }
                }
                return;
            }
        }
}
bool isPossible(int x, int y, int n) {
    if (x + n > 10 || y  + n > 10)
        return false;
    for (int i = x; i < x + n; i++)
        for (int j = y; j <  y+n; j++)
            if (arr[i][j] == 0)
                return false;

    return true; // 색종이를 놓을 수 있다.
}
void fill(int x, int y, int n) { //  종이 채우기
    for (int i = x; i < x + n; i++)
        for (int j = y; j < y + n; j++)
                arr[i][j] = 0, v++;
    num[n]--, sum++;
}
void clean(int x, int y, int n) { //  종이 비우기
    for (int i = x; i < x + n; i++)
        for (int j = y; j < y + n; j++)
            arr[i][j] = 1, v--;
    num[n]++, sum--;
}