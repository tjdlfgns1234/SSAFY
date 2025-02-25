#include <iostream>
#include <algorithm>
#include <list>
#include <vector>
#include <queue>
#define MAX 50000
using namespace std;
vector<vector<int>> graph(MAX);
int Lca(int v, int w);
int d[MAX + 1] = { 0 };
int parent[MAX + 1] = { 0 };
bool visit[MAX + 1] = { false };
void bfs(); // d 확인

int main(void)
{
	ios::sync_with_stdio(NULL);
	cout.tie(NULL), cin.tie(NULL);

	int n, m;
	cin >> n;
	d[1] = 1;

	for (int i = 0; i < n - 1; i++)
	{
		int v, w;
		cin >> v >> w;
		graph[v].push_back(w);
		graph[w].push_back(v);
	}

	bfs();
	cin >> m;

	for (int i = 0; i < m; i++)
	{
		int v, w;
		cin >> v >> w;
		cout << Lca(v, w) << '\n';
	}

	return 0;
}
void bfs() // d 확인
{
	queue <int> q;
	visit[1] = 1; // 루트는 무조건 1번
	q.push(1);
	while (!q.empty())
	{
		int curr = q.front();
		q.pop();
		
		for (auto i : graph[curr]) 
			if (!visit[i]) 
				q.push(i), visit[i] = true, d[i] = d[curr] + 1, parent[i] = curr;
	}
}
int Lca(int v, int w)
{
	// 더 깊은 것만 선택
	if(d[v] > d[w]) swap(v,w);

	while (d[v] != d[w])w = parent[w];

	while (v != w)
		v = parent[v], w = parent[w];
	return w;
