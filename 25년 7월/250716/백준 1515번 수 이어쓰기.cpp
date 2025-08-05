#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 40'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

// 24분 걸림
// 최대숫자를 계산을 제대로 못해서 2번을 틀렸다.
// 브루트포스로 바로 접근해야 하는 문제를 수학적 규칙을 찾다가 실수했다.
// 강사님이 말했던 것 처럼 항상 완탐을 먼저 생각하자.

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
    string s;

    cin >> s;

    int idx = 0;
    string cur ="";
    for(int i = 1; i < MAX;i++){
        cur = to_string(i);
        for(auto& j : cur)
            if(idx != s.size() && j == s[idx]) idx++;

        if(idx >= s.size()) cout << i, i = MAX;
    }
    
}