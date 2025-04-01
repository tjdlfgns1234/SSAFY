#include <iostream>
#include <queue>
#include <algorithm>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define MOD 1000000007
#define MAX 65536
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
int n, k, m;
int arr[5'000'001];


int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	//cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	int n, k;
	cin >> n >> k;

	for (int i = 0; i < n; i++) cin >> arr[i];

	nth_element(arr, arr + k-1, arr + n);

	cout << arr[k - 1];
}