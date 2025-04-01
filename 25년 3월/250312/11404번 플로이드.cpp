#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<list>
#include <numeric>
#include <algorithm>
#include<queue>
#define INF 987654321
#define MAX 100
using namespace std;

void solve();

int n, e;
int dist[MAX + 1][MAX + 1];


int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	// freopen("input.txt", "r", stdin);

	solve();
}
void solve() {
	cin >> n >> e;

	// 초기화
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			dist[i][j] = ((i == j) ? 0 : INF);

	int x, y, z;
	for (int i = 1; i <= e; i++) {
		cin >> x >> y >> z;

		dist[x][y] = min(dist[x][y], z);
	}

	// 모든 노드쌍(j,k)에 대해 i번 노드를 거쳐가는 경로가 더 짧다면 갱신한다.
	for (int i = 1; i <= n; i++) // 중간 노드 i
		for (int j = 1; j <= n; j++) // 시작노드 j
			for (int k = 1; k <= n; k++) // 도착 노드 k
				dist[k][j] = min(dist[k][i]+ dist[i][j], dist[k][j]);
	
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++)
			cout << ((dist[i][j] != INF) ? dist[i][j] : 0) << " ";
		cout << '\n';
	}
}