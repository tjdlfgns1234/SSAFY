#include <bits/stdc++.h>
#define all(x) x.begin(),x.end()
using namespace std;

void solve();
void dfs(int cur);

char* arr;
int n;
string result;
int cnt = 1;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int t = 10;
	// cin >> t;
	while(t--)
		solve();

}
void dfs(int cur) {
	if (cur > n) return;
	dfs(cur * 2);
	cout << arr[cur];
	dfs(cur * 2 + 1);
}

void solve() {
	cin >> n;

	cin.ignore();

	arr = new char[n + 1];

	for (int i = 1; i <= n; i++) {
		string s;
		getline(cin, s);
		bool f = false;
		for (char c : s) {
			if (f) {
				arr[i] = c;
				break;
			}
			if (c == ' ') f = true;
		}

	}

	cout << "#" << cnt++ << " ";

	dfs(1);
	// delete[] arr;
	cout << '\n';
}