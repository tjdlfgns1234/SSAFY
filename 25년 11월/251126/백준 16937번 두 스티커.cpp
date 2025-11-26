#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 2e9
#define sum(a) (a*(a+1)/2)

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

struct sticker {
	int x, y;
};

constexpr int MAX = 101;

void solve();
bool fill(int x1, int x2, int y1, int y2); // 채우는 함수

int h, w, n; // 범위는 전부 100이하
bool board[MAX][MAX];

/*
	스티커는 서로 겹치면 안됨.
	스티커가 접하는 것은 가능.
	스티커는 90도 회전 시키는 것 가능
	스티커가 모눈 종이를 벗어나는 것은 불가능

    스티커가 접하는 경우가 가장 많이 붙일 수 있는 경우
    스티커가 접하는 거만 생각하면 해결됨.

	bruteforce O(n^5) 
*/

vector<sticker> arr;

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
    cin >> h >> w >> n;

    vector<sticker> arr;

    int x, y;
    for (int i = 0; i < n; i++) cin >> x >> y, arr.push_back({ x,y });
    

    n = arr.size();
    int ans = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int x1 = arr[i].x, y1 = arr[i].y;
            int x2 = arr[j].x, y2 = arr[j].y;

            // 첫 번째 스티커 방향 2가지
            for (int r1 = 0; r1 < 2; r1++) {
                int a = (r1 ? y1 : x1);
                int b = (r1 ? x1 : y1);

                // 두 번째 스티커 방향 2가지
                for (int r2 = 0; r2 < 2; r2++) {
                    int c = (r2 ? y2 : x2);
                    int d = (r2 ? x2 : y2);

                    // 가로로 나란히 (종이 기준 H×W 그대로 사용)
                    if (a + c <= h && max(b, d) <= w)
                        ans = max(ans, a * b + c * d);
                    if (a + c <= w && max(b, d) <= h)
                        ans = max(ans, a * b + c * d);

                    // 세로로 나란히
                    if (max(a, c) <= h && b + d <= w)
                        ans = max(ans, a * b + c * d);
                    if (max(a, c) <= w && b + d <= h)
                        ans = max(ans, a * b + c * d);
                }
            }
        }
    }

    cout << ans;
}