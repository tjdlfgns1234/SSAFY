#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 11
#define INF 10'000'000'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

/*
	S2, Implementaion
	앞에서부터 천천히 만들면 되는 문제
	구상적 알고리즘 모르면 외워야 피보지 않는다.
*/


int n;


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

	vector<int> arr(n);
	
	for (auto& i : arr) cin >> i;
	// 자기보다 큰 사람이 왼쪽에 몇명 있었는지만 기억
	// 모든 수는 Unique함
	// 자기보다 작은 사람의 수는 기억 안함 

	vector<int> ans(n);

	for (int i = 0; i < n; i++) {
		int cnt = 0;

		for (int j = 0; j < n; j++) {
			if (ans[j] == 0 && cnt == arr[i]) {
				
				// 값이 정해지지 않고
				// cnt가 arr[i]와 일치 할때
				// 아래부터 채워나간다.

				ans[j] = i + 1;
				break;
			}
			else if (ans[j] == 0) 
				cnt++; 
		}
	}

	for (auto& i : ans) cout << i << ' ';
}