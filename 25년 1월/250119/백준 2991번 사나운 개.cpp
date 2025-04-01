#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 4000001
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


void solve();

int a, b, c, d;
int arr[3];

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	solve();

	return 0;
}
void solve() {
	cin >> a >> b >> c >> d;

	for (int i = 0; i < 3; i++) cin >> arr[i], arr[i]--;

	for (int i = 0; i < 3; i++) {
		int tmp = 0;
		if (arr[i] % (a + b) < a)
			tmp++;
		if (arr[i] % (c + d) < c)
			tmp++;

		cout << tmp << '\n';
	}
}
