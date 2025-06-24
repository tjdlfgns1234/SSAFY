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

struct p {
	int x, y, cost;
};

bool operator< (const p& a,const p& b) {
	return a.cost > b.cost;
}


void solve();
void dijstra(int sx, int sy);
void rev_dijstra(int sx, int sy);
int get_height(char c);

// 1486번 등산
// https://www.acmicpc.net/problem/1486
// 문제에서 핵심 조건들을 놓쳐서 오래걸렸다.
// 알파벳 정의를 잘못 이해해서, 높이를 잘못 계산했다.

int n, m, t, d, ans;
string arr[25];

int cost[25][25]; // 시작
int cost2[25][25]; // 돌아갈때

int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };

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
	cin >> n >> m >> t >> d;

	ans = 0;

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	// 시작점은 항상 (0,0)
	// 도착점도 항상 (0,0)

	dijstra(0, 0);
	rev_dijstra(0, 0);

	for (int i = 0; i < n; i++) 
		for (int j = 0; j < m; j++) 
			if (cost[i][j] + cost2[i][j] <= d)
				ans = max(ans, get_height(arr[i][j]));
	
	cout << ans << '\n';
}
int get_height(char c) {
	if ('A' <= c && c <= 'Z') return c - 'A';
	return 26 + c - 'a';
}
void dijstra(int sx, int sy) {

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cost[i][j] = INF;

	priority_queue<p> pq;
	cost[sx][sy] = 0;
	pq.push({ sx, sy, 0 });
	
	while (!pq.empty()) {
		p cur = pq.top();
		pq.pop();

		if (cur.cost > cost[cur.x][cur.y]) continue;
		if (cur.cost >= d) continue;

		for (int i = 0; i < 4; i++) {
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];
		
			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;


			// 높이가 낮은 곳을 갈때는 1초! 아니면 제곱
			int diff = abs(get_height(arr[cur.x][cur.y]) - get_height(arr[nx][ny]));

			if (diff <= t) {
				if (arr[cur.x][cur.y] < arr[nx][ny]) 
					// 낮은 곳에서 높은 곳
					diff = diff*diff;
				
				else 
					diff = 1;

				int ncost = cur.cost + diff;
				if(ncost < cost[nx][ny])
					pq.push({ nx, ny,ncost }), cost[nx][ny] = ncost;
			}
		}
	}
}
void rev_dijstra(int sx, int sy) {

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cost2[i][j] = INF;

	priority_queue<p> pq;
	cost2[sx][sy] = 0;
	pq.push({ sx, sy, 0 });

	while (!pq.empty()) {
		p cur = pq.top();
		pq.pop();

		if (cur.cost > cost2[cur.x][cur.y]) continue;
		if (cur.cost >= d) continue;

		for (int i = 0; i < 4; i++) {
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;

			int diff = abs(get_height(arr[cur.x][cur.y]) - get_height(arr[nx][ny]));

			if (diff <= t) {
				if (arr[cur.x][cur.y] <= arr[nx][ny])
					// 낮은 곳에서 높은 곳
					diff = 1;

				else
					diff = diff*diff;

				int ncost = cur.cost + diff;
				if (ncost < cost2[nx][ny])
					pq.push({ nx, ny,ncost }), cost2[nx][ny] = ncost;
			}
		}
	}
}