#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 10'000'000'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

constexpr int MAX = 501;


/*
    G5, Implementation
    기본적인 Edge Case을 테스트 하지 않아
    2번의 틀렸습니다를 받았다.
*/


int h, w;
int arr[MAX];
int board[MAX][MAX];

void solve();

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
	cin >> h >> w;

	for (int i = 0; i < w; i++) cin >> arr[i];

	for (int i = 0; i < w; i++) 
		for (int j = h-1; j >= h-arr[i]; j--)
			board[j][i] = 1;
	
	int ans = 0, cnt = 0;
	bool f = false;
	for (int i = h-1; i >= 0; i--) {
		f = false;
		for (int j = 0; j < w; j++) {
			if (board[i][j] == 0) {
				// 빈공간
				cnt++;
			}
			else if (board[i][j] == 1) {
				// 벽
				if (f) {
					// 이전값이 벽이면
					ans += cnt;
					cnt = 0;
				}

				f = true;
				cnt = 0;
			}
		}

		// cout <<  "Test : " << ans << '\n';

		cnt = 0;
	}

	//for (int i = 0; i < h; i++) {
	//	for (int j = 0; j < w; j++) 
	//		cout << board[i][j] << " ";
	//	cout << '\n';
	//}

	cout << ans << '\n';


}