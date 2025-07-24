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

// set을 사용하는 문제
// 파싱을 구현함.

int n, m;
set<string>st;

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
     cin >> n >> m;

    string s;
    for(int i = 0; i < n;i++)
        cin >> s, st.insert(s);

    vector<string> cur;
    for(int i = 0; i < m;i++){
        cin >> s;
        string tmp = "";
        for(auto& j : s){
            if(j != ',')
                tmp+= j;
            else
                cur.push_back(tmp), tmp ="";
        }

        if(tmp != "")
            cur.push_back(tmp);
        cur.erase(unique(all(cur)), cur.end());

        for(auto& k : cur){
            if(st.count(k) != 0)
                st.erase(k);
        }

        cout << st.size() << '\n';
        cur.clear();
    }
    

}