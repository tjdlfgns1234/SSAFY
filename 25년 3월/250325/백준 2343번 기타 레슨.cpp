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
int chk(int size);
int n, k, m;
int arr[100001];


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
	cin >> n >> k;

	for (int i = 0; i < n; i++) cin >> arr[i];

	int ans = 1000654321;
	int l = 0, r = 1'000'000'000;
	while (l <= r) {
		int mid = r - (r - l) / 2;
		int c = chk(mid);
		// cout << c <<  '\n';
		if (c > k) {
			l = mid + 1;
		}
		else if (c == k) {
			if (ans > m)
				ans = m;
			r = mid - 1;
		}
		else {
			if (ans > m)
				ans = m;
			r = mid - 1;
		}
	}

	cout << ans;
}
int chk(int size) {
	int ret = 0, sum = 0;
	m = 0;
	for (int i = 0; i < n; i++) 
		if (sum + arr[i] <= size)
			sum+=arr[i];
		else {
			if (m < sum)
				m = sum;
			ret++, sum = arr[i];
		}
		
	if (m < sum)
		m = sum;
	if (sum != 0)
		ret++;

	return ret;
}