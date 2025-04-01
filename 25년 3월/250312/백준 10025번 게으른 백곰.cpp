#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<list>
#include <numeric>
#include <algorithm>
#include<queue>
#define MAX 1'000'000
using namespace std;

void solve();

int n, k;
int arr[MAX+1] = { 0 };

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	// freopen("input.txt", "r", stdin);

	solve();
}
void solve() {
	cin >> n >> k;

	int x, y;
	for (int i = 0; i < n; i++)
		cin >> x >> y, arr[y] = x; // 모든 양동이 위치는 다름

	int ans = 0;
	if (k >= 500'000)
		ans = accumulate(arr, arr + MAX + 1, 0);
	else {
		int sum = 0;
		for (int i = 0; i <= 2 * k; i++) sum += arr[i];

		int l = 0, r = 2 * k;
		
		for (int i = 0; i < MAX + 1; i++) {
			ans = max(ans, sum);
			sum -= arr[l], sum += arr[r+1];
			l++, r++;
			if (r == MAX + 1)
				break;
		}
	}


	cout << ans;
}