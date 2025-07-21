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

string s;

/*  S3 약 14분 소요
    상당히 간단한 문제, 10분 내에 해결했으면 좀 더 좋았을 듯
    Greedy, String
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
    cin >> s;

    // 0은 뒤에서부터
    // 1은 앞에서 부터

    int o = 0, z =0;
    for(auto& i : s) 
        if(i == '1') o++;
        else if(i == '0') z++;
    
    int cnt =0;
    for(auto& i : s)
        if(i == '1' && cnt != o/2)
            i = '2', cnt++;

    cnt = 0;
    for(int i = s.size()-1; i >= 0; i--)
      if(s[i]== '0' && cnt != z/2)
            s[i] = '2', cnt++;
    
    for(auto& i : s)
        if(i != '2')
            cout << i;

}