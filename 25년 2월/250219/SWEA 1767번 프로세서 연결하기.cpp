#include <iostream>
#include <queue>
using namespace std;

void solve();
void dfs(int sel, int cost, int cnt); // 각 칩별로 타고 들어감

struct chip {
	int x, y;
};

int value = 0;
int n, idx = 0, ans, testcase = 1;
int arr[13][13] = { 0 };
chip processor[14] = { 0 };
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };

int test = 0;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int t = 1;
	cin >> t;
	while (t--)
		solve();

	return 0;
}
void solve() {
	cin >> n;
	idx = 0; // 프로세서도 1부터 시작이야!
	value = 0;
	ans = 987654321;
	// 1부터 시작이야!
	for (int i = 1; i <= n; i++) 
		for (int j = 1; j <= n; j++) {
			cin >> arr[i][j];
			if (arr[i][j])
				if (i != n && i != 1 && j != n && j != 1)
					processor[idx++] = { i,j };
		}
			
	dfs(0,0, 0);

	cout << "#" << testcase++ << ' ' << ans << '\n';
}
void dfs(int sel, int cost,int cnt) { // 각 칩별로 타고 들어갈꺼야!
	if (sel == idx) {
		if (value < cnt) {
			value = cnt;
			ans = cost;
		}
		else if (value == cnt) {
			ans = min(cost, ans);
		}

		//if (ans == 8) {
		//	for (int i = 1; i <= n; i++) {
		//		for (int j = 1; j <= n; j++)
		//			cout << arr[i][j] << ' ';
		//		cout << '\n';
		//	}
		//	cout << "ans: " << ans << " value: " << value;
		//	cout << " cnt: " << cnt << '\n';
		//}

		return;
	}

	// 사용할 수 없는 경우 먼저 탐색
	dfs(sel + 1, cost, cnt); 

	// 4방향 탐색 찍을 꺼야!
	
	for (int i = 0; i < 4; i++) {
		int nx = processor[sel].x;
		int ny = processor[sel].y;
		int curr_cost = 0;
		bool f = true;
		while (1) {
			nx = nx + dx[i];
			ny = ny + dy[i];

			if (nx <= 0 || nx > n || ny <= 0 || ny > n)
				break;

			// 프로세서거나 이미 전선을 만나면 이 프로세서는 현재사용 X
			if (arr[nx][ny] != 0) {
				f = false;
				break;
			}
			curr_cost++;
			arr[nx][ny] = 2;
		}
		if(f)
			dfs(sel + 1, cost + curr_cost, cnt+1); // 사용할 수 있으므로
		// 원복
		while (1) {
			nx = nx - dx[i];
			ny = ny - dy[i];

			if (nx <= 0 || nx > n || ny <= 0 || ny > n || arr[nx][ny] == 1 || arr[nx][ny] == 0)
				break;

			arr[nx][ny] = 0;
		}
	}
}