#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define K 256
#define MOD 127
#define MAX 1000001
#define INF 987654321
#define ll long long
using namespace std;

int n, k;
string a, b;
int f[MAX] = { 0 }; // 실패 함수

void solve();

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	getline(cin, a);
	getline(cin, b);

	int n = a.size();
	int m = b.size();

	a = "#" + a;
	b = "#" + b;

	f[0] = -1;
	
	// cout << n << '\n';

	vector<int> ans;

	for (int i = 1; i <= m; i++) {
		int j = f[i - 1];

		while (j >= 0 && b[j + 1] != b[i])
			j = f[j];
		f[i] = j + 1;
	}

	int cnt = 0, pre = -1, idx = 0;
	int j = 0;
	for (int i = 1; i <= n; i++) {
		while (j >= 0 && b[j + 1] != a[i])
			j = f[j];

		j++;

		if (j == m) {
			cnt++;
			j = f[j];
			ans.push_back(i - m + 1);
		}
	}
	cout << cnt << '\n';
	for (auto& i : ans)
		cout << i << ' ';
}