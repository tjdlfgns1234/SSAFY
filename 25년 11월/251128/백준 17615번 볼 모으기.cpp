#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 2e9
#define sum(a) (a*(a+1)/2)

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
int chk(const char target);

int n;
string s;

/*
	S1, Greedy

	4가지 경우만 보면 되지만 증명이 쉽지 않다.
*/

int main()
{
	ios::sync_with_stdio(NULL);	
	cin.tie(NULL), std::cout.tie(NULL);

	//freopen("input.txt", "r", stdin);

	int t = 1;
	cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	cin >> n >> s;

	int ans = INF;
	ans = min(chk('B'), chk('R'));

	cout << ans << '\n';
}
int chk(const char target) {
	int cur = 0, cnt = 0;
	int ret = INF;
	// B R로 만드는 경우
	for (int i = 0; i < n; i++)
		if (s[i] == target)
			cur++, cnt++;
		else
			cnt = 0;
	cur -= cnt;
	ret = min(ret, cur);

	cur = 0, cnt = 0;

	// R B로 만드는 경우
	for (int i = n - 1; i >= 0; i--)
		if (s[i] == target)
			cur++, cnt++;
		else
			cnt = 0;
	cur -= cnt;
	ret = min(ret, cur);

	return ret;
}