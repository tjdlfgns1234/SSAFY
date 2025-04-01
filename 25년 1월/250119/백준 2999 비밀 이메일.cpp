#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <stack>
#include <cstring>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 4000001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

string s;

vector<string> arr(10);

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	solve();

	return 0;
}
void solve() {
	cin >> s;

	int r = 1;
	for (int i = 2; i*i <= s.size(); ++i) if(s.size() % i == 0) r = i;
	
	for (int i = 0; i < s.size(); i++) 
		arr[(i%r)].push_back(s[i]);
	
	//for (int i = 0; i < r;++i) {
	//	for (auto j : arr[i])
	//		cout << j << " ";
	//	cout << '\n';
	//}

	for (int i = 0; i < r; ++i)
		for (auto j : arr[i])
			cout << j;

}