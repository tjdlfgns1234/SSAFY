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

void solve();
void init();

int n, m, s;
vector<int> arr;
vector<vector<int>> buk;


/*
	D5, Square Root Decomposition
*/


int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	// cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	cin >> n;

	int x;
	arr.resize(n);
	for (int i = 0; i < n; i++) cin >> arr[i];

	init();

	cin >> m;

	while (m--) {
		int cmd;
		cin >> cmd;

		int i, j, k;
		if (cmd == 2) { 
			cin >> i >> j >> k;

			i--, j--;

			int cnt = 0;

			// 왼쪽 꼬리
			while (i % s != 0 && i <= j) 
				if (arr[i++] > k) cnt++;

			// 오른쪽 꼬리
			while ((j+1) % s != 0 && i <= j)
				if (arr[j--] > k) cnt++;

			// 계속 버킷만 더함
			while (i <= j) 
				cnt += buk[i / s].end() - upper_bound(all(buk[i / s]), k), i+= s;
			
			cout << cnt << '\n';
		}
		else if (cmd == 1) {
			cin >> i >> k;
			i--;

			buk[i / s].erase(lower_bound(all(buk[i / s]), arr[i]));
			buk[i / s].insert(lower_bound(all(buk[i / s]),k), k);

			arr[i] = k;
		}

	}

}
void init() {
	// 버킷 초기화
	// s = sqrt(n);
	s = 756; // 버킷 크기는 500으로 고정
	buk.resize(n/s+1);

	for (int i = 0; i < n; i++) buk[i / s].push_back(arr[i]);

	for (int i = 0; i < buk.size(); i++) sort(all(buk[i]));
}