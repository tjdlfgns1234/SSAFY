#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 250'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

int n;
string game;

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
    cin >> n >> game;

    vector<string> arr(n);
    for(auto& i : arr) cin >> i;

    sort(all(arr));
    arr.erase(unique(all(arr)),arr.end());

    if(game == "Y")
        cout << arr.size();
    else if(game == "F")
        cout << arr.size()/2;
    else if(game == "O")
        cout << arr.size()/3;
}