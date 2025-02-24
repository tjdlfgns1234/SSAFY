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
void init();
void bfs(int start);
vector<vector<int>> arr(501);
vector<vector<int>> rev(501);
bool vit[501] = { false };

int n, m, ans, cnt = 1;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

   //freopen("input.txt", "r", stdin);

    int t = 1;
    // cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> n >> m;

    init();
    int x, y;
    for (int i = 0; i < m; i++) {
        cin >> x >> y;

        arr[x].push_back(y);
        rev[y].push_back(x);
    }

    for (int i = 1; i <= n; i++)
        bfs(i);

    cout << ans;
   //  cout << "#" << cnt++ << ' ' << ans << '\n';
}
void init() {
    ans = 0;
    memset(vit, 0, sizeof(vit));
    for (int i = 1; i <= n; i++)
        arr[i].clear(), rev[i].clear();
}
void bfs(int start) {
    queue <int> q;
    int sum = 0;
    q.push(start);
    vit[start] = true;

    memset(vit, 0, sizeof(vit));

    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        for (auto& i : arr[curr])
            if (!vit[i])
                q.push(i), vit[i] = true, sum++;
    }

    memset(vit, 0, sizeof(vit));

    q.push(start);
    vit[start] = true;


    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        for (auto& i : rev[curr])
            if (!vit[i])
                q.push(i), vit[i] = true, sum++;
    }

    if (sum == n - 1)
        ans++;
}