#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100001
using namespace std;

// 공부중..

struct Edge {
	int e, cost;
};

int n, m;
vector<vector<int>> g(MAX), rev_g(MAX), lev_list(MAX);
int indeg[MAX] = { 0 }, lev[MAX] = { 0 };
set<int> s;

void solve();
void topological_sort();

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n >> m;
	int x, y;
	for (int i = 1; i <= m; i++) {
		cin >> x >> y;

		// 단방향
		g[x].push_back(y), indeg[y]++;
		rev_g[y].push_back(x);
	}

	topological_sort();

	// cout << ans;
}
void topological_sort()
{
	queue<int> q;

	for (int i = 1; i <= n; i++)
		if (!indeg[i]) // indeg가 0인 정점 삽입
			q.push(i);


	// 위상 정렬 + level
	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		// lev는 0부터 시작
		lev_list[lev[cur]].push_back(cur);

		for (auto& i : g[cur]) {
			lev[i] = max(lev[cur] + 1, lev[i]);
			indeg[i]--;
			if (!indeg[i])
				q.push(i);
		}
	}

	//for (int i = 0; 0 < lev_list[i].size(); i++) {
	//	cout << "lev "<<  i << " :";
	//	for (auto&j : lev_list[i])
	//		cout << " " << j << " ";
	//	cout << '\n';
	//}


	vector<int> ans;

	// 하위 레벨부터 탐색 시작
	// s: 순위가 결정되지 않은 것이 저장
	// size가 1일 경우 순위가 결정됨
	for (int i = 0; 0 < lev_list[i].size(); i++) {

		//cout << "------------------\n";
		//cout << "set: ";
		//for (auto& j : s)
		//	cout << j << " ";
		//cout << "\n";


		for(auto&j : lev_list[i])
			for (auto& k : rev_g[j]) 
				s.erase(k);
			

		if(lev_list[i].size() == 1)
			if(s.empty())
				ans.push_back(lev_list[i][0]);
		
		s.insert(lev_list[i].begin(), lev_list[i].end());
		

		//cout << "set: ";
		//for (auto& j : s)
		//	cout << j << " ";

		//cout << '\n';
	}

	sort(all(ans));

	cout << ans.size() << '\n';

	// cout << "ans : ";
	for (auto& i : ans)
		cout << i << " ";
}
