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
void put_archer(int cnt); // 궁수 배치
int dist(int x, int y, int x2, int y2);
void attack(); // 궁수가 적 공격
bool mv();  // 적 이동


int n, m, d, ans = 0, sum = 0, enemy = 0, arrive = 0;
int arr[16][16] = { 0 };
int cp[16][16] = { 0 }; // 복사된 배열
bool archer[16] = { false };

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    solve();

    return 0;
}
void solve() {
    cin >> n >> m >> d;


    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
            cin >> arr[i][j], enemy += arr[i][j]; // 1은 적이 있는 칸

    put_archer(0);

    cout << ans;
}
bool mv() {// 적 이동
    bool f = false; // 종료조건 확인
    for (int i = 1; i <= m; i++)
        if (cp[n][i] == 1) // 적이 성에 진입하면 제외
            arrive += cp[n][i];

    for (int i = n - 1; i >= 1; i--)
        for (int j = 1; j <= m; j++)
            cp[i + 1][j] = cp[i][j];

    for (int i = 1; i <= m; i++)
        cp[1][i] = 0;


    return f;
}
void attack() { // 궁수가 공격함
    // 왼쪽의 있는 궁수부터 처리함
    // 적도 왼쪽부터 처리함

    stack <pii> st; // 제거할 적의 위치
    int x, y, z = INF;
    for (int i = 1; i <= m; i++) {
        if (archer[i]) { // 궁수가 있으면
            for (int j = n; j >= 1; j--)
                for (int k = 1; k <= m; k++) {
                    if (cp[j][k] != 0) {
                        int distance = dist(n + 1, i, j, k);
                        if (distance <= d) {
                            // 범위안에 있으면
                            if (distance < z)  // 현재 적보다 가까우면
                                x = j, y = k, z = distance;
                            if (distance == z && k < y)  // 현재 적보다 가까우면
                                x = j, y = k, z = distance;
                            // 제거할 적의 좌표를 스택에 입시 저장
                        }
                    }
                }
            if (z != INF)
                st.push({ x,y }), z = INF; // 초기화
        }
    }

    while (!st.empty()) {
        tie(x, y) = st.top(), st.pop();
        if (cp[x][y] == 1)
            cp[x][y] = 0, sum++;
    }
}
void put_archer(int cnt) { // 궁수 배치
    if (cnt == 3) {
        // 궁수 배치가 끝나면 게임 시작
        // 게임 시작
        sum = 0, arrive = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                cp[i][j] = arr[i][j];

        while (1) {
            attack();

            // 디버깅용
  /*          for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++)
                    cout << cp[i][j] << ' ';
                cout << '\n';
            }
            cout << '\n';*/


            if (mv() || enemy == sum + arrive) {
                break;
            }

        }
        ans = max(sum, ans);
        return;
    }

    for (int i = 1; i <= m; i++) {
        if (!archer[i]) {
            archer[i] = true;
            put_archer(cnt + 1);
            archer[i] = false;
        }
    }
}
int dist(int x, int y, int x2, int y2) {
    return abs(x - x2) + abs(y - y2);
}
