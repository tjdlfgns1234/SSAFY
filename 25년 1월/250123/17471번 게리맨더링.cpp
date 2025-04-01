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
void dfs(int cnt, int idx);
bool bfs();
void calc();


int n, ans = 987654321, sum = 0, cnt = 0; // 총 인구수
int arr[11] = { 0 }; // 인구수
bool chk[11] = { false }; // 사용 확인
 
vector<vector<int>> g(11); // 1부터 시작

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    solve();

    return 0;
}
void solve() {
    cin >> n;

    for (int i = 1; i <= n; i++)
        cin >> arr[i], sum += arr[i];

    int a;
    for (int i = 1; i <= n; i++) {
        cin >> a;

        int x;
        for (int j = 0; j < a; j++) {
            cin >> x;

            // 무방향 그래프
            g[x].push_back(i);
            g[i].push_back(x);
        }
    }

    dfs(0, 1);
    if (ans == 987654321)
        cout << -1;
    else
        cout << ans;
}
void dfs(int cnt, int idx) {
    if (cnt == n) {
        if(bfs()) // 선거구가 모두 이어져 있으면 OK
          calc();

        return;
    }


    chk[idx] = true;
    dfs(cnt + 1, idx+1);
    chk[idx] = false;
    dfs(cnt + 1, idx + 1);
}
void calc() {
    int sum2 = 0;
    for (int i = 1; i <= n; i++) 
        if (chk[i])
            sum2 += arr[i];

    ans = min(ans, abs(sum - 2 * sum2));
}
bool bfs() {
    bool chk2[11] = { false };
    queue <int> q;

    for(int i = 1; i <=n; i++)
        if (chk[i]) {
            q.push(i), chk2[i] = true;
            break;
        }

    while (!q.empty()) {
        int x = q.front();
        q.pop();

        for (auto i : g[x])
            if (!chk2[i] && chk[i])
                chk2[i] = true, q.push(i);
    }

    for (int i = 1; i <= n; i++)
        if (chk[i] != chk2[i])
            return false;

    memset(chk2, false, sizeof(chk2));


    for (int i = 1; i <= n; i++)
        if (!chk[i]) {
            q.push(i), chk2[i] = true;
            break;
        }

    while (!q.empty()) {
        int x = q.front();
        q.pop();

        for (auto i : g[x])
            if (!chk2[i] && !chk[i])
                chk2[i] = true, q.push(i);
    }

    //for (int i = 1; i <= n; i++)
    //    cout << chk2[i]<< ' ';
    //cout << '\n';

    //for (int i = 1; i <= n; i++)
    //    cout << chk[i] << ' ';
    //cout << '\n';

    //cout << '\n';
    for (int i = 1; i <= n; i++)
        if (!chk[i] != chk2[i])
            return false;

    return true;
}