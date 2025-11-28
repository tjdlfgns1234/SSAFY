#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 2e9
#define sum(a) (a*(a+1)/2)
#define ADD 1000'000'000
#define SUB 1000'000'001
#define SPACE 1000'000'002

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
void dfs(int cnt);
int calc();

constexpr int MAX = 10;

int n;
vector<int> ops; // 연산자만
vector<int> ans; // 정답 배열
vector<int> arr; // 가공전 배열

/*
    G5, Brute Force, DFS
*/

int main()
{
	ios::sync_with_stdio(NULL);	
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	cin >> n;

	dfs(1);

	cout << '\n';
}
void dfs(int cnt) {
	if(cnt == n){ // 연산자만 고름

		if (calc() == 0) {
			for(int i = 0; i < ans.size();i++)
				if (ans[i] < ADD)
					cout << ans[i];
				else if (ans[i] == ADD)
					cout << "+";
				else if (ans[i] == SUB)
					cout << "-";
				else if (ans[i] == SPACE)
					cout << " ";
			cout << '\n';
		}
		

		arr.clear();
		ans.clear();

		return;
	}

	ops.push_back(SPACE);
	dfs(cnt + 1);
	ops.pop_back();

	ops.push_back(ADD);
	dfs(cnt + 1);
	ops.pop_back();

	ops.push_back(SUB);
	dfs(cnt + 1);
	ops.pop_back();


}
int calc() {

	queue<int> q;
	int cnt = 1;
	arr.push_back(cnt);
	ans.push_back(cnt);

	for (int i = 0; i < ops.size(); i++) {
		ans.push_back(ops[i]);
		ans.push_back(++cnt);

		if (ops[i] != SPACE) 
			arr.push_back(ops[i]), arr.push_back(cnt);
		else 
			arr[arr.size()-1] = arr[arr.size()-1] * 10 + cnt;
		
	}

	int ret = 0;
	
	//for (int i = 0; i < arr.size(); i++)
	//	if (arr[i] < ADD)
	//		cout << arr[i];
	//	else if (arr[i] == ADD)
	//		cout << "+";
	//	else if (arr[i] == SUB)
	//		cout << "-";
	//	else if (arr[i] == SPACE)
	//		cout << " ";
	//cout << '\n';

	ret = arr[0];
	for (int i = 1; i < arr.size(); i++) 
		if (arr[i] == ADD)
			ret += arr[++i];
		else if (arr[i] == SUB)
			ret -= arr[++i];
	
	// cout << " ret : " << ret << '\n';

	return ret;
}


