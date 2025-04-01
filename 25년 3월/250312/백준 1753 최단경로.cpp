#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<list>
#include<queue>

using namespace std;
#define MAX_VERTEX 20000
#define INF 987654321

struct Edge
{
	int dir;
	int weight;
};

vector<vector<Edge>> g(MAX_VERTEX);
int cost[MAX_VERTEX + 1] = { 0 };
bool vit[MAX_VERTEX + 1] = {0};


bool operator< (const Edge& a, const Edge&b) {
	return a.weight > b.weight;
}

void Dijstra(int start, int vsize);
void solve();

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	// freopen("input.txt", "r", stdin);

	solve();
}
void solve() {
	int v, e;
	int start;
	int v1, v2, w;

	cin >> v >> e;
	cin >> start;

	for (int i = 0; i < e; i++)
	{
		cin >> v1 >> v2 >> w;

		// 단 방향 그래프
		g[v1].push_back({ v2,w });
	}

	for (int i = 1; i < v + 1; i++)
		cost[i] = INF;

	Dijstra(start, v);

	for (int i = 1; i < v + 1; i++)
		if (cost[i] == INF)
			cout << "INF" << "\n";
		else
			cout << cost[i] << "\n";
}
void Dijstra(int start, int vsize)
{
	priority_queue<Edge> pq;

	cost[start] = 0;
	vit[start] = true;
	pq.push({ start, 0 });

	while (!pq.empty()) {
		Edge curr = pq.top();
		pq.pop();
	
		for (auto& next : g[curr.dir]) {
			int new_weight = cost[curr.dir] + next.weight;
			if (new_weight < cost[next.dir])
				cost[next.dir] = new_weight, pq.push({ next.dir , new_weight });
		}
	}
}