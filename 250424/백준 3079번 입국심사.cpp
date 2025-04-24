#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define ll long long
#define ull unsigned long long
#define MAX 100001
#define INF 987654321
using namespace std;

// 오버플로우에 주의하자

int n, m;
int arr[MAX] = { 0 };

void solve();
bool chk(ull mid);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	//freopen("input.txt", "r", stdin);

	solve();

	return 0;
}
void solve() {
	cin >> n >> m;

	for (int i = 0; i < n; i++) cin >> arr[i];

	ull ans =LLONG_MAX;

	ull l = 0, r = LLONG_MAX;
	while (l <= r) {
		ull mid = r - (r - l) / 2;
	
		if (chk(mid)) {
			ans = min(ans,mid);
			r = mid - 1;
		}
		else {
			l = mid + 1;
		}
	}

	cout << ans;
}
bool chk(ull mid) {
	ull ret = 0;

	for (int i = 0; i < n; i++) {
		if (ret >= m)
			break;
		ret += mid / arr[i];
	}
	
	if (ret >= m)
		return true;
	else
		return false;

}