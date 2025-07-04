#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 10'000'000'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int n, m, cnt = 1;
int p[MAX];
ll w[MAX];

void solve();
void init();
int find(int x);
bool _union(int x, int y,ll diff);
bool _union(int x, int y);

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	// cin >> t;

	while (t)
		init(), solve();

	return 0;
}
void solve() {
	cin >> n >> m;

	if (n == 0 && m == 0) exit(0); // 종료 조건
	

	// cout << "#" << cnt++ << " ";

	string cmd;
	int a, b;
	ll c;
	for (int i = 0; i < m; i++) {
		cin >> cmd;

		if (cmd[0] == '!') {
			cin >> a >> b >> c;
			
			_union(a, b, c);
		}
		else if (cmd[0] == '?') {
			cin >> a >> b;

			if (find(a) != find(b)) // 서로 다른 집합이면 비교 못함
				cout << "UNKNOWN" << '\n';
			else // 같은 집합이면 비교 가능
				cout << w[b] - w[a] << '\n';
		}
	}

	// cout << '\n';
}
void init() {
	memset(w, 0, sizeof(w));
	for (int i = 0; i < MAX; ++i) p[i] = i;
}
int find(int x) {
	if (x == p[x])
		return x;

	int pa = p[x];
	p[x] = find(p[x]), w[x] += w[pa];

	return p[x];
}
bool _union(int x, int y, ll diff) {
	int nx = find(x), ny = find(y);
	
	if (nx == ny)
		return false;

	// x와 y 중 어느 쪽으로 연결해야 할까?
	// - 더 무거운 쪽이라던가, 뭔가 기준없이 무조건 뒤에 오는 집합이 움직인다.
	// parents[rootB] = rootA;
	// weights[rootB] = weights[A] - weights[B] + w;

	// 항상 동일한 기준으로 집합을 병합시켜 주어야 한다.
	// 일반적인 경우 (더 큰 번호의 root로 병합)
	// 아래와 같은 형식
	
	//if (rootA < rootB) {
	//	parents[rootA] = rootB;
	//	weights[rootA] = weights[B] - weights[B] + w;
	//}
	//else {
	//	parents[rootB] = rootA;
	//	weights[rootB] = weights[A] - weights[B] + w;
	//}


	p[ny] = nx;
	w[ny] = diff + w[x] - w[y];

	return true;
}