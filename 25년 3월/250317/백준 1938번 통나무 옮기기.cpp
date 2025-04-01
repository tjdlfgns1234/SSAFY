#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define MOD 1000000007
#define MAX 50000
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

enum {
	U, D, L, R, T
};

struct p {
	int x, y;
};

struct namu {
	int x, y, isrotate, cnt;// x, y좌표, 회전여부
};

int n, ans;
string s[50];
bool vit[50][50][2];
int dx[4] = { 1, -1, 0,0 };
int dy[4] = { 0, 0, 1,-1 };
p t[3] = { 0 };
p e[3] = { 0 };

void solve();
bool check(int x,int y);
bool rCheck(int x, int y);

// 상태 정의가 핵심!

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    // freopen("input.txt", "r", stdin);

    int t = 1;
    //cin >> t;

    while (t--)
        solve();

	cout << ans;

    return 0;
}
void solve() {
	cin >> n;

	memset(vit, false, sizeof(vit));
	for (int i = 0; i < n; i++) cin >> s[i];

	int idx = 0, idx2 = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			if (s[i][j] == 'B')
				t[idx++] = { i,j };
			else if (s[i][j] == 'E')
				e[idx2++] = { i,j };

	// 회전시 중앙점 기준으로 한그루의 나무도 없어야 한다
	queue<namu> q;

	// 1일때 가로, 0일때 세로
	q.push({ t[1].x,t[1].y, t[0].x == t[2].x, 0 });
	vit[t[1].x][t[1].y][(t[0].x == t[2].x)] = true;

	while (!q.empty()) {
		namu curr = q.front();
		q.pop();

		// cout << curr.x + 1 << " " << curr.y + 1 << ' ' << curr.cnt << " " << curr.isrotate << '\n';
		if (curr.x == e[1].x && curr.y == e[1].y) {
			if ((e[0].x == e[2].x) == curr.isrotate) {
				ans = curr.cnt;
				return;
			}

		}

		int nx, ny; // 4방향 탐색
		for (int i = 0; i < 4; i++) {
			nx = curr.x + dx[i];
			ny = curr.y + dy[i];

			// 그냥 할때
			if (curr.isrotate) {// 가로 일때
				if (check(nx, ny-1) && check(nx, ny) && check(nx, ny+1))
					if (!vit[nx][ny][curr.isrotate])
						vit[nx][ny][curr.isrotate] = true, q.push({ nx,ny,curr.isrotate , curr.cnt + 1 });
			}
			else
				if (check(nx-1, ny) && check(nx, ny) && check(nx+1, ny)) 
					if (!vit[nx][ny][curr.isrotate])
						vit[nx][ny][curr.isrotate] = true, q.push({ nx,ny,curr.isrotate , curr.cnt + 1 });
		}
		// 회전 할때
		nx = curr.x;
		ny = curr.y;
		curr.isrotate = (!curr.isrotate);
		// 회전가능하면 돌려서 추가
		if (rCheck(nx, ny)) 
			if (!vit[nx][ny][curr.isrotate])
				vit[nx][ny][curr.isrotate] = true, q.push({ nx,ny,curr.isrotate , curr.cnt + 1 });
	}
}
bool check(int x, int y) {
	if (x < 0 || x >= n || y < 0 || y >= n || s[x][y] == '1')
		return false;

	return true;
}
bool rCheck(int x, int y) {
	// 입력값은 늘 중심값
	if (check(x - 1, y - 1) && check(x + 1, y + 1)) {
	
		for(int i = x-1; i <= x+1;i++)
			for (int j = y - 1; j <= y + 1; j++) 
				if (s[i][j] == '1')
					return false;
					
		return true;
	}
	return false;
}