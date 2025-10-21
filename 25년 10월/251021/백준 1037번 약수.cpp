#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 1e9
#define sum(a) (a*(a+1)/2)

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int n;

/*
    B1, Sort
*/

void solve();

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	freopen("input.txt", "r", stdin);

	int t = 1;
	// cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	cin >> n;
	
	vector<int> arr(n);

	for (auto& i : arr) cin >> i;

	sort(all(arr));

	int size = arr.size();

	if (size == 1)
		cout << arr[0] * arr[0];
	else
		cout << arr[0] * arr[size - 1];

}