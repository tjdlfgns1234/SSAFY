#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <stack>
#include <cstring>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 4000001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

int l, n ,x , y, z;
bool cake[1001] = { false };
int cnt[1001] = { 0 };
int ans = 0, ans2 = 0;
int v = 0;

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	solve();

	return 0;
}
void solve() {
	cin >> l >> n;

	for (int i = 1; i <= n; ++i) {
		cin >> x >> y, z = y - x + 1;
		if (z > v) ans = i, v = z;

		for (int j = x; j <= y; j++)
			if (!cake[j]) cake[j]= true, ++cnt[i];
	}

	v = 0;
	for (int i = 1; i <= n; ++i)
		if (cnt[i] > v)
			v = cnt[i], ans2 = i;

	cout << ans << '\n' << ans2;
}