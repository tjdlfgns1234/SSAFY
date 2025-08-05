#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
string what_title(int power);

int n, m;
map<int, string>mp;

// lower_bound 함수 사용법기 기억이 안나서 찾아본 문제
// 필요하면 구현해서 써도 상관 없을듯?

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
string what_title(int power){
    return "SSS";
}
void solve() {
     cin >> n >> m;

    // 해당하는 칭호가 없는 전투력은 입력 X
    // 전투력이 같으면 먼저 입력된 칭호만
    // 전투력이 다를 경우는 상관 없음
    // 순차 탐색은 Time out
    
    string s;
    int p;
    for(int i = 0; i < n;i++){
        cin >> s >> p;

        if(mp.count(p) == 0)
            mp[p] = s;
    }

    int c;
    for(int i = 0; i < m;i++){
        cin >> c;

        cout << mp.lower_bound(c)->second << '\n';
    }
}