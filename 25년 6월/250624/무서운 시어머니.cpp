#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 200'000'000

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
void init();
void dijstra(int n, int sx, int sy);

int arr[1001][1001];
int cost[1001][1001];
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,1,0, -1 };


int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	freopen("input.txt", "r", stdin);

	int t = 1;
	// cin >> t;

	while (t--)
		solve(), init();

	return 0;
}
void solve() {
	int sx, sy; // 시어머니의 좌표
	cin >> sx >> sy;

	int n; // 마을 수 (정사각형 이기때문)
	cin >> n;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> arr[i][j], cost[i][j] = INF;

	dijstra(n, sx, sy);
}
void init() {
	memset(arr, 0, sizeof(arr));
	memset(cost, 0, sizeof(cost));
}
void dijstra(int n, int sx, int sy) {

	priority_queue<pair<int, pair<int, int>>> pq;
	pq.push({ arr[sx][sy], { sx, sy } });
	cost[sx][sy] = arr[sx][sy];

	while (!pq.empty()) {
		int x = pq.top().second.first;
		int y = pq.top().second.second;
		int dist = pq.top().first;

		pq.pop();

		if (dist >= INF) continue;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == -1)
				continue;

			if (dist + arr[nx][ny] < cost[nx][ny]) {
				cost[nx][ny] = dist + arr[nx][ny];
				pq.push({ cost[nx][ny],{nx,ny} });
			}
		}
	}

	int ans = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			if(cost[i][j] < INF)
				ans = max(ans, cost[i][j]);

	cout << ans;
}