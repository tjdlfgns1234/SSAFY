#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 4000001
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


void solve();

string s;

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	solve();

	return 0;
}
void solve() {
	getline(cin, s);

	bool f = false; // <으로 시작했는지 유무
	string tmp = "";
	for (auto& i : s) {

		// 공백 먼저 구분
		// 문자열 시작과 끝은 공백이 아님.
		if (i == '<') {
			reverse(all(tmp)), cout << tmp, tmp = "";
			tmp += i, f = true;
		}
		else if (i == '>')
			tmp += i, f = false, cout << tmp, tmp ="";
		else if (f)
			tmp += i;
		else if (i != ' ')
			tmp += i;
		else
			reverse(all(tmp)), cout << tmp << ' ', tmp = "";
	}
	reverse(all(tmp)), cout << tmp;

	//cout << s;
}