#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

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
	int n;
	cin >> n;

	for (int i = 0; i <= 100; i++)
		for (int j = 0; j <= 100; j++) 
			if ((i + j) * (i + j) == n) {
				cout << i << " " << j << '\n';
				return;
			}
	cout << -1 << '\n';
}