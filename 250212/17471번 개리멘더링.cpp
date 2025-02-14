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
void recursive(int idx, int cnt);
bool chk(int cnt, bool target);

int n;
int population[11] = { 0 } ; // 1부터 시작이야
bool sel[11] = { false };
int ans = INF;

vector<vector<int>> arr(11);


int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    freopen("input.txt", "r", stdin);

    int t = 1;
    // cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> n;

    // 인구 입력
    for (int i = 1; i <= n; i++) cin >> population[i];

    int x, y;
    // 그래프 제작
    for (int i = 1; i <= n; i++) {
        cin >> x;
        for (int j = 0; j < x; j++) {
            cin >> y;
            arr[i].push_back(y);
            arr[y].push_back(i);
        }
    }

    recursive(1,0);

    if (ans == INF)
        ans = -1;

    cout << ans;
    // cout << test << '\n';
}
void recursive(int idx, int cnt) {
    if (idx == n + 1) {
        if (cnt == 0 || cnt == n)
            return;

        if (chk(cnt, true))
            return;

        if (chk(n - cnt, false))
            return;


        int a = 0, b = 0;

        for (int i = 1; i <= n; i++)
            if (sel[i])
                a += population[i];
            else
                b += population[i];

        ans = min(ans, abs(a - b));


        //for (int i = 1; i <= n; i++)
        //    cout << sel[i] << ' ';

        //cout << "diff : " << abs(a - b) << " "  << cnt;
        //cout << '\n';


        return;
    }

    sel[idx] = true;
    recursive(idx + 1, cnt + 1);
    sel[idx] = false;
    recursive(idx + 1, cnt);
}
bool chk(int cnt, bool target) {
    bool f = false;
    bool vit[11] = { false };

    queue <int> q;

    int sum = 0;
    for (int i = 1; i <= n; i++) {
        if (sel[i] == target) { // 선택된 선거구 일때
            
            q.push(i);
            vit[i] = true, sum = 1;
            while (!q.empty()) {
                int curr = q.front();
                q.pop();
                for (auto next : arr[curr]) {
                    if (!vit[next] && (target == sel[next]))
                        q.push(next), vit[next] = true, sum++;
                }
            }
            if (cnt != sum)
                f = true;
        }
    }

    return f;
}