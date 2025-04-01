#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#define ll long long
#define ull unsigned long long

using namespace std;

int n, l,cnt = 1, ans;
int s[100001] = { 0 }, e[100001] = { 0 };
int pre[100001] = { 0 };

void solve();
int Search(int time);

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t;
	cin >> t;
	while(t--)
		solve();

	return 0;
}
int Search(int time){
	int l = 0, r = n-1;
	int ret = n;

	// upper bound
	while (l <= r) {
		int mid = l + (r - l) / 2;

		if (e[mid] > time) 
			ret = mid, r = mid - 1;
		else
			l = mid + 1;
	}

	return ret;
}

void solve() {
	cin >> l >> n;
	ans = 0; //구간 길이

	cin >> s[0] >> e[0], pre[0] = e[0] - s[0];
	for (int i = 1; i < n; i++)
		cin >> s[i]>> e[i], pre[i] = pre[i-1] + e[i] - s[i];

	int sum = 0, r = 0;
	for (int i = 0; i < n; i++) {
		int curr = s[i] + l; // 최대 시간
		// 광고 시간에 가장 가까우면서 큰 누적합 찾기
		int idx = Search(curr);
		sum = pre[idx-1];
		
		if (i != 1)
			sum -= pre[i-1]; // 크키 때문에 -1!

		if (idx != n && curr > s[idx])
			sum += (curr - s[idx]);

		ans = max(ans, sum);
	}

	cout << "#" << cnt++ << " " << ans << '\n';
}